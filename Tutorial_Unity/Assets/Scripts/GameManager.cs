using UnityEngine;
using System.Collections;
using System.Collections.Generic;        //Allows us to use Lists. 

public class GameManager : MonoBehaviour
{


    public float turnDelay = 0.1f;
    public static GameManager instance = null;                  //Static instance of GameManager which allows it to be accessed by any other script.
    private BoardManager boardScript;                           //Store a reference to our BoardManager which will set up the level.
    private int level = 3;                                      //Current level number, expressed in game as "Day 1".
    public int playerFoodPoints = 100;
    [HideInInspector] public bool playersTurn = false;
    private List<Enemy> enemies;
    private bool enemiesMoving;

    //Awake is always called before any Start functions
    void Awake()
    {
        if (instance == null)
            instance = this;
        else if (instance != this)
            Destroy(gameObject);


        DontDestroyOnLoad(gameObject);
        enemies = new List<Enemy>();
        //Get a component reference to the attached BoardManager script
        boardScript = GetComponent<BoardManager>();

        //Call the InitGame function to initialize the first level 
        InitGame();



    }

    //Initializes the game for each level.
    void InitGame()
    {
        enemies.Clear();
        
        //Call the SetupScene function of the BoardManager script, pass it current level number.
        boardScript.SetupScene(level);

    }
     public void GameOver()
    {
        enabled = false;
    }
    IEnumerator MoveEnemies()
    {
        enemiesMoving = true; //S'estan movent enemics
        yield return new WaitForSeconds(turnDelay);//Fem un delay
        if (enemies.Count ==0)
        {
            yield return new WaitForSeconds(turnDelay);
        }
        for (int i=0; i< enemies.Count; i++)
        {
            enemies[i].MoveEnemy();
            yield return new WaitForSeconds(enemies[i].moveTime);
        }
        playersTurn = true;
        enemiesMoving = false;


    }


    //Update is called every frame.
    void Update()
    {
        if (playersTurn || enemiesMoving)
        {
            return;
        }
        StartCoroutine(MoveEnemies());


    }
    public void AddEnemyToList ( Enemy script)
    {
        enemies.Add (script);
    }



}

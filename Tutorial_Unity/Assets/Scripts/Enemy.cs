using UnityEngine;
using System.Collections;


public class Enemy : MovingObject
{
    public int playerDamage;                             


    private Animator animator;                           
    private Transform target;                            
    private bool skipMove;                                


    protected override void Start()
    {
        GameManager.instance.AddEnemyToList(this); // el propi script s'afegeix a la llista de enemics del game manager
        
        animator = GetComponent<Animator>();

        target = GameObject.FindGameObjectWithTag ("Player").transform;

        base.Start();
    }



    protected override void AttemptMove<T>(int xDir, int yDir)
    {

        if (skipMove)//if enemy is skipping a turn
        {
            skipMove = false;
            return;
        }

        base.AttemptMove<T>(xDir, yDir);//truquem a la base del attempt move de la clase Moving object

        skipMove = true;
    }


    public void MoveEnemy()
    {
        int xDir = 0;
        int yDir = 0;

        //If the difference in positions is approximately zero (Epsilon) do the following:
        if (Mathf.Abs(target.position.x - transform.position.x) < float.Epsilon)

            //If the y coordinate of the target's (player) position is greater than the y coordinate of this enemy's position set y direction 1 (to move up). If not, set it to -1 (to move down).
            yDir = target.position.y > transform.position.y ? 1 : -1;

        //If the difference in positions is not approximately zero (Epsilon) do the following:
        else
            //Check if target x position is greater than enemy's x position, if so set x direction to 1 (move right), if not set to -1 (move left).
            xDir = target.position.x > transform.position.x ? 1 : -1;

        //Call the AttemptMove function and pass in the generic parameter Player, because Enemy is moving and expecting to potentially encounter a Player
        AttemptMove<Player>(xDir, yDir);
    }


    //OnCantMove is called if Enemy attempts to move into a space occupied by a Player, it overrides the OnCantMove function of MovingObject 
    //and takes a generic parameter T which we use to pass in the component we expect to encounter, in this case Player
    protected override void OnCantMove<T>(T component)
    {
        //Declare hitPlayer and set it to equal the encountered component.
        Player hitPlayer = component as Player;

        //Call the LoseFood function of hitPlayer passing it playerDamage, the amount of foodpoints to be subtracted.
        hitPlayer.LoseFood(playerDamage);

        animator.SetTrigger("enemyAttack"); // fem que l'enemic ataqui


    }
}
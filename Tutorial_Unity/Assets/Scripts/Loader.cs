using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class Loader : MonoBehaviour
{
    public GameObject gameManager;

    // Start is called before the first frame update
    void Awake()
    {
        if (GameManager.instance == null) //mirem si existeix o no el game manager i instanciem una si no existeix
            Instantiate(gameManager);
    }
}



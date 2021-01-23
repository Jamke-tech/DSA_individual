
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import static org.junit.Assert.assertEquals;


public class TestCovid19Manager {
    Covid19Manager manager ;

    @Before
    public void setUp() throws Exception{
         manager = Covid19ManagerImpl.getInstance();
    }

    @After
    public void TearDown() throws Exception{
       manager=null;
    }

    @Test
    public void testCreateBrote() throws Exception {
        Brote brote1 = new Brote();
        manager.addBrote("1", brote1);

        Assert.assertEquals(brote1, manager.mostrarBrotes().get("1"));


    }
    @Test
     public void testAñadirBrote() throws Exception{
        Brote brote1 = new Brote();
        manager.addBrote("1",brote1);

        Caso caso1 = new Caso ( 14, 02 , 2020, "sospechoso");
        Caso caso2 = new Caso ( 28, 05, 2021 , "confirmado");
        Caso caso3 = new Caso ( 30, 04, 2020 , "confirmado");
        Caso caso4  = new Caso ( 18, 02, 2020 , " no caso");

        manager.addCase("1", caso1);
        manager.addCase("1", caso2);
        manager.addCase("1",caso3);
        manager.addCase("1",caso4);

        Assert.assertEquals(manager.mostrarCasos("1").get(0),caso2);
        Assert.assertEquals(manager.mostrarCasos("1").get(1),caso3);
        Assert.assertEquals(manager.mostrarCasos("1").get(2),caso1);
        Assert.assertEquals(manager.mostrarCasos("1").get(3),caso4);

    }







}

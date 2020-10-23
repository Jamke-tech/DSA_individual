import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Queue;

public class QueueTest {

    Queueimpl<Integer> Cola1;

    @Before
    public void setUp() throws Exception{
        //Creamos cola y la llenamos con 4 valores
        Cola1 = new Queueimpl<Integer>(4);
        Cola1.push(1);
        Cola1.push(2);
        Cola1.push(3);

    }
    @Test
    public void testSize1() throws Exception{
        Assert.assertEquals(3,this.Cola1.size());
        this.Cola1.push(4);
        Assert.assertEquals(4,this.Cola1.size());
    }

    @Test (expected = FullQueueException.class)
    public void testFull() throws Exception{
        Assert.assertEquals(3,this.Cola1.size());
        this.Cola1.push(4);
        this.Cola1.push(5);
        this.Cola1.push(6);
        Assert.assertEquals(4,this.Cola1.size());

    }
    @Test
    public void testpop() throws Exception{
        Assert.assertEquals(3,this.Cola1.size());
        this.Cola1.pop();
        this.Cola1.pop();
        Assert.assertEquals(1,this.Cola1.size());

    }
    @Test (expected = EmptyQueueException.class)
    public void testEmpty() throws Exception{
        Assert.assertEquals(3,this.Cola1.size());
        this.Cola1.pop();
        this.Cola1.pop();
        this.Cola1.pop();
        Assert.assertEquals(0, this.Cola1.size());
        this.Cola1.pop();


    }







}

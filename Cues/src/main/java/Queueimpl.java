

public class Queueimpl<Q> implements Queue<Q> {

    private Q[] Cola;
    private int pos;

    //CONSTRUCTOR
    public Queueimpl (int len){
        this.Cola= (Q[]) new Object[len];
        this.pos=0;
    }

    public void push(Q q) throws FullQueueException {
        //Hem de posar la data darrera de tot i fer exception si esta full
        if(this.isFull())throw new FullQueueException();
        this.Cola[this.pos++]=q;

    }
    private boolean isFull() {
        if (Cola.length<(this.pos+1)){
            return true;
        }
        else{
            return false;
        }
    }

    private boolean isEmpty() {
        if (pos==0) return true;
        else return false;
    }

    public Q pop() throws EmptyQueueException {
        if(this.isEmpty()) throw new EmptyQueueException();
        else{
            Q retornar = Cola[0];
            for (int i=0; i<pos; i++){
                Cola[i]=Cola[i+1];
            }
            pos--;
            return retornar;
        }
    }
     public int size() {
        return pos;
    }
}

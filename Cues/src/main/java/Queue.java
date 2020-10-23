


//Especifiquem la nostra Cua amb les funcions que volem que fagi en aquest cas volem un Push un Pop i la size

public interface Queue<Q> {
    public void push(Q q) throws FullQueueException;
    public Q pop()throws EmptyQueueException;
    public int size();
}

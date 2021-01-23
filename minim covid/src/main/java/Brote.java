import java.util.*;

public class Brote {

    ArrayList<Caso> listaCasos;

    public Brote( ) {
        listaCasos = new ArrayList<Caso>();
    }

    public void setListaCasos(ArrayList<Caso> casos){
        listaCasos=casos;
    }
    public ArrayList<Caso> getListaCasos(){
        return listaCasos;
    }

    public boolean addCaso (Caso caso){
        listaCasos.add(caso);
        return true;

    }
}

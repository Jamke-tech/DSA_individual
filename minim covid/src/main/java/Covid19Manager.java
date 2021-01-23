

import java.util.ArrayList;

import java.util.HashMap;


public interface Covid19Manager {

    public void addBrote(String key, Brote brote);
    public HashMap<String,Brote> mostrarBrotes();
    public void addCase (String key, Caso caso);
    public ArrayList<Caso> mostrarCasos(String key);

}


import org.apache.log4j.Logger;

import java.util.*;

public class Covid19ManagerImpl implements Covid19Manager {
    // Ho implemntem en forma de Singelton
    private static Covid19Manager instance;

    protected HashMap<String, Brote> contenedorbrotes;

    final static Logger logger = Logger.getLogger(Covid19ManagerImpl.class);

    private Covid19ManagerImpl() {this.contenedorbrotes = new HashMap<String, Brote>();}

    public static Covid19Manager getInstance(){
        if (instance==null) instance = new Covid19ManagerImpl();
        return instance;
    }


    public void addBrote(String key, Brote brote) {
        logger.info ("Elementos del contenedor" + contenedorbrotes);
        contenedorbrotes.put(key,brote);
        logger.info ("Elementos del contenedor despues de introduccion" + contenedorbrotes);
    }

    public HashMap<String, Brote> mostrarBrotes() {
        if (contenedorbrotes!=null) {
            logger.info("lista mostrada");
            return contenedorbrotes;

        }
        else {
            logger.warn("Contenedor de brotes vacio");
            return null;
        }
        }

    public void addCase(String key, Caso c) {

        Brote broteUpdate= contenedorbrotes.get(key);
        if(broteUpdate==null) {
            logger.warn("El brote con key " + key + " no existe ");
        }
        else {
            broteUpdate.addCaso(c);
            logger.info("caso añadido correctamente");
        }

    }

    public ArrayList<Caso> mostrarCasos(String key) {
        Brote brotetoList= contenedorbrotes.get(key);
        if(brotetoList==null) {
            logger.warn("El brote con key " + key + " no existe ");
            return null;
        }
        else {
            ArrayList<Caso> listaCasosOrden = brotetoList.getListaCasos();
            if (listaCasosOrden ==null){
                logger.warn("La lista de casos del brote " + key + " està vacia, revisa si has añadido correctamente los casos");
                return null;
            }
            else {
                Collections.sort(listaCasosOrden);
                logger.info("Lista de casos retornada correctamente");
                return listaCasosOrden;
            }
        }
    }
}


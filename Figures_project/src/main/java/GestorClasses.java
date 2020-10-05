import java.util.Arrays;
public class GestorClasses {

    public static double Suma(Figura[] vector){
        double total_area=0;

        for(int i=0; i < vector.length; i++) {
            total_area=total_area+vector[i].area();

        }
        return total_area;
        }

    public static void sort(Figura[] vFigures){
        Arrays.sort(vFigures);
    }

    public static void main (String[] args) {
        Figura[] fVector = new Figura[3];
        fVector[0] = new Cercle(2);
        fVector[1] = new Rectangle(2, 2);
        fVector[2] = new Triangle(3, 2);

        System.out.println("Tenim les figures desordenades:" + "\n");

        for (int i = 0; i < fVector.length; i++) {
            System.out.println(fVector[i] + "\n");
        }

        System.out.println("La suma total de la area es: "+ GestorClasses.Suma(fVector));

        GestorClasses.sort(fVector);

        System.out.println("Tenim les figures ordenades:" + "\n");

        for (int i = 0; i < fVector.length; i++) {
            System.out.println(fVector[i] + "\n");
        }

        }
    }





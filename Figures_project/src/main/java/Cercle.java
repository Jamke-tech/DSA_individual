public class Cercle extends Figura {

    private double r;

    public Cercle(double radi)
    {
        r=radi;
    }


    public double area() {

        return 2*Math.PI*Math.pow(r,2);
    }

    @Override
    public String toString() {
        return "Cercle {" +
                "radi=" + r + " area: "+area()+
                '}';
    }

}

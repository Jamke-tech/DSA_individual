public class Rectangle extends Figura {

    private double costat1;
    private double costat2;


    public Rectangle(double costat1, double costat2) {
        this.costat1 = costat1;
        this.costat2 = costat2;
    }

    public double area() {
        return costat1 * costat2;
    }

    @Override
    public String toString() {
        if (costat1 == costat2) {
            return "Quadrat {" +
                    "costats=" + costat1 + "area: "+area()+
                    '}';
        } else {
            return "Rectangle{" +
                    "costat 1=" + costat1 +
                    "costat 2=" + costat2 + " area: "+area()+
                    '}';
        }
    }
}

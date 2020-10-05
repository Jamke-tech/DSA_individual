public class Triangle extends Figura {
    private double base;
    private double altura;


    public Triangle(double base, double altura ){
        this.altura=altura;
        this.base=base;
    }


    @Override
    public double area() {
        return base*altura*0.5;
    }

    @Override
    public String toString() {
        return "Triangle{" +
                "base=" + base +
                ", altura=" + altura +
                " area: "+area()+'}';
    }
}

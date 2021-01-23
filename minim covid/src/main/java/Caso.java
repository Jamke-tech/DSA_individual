import java.text.SimpleDateFormat;
import java.util.Date;



public class Caso implements Comparable <Caso> {

    //Parametros de un caso
    int dia;
    int mes;
    int año;
    String classificacion;

    public Caso(int dia, int mes, int año, String classificacion){
        this.dia=dia;
        this.mes=mes;
        this.año=año;
        this.setClassificacion(classificacion);
    }

    public String getClassificacion(){
        return classificacion;
    }
    public void setClassificacion(String classificacion){
        this.classificacion=classificacion;
    }
    public int getDia(){
        return dia;
    }
    public int getMes(){
        return mes;
    }
    public int getAño(){
        return año;
    }

    public int setvalor(String classificacion){
        if (classificacion=="confirmado"){
            return 2;
        }
        else if (classificacion=="sospechoso"){
            return 1;
        }
        else {
            return 0;
        }
    }

    public int compareTo(Caso c){
        int valorThisCaso= setvalor(this.classificacion);
        int valorOtherCaso = setvalor(c.getClassificacion());
        int valorComparation = valorOtherCaso- valorThisCaso;

        if (valorComparation==0){
            if (this.año > c.getAño()) {
                return -1;
            }
            else if (this.año == c.getAño()) {
                if (this.mes > c.getMes()) {
                    return -1;
                }
                else if (this.mes == c.getMes()) {
                    if (this.dia > c.getDia())
                        return -1;
                    else if (this.dia == c.getDia())
                        return 0;
                    else
                        return 1;
                }
                else
                    return 1;
            }
            else
                return 1;

            }
        else {
            return (valorComparation);
        }
    }


}

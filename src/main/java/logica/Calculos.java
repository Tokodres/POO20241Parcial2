
package logica;

public class Calculos {
    private int num1;
    private int num2;
    private String operacion;
      
    public final static String DEL= "AC";
    public final static String MUL= "*";
    public final static String DIV= "/";
    public final static String SUM= "+";
    public final static String RES= "-";
    public final static String IGU= "=";

    public int getNum1() {
        return num1;
    }

    public void setNum1(int num1) {
        this.num1 = num1;
    }

    public int getNum2() {
        return num2;
    }

    public void setNum2(int num2) {
        this.num2 = num2;
    }

    public String getOperacion() {
        return operacion;
    }

    public void setOperacion(String operacion) {
        this.operacion = operacion;
    }

    public int operaciones(){
        int rta = 0;
        if(this.operacion.equalsIgnoreCase(Calculos.MUL)){
            rta = this.num1*this.num2;
        }else if(this.operacion.equalsIgnoreCase(Calculos.DIV)){
                rta = this.num1/this.num2;    
        }else if(this.operacion.equalsIgnoreCase(Calculos.MUL)){
            rta = this.num1*this.num2;
        }else if(this.operacion.equalsIgnoreCase(Calculos.SUM)){
            rta = this.num1+this.num2;
        }else if(this.operacion.equalsIgnoreCase(Calculos.RES)){
            rta = this.num1-this.num2;
        }
        
        return rta;
    }
}

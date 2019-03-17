package classes;
import classes.*;
import java.util.ArrayList;
import java.util.Calendar;
/**
*  Nombre: Airport
*  Descripcion: Instanciasion de Avion
*  @author Miguel Angel Perez
*  @version 1.0.0
*/
public class Airplane{
      protected String enrollment;
      protected Calendar acquisitionDate;
      protected double price;
      protected int autonomy;
      protected int passengercapasity;
      protected double intake;
      protected int rows;
      protected int colums;
      public ArrayList<Airplane> nairplane = new ArrayList<Airplane>();

      public Airplane (String enrollment, double price,int autonomy, int passengercapasity,
                      double intake, String acquisitionDate,  int rows, int colums){ 
          this.enrollment=enrollment;
          this.acquisitionDate=acquisitionDate;
          this.price=price;
          this.autonomy=autonomy;
          this.passengercapasity=passengercapasity;
          this.intake=intake;
          this.rows=rows;
          this.colums=colums;
      }

      //Getter
      public String getEnrollment(){
          return enrollment;
      }
      public Calendar getAcquisitionDate(){
          return acquisitionDate;
      }
      public double getPrice(){
          return price;
      }
      public int getAutonomy(){
          return autonomy;
      }
      public int getPassengercapasity(){
          return passengercapasity;
      }
      public double getIntake(){
          return intake;
      }
      //Setter
      public void setEnrollment(String enrollment){
          this.enrollment=enrollment;
      }
      public void setAcquisitiondate(Calendar acquisitionDate){
          this.acquisitionDate=acquisitionDate;
      }
      public void setPrice(double price){
          this.price=price;
      }
      public void setAutonomy(int autonomy){
          this.autonomy=autonomy;
      }
      public void setPassengercapasity(int passengercapasity){
          this.passengercapasity=passengercapasity;
      }
      public void setIntake(double intake){
          this.intake=intake;
      }

    @Override
    public String toString(){
        return "Matricula "+this.getEnrollment()+" fecha de adquisicion "+this.getAcquisitionDate()+
        " precio "+this.getPrice()+" autonomia "+this.getAutonomy()+" capasidad "+this.getPassengercapasity()+
        " consumo "+this.getIntake();
    }
}

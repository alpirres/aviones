package classes;
import java.util.ArrayList;
/**
*  Nombre: Airport
*  Descripcion: Instanciasion de Avion
*  @author Miguel Angel Perez
*  @version 1.1
*/
abstract public class Airplane{
      protected String acquisitionDate;
      protected double price;
      protected int autonomy;
      protected int passengercapasity;
      protected double intake;
      protected int rows;
      protected int colums;
      public String enrollment;
      public static AirCompany company;
      

      public Airplane(double price,int autonomy, int passengercapasity,
                      double intake, String acquisitionDate,  int rows, int colums, AirCompany company){ 
          this.acquisitionDate=acquisitionDate;
          this.price=price;
          this.autonomy=autonomy;
          this.passengercapasity=passengercapasity;
          this.intake=intake;
          this.rows=rows;
          this.colums=colums;
          this.company=company;
          this.enrollment=CreateEnrollment();
      }

      //Getter
      
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
      abstract public void addvehicle(String newvehicles);
      abstract public String CreateEnrollment();
    @Override
    public String toString(){
        return "Fecha de adquisicion "+this.acquisitionDate+
        " precio "+this.getPrice()+" autonomia "+this.getAutonomy()+" capasidad "+this.getPassengercapasity()+
        " consumo "+this.getIntake();
    }
}

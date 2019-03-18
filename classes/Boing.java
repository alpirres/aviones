package classes;
/**
*  Nombre: Boing
*  Descripcion: Instanciasion de Avion de tipo Boing
*  @author Miguel Angel Perez
*  @version 1.0.0
*/
public class Boing extends Airplane{
  protected final static double DEFPRICE=280000;
  protected final static int DEFAUTONOMY=8000;
  protected final static int DEFPASSENGERCAPASITY=350;
  protected final static double DEFINTAKE=12;
  protected final static int DEFROWS=50;
  protected final static int DEFCOLUMNS=7;
  protected String enrollment;
  public String[] transport=new String[4];
  public static int number=1;

  public Boing(String acquisitionDate,AirCompany company){
    super(DEFPRICE, DEFAUTONOMY,DEFPASSENGERCAPASITY, DEFINTAKE, acquisitionDate, DEFROWS, DEFCOLUMNS, company);
    this.enrollment=CreateEnrollment();
  }

  /**
  *Añade un vehiculo si hay un hueco
  *@param recibe un string el cual es la matricula del vehiculo
  */
  public void addvehicle(String newvehicles){
    boolean flag=false;
    for(int i=0;i<this.transport.length&&!flag;i++){
      if(transport[i]==null){
        transport[i]=newvehicles;
        flag=true;
      }
    }
  }
  /**
  *metodo que crea una matricula para el avion
  *@return devuelve un string compuesto por iniciales de la compaña la letra B de boing747 y un numero
  */
  public String CreateEnrollment(){
      StringBuilder Enroll=new StringBuilder();
      for(int i=0;i<company.code.length -1;i++){
        Enroll.append(company.code[i]);
      }
        String fin= String.format("%04d",number);
        number ++;
        return Enroll.toString()+'B'+fin;
      }

  @Override
  public String toString(){
    return super.toString()+"Matricula "+this.enrollment+" y tiene capacidad para "+this.transport.length+" vehiculos";
  }
}

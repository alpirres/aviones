package classes;
import classes.AirCompany;
/**
*  Nombre: AirBus
*  Descripcion: Instanciasion de Avion de tipo AirBus
*  @author Miguel Angel Perez
*  @version 1.0.0
*/
public class AirBus extends Airplane{
  protected final static double DEFPRICE=80000;
  protected final static int DEFAUTONOMY=4000;
  protected final static int DEFPASSENGERCAPASITY=80;
  protected final static double DEFINTAKE=11;
  protected final static int DEFROWS=20;
  protected final static int DEFCOLUMNS=4;
    public String enrollment;
    public static int number=1;

  public AirBus(String acquisitionDate){
    super(DEFPRICE, DEFAUTONOMY, DEFPASSENGERCAPASITY,
     DEFINTAKE, acquisitionDate, DEFROWS, DEFCOLUMNS);
      this.enrollment=CreateEnrollment();
  }


  /**
  *metodo que crea una matricula para el avion
  *@param code char de Company usado para cojer las dos primeras letras de la compañia
  *@return las dos primeas letras, la sigla del nombre del avion y un contador
  */
    public String CreateEnrollment(){
        StringBuilder Enroll=new StringBuilder();
        for(int i=0;i<AirCompany.code.length -1;i++){
          Enroll.append(this.code[i]);
        }
          String fin= String.format("%04d",this.number);
          this.number ++;
          return Enroll.toString()+'A'+fin;
        }

  @Override
  public String toString(){
  return super.toString();
  }
}

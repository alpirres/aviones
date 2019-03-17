package classes;
import interfaces.ICrew;
import java.util.Calendar;
import java.util.ArrayList;
/**
*	Clase tripulacion que hereda de Empleado
*	@author Miguel Angel
*	@version: 1.0.0
*/
public class Crew extends Employee implements ICrew{
	//Atributos de la clase
	public ArrayList<Flight> assignedFlight= new ArrayList();
	protected int flightHours;
    protected int salary;
    protected int perAssignedFlight;
	private static int num=1;

    
	//Constructor de la clase Crew(Tripulacion)
	public Crew(String dni,String name,String surname,String birthDate,String nationality,String lenguages){
		super(dni,name,surname,birthDate,nationality,lenguages,createid());
        this.salary=SALARY_DEF;
        this.perAssignedFlight=PERASSIGNEDFLIGHT_DEF;
		
	}
	// Metodo que se encarga de crear un id al empleado con la union del codigo de la compañia y un numero para cada empleado
	public String createid(){
		 StringBuilder employee=new StringBuilder();
        	for (char i=0; i<this.code.length -1; i++){
           	employee.add(this.code[i]);  
       		}
       		String nemployee= String.format("%03d",this.num);
        	this.num ++;
        	return employee.toString()+'C'+nemployee;
               
	}
	// Metodo que añade vuelos al array list
	public void addFlight(Flight newAssignedFlight){
		this.assignedFlight.add(newAssignedFlight);
	}
    
	//Getters y Setters de todos los atributos
    public int getFlightHours() {
        return this.flightHours;
    }

    public void setFlightHours(int flightHours) {
        this.flightHours = flightHours;
    }
    
    public int getSalary(){
        return this.salary;
    }
    
    public void setSalary(int salary){
        this.salary=salary;
    }
    
    public int getPerAssignedFlight(){
        return this.perAssignedFlight;
    }
    
    public void setPerAssignedFlight(int perAssignedFlight){
        this.perAssignedFlight=perAssignedFlight;
    }

    //Funcion que te devuelve el salario total con el bonus de los vuelos asignados
    public double totalSalary(){
    	return (this.salary+(this.perAssignedFlight*assignedFlight.size()));

    }
   
	public String toString(){
		return super.toString()+"dado que es tripulante su salario es de "+this.getSalary()+" y por vuelo asignado cobra"+this.getPerAssignedFlight();
    }
    
    /**
    *  Funcion que calcula las horas de vuelo de un empleado segun los vuelos asignados.
    *  @return devuelve un int total el cual es la suma total de las horas.
    */
    public int calculateFlightHours(){
        int total=0;
        for(int i=0;i<this.assignedFlight.size();i++){
             total+=this.assignedFlight.get(i).time;
        }
        return total;
    }
}
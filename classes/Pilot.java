package classes;
import interfaces.IPilot;
import java.util.ArrayList;
/**package classes;
*	Clase piloto que hereda de Empleado
*	@author Miguel Angel
*	@version: 1.0.0
*/
public class Pilot extends Employee implements IPilot{
	//Atributos de la clase Pilot
	public ArrayList<Flight> assignedFlight= new ArrayList<>();
    protected int salary;
    protected int perAssignedFlight;
	protected int flightHours;
	public static int num=1;
    
	
	//Constructor de la clase Pilot(Piloto)
	public Pilot(String name,String surname,String birthDate,String nationality,String lenguages)throws Exception{
		super(name,surname,birthDate,nationality,lenguages);
        this.salary=SALARY_DEF;
        this.perAssignedFlight=PERASSIGNEDFLIGHT_DEF;
	}
    
	public String createid(){
        StringBuilder emp=new StringBuilder();
        for (int i=0; i<3; i++){
           	emp.append(company.code[i]);  
       	}
       	String nemployee= String.format("%03d",num);
        num ++;
        return emp.toString()+'P'+nemployee;
               
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
    public double calculatetotalSalary(){
    	return this.getSalary()+(this.getPerAssignedFlight()*this.assignedFlight.size());
    }
    @Override
	public String toString(){
		return super.toString()+"dado que es piloto su salario es de " +this.getSalary()+ " y por vuelo asignado cobra "+this.getPerAssignedFlight(); 
    }
  
    
    /**
    *  Funcion que calcula las horas de vuelo de un empleado segun los vuelos asignados.
    *  @return devuelve un int total el cual es la suma total de las horas.
    */
    public int calculateFlightHours(){
        int total=0;
        for(int i=0;i<assignedFlight.size();i++){
             total+=this.assignedFlight.get(i).getTime();
        }
        return total;
    }
}
        
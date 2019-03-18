package interfaces;
import classes.*;

public interface IAirCompany{
	
	boolean hireEmployee(Employee newemployee);
	boolean fireEmployee(String dni);
	void listEmployee();
	boolean searchEmployee(String idemploye);
	void totalSalary();
    
	
	boolean addPlane(Airplane newairplane);
	void listPlane();
	boolean removePlane(String enrroloment);
	boolean searchPlane(String enrollment);
    
    
	boolean addFlight(Flight newflight);
	boolean removeFlight(String id);
	boolean buyTicket(String ticket);
	boolean removeTicket(String idticket);
	boolean searchTicket(String idticket);
	boolean addClient(Client newclient);
	void listClient();
	boolean searchClient(String dni);
	boolean removeClient(String dni);


}
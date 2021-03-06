package interfaces;
import classes.*;

public interface IAirCompany{
	
	void hireEmployee(Employee newemployee);
	boolean fireEmployee(String dni);
	void listEmployee();
	boolean searchEmployee(String idemploye);
	void totalSalary();
    
	
	void addPlane(Airplane newairplane);
	void listPlane();
	boolean removePlane(String enrroloment);
	boolean searchPlane(String enrollment);
    
    
	void addFlight(Flight newflight);
	boolean removeFlight(String id);
	void buyTicket(String ticket);
	boolean removeTicket(String idticket);
	boolean searchTicket(String idticket);
	void addClient(Client newclient);
	void listClient();
	boolean searchClient(String dni);
	boolean removeClient(String dni);


}
package interfaces;
import classes.*;
public interface ICrew {

   	double SALARY=40000;
	double PERASSIGNEDFLIGHT=1000;
	static int num=1;

    String createid();
	void addFlight(Flight newAssignedFlight);
	int getFlightHours();
	void setFlightHours(int flightHours);
    int getSalary();
	void setSalary(int salary);
    int getPerAssignedFlight();
    void setPerAssignedFlight(int perAssignedFlight);
    
	double totalSalary();
   	int calculateFlightHours();
    
    @Override
    String toString();
}
package interfaces;
import classes.*;
public interface ICrew {

   	int SALARY_DEF=40000;
	int PERASSIGNEDFLIGHT_DEF=1000;
	static int num=1;
    
	void addFlight(Flight newAssignedFlight);
	int getFlightHours();
	void setFlightHours(int flightHours);
    int getSalary();
	void setSalary(int salary);
    int getPerAssignedFlight();
    void setPerAssignedFlight(int perAssignedFlight);
    
	double calculatetotalSalary();
   	int calculateFlightHours();
    
    @Override
    String toString();
}
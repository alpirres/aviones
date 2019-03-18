package interfaces;
import classes.Flight;

public interface IPilot {

	int SALARY_DEF=100000;
	int PERASSIGNEDFLIGHT_DEF=5000;
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
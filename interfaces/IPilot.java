package interfaces;
import classes.Flight;

public interface IPilot {

	int SALARY_DEF=100000;
	int PERASSIGNEDFLIGHT_DEF=5000;
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
package interfaces;
import java.util.Calendar;

public interface IEmployee {
    
    String getIdemployee();
    void setIdemployee(String idemployee);
    String getName();
    void setName(String name);
    String getSurname();
    void setSurname(String surname);
    Calendar getBirthDate();
    void setBirthDate(Calendar birthDate);
    String getNationality();
    void setNationality(String nationality);
    String getLenguages();
    void setLenguages(String lenguages);

	String calculatesLetter();
	boolean validDNI();
    
    @Override
    String toString();
	
}

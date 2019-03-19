package interfaces;

public interface IEmployee {
    
    String getIdemployee();
    void setIdemployee(String idemployee);
    String getName();
    void setName(String name);
    String getSurname();
    void setSurname(String surname);
    String getBirthDate();
    void setBirthDate(String birthDate);
    String getNationality();
    void setNationality(String nationality);
    String getLenguages();
    void setLenguages(String lenguages);

	String calculatesLetter(String dni);
	boolean validDNI(String dni);
    
    @Override
    String toString();
	
}

package classes;
import interfaces.IEmployee;
import java.util.ArrayList;
/**
*	Clase Empleado que implementa IAirCompany
*	@author Miguel Angel
*	@version: 1.0.0
*/

 abstract public class Employee implements IEmployee{

	//Atributos de la clase
    
	protected String dni;
    protected String idemployee;
	protected String name;
	protected String surname;
	protected String birthDate;
	protected String nationality;
	protected String lenguages;
    public static AirCompany company;

	//Constructor de la clase Empleado
	public Employee(String dni,String name,String surname,String birthDate,String nationality,String lenguages,AirCompany company)throws Exception{
		setDNI(dni);
		this.name=name;
		this.surname=surname;
		this.birthDate=birthDate;
		this.nationality=nationality;
		this.lenguages=lenguages;
        this.company=company;

	}
    // set de DNI que llama validDNI
    public void setDNI(String dni)throws Exception{
        if(this.validDNI(dni)){
            this.dni=dni;
        }else{
            throw new Exception("DNI no valido");
        }
    }
       public String getDNI()throws Exception{
        return this.dni;
    }

    // Getters y Setters de todos los atributos
    public String getIdemployee() {
        return this.idemployee;
    }
    public void setIdemployee(String idemployee) {
        this.idemployee = idemployee;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return this.surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getBirthDate() {
        return this.birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getNationality() {
        return this.nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getLenguages() {
        return this.lenguages;
    }

    public void setLenguages(String lenguages) {
        this.lenguages = lenguages;
    }
    // Metodo que valida el DNI que se le pasa
	public boolean validDNI(String dni){
        boolean valido=false;
        if(dni.length()==9){
            if(Character.isDigit(dni.charAt(0))&&Character.isDigit(dni.charAt(1))&&
            (Character.isDigit(dni.charAt(2))&&Character.isDigit(dni.charAt(3))&&
            (Character.isDigit(dni.charAt(4))&&Character.isDigit(dni.charAt(5))&&
            (Character.isDigit(dni.charAt(6))&&Character.isDigit(dni.charAt(7))&&
            (Character.isLetter(dni.charAt(8))))))){
                String miLetra=""+dni.charAt(8); //Convertir de char a String
                if(miLetra.toUpperCase().equals(this.calculatesLetter(dni.substring(0,8)))){
                    valido=true;
                }
            }
        }
        return valido;
    }
    // Metodo que calcula la letra correcta del DNI 
    public String calculatesLetter(String dni){
        int DNI=Integer.parseInt(dni.substring(0,8));
        int resto=0;
        String miLetra="";
        String[]asignacionLetra={"T","R","W","A","G","M","Y","F","P", "D", "X", "B", "N", "J", "Z", "S", "Q", "V", "H", "L", "C", "K", "E"};
        resto=DNI % 23;
        miLetra=asignacionLetra[resto];
        return miLetra;
    }
     
     abstract public double calculatetotalSalary();
     
    @Override
    public String toString(){
        return "Su nombre es "+this.getName()+" "+this.getSurname()+ ", su fecha de nacimiento es "+this.getBirthDate()+ ", su nacionalidad es " +this.getNationality()+ " y habla "+this.getLenguages();
    }

}
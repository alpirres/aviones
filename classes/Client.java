package classes;
import java.util.ArrayList;
/**
*  Nombre: Client
*  Descripcion: clase que instancia un cliente
*  @author Alfonso Prieto Escribano
*  @version 1.0.0
*/
public class Client{
    private String dni;
    private String name;
    private String surname;
    private String nationality;
    private String birthdate;
    
    
    public Client(String dni, String name, String surname, String nationality, String birthdate)throws Exception{
        this.setDNI(dni);
        this.name=name;
        this.surname=surname;
        this.nationality=nationality;
        this.birthdate=birthdate;
    }

    
    /**
    *  Función que compara posición por posición del dni cada número, luego pone la letra a mayuscula,
    *   calcula que letra deberia ser segun el numero introducido y las compara y si son iguales devuelve true
    *  @param recibe un String dni 
    *  @return devuelve un booleano valido 
    */
    protected boolean validaDNI(String dni) throws Exception{
        boolean valido=false;
        int miDNI = Integer.parseInt(dni.substring(0,8));
        int resto = 0;
        String laLetra = "";
        String[] asignacionLetra ={"T","R","W","A","G","M","Y","F","P","D","X","B","N","J","Z","S","Q","V","H","L","C","K","E"};
        if(dni.length()==9){
            if(Character.isDigit(dni.charAt(0))&&Character.isDigit(dni.charAt(1))&&
            Character.isDigit(dni.charAt(2))&&Character.isDigit(dni.charAt(3))&&
            Character.isDigit(dni.charAt(4))&&Character.isDigit(dni.charAt(5))&&
            Character.isDigit(dni.charAt(6))&&Character.isDigit(dni.charAt(7))&&
            Character.isLetter(dni.charAt(8))){
                String miLetra=""+dni.charAt(8);
                resto = miDNI % 23;
                laLetra = asignacionLetra[resto];
                if(miLetra.toUpperCase().equals(laLetra)){
                    valido=true;
                }
            }
        }
        return valido;
    }
    
    public String getDni(){
        return this.dni;
    }
    
    public void setDNI(String dni)throws Exception{
        if(this.validaDNI(dni)){
            this.dni=dni;
        }else{
            throw new Exception("DNI no valido!!!!");
        }
    }
    
    public String getName(){
        return this.name;
    }
    public void setName (String name){
        this.name=name;
    } 
    public String getSurname(){
        return this.surname;
    }
    public void setSurname(String surname){
        this.surname=surname;
    } 
    public String getNationality(){ 
        return this.nationality;
    }
    public void setNationality(String nationality){
        this.nationality=nationality;
    } 
    public String getBirthdate(){
        return this.birthdate;
    }
    public void setBirthdate(String birthdate){
        this.birthdate=birthdate;
    } 
} 
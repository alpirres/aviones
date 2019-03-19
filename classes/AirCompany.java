package classes;
import interfaces.IAirCompany;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Calendar;
/**
*	Nombre: AirCompany
*   Descripcion: esta clase recoge todos los metodas descritos en la interfaz
*	@author Alfonso Prieto Escribano
*	@version: 1.1
*/

public class AirCompany implements IAirCompany{

	protected String name;
	protected char[] code=new char[3];
	protected String ceo;
	protected String fundationDate;
	private static AirCompany instance;
    	public static ArrayList<Employee> nEmployee= new ArrayList<>();
	public static ArrayList<Airplane> nairplane = new ArrayList<>();
	public static ArrayList<Flight> nFlight= new ArrayList<>();
    	public ArrayList<Client> nClients=new ArrayList<Client>();
    

	private AirCompany(String name,String ceo,String fundationDate){
		this.name=name;
		this.ceo=ceo;
		this.fundationDate=fundationDate;
        createCode(name);
	}
	public static AirCompany getInstance(String name,String ceo,String fundationDate) throws Exception{
        if(instance == null){
            instance = new AirCompany(name,ceo,fundationDate);
        }
        return instance;
    }
	
    /**
    *  Funcion createCode la cual introduce en un array de char las 3 primeras letras de la compañia
    *  @param String name que es el nombre de la compañia
    */
    public void createCode(String name){
        for(int i=0;i<this.code.length;i++){
            char letra=name.charAt(i);
            this.code[i]=Character.toUpperCase(letra);
        }
    }


	public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCeo() {
        return this.ceo;
    }

    public void setCeo(String ceo) {
        this.ceo = ceo;
    }

    /**
    *  Función hireEmployee que añade un nuevo empleado al arraylist
    *  @param Employee newemployee que sirve para encontrar uno que coincida
    */
    public void hireEmployee(Employee newemployee){
		this.nEmployee.add(newemployee);
	}
	/**
    *  Función fireEmployee que elimina un empleado del arraylist
    *  @param String dni para encontrar uno que coincida
    *  @return boolean fire si lo consigue
    */
	public boolean fireEmployee(String dni){
		boolean fire=false;
        Iterator<Employee> nombreIterator = this.nEmployee.iterator();
        while(nombreIterator.hasNext()&&!fire){
            Employee elemento = nombreIterator.next();
	       if(elemento.dni.equals(dni)){
		      nombreIterator.remove();
              fire=true; 
           }
		}
		return fire;
	}
	// Metodo listEmployee que se encarga de listar todos los empleados
	public void listEmployee(){
			for(int i=0;i<this.nEmployee.size();i++) {
  			System.out.println(this.nEmployee.get(i));
		}
	}
    /**
    *  Funcion searchEmployee que busca un determinado empleado en el arraylist
    *  @param String idemployee que es usado para compararlo con los id de los empleados del arraylist
    *  @return boolean find que devuelve true si lo encuentra
    */
    public boolean searchEmployee(String idemployee){
		boolean search=false;
		for(int i=0;i<this.nEmployee.size()&&!search;i++) {
			if(this.nEmployee.get(i).idemployee.equals(idemployee)){
                System.out.println(this.nEmployee.get(i));
                search=true;
			}
		}
		return search;
	}
	// Metodo totalSalary que nos mostrara el salario de cada empleado
	public void totalSalary(){
		double allSalary;
	   for(int i=0;i<this.nEmployee.size();i++){
           allSalary=this.nEmployee.get(i).calculatetotalSalary();
           System.out.println(this.nEmployee.get(i).name+" cobra "+allSalary);
		}
	}
    /**
    *  Función addPlane que añade un nuevo avion al arraylist
    *  @param Airplane newairplane que sirve para encontrar uno que coincida
    *  @return boolean add devuelve true si lo consigue
    */
    public void addPlane(Airplane newairplane){
		this.nairplane.add(newairplane);
    }
    /**
    *  Funcion listPlane recorre la cantidad de aviones y los lista
    */
    public void listPlane(){
        for(int i=0;i<this.nairplane.size();i++){
            System.out.println(this.nairplane.get(i));
        }
    }

    /**
    *  Función removePlane que elimina un avion del arraylist
    *  @param String enrollment para encontrar uno que coincida
    *  @return boolean remove si lo consigue
    */
    public boolean removePlane(String enrollment){
        boolean remove=false;
        Iterator<Airplane> nombreIterator = this.nairplane.iterator();
        while(nombreIterator.hasNext()&&!remove){
            Airplane elemento = nombreIterator.next();
            if(elemento.enrollment.equals(enrollment)){
                nombreIterator.remove();
                remove=true; 
           }
		}
        return remove;
    }
    /**
    *  Funcion searchPLane que busca un determinado avion en el arraylist
    *  @param String enrrolment que es usado para compararlo con las matriculas del arraylist
    *  @return boolean find que devuelve true si lo encuentra
    */
    public boolean searchPlane(String enrollment){
        boolean find=false;
        for(int i=0;i<this.nairplane.size()&&!find;i++) {
            if(this.nairplane.get(i).enrollment.equals(enrollment)){
                System.out.println(this.nairplane.get(i));
                find=true;
            }
        }
        return find;
    }
    /**
    *  Función addFlight que añade un nuevo vuelo al arraylist
    *  @param Airplane newairplane que sirve para encontrar uno que coincida
    *  @return boolean add devuelve true si lo consigue
    */
	public void addFlight(Flight newflight){
		this.nFlight.add(newflight);
    }
    /**
    *  Funcion listFlight recorre los vuelos y los lista
    *  @param String destino para listar todos los vuelos que se dirigen hacia este
    */
    public void listFlight(String destino){
        for(int i=0;i<this.nFlight.size();i++){
            System.out.println(this.nFlight.get(i));
        }
    }
    /**
    *  Funcion searchFlight que busca un determinado vuelo en el arraylist
    *  @param String id que es usado para compararlo con los id del arraylist
    *  @return boolean find que devuelve true si lo encuentra
    */
    public boolean searchFlight(String id){
        boolean find=false;
        for(int i=0;i<this.nFlight.size()&&!find;i++) {
            if(this.nFlight.get(i).getID().equals(id)){
                System.out.println(this.nFlight.get(i));
                find=true;
            }
        }
        return find;
    }

    /**
    *  Función removeFlight que elimina un vuelo del arraylist
    *  @param String id para encontrar uno que coincida
    *  @return boolean remove si lo consigue
    */
	public boolean removeFlight(String id){
        boolean remove=false;
        Iterator<Flight> nombreIterator = this.nFlight.iterator();
        while(nombreIterator.hasNext()&&!remove){
            Flight elemento = nombreIterator.next();
            if(elemento.getID().equals(id)){
                nombreIterator.remove();
                remove=true; 
           }
		}
        return remove;
    }
    /**
    *  Función buyTicket crea un nuevo ticket y añade al cliente que lo compra al asiento
    *  @param String ticket es el ticket que se ha creado al seleccionar el vuelo
    *  @return boolean bought devuelve true si lo consigue
    */
	public void buyTicket(String ticket){
        Flight.nTickets.add(ticket);
    }
    /**
    *  Función removeTicket que elimina un ticket del arraylist
    *  @param String idticket para encontrar uno que coincida
    *  @return boolean remove si lo consigue
    */
	public boolean removeTicket(String idticket){
        boolean remove=false;
        Iterator<String> nombreIterator = Flight.nTickets.iterator();
        while(nombreIterator.hasNext()&&!remove){
            String elemento = nombreIterator.next();
            if(elemento.equals(idticket)){
                nombreIterator.remove();
                remove=true; 
           }
		}
        return remove;
    }
    /**
    *  Funcion searchTicket que busca un determinado ticket en el arraylist
    *  @param String idticket que es usado para compararlo con los id del arraylist
    *  @return boolean find que devuelve true si lo encuentra
    */
	public boolean searchTicket(String idticket){
        boolean find=false;
        for(int i=0;i<Flight.nTickets.size()&&!find;i++) {
            if(Flight.nTickets.get(i).equals(idticket)){
                System.out.println("Aqui tiene el ticket buscado "+Flight.nTickets.get(i));
                find=true;
            }
        }
        return find;
    }
    /**
    *  Función addClient que añade un nuevo cliente al arraylist
    *  @param lient newclient que sirve para encontrar uno que coincida
    *  @return boolean add devuelve true si lo consigue
    */
	public void addClient(Client newclient){
		this.nClients.add(newclient);  
    }
    /**
    *  Funcion listPlane recorre los clientes y los lista
    */
	public void listClient(){
        for(int i=0;i<this.nClients.size();i++){
            System.out.println(this.nClients.get(i));
        }
    }
    /**
    *  Funcion searchClient que busca un determinado cliente en el arraylist
    *  @param String dni que es usado para compararlo con los dni del arraylist
    *  @return boolean find que devuelve true si lo encuentra
    */
	public boolean searchClient(String dni){
        boolean find=false;
        for(int i=0;i<nClients.size()&&!find;i++) {
            if(this.nClients.get(i).getDni().equals(dni)){
                System.out.println(this.nClients.get(i));
                find=true;
            }
        }
        return find;
    }
    /**
    *  Función removeClient que elimina un cliente del arraylist
    *  @param String dni para encontrar uno que coincida
    *  @return boolean remove si lo consigue
    */
	public boolean removeClient(String dni){
        boolean remove=false;
        Iterator<Client> nombreIterator = this.nClients.iterator();
        while(nombreIterator.hasNext()&&!remove){
            Client elemento = nombreIterator.next();
            if(elemento.getDni().equals(dni)){
                nombreIterator.remove();
                remove=true; 
           }
		}
        return remove;
    }
}

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
    protected Airplane planes;
    protected Employee empleados;
    protected Flight vuelos;
    public ArrayList<Client> nClients=new ArrayList<Client>();
    

	public AirCompany(String name,String ceo,String fundationDate,Airplane aviones,Employee nEmployee,Flight nFlight){
		this.name=name;
		this.ceo=ceo;
		this.fundationDate=fundationDate;
        this.empleados=nEmployee;
        this.planes=aviones;
        this.vuelos=nFlight;
        createCode(name);
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
    *  @return boolean hire devuelve true si lo consigue
    */
    public boolean hireEmployee(Employee newemployee){
		boolean hire=false;
		for(int i=0;i<this.empleados.nEmployee.size()&&!hire;i++){
			if(!this.empleados.nEmployee.get(i).equals(newemployee)){
				this.empleados.nEmployee.add(newemployee);
				hire=true;
			}
		}
		return hire;
	}
	/**
    *  Función fireEmployee que elimina un empleado del arraylist
    *  @param String dni para encontrar uno que coincida
    *  @return boolean fire si lo consigue
    */
	public boolean fireEmployee(String dni){
		boolean fire=false;
        Iterator<Employee> nombreIterator = this.empleados.nEmployee.iterator();
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
			for(int i=0;i<this.empleados.nEmployee.size();i++) {
  			System.out.println(this.empleados.nEmployee.get(i));
		}
	}
    /**
    *  Funcion searchEmployee que busca un determinado empleado en el arraylist
    *  @param String idemployee que es usado para compararlo con los id de los empleados del arraylist
    *  @return boolean find que devuelve true si lo encuentra
    */
    public boolean searchEmployee(String idemployee){
		boolean search=false;
		for(int i=0;i<this.empleados.nEmployee.size()&&!search;i++) {
			if(this.empleados.nEmployee.get(i).idemployee.equals(idemployee)){
                System.out.println(this.empleados.nEmployee.get(i));
                search=true;
			}
		}
		return search;
	}
	// Metodo totalSalary que nos mostrara el salario de cada empleado
	public void totalSalary(){
		double allSalary;
	   for(int i=0;i<this.empleados.nEmployee.size();i++){
           allSalary=this.empleados.nEmployee.get(i).calculatetotalSalary();
           System.out.println(this.empleados.nEmployee.get(i).name+" cobra "+allSalary);
		}
	}
    /**
    *  Función addPlane que añade un nuevo avion al arraylist
    *  @param Airplane newairplane que sirve para encontrar uno que coincida
    *  @return boolean add devuelve true si lo consigue
    */
    public boolean addPlane(Airplane newairplane){
        boolean add=false;
        for(int i=0;i<this.planes.nairplane.size()&&!add;i++){
            if(this.planes.nairplane.get(i).equals(newairplane)){
                this.planes.nairplane.add(newairplane);
                add=true;
            }
        }
        return add;
    }
    /**
    *  Funcion listPlane recorre la cantidad de aviones y los lista
    */
    public void listPlane(){
        for(int i=0;i<this.planes.nairplane.size();i++){
            System.out.println(this.planes.nairplane.get(i));
        }
    }

    /**
    *  Función removePlane que elimina un avion del arraylist
    *  @param String enrollment para encontrar uno que coincida
    *  @return boolean remove si lo consigue
    */
    public boolean removePlane(String enrollment){
        boolean remove=false;
        Iterator<Airplane> nombreIterator = this.planes.nairplane.iterator();
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
        for(int i=0;i<this.planes.nairplane.size()&&!find;i++) {
            if(this.planes.nairplane.get(i).enrollment.equals(enrollment)){
                System.out.println(this.planes.nairplane.get(i));
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
	public boolean addFlight(Flight newflight){
        boolean add=false;
        for(int i=0;i<this.vuelos.nFlight.size()&&!add;i++){
            if(this.vuelos.nFlight.get(i).equals(newflight)){
                this.vuelos.nFlight.add(newflight);
                add=true;
            }
        }
        return add;
    }
    /**
    *  Funcion listFlight recorre los vuelos y los lista
    *  @param String destino para listar todos los vuelos que se dirigen hacia este
    */
    public void listFlight(String destino){
        for(int i=0;i<this.vuelos.nFlight.size();i++){
            System.out.println(this.vuelos.nFlight.get(i));
        }
    }
    /**
    *  Funcion searchFlight que busca un determinado vuelo en el arraylist
    *  @param String id que es usado para compararlo con los id del arraylist
    *  @return boolean find que devuelve true si lo encuentra
    */
    public boolean searchFlight(String id){
        boolean find=false;
        for(int i=0;i<this.vuelos.nFlight.size()&&!find;i++) {
            if(this.vuelos.nFlight.get(i).getID().equals(id)){
                System.out.println(this.vuelos.nFlight.get(i));
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
        Iterator<Flight> nombreIterator = this.vuelos.nFlight.iterator();
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
	public boolean buyTicket(String ticket){
        boolean bought=false;
        for(int i=0; i<this.vuelos.nTickets.size()&&bought;i++){
            if(!this.vuelos.nTickets.get(i).equals(ticket)){
                this.vuelos.nTickets.add(ticket);
                bought=true;
            }
        }
        return bought;
    }
    /**
    *  Función removeTicket que elimina un ticket del arraylist
    *  @param String idticket para encontrar uno que coincida
    *  @return boolean remove si lo consigue
    */
	public boolean removeTicket(String idticket){
        boolean remove=false;
        Iterator<String> nombreIterator = this.vuelos.nTickets.iterator();
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
        for(int i=0;i<this.vuelos.nTickets.size()&&!find;i++) {
            if(this.vuelos.nTickets.get(i).equals(idticket)){
                System.out.println("Aqui tiene el ticket buscado "+this.vuelos.nTickets.get(i));
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
	public boolean addClient(Client newclient){
        boolean add=false;
        for(int i=0;i<this.nClients.size()&&!add;i++){
            if(this.nClients.get(i).equals(newclient)){
                this.nClients.add(newclient);
                add=true;
            }
        }
        return add;
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

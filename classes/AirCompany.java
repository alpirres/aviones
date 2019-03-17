package classes;
import classes.*;
import interfaces.IAirCompany;
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
	protected Calendar fundationDate;


	public AirCompany(String name,String ceo,String fundationDate){
		this.name=name;
		this.ceo=ceo;
		this.fundationDate=fundationDate;
        createCode(name);
	}
    /**
    *  Funcion createCode la cual introduce en un array de char las 3 primeras letras de la compañia
    *  @param String name que es el nombre de la compañia
    */
    public void createCode(String name){
        for(int i=0;i<this.code.lenght;i++){
            char letra=name.charAt(i).toUpercase();
            this.code[i]=letra;
        }
    }


	public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

   	public char getCode() {
        return this.code;
    }

    public void setCode(char code) {
        this.code = code;
    }

    public String getCeo() {
        return this.ceo;
    }

    public void setCeo(String ceo) {
        this.ceo = ceo;
    }

	public Calendar getFundationDate() {
        return this.fundationDate;
    }

    public void setFundationDate(Calendar fundationDate) {
        this.fundationDate = fundationDate;
    }
    /**
    *  Función hireEmployee que añade un nuevo empleado al arraylist
    *  @param Employee newemployee que sirve para encontrar uno que coincida
    *  @return boolean hire devuelve true si lo consigue
    */
    public boolean hireEmployee(Employee newemployee){
		boolean hire=false;
		for(int i=0;i<nEmployee.size()&&!hire;i++){
			if(!this.nEmployee.get(i).equals(newemployee)){
				this.nEmployee.add(newemployee);
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
		for(int i=0;i<nEmployee.size()&&!fire;i++){
			if(this.nEmployee.get(i).dni!=null){
				if(this.nEmployee.get(i).dni.equals(dni)){
                    this.nEmployee.remove();
					fire=true;
				}
			}
		}
		return fire;
	}
	// Metodo listEmployee que se encarga de listar todos los empleados
	public void listEmployee(){
			for(int i=0;i<nEmployee.size();i++) {
  			System.out.println(nEmployee.get(i));
		}
	}
    /**
    *  Funcion searchEmployee que busca un determinado empleado en el arraylist
    *  @param String idemployee que es usado para compararlo con los id de los empleados del arraylist
    *  @return boolean find que devuelve true si lo encuentra
    */
    public boolean searchEmployee(String idemployee){
		boolean search=false;
		for(int i=0;i<nEmployee.size()&&!search;i++) {
			if(this.nEmployee.get(i).idemployee.equals(idemployee)){
                System.out.println(this.nEmployee.get(i));
                search=true;
			}
		}
		return search;
	}
	// Metodo totalSalary que nos mostrara el salario de cada empleado
	public double totalSalary(String dni){
		double allSalary;
	   for(int i=0;i<nEmployee.size()&&!fire;i++){
           if(this.nEmployee[i].dni.equals(dni)){
				allSalary=nEmployee.get(i).totalSalary();
			}
		}
		return allSalary;
	}
    /**
    *  Función addPlane que añade un nuevo avion al arraylist
    *  @param Airplane newairplane que sirve para encontrar uno que coincida
    *  @return boolean add devuelve true si lo consigue
    */
    public boolean addPlane(Airplane newairplane){
        boolean add=false;
        for(int i=0;i<this.nairplane.size()&&!add;i++){
            if(this.nairplane.get(i).equals(newairplane)){
                this.nairplane.add(newairplane);
                add=true;
            }
        }
        return add;
    }
    /**
    *  Funcion listPlane recorre la cantidad de aviones y los lista
    */
    public void listPlane(){
        for(int i=0;i<this.nairplane.size();i++){
            System.out.println(nairplane.get(i));
        }
    }

    /**
    *  Función removePlane que elimina un avion del arraylist
    *  @param String enrollment para encontrar uno que coincida
    *  @return boolean remove si lo consigue
    */
    public boolean removePlane(String enrollment){
        boolean remove=false;
        for(int i=0;i<nairplane.size()&&!remove;i++){
            if(this.nairplane.get(i).enrollment.equals(enrollment)){
                this.nairplane.remove();
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
        for(int i=0;i<nairplane.size()&&!find;i++) {
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
	public boolean addFlight(Flight newflight){
        boolean add=false;
        for(int i=0;i<this.nFlight.size()&&!add;i++){
            if(this.nFlight.get(i).equals(newflight)){
                this.nFlight.add(newflight);
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
        for(int i=0;i<nFlight.size()&&!find;i++) {
            if(this.nFlight.get(i).id.equals(id)){
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
        for(int i=0; i<this.nFlight.size()&&!remove;i++){
            if(this.nFlight.get(i).id.equals(id)){
                this.nFlight.remove();
                remove=true;
            }
        }
    }
    /**
    *  Función buyTicket crea un nuevo ticket y añade al cliente que lo compra al asiento
    *  @param String ticket es el ticket que se ha creado al seleccionar el vuelo
    *  @return boolean bought devuelve true si lo consigue
    */
	public boolean buyTicket(String ticket){
        boolean bought=false;
        for(int i=0; i<this.nTickets.size()&&bought;i++){
            if(!this.nTickets.get(i).equals(tickets)){
                this.nTickets.add(ticket);
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
        for(int i=0; i<this.nTickets.size()&&!remove;i++){
            if(this.nTickets.get(i).equals(idticket)){
                this.nTickets.remove();
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
        int i=1;
        for(int i=0;i<nTickets.size()&&!find;i++) {
            if(this.nTickets.get(i).equals(idticket)){
                System.out.println("Aqui tiene el ticket buscado "+this.nTickets.get(i));
                i++;
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
            if(this.nClients.get(i).dni.equals(dni)){
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
        for(int i=0; i<this.nTickets.size()&&!remove;i++){
            if(this.nClients.get(i).dni.equals(dni)){
                this.nClients.remove();
                remove=true;
            }
        }
        return remove;
    }
}

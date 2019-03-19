package classes;
import java.lang.Math;
import java.util.ArrayList;
import java.util.Hashtable;
/**
*  Nombre: Flight
*  Descripcion: clase que instancia un vuelo
*  @author Alfonso Prieto Escribano
*  @version 1.1.0
*/
public class Flight{
    
    private String ID;
    private String date;
    private Airplane airplane;
    private Pilot[] mypilot;
    private Crew[] mycrew;
    private Airport aporigen;
    private Airport apdestino;
    private int baseprice;
    private int time;
    public AirCompany company;
    public static ArrayList<Flight> nFlight= new ArrayList<Flight>();
    public Client[][] asientos;
    public static ArrayList<String> nTickets=new ArrayList<String>();
    

    
    //constructor de la clase Flight
    public Flight(Airplane airplane, Airport aporingen, Airport apdestino,String date, int baseprice, int time, AirCompany company)throws Exception{
        this.date=date;
        this.airplane=airplane;
        this.mypilot=new Pilot[2];
        this.aporigen=aporigen;
        this.apdestino=apdestino;
        this.baseprice=baseprice;
        this.time=time;
        this.company=company;
        this.asientos= new Client[this.airplane.rows][this.airplane.colums];
        this.mycrew=new Crew[(int)Math.ceil((this.airplane.passengercapasity)*0.2)];
		
		try{
			this.ID=createID();
		}catch(Exception e){
			System.out.println(e);
		}
        
    }
    
    /**
    *  Funcion que introduce en array mypilot el nuevo piloto recibido si hay un hueco.
    *  @param recibe una variable de tipo Piloto
    */
    public void addPilot(Employee newpilot){
        boolean added=false;
        for(int i=0;i<this.mypilot.length&&!added;i++){
            if(this.mypilot[i]==null){
                this.mypilot[i]=(Pilot)newpilot;
                added=true;
            }else{
                System.out.println("All the pilots are on board.");
            }
        }
    }
    
    /**
    *  Funcion que introduce en array mycrew el nuevo tripulante recibido si hay un hueco
    *  @param recibe una variable de tipo Crew
    */
    public void addCrew(Employee newcrew){
        boolean added=false;
        for(int i=0;i<this.mycrew.length&&!added;i++){
            if(this.mycrew[i]==null){
                this.mycrew[i]=(Crew)newcrew;
                added=true;
            }else{
                System.out.println("All the crew are on board.");
            }
        }
    }
    /**
    *  Funcion que introduce en un asiento libre un cliente
    *  @param recibe como parametro un objeto de tipo Cliente newcliente
    */
    public void addClienteAsiento(Client newclient, int asiento){
        boolean added=true;
        for(int i=0; i<this.asientos.length&&added;i++){
            for(int j=0;j<this.asientos[i].length&&added;j++){
                if(this.asientos[i][j]==null){
                    this.asientos[i][j]=newclient;
                    added=false;
                }
            }
        }
    }
    
    
    
    /**
    *  Funcion que crea un identificador de ticket con vuelo+asiento+fecha
    *  @return devuelve un string con todo el conjunto de parametros unidos
    */
    public String createTicket(String asiento){
        StringBuilder ticket=new StringBuilder();
        ticket.append(this.ID);
        ticket.append(asiento);
        ticket.append(this.date);
        return ticket.toString();
    }
    /**
    *  Funcion priceTicket que calcula el precio de los asientos vacios y añade la posicion en la que se encuentra
    */
    public Hashtable priceTicket(){
        Integer contador=new Integer(1);
        char letra='x';
        Hashtable<Integer,String> listClient=new Hashtable<Integer,String>();
        for(int i=0;i<this.asientos.length;i++){
            for(int j=0;j<this.asientos[0].length;j++){
                if(this.asientos[i]==null){
                    switch(j){
                    case 0:
                        letra='A';break;
                    case 1:
                        letra='B';break;
                    case 2:
                        letra='C';break;
                    case 3:
                        letra='D';break;
                    case 4:
                        letra='E';break;
                    case 5:
                        letra='F';break;
                    }
                    if(this.airplane.intake==160){
                        if(i<10){
                            System.out.println(contador+") "+((i+1)+letra)+" "+(this.baseprice*0.2)+"€");
                        }else{
                            System.out.println(contador+") "+((i+1)+letra)+" "+this.baseprice+"€");
                        }
                    }else if(this.airplane.intake==140){
                        if(i<5){
                            System.out.println(contador+") "+((i+1)+letra)+" "+(this.baseprice*0.2)+"€");
                        }else{
                            System.out.println(contador+") "+((i+1)+letra)+" "+this.baseprice+"€");
                        }
                    }
                    String fin=i+""+letra;
                    listClient.put(contador,fin);
                    contador++;
                }else{
                    System.out.println("Lo sentimos, todos lo asientos están ocupados, gracias.");
                }
            }
        }
        return listClient;
    }
    /**
    *  Funcion que crea un identificador a partir de las variables codigo de compañia, hora 
    *  y acronimo de la ciudad de destino
    *  @return devuelve un String conjunto el cual es el identificador ya formado
    */
    private String createID()throws Exception{
        StringBuilder conjunto=new StringBuilder();
        for(int i=0;i<company.code.length;i++){
            conjunto.append(company.code[i]);
        }
        int hours1=this.date.charAt(11);
        int hours2=this.date.charAt(12);
        int minutes1=this.date.charAt(14);
        int minutes2=this.date.charAt(15);
        conjunto.append(hours1+""+hours2);
        conjunto.append(minutes1+""+minutes2);
        conjunto.append(this.apdestino.getacronym());
        return conjunto.toString();
    }
    /**
    *  
    *
    */
    @Override
    public String toString(){
        return "Este es el vuelo "+this.ID+" sale desde "+this.aporigen.cityname+", se direge hacia "+this.apdestino.cityname+", sale el día "+this.date;                
    }
    //getter y setter
    public String getID(){
        return this.ID;
    }
    
    public void setID(String ID){
        this.ID=ID;
    }
    
    public String getDate(){
        return this.date;
    }
    
    public void setDate(String date){
        this.date=date;
    }
    
    public Airplane getAirplane(){
        return this.airplane;
    }
    
    public void setAirplane(Airplane airplane){
        this.airplane=airplane;
    }
    public Airport getAporingen(){
        return this.aporigen;
    }
    public void setAporingen(Airport aporigen){
        this.aporigen=aporigen;
    }
    public Airport getApdestino(){
        return this.apdestino;
    }
    public void setApdestino(Airport apdestino){
        this.apdestino=apdestino;
    }
    public int getTime(){
        return this.time;
    }
    public void setTime(int time){
        this.time=time;
    } 
}
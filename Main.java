import classes.*;
public class Main{
    
	public static void main(String[] args){
        try{
            
        AirCompany myCompany=new AirCompany("IBERIA","Carlos Serrano","2019/02/14",null,null,null);
        
		Airplane av1=new AirBus("08/03/2008",myCompany);
		Airplane av2=new AirBus("27/02/2011",myCompany);
		Airplane av3=new Boing("05/12/2013",myCompany);
        av3.addvehicle("Seat IBIZA");
        av3.addvehicle("Ford MONDEO");
		
        Airport ap1=new Airport("Cordopolis","Cordoba","Espania","aparcamiento y wifi");
        Airport ap2=new Airport("Barajas","Madrid","Espania","restaurante y wifi");
        Airport ap3=new Airport("El Prat","Barcelona","Españia","cajero automatico y wifi");
        Airport ap4=new Airport("Manises","Valencia","Españia","carrito portaequipaje y wifi");
        Airport ap5=new Airport("Loiu","Bilbao","Españia","gasolinera y wifi");
        Airport ap6=new Airport("Idlewild","New York","Estados Unidos","area de recreo infantil y wifi");
        
		Employee p1=new Pilot("89586064Y","Alejandro","Sanchez","01/01/1990","Español","Español,Ingles",myCompany);
		Employee p2=new Pilot("59163602N","Joaquin","Esturion","05/10/1985","Español","Español,Ingles",myCompany);
        
		Employee c1=new Crew("49611453Q","Ana","Serrano","08/03/1982","Española","Español,Ingles",myCompany);
		Employee c2=new Crew("84127918J","Bernardo","Galisteo","28/03/2008","Español","Español,Ingles",myCompany);
		Employee c3=new Crew("83659896H","Maria","Rodriguez","11/08/1992","Español","Español,Ingles",myCompany);
		Employee c4=new Crew("39417290M","Andrea","Fernandez","12/11/1995","Española","Español,Ingles",myCompany);
		Employee c5=new Crew("11223484J","Ignacio","Vilchez","14/03/1989","Español","Español,Ingles",myCompany);
		Employee c6=new Crew("47141808L","Irene","Lucena","22/03/1990","Española","Español,Ingles",myCompany);
        
        Flight v0=new Flight(av1,ap1,ap2,"10/03/2019 08:00",80,50,myCompany);
		Flight v1=new Flight(av1,ap2,ap3,"10/03/2019 09:30",50,40,myCompany);
		Flight v2=new Flight(av2,ap2,ap4,"10/03/2019 11:00",60,45,myCompany);
		Flight v3=new Flight(av2,ap4,ap5,"10/03/2019 12:30",0,0,myCompany);
		Flight v4=new Flight(av3,ap2,ap6,"10/03/2019 19:00",600,620,myCompany);
        
        myCompany.hireEmployee(p1);
        myCompany.hireEmployee(p2);
        myCompany.hireEmployee(c1);
        myCompany.hireEmployee(c2);
        myCompany.hireEmployee(c3);
        myCompany.hireEmployee(c4);
        myCompany.hireEmployee(c5);
        myCompany.hireEmployee(c6);
        
        myCompany.addPlane(av1);
        myCompany.addPlane(av2);
        myCompany.addPlane(av3);
        
        myCompany.addFlight(v0);
        myCompany.addFlight(v1);
        myCompany.addFlight(v2);
        myCompany.addFlight(v3);
        myCompany.addFlight(v4);
        
        
        v0.addPilot(p1);v0.addPilot(p2);
        v1.addPilot(p1);v1.addPilot(p2);
        v2.addPilot(p1);v2.addPilot(p2);
        v3.addPilot(p1);v3.addPilot(p2);
        v4.addPilot(p1);v4.addPilot(p2);
        
        v0.addCrew(c1);v0.addCrew(c2);v0.addCrew(c3);v0.addCrew(c4);
        v1.addCrew(c1);v1.addCrew(c2);v1.addCrew(c3);v1.addCrew(c4);
        v2.addCrew(c1);v2.addCrew(c2);v2.addCrew(c3);v2.addCrew(c4);
        v3.addCrew(c1);v3.addCrew(c2);v3.addCrew(c3);v3.addCrew(c4);
        v4.addCrew(c1);v4.addCrew(c2);v4.addCrew(c3);v4.addCrew(c4);v4.addCrew(c5);v4.addCrew(c6);
            
        
			Menu mimenu=Menu.getInstance();
			mimenu.imprimeMenu(myCompany,null);
		}catch(Exception e){
			System.out.println(e);
		}
        
    }
    
}
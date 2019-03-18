package classes;
import java.util.Scanner;
import java.util.Hashtable;
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;
/**
*  Nombre: menu
*  Descripcion: clase que contiene el menu que se mostrara por pantalla
*  @author Alfonso Prieto Escribano
*  @version 1.0.0
*/
public class Menu{
    /** Entrada por teclado */
    Scanner entrada;
    /** Lista de las opciones del menú principal */
    List<String> menuprincipal;
    
    AirCompany company;
    
    Flight vuelo;
    
    
    private static Menu instance;
   
    private Menu() throws Exception{
        
        //Entrada por teclado
        entrada = new Scanner(System.in);

        //Menú principal
        menuprincipal=new ArrayList<>();
        menuprincipal.add("Buscar Vuelo");
        menuprincipal.add("Consultar Billete");
        menuprincipal.add("Eliminar Billete");
        menuprincipal.add("Listar Vuelos");
        menuprincipal.add("Listar Empleados");
        menuprincipal.add("Listar Clientes");
        menuprincipal.add("Listar Flota");
        menuprincipal.add("Calcular Salarios total");
        menuprincipal.add("Calcular la rentabilidad de un vuelo");
        menuprincipal.add("Salir");
          
    }
    //Implementa el patrón singleton
    public static Menu getInstance() throws Exception{
        if(instance == null){
            instance = new Menu();
        }
        return instance;
    }

    /**
     * Controla error en entrada y si la opción es válida para cada menú.
     * En caso de ser valida delega la gestión a los métodos gestionPrincipal
     */
    public void imprimeMenu(AirCompany company, Flight v){
        this.vuelo=v;
        List menu=this.menuprincipal; 
        System.out.println("\n-------------Menu Principal-------------\n");
        if(menu!=null){
            Iterator it=menu.iterator();
            int i=1;
            while(it.hasNext()){
                String opcion=(String)it.next();
                System.out.println(i+") "+opcion);
                i++;
            }
            System.out.println("Elija el numero de la opcion correcta y pulse enter");
            try{
                int opcion = entrada.nextInt();
                if(opcion<=0||opcion>menuprincipal.size()){
                    System.out.println("Opcion no valida");
                    entrada.nextLine();
                    this.imprimeMenu(company, this.vuelo);
                }else{
                    this.gestionPrincipal(opcion, company);
                } 
            }catch(Exception e){
                entrada=new Scanner(System.in);
                System.out.println("Elija un numero correcto");
                imprimeMenu(company, this.vuelo);
            }
        }
    }
    /**
     * @param int o identifica la opcion elegida por el usuario en el menú principal.
     */
    private void gestionPrincipal(int o, AirCompany company){
        this.company=company;
        switch (o) {
            case 1:
                System.out.print("Porfavor introduzca el aeropuerto origen: ");
                String origen=entrada.nextLine();
                System.out.print("Porfavor introduzca el aeropuerto destino: ");
                String destiny=entrada.nextLine();
                this.createSubmenu(origen,destiny);
                break;
            case 2:
                System.out.print("Porfavor introduzca el identificador del billete: ");
                String id=entrada.nextLine();
                System.out.print("Porfavor introduzca su DNI: ");
                String dni=entrada.nextLine();
                company.searchTicket(id);
                break;
            case 3:
                System.out.print("Porfavor introduzca el identificador del billete: ");
                String id1=entrada.nextLine();
                System.out.print("Porfavor introduzca su DNI: ");
                String dni1=entrada.nextLine();
                company.removeTicket(id1);
                break;
            case 4:
                System.out.println("Intoduzca el destino de los vuelos que desea visualizar");
                String destino=entrada.nextLine();
                company.listFlight(destino);
                break;
            case 5:
                System.out.println("Aquí tiene todos los emppleados contratados");
                company.listEmployee();
                break;
            case 6:
                System.out.println("Aquí tiene todos los clientes registrados");
                company.listClient();
                break;
            case 7:
                System.out.println("Aquí tiene todos los aviones disponibles");
                company.listPlane();
                break;
            case 8:
                System.out.println("Aquí tiene el sueldo total de cada empleado");
                company.totalSalary();
                break;
            case 9:
                break;
            case 0:
                System.out.println("Gracias por visitarnos, hasta pronto.");
                break;
            default:
                System.out.println("opción incorrecta");
        }
    }
    /**
    *  
    *  
    */
    public void createSubmenu(String origen, String destino){
        int contador=1;
        Hashtable<Integer,Flight> idFlight=new Hashtable<Integer,Flight>();
        Hashtable<Integer,String> listClient=new Hashtable<Integer,String>();
        while(!origen.equalsIgnoreCase(destino)){
            for(int i=0;i<this.vuelo.nFlight.size();i++){
                if(this.vuelo.nFlight.get(i).getAporingen().cityname.equals(origen)&&
                   this.vuelo.nFlight.get(i).getApdestino().cityname.equals(destino)){
                    idFlight.put(contador,this.vuelo.nFlight.get(i));
                    System.out.println(contador+") "+this.vuelo.nFlight.get(i).getID());
                    contador++;
                }
            }
            System.out.println("Seleccione el vuelo	deseado	o vuelva atrás (0).");
            int id=entrada.nextInt();
            while(id!=0&&id<=contador){
                listClient=idFlight.get(id).priceTicket();
                System.out.println("Seleccione el asiento deseado o vuelva atrás (0).");
                int asiento=entrada.nextInt();
                while(asiento!=0&&asiento<listClient.size()){
                    System.out.println("Introduzca su dni o vuelva atrás (0).");
                    String dnii=entrada.nextLine();
                    if(dnii.equals("0")){
                        boolean estoy=false;
                        for(int i=0;i<company.nClients.size()&&!estoy;i++){
                            if(!company.nClients.get(i).getDni().equals(dnii)){
                                System.out.println("Usted no tiene cuenta");
                                System.out.println("Desea crear una cuenta (s/n)");
                                String respuesta=entrada.nextLine();
                                if(respuesta.equalsIgnoreCase("s")){
                                    System.out.println("Introduzca su nombre: ");
                                    String nombre=entrada.nextLine();
                                    System.out.println("Introduzca su apellido: ");
                                    String apellido=entrada.nextLine();
                                    System.out.println("Introduzca su nacianalidad: ");
                                    String nacionalidad=entrada.nextLine();
                                    System.out.println("Introduzca su fecha de nacimiento(yyyy/mm/dd): ");
                                    String nacimiento=entrada.nextLine();
                                    try{
                                    Client nuevo=new Client(dnii,nombre,apellido,nacionalidad,nacimiento);
                                    company.addClient(nuevo);
                                    }catch(Exception e){
                                        System.out.println(e);
                                    }
                                    String seat=listClient.get(asiento);
                                    String ticket=this.vuelo.createTicket(seat);
                                    company.buyTicket(ticket);
                                    System.out.println("");
                                }else{
                                    System.out.println("pulse (0) para salir");
                                    id=entrada.nextInt();
                                }
                            }else{
                                System.out.println("Usted ya tiene cuenta");
                                System.out.println("Desea comprar el billete (s/n)");
                                String respues=entrada.nextLine();
                                if(respues.equalsIgnoreCase("s")){
                                    String seat=listClient.get(asiento);
                                    String ticket=this.vuelo.createTicket(seat);
                                    company.buyTicket(ticket);
                                }else{
                                    System.out.println("pulse (0) para salir");
                                    id=entrada.nextInt();
                                }
                            }
                            estoy=true;dnii="0";asiento=0;destino=origen;
                        }
                    }
                }
            }
        }
    }
}
package classes;
import classes.AirCompany;
import java.util.Scanner;
import java.util.Hashtable;
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
    public void imprimeMenu(AirCompany company){
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
                int opcion = entradaa.nextInt();
                if(opcion<=0||opcion>menuprincipal.size()){
                    System.out.println("Opcion no valida");
                    entrada.nextLine();
                    this.imprimeMenu(company);
                }else{
                    this.gestionPrincipal(opcion, company);
                } 
            }catch(Exception e){
                entrada=new Scanner(System.in);
                System.out.println("Elija un numero correcto");
                imprimeMenu();
            }
        }
    }
    /**
     * @param int o identifica la opcion elegida por el usuario en el menú principal.
     */
    private void gestionPrincipal(int o, AirCompany company){
        switch (o) {
            case 1:
                System.out.print("Porfavor introduzca el aeropuerto origen: ");
                String origen=entrada.nextInt();
                System.out.print("Porfavor introduzca el aeropuerto destino: ");
                String destiny=entrada.nextInt();
                this.createSubmenu(origen,destino);
                break;
            case 2:
                System.out.print("Porfavor introduzca el identificador del billete: ");
                String id=entrada.nextInt();
                System.out.print("Porfavor introduzca su DNI: ");
                String dni=entrada.nextInt();
                company.searchTicket(id);
                break;
            case 3:
                System.out.print("Porfavor introduzca el identificador del billete: ");
                String id=entrada.nextInt();
                System.out.print("Porfavor introduzca su DNI: ");
                String dni=entrada.nextInt();
                company.removeTicket(id);
                break;
            case 4:
                System.out.println("Intoduzca el destino de los vuelos que desea visualizar");
                String destiny=entrada.nextInt();
                company.listFlight(destiny);
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
                company.listAirplane();
                break;
            case 8:
                System.out.println("Aquí tiene el sueldo total de cada empleado");
                for(int i=0;i<nEmployee.size();i++){
                    System.out.println("El empleado "+this.nEmployee.get(i).nombre+" y cobra"
                                       +this.totalSalary(this.nEmployee.get(i)));
                }
                break;
            case 9:
                break;
            case 0:
                System.out.printl("Gracias por visitarnos, hasta pronto.");
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
        Hashtable<int,Flight> idFLight=new Hashtable<int,Flight>();
        Hashtable<int,String> listClient=new Hashtable<int,String>();
        if(!origen.equalsIgnoreCase(destino)){
            for(int i=0;i<this.nFlight.size();i++){
                if(this.nFlight.get(i).aporigen.cityname.equals(origen)&&
                   this.nFlight.get(i).apdestino.cityname.equals(destino)){
                    idFlight.put(contador,this.nFlight.get(i));
                    System.out.println(contador+") "+this.nFlight.get(i).ID);
                    contador++;
                }
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
                String dni=entrada.nextInt();
                if(dni!=0){
                    boolean estoy=false;
                    for(int i=0;i<this.nClients.size()&&!estoy;i++){
                        if(!this.nClients.get(i).dni.equals(dni)){
                            System.out.println("Usted no tiene cuenta");
                            System.out.println("Desea crear una cuenta (s/n)");
                            char respuesta=entrada.nextInt();
                            if(respuesta.equalsIgnoreCase('s')){
                                System.out.println("Introduzca su nombre: ");
                                String nombre=entrada.nextInt();
                                System.out.println("Introduzca su apellido: ");
                                String apellido=entrada.nextInt();
                                System.out.println("Introduzca su nacianalidad: ");
                                String nacionalidad=entrada.nextInt();
                                System.out.println("Introduzca su fecha de nacimiento: ");
                                String nacimiento=entrada.nextInt();
                                Client nuevo=new Client(dni,nombre,apellido,nacionalidad,nacimiento);
                                nuevo.addClient(nuevo);
                                String seat=listClient.get(asiento);
                                String ticket=createTicket(seat);
                                this.buyTicket(ticket);
                                System.out.println("");
                            }else{
                                System.out.println("pulse (0) para salir");
                                id=entrada.nextInt();
                            }
                        }else{
                            System.out.println("Usted ya tiene cuenta");
                            System.out.println("Desea comprar el billete (s/n)");
                            char respuesta=entrada.nextInt();
                            if(respuesta.equalsIgnoreCase('s')){
                                this.buyTicket();
                            }else{
                                System.out.println("pulse (0) para salir");
                                id=entrada.nextInt();
                            }
                        }
                        estoy=true;dni=0;asiento=0;
                    }
                }
            }
        }r
     
}
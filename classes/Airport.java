package classes;
import java.util.ArrayList;
/**
*  Nombre: Airport
*  Descripcion: Instanciasion de Aeropuerto
*  @author Miguel Angel Perez
*  @version 1.0.0
*/
public class Airport{
    public ArrayList<Airport> nAirport=new ArrayList<Airport>();
    protected String acronym;
    protected String name;
    protected String cityname;
    protected String country;
    protected String services;

  public Airport(String name, String cityname, String country, String services){
      this.acronym=doAcronym(cityname);
      this.name=name;
      this.cityname=cityname;
      this.country=country;
      this.services=services;
      this.nAirport.add(this);
  }
  /**Metodo acronym crea un StringBuilder que recoje las tres primeras letras del nombre de la ciudad en mayuscula
  *@param String cityname nombre de la ciudad
  *@return devuelve un string letter con el conjunto
  */
  public String doAcronym(String cityname){
      StringBuilder letter=new StringBuilder();
      char mayus;
      for(int i=0;i<3;i++){
          mayus=cityname.charAt(i);
          letter.append(mayus);
      }
      return letter.toString();
  }


//Getter
  public String getacronym(){
    return acronym;
  }
  public String getname(){
    return name;
  }
  public String getcityname(){
    return cityname;
  }
  public String getcountry(){
    return country;
  }
  public String getservices(){
    return services;
  }
  //Setter
  public void setacronym(String acronym){
    this.acronym=acronym;
  }
  public void setname(String name){
    this.name=name;
  }
  public void setcityname(String cityname){
    this.cityname=cityname;
  }
  public void setcountry(String country){
    this.country=country;
  }
  public void setservices(String services){
    this.services=services;
  }

  @Override
  public String toString(){
    return "Acronimo "+this.getacronym()+" name "+this.getname()+
    " ciudad "+this.getcityname()+" Pais "+this.getcountry()+" servicios "+this.getservices();
  }
  @Override
  public boolean equals(Object Obj){
    boolean validate=false;
    if(Obj instanceof Airport){
      Airport tmp=(Airport)Obj;
      if(this.acronym.equals(tmp.acronym)&&this.name.equals(tmp.name)){
        validate=true;
      }
    }return validate;
  }

}

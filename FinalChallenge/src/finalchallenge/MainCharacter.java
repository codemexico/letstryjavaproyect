

package finalchallenge;
import java.util.*;
public class MainCharacter {
    String name;
    int weigth;
    int age;
    int vida;
    int dinero;
    String profession;
    String planet;
    String race;
    boolean weapon;
    int shield;
    int monsterspassed = 0;
    Vector armas=new Vector(0, 5);    

    public MainCharacter (String name,  int dinero, int age, String planet, int vida, String profession, String race, boolean weapon, int shield) {
        this.name = name;
        this.dinero = dinero;
        this.age = age;
        this.planet = planet;
        this.vida = vida;
        this.profession= profession;
        this.race= race;
        this.weapon= weapon;
        this.shield = shield;
    }
    void print(){
        System.out.println("-------------------------------------------------------------------------------");
        System.out.println ("                     INFORMACIÓN DE PERSONAJE");
        System.out.println("Nombre: "+ name);
        System.out.println("Edad: "+ age);
        System.out.println("Planeta: "+ planet);
        System.out.println("Especie: "+ race);
        System.out.println("Profesión: "+ profession);       
    }
    
    String getName (){
        return name;
    }
    
    void setVida (int valor){        
        this.vida = vida+ valor;
    }
    void lost (){
        this.vida = 0;
    }
    void setDinero (int valor){
        this.dinero= dinero+valor;
    }
    void meditate(){
        this.vida =100;
    }
    int getVida(){
        return vida;
    }
    int getDinero (){
        return dinero;
    }    
    boolean getWeapon(){
        return weapon;
    }
    void setShield (int valor){
        this.shield = shield + valor;
    }
    void loseShield(){
        this.shield = 0;
    }
    void setWeapon(Weapons w){
        weapon = true;
        armas.addElement(w);
    }
    void die (){
        vida = 0;
    }
    void chances (){
        vida = 100;
    }
    Vector getMenuArmas (){
        return armas;
    }
    int getMenuSize(){
        return armas.size();
    }
    void setMonsterspassed(){
        monsterspassed = monsterspassed+1;
    }
    int getMonsterspassed(){
        return monsterspassed;
    }
    int getShield (){
        return shield;
    }  
    String getPlanet(){
        return planet;
    }
}



package finalchallenge;
import java.util.Random;


public class Monsters {
    int vida;
    String name;
    Random r = new Random ();
    int type;
    int olife;
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_RESET = "\u001B[0m";
    
    Monsters(String name, int vida, int type){
        this.name = name;
        this.vida = vida;
        this.type = type;
        this.olife= vida;
    }
    void attack(MainCharacter p1){
        int daño = Daño();
        if (p1.getShield()>0){
            if ((p1.getShield()-daño)<0){
                int finality = p1.getShield()-daño;
                p1.setVida(finality);
                p1.loseShield();     
                int express= finality*(-1);
                System.out.println(ANSI_RED+"\n"+name+ " te ha quitado tu escudo y "+ express+ " puntos de vida."+ANSI_RESET);
            }else if ((p1.getShield()-daño)>0){
                p1.setShield(-daño);
                System.out.println(ANSI_RED+"\n"+name+" te ha quitado "+ daño+ " puntos de escudo."+ANSI_RESET);
            }else if ((p1.getShield()-daño)==0){
                p1.loseShield();
                System.out.println(ANSI_RED+"\n"+name+ " te ha quitado tu escudo."+ANSI_RESET);
            }
        }else if (p1.getShield()==0 && p1.getVida()-daño >0){
            p1.setVida(-daño);
            System.out.println(ANSI_RED+"\n"+ name+ " te ha quitado "+ daño+ " puntos de vida."+ANSI_RESET);
        }
        if (p1.getVida() + p1.getShield() -daño <= 0){
            p1.die();
            System.out.println(ANSI_RED+"\n"+ name+ " te ha quitado el resto de su vida."+ANSI_RESET);
        }
           
    }
    void defense (MainCharacter p1){
        if (vida<olife){
            int aumento =Augment();
            vida = vida+ (aumento);     
            if (vida>olife){
                int expresión = olife- (vida- aumento);
                System.out.println(ANSI_BLUE+"\n" + name+ " tuvo un aumento de "+ expresión + " puntos de vida."+ANSI_RESET);
                vida= olife;
            }else{
                System.out.println(ANSI_BLUE+"\n"+ name+ " tuvo un aumento de "+ aumento + " puntos de vida."+ANSI_RESET);
            }
        }else{
            System.out.println("\nEl Sith tuvo una mala elección.");
        }            
    }
    
    void setVida(int value){
        this.vida =vida- value;
    }
    int getVida(){
        return vida;
    }
    void die(){
        vida= 0;
    }
    String getName(){
        return name;
    }
    int Daño(){
        int dam = 0;
        switch (type){
            case 1:
                dam = 5+ r.nextInt(15);           
                break;
            case 2:
                dam = 5+ r.nextInt(20);
                break;
            case 3:
                dam = 5+ r.nextInt(25);
                break;
            case 4:
                dam = 5+r.nextInt(30);
                break;
        }
        return dam;
    }
    
    int Augment (){
        int a= 0;
        switch (type){
            case 1:
                a =5+r.nextInt(10);      
                break;
            case 2:
                a=5+r.nextInt(20);  
                break;
            case 3:
                a =5+r.nextInt(25);                             
                break;
            case 4:
                a =5+r.nextInt(30);
                break;
        }
        return a;
    }
}

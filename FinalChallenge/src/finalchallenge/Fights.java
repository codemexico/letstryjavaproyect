

package finalchallenge;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Fights {
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String YELLOW = "\033[0;33m";
    int type;
    String dialog;
    Random r = new Random();
    Scanner in = new Scanner (System.in);
    int acción;
    int acabemos = 0;
    boolean finalizer= false;
    Fights (int type){
        this.type = type;
    }   
    void Fighting(MainCharacter p1, Monsters m1, int pasados){
        if (p1.getWeapon()== true&& p1.getMonsterspassed()== pasados){
            System.out.println(d(pasados));
            int orden1 = r.nextInt(2)+1;       
            int orden2;
            if (2-orden1 == 0)
                 orden2= 1;
            else
                orden2= 2;        
            String orden []= new String [2]; 
            orden [orden1-1]= m1.getName();
            orden [orden2-1]= p1.getName();
            while (p1.getVida() >0 && m1.getVida()>0){
                System.out.println("----------------------------------------------");
                for (int i = 0; i < 2; i++) {                   
                    if(orden [i].equals(p1.getName()) ){
                        System.out.println("\n¿Qué acción gustas realizar?");
                        System.out.println("1. Atacar");
                        System.out.println("2. Defensa");
                        if(p1.getMonsterspassed()<3)
                            System.out.println("3. Huir (al huir pierdes un monto de vida aleatorio)");
                        acción = in.nextInt();
                        switch (acción){
                            case 1:
                                System.out.println("\n¿Qué arma deseas usar?");
                                Weapons finalarms []= new Weapons [0];
                                int weaponattack;                               
                                do{
                                    for (int j = 0; j < p1.getMenuSize(); j++) {
                                        Object armas []= p1.getMenuArmas().toArray();  
                                        finalarms= Arrays.copyOf(armas, armas.length, Weapons[].class);
                                        System.out.println((j+1)+". " +finalarms[j].getName());                                        
                                    }
                                    weaponattack = in.nextInt();
                                    if (!(0>weaponattack || weaponattack>p1.getMenuSize()))
                                        finalarms[weaponattack-1].Attacks(m1);
                                    if (0>weaponattack || weaponattack>p1.getMenuSize()){
                                        System.out.println("\nEsa no es una opción en el menú, vuelva a intentarlo.");
                                    }
                                }while (0>weaponattack || weaponattack>p1.getMenuSize());
                                break;
                            case 2:
                                Defenses d = new Defenses (pasados);
                                d.defending(p1);
                                break;
                            case 3:                               
                                int lost = r.nextInt(20)+5;
                                p1.setVida(-lost);
                                System.out.println("\nAl decidir huir, ha perdido "+lost +" puntos de vida.");
                                break;
                            default:
                                System.out.println("\nEsa no es una opción.");
                        }   
                        if (acción==3){
                            break;
                        }
                        if (m1.getVida() <= 0){
                            break;
                        }
                    }else if (orden [i].equals(m1.getName())){
                        System.out.println("\nTurno de "+ m1.getName()+".");
                        acción= r.nextInt(2)+1;
                        switch (acción){
                            case 1:                                       
                                m1.attack(p1);
                                break;
                            case 2:
                                m1.defense(p1);
                                break;
                        }
                        if (p1.getVida() <= 0){
                            break;
                        }
                    }                               
                }
                if (acción==3){
                    break;
                }                        
                if (p1.getVida() <=0){
                    System.out.println("----------------------------------------------");
                    p1.die();
                    System.out.println(ANSI_RED+"\nLo siento "+ p1.getName()+ " has perdido, tendrás que volver a empezar la aventura."+ANSI_RESET);
                 }else if (m1.getVida() <=0){
                    m1.die();
                    System.out.println("----------------------------------------------");
                    System.out.println("\nFelicidades "+p1.getName()+ " has ganado la batalla.");
                    switch (type){
                        case 1:
                            System.out.println("\nDebido a su victoria, has obtenido 200 créditos.");
                            p1.setDinero(200);
                            p1.setMonsterspassed();
                            System.out.println("\nSiths derrotados: "+p1.getMonsterspassed());
                            finalizer = true;
                            break;
                        case 2:
                            System.out.println("\nHas acabado con el Sith más poderoso.");
                            System.out.println("Por ende, has evitado que lleven acabo su plan.");
                            System.out.println("Eres un héroe de la galaxia, "+p1.getName()+".");
                            acabemos =1;
                            break;
                    }
                } 
                if (p1.getVida()>0 && m1.getVida()>0){
                    System.out.println("\n-Vida de "+ p1.getName()+ ": "+p1.getVida());
                    System.out.println("-Vida de "+ m1.getName()+ ": "+ m1.getVida());                          
                }
            }                          
        }else if (p1.getWeapon()== false){
            System.out.println("\nLo sentimos, no cuentas con un arma para iniciar una pelea con el Sith.");
            System.out.println("Consigue un arma y vuelve.");
        }else if (p1.getMonsterspassed() < pasados){
            System.out.println("\nLo sentimos, debes pelear con otro Sith antes de confrontar a "+ m1.getName());
        }else if (p1.getMonsterspassed() >pasados){
            System.out.println("\nLo sentimos, ya has derrotado al Sith que residía en esta caverna.");
        }
    }   
    int getAcabemos(){
        return acabemos;
    }
    boolean getFinalizer(){
        return finalizer;
    }
    String d (int pass){
        switch(pass){
            case 0:
                dialog= "\nCount Dooku se encuentra en esta caverna."+ "\n"+"\n¿Quién eres? ¿Deseas experimentar toda la ira de los Sith?";
                break;
            case 1:
                dialog="\nDarth Bane se encuentra en esta caverna."+ "\n"+"\nVeo que has logrado terminar con Dooku, a ver si puedes repetir esas artimañas conmigo.";
                break;
            case 2:
                dialog= "\nDarth Vader se encuentra en esta caverna."+ "\n"+"\nSoy el villano más famoso de todos los tiempos ¿Crees poder conmigo?";
                break;
            default:
                dialog = "";
                break;
        }
        return dialog;
    }
}

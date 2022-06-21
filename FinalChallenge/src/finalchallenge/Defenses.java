/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalchallenge;
import java.util.Random;
import java.util.Scanner;

public class Defenses {
    int monsterspassed;
    int type;
    public static final String BLUE = "\u001B[34m";
    public static final String ANSI_RESET = "\u001B[0m";
    Random r = new Random ();
    Scanner in = new Scanner (System.in);
    
    Defenses(int monsterspassed){
        this.monsterspassed= monsterspassed;   
        
    }
    void defending(MainCharacter p1){       
        if (p1.getVida()<100){
            int vidaextra;
            int aumento = 5+r.nextInt(20);
            System.out.println("\nElige un tipo de defensa:");
            System.out.println("1.Defensa única.");
            System.out.println("2.Defensa prominente.");
            System.out.println("3.Defensa ávida.");
            int tipoataque= in.nextInt();
            vidaextra = r.nextInt(3)+1;
            switch (tipoataque){
                case 1:
                    vidaextra = vidaextra+4;
                    break;
                case 2:
                    vidaextra= vidaextra*2;
                    break;
                case 3:
                    vidaextra = vidaextra+3;
                    break;                    
            }                           
            p1.setVida(aumento+ vidaextra);                                
            if (p1.getVida()>100){
                int expresión = 100- (p1.getVida()-(aumento+vidaextra));
                System.out.println(BLUE+"\n"+p1.getName()+ ", tuvo un aumento de "+ expresión + " puntos de vida."+ANSI_RESET);
                p1.meditate();
            }else{
                System.out.println(BLUE+"\n"+p1.getName()+", tuvo un aumento de "+ (aumento+vidaextra)+ " puntos de vida."+ANSI_RESET);
            }
        }else{
            System.out.println("\nSu vida es 100, no puede incrementar más.");
            System.out.println("Mala decisión");
        }           
    }
    
    int Amount(){
        int heal = 0;
        switch (monsterspassed){
            case 0:
                heal = 5+r.nextInt(15);
                break;
            case 1:
                heal = 5+r.nextInt(20);
                break;
            case 2:
                heal = 5+r.nextInt(25);
                break;
            case 3:
                heal = 5+r.nextInt(30);
                break;   
        }
        return heal;
    }      
}

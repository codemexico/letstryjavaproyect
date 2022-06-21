/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalchallenge;
import java.util.Random;
import java.util.Scanner;

public class Weapons {
    String name;
    int type;
    public static final String RED = "\u001B[31m";
    public static final String ANSI_RESET = "\u001B[0m";
    Random r = new Random ();
    Weapons (String name, int type){
        this.name = name;
        this.type = type;
    }
    
    void Attacks (Monsters m1){
        try (Scanner in = new Scanner (System.in)) {
            switch (type){
                case 0:
                    int latigo = 0;
                    while (latigo>3 ||  latigo<1){
                        System.out.println("\n¿Qué ataque deseas realizar con tu látigo?");
                        System.out.println("1. Latigazo corto.");
                        System.out.println("2. Corte lateral.");
                        System.out.println("3. Golpe largo.");
                        latigo = in.nextInt();
                        switch (latigo){
                            case 1:
                                int l = r.nextInt(10)+3;
                                if (m1.getVida() - l> 0){
                                    m1.setVida(l);
                                    System.out.println(RED+"\nLe has quitado "+ l+" puntos a "+ m1.getName()+ "."+ANSI_RESET);
                                }else{
                                    m1.die();
                                }
                                break;
                            case 2:
                                int s = r.nextInt(15)+5;
                                if (m1.getVida() - s> 0){
                                    m1.setVida(s);
                                    System.out.println(RED+"\nLe has quitado "+ s+ " puntos a "+ m1.getName()+ "."+ANSI_RESET);
                                }else{
                                    m1.die();
                                }
                                break;
                            case 3:
                                int f = r.nextInt(30);
                                if (m1.getVida() - f> 0){
                                    m1.setVida(f);
                                    System.out.println(RED+"\nLe has quitado "+ f+ " puntos a "+ m1.getName()+ "."+ANSI_RESET);
                                }else{
                                    m1.die();
                                }
                                break;
                            default:
                                System.out.println("\nEsa opción no está disponible, vuelve a intentarlo.");
                                break;
                        }
                    }                
                    break;
                case 1:
                    int blaster = 0;
                    while (blaster>3 || blaster<1){
                        System.out.println("\n¿Qué ataque deseas realizar con tu bláster?");
                        System.out.println("1. Short scope.");
                        System.out.println("2. Auto-load fire.");
                        System.out.println("3. Long shot.");
                        blaster = in.nextInt();
                        switch (blaster){
                            case 1:
                                int l = r.nextInt(15)+5;
                                if (m1.getVida() - l> 0){
                                    m1.setVida(l);
                                    System.out.println(RED+ "\nLe has quitado "+ l+" puntos a "+ m1.getName()+ "."+ANSI_RESET);
                                }else{
                                    m1.die();
                                }
                                break;
                            case 2:
                                int s = r.nextInt(20)+10;
                                if (m1.getVida() - s> 0){
                                    m1.setVida(s);
                                    System.out.println(RED+"\nLe has quitado "+ s+ " puntos a "+ m1.getName()+ "."+ANSI_RESET);
                                }else{
                                    m1.die();
                                }
                                break;
                            case 3:
                                int f = r.nextInt(40);
                                if (m1.getVida() - f> 0){
                                    m1.setVida(f);
                                    System.out.println(RED+"\nLe has quitado "+ f+ " puntos a "+ m1.getName()+ "."+ANSI_RESET);
                                }else{
                                    m1.die();
                                }
                                break;
                            default:
                                System.out.println("\nEsa opción no está disponible, vuelve a intentarlo.");
                                break;
                        }
                    } 
                    break;
                case 2:
                    int cannon = 0;
                    while (cannon>3 ||  cannon<1){
                        System.out.println("\n¿Qué ataque deseas realizar con tu cañón de partículas?");
                        System.out.println("1. Explosión.");
                        System.out.println("2. Aceleración atómica.");
                        System.out.println("3. Fuerza subatómica");
                        cannon = in.nextInt();
                        switch (cannon){
                            case 1:
                                int l = r.nextInt(30)+5;
                                if (m1.getVida() - l> 0){
                                    m1.setVida(l);
                                    System.out.println(RED+"\nLe has quitado "+ l+" puntos a "+ m1.getName()+ "."+ANSI_RESET);
                                }else{
                                    m1.die();
                                }
                                break;
                            case 2:
                                int s = r.nextInt(30)+10;
                                if (m1.getVida() - s> 0){
                                    m1.setVida(s);
                                    System.out.println(RED+"\nLe has quitado "+ s+" puntos a "+ m1.getName()+ "."+ANSI_RESET);
                                }else{
                                    m1.die();
                                }
                                break;
                            case 3:
                                int f = r.nextInt(60);
                                if (m1.getVida() - f> 0){
                                    m1.setVida(f);
                                    System.out.println(RED+"\nLe has quitado "+ f+ " puntos a "+ m1.getName()+ "."+ANSI_RESET);
                                }else{
                                    m1.die();
                                }
                                break;
                            default:
                                System.out.println("\nEsa opción no está disponible, vuelve a intentarlo.");
                                break;
                        }
                    } 
                    break;
                case 3:
                    int lanza = 0;
                    while (lanza>3 ||  lanza<1){
                        System.out.println("\n¿Qué ataque deseas realizar con tu lanza?");
                        System.out.println("1. Tiro corto.");
                        System.out.println("2. Ataque personal.");
                        System.out.println("3. Proyección.");
                        lanza = in.nextInt();
                        switch (lanza){
                           case 1:
                                int l = r.nextInt(10)+10;
                                if (m1.getVida() - l> 0){
                                    m1.setVida(l);
                                    System.out.println(RED+"\nLe has quitado "+ l +" puntos a "+ m1.getName()+ "."+ANSI_RESET);
                                }else{
                                    m1.die();
                                }
                                break;
                            case 2:
                                int s = r.nextInt(20)+5;
                                if (m1.getVida() - s> 0){
                                    m1.setVida(s);
                                    System.out.println(RED+"\nLe has quitado "+ s+" puntos a "+ m1.getName()+ "."+ANSI_RESET);
                                }else{
                                    m1.die();
                                }
                                break;
                            case 3:
                                int f = r.nextInt(30);
                                if (m1.getVida() - f> 0){
                                    m1.setVida(f);
                                    System.out.println(RED+"\nLe has quitado "+ f+ " puntos a "+ m1.getName()+ "."+ANSI_RESET);
                                }else{
                                    m1.die();
                                }
                                break;
                            default:
                                System.out.println("\nEsa opción no está disponible, vuelve a intentarlo.");
                                break;
                        }
                    } 
                    break;
                case 4:
                    int sword = 0;
                    while (sword>3 || sword<1){
                        System.out.println("\n¿Qué ataque deseas realizar con tu espada?");
                        System.out.println("1. Cortejo magistral.");
                        System.out.println("2. Esgrima explosiva.");
                        System.out.println("3. Fuerza bruta.");
                        sword = in.nextInt();
                        switch (sword){
                           case 1:
                                int l = r.nextInt(30)+10;
                                if (m1.getVida() - l> 0){
                                    m1.setVida(l);
                                    System.out.println(RED+"\nLe has quitado "+ l+" puntos a "+ m1.getName()+ "."+ANSI_RESET);
                                }else{
                                    m1.die();
                                }
                                break;
                            case 2:
                                int s = r.nextInt(40)+2;
                                if (m1.getVida() - s> 0){
                                    m1.setVida(s);
                                    System.out.println(RED+"\nLe has quitado "+s+" puntos a "+ m1.getName()+ "."+ANSI_RESET);
                                }else{
                                    m1.die();
                                }
                                break;
                            case 3:
                                int f = r.nextInt(70);
                                if (m1.getVida() - f> 0){
                                    m1.setVida(f);
                                    System.out.println(RED+"\nLe has quitado "+ f+ " puntos a "+ m1.getName()+ "."+ANSI_RESET);
                                }else{
                                    m1.die();
                                }
                                break;
                            default:
                                System.out.println("\nEsa opción no está disponible, vuelve a intentarlo.");
                                break;
                        }
                    } 
                    break;           
            }
        }
        
    }
    String getName(){
        return name;
    }
    
}

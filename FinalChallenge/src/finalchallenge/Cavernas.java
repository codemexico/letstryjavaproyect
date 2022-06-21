
package finalchallenge;
import java.util.Scanner;
import java.util.Random;


public class Cavernas {
    Scanner in = new Scanner (System.in);
    Random r = new Random ();
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String YELLOW = "\033[0;33m";
    public static final String GREEN = "\033[0;32m";
    int number;
    int monsterspassed;
    boolean treasure;
    boolean sithHistory;
    boolean shield;
    boolean story;
    boolean weapon;
    boolean enemy;
    boolean potion;
    boolean finalboss;
    int treasure1= 0;
    int treasure2= 0;
    int passwep1 = 0;
    int passshield1= 0;
    int passpotion1= 0;
    int passwep2= 0;
    int passshield2= 0;    
    int passpotion2= 0;
    int passshield3= 0;
    int passpotion3= 0;
    int acabemos = 0;
    public Cavernas (int number) {
        this.number = number;
    }
    public void action(MainCharacter p1, int sithhistory){
        switch (number){
            case 1:
                System.out.println("-------------------------------------------------------------------------------");
                System.out.println("\nHas entrado a una nueva caverna;");
                System.out.println("\nHola, bienvenido al bar Sith, aquí podrás comprar bebidas para mejorar tu salud.");
                System.out.println("¿Deseas ver el menú?");
                System.out.println("1. Sí");
                System.out.println("2. No");
                int respuesta = in.nextInt();
                if (respuesta ==1){
                    System.out.println("\nBebidas:");
                    System.out.println("1. Abrax");
                    System.out.println("2. Cerveza Agárica");
                    System.out.println("3. Champaña Daruvviana");
                    int beverage = 1;
                    while (beverage!= 0){
                        System.out.println("\n¿Te interesa saber sobre una bebida en específico?");
                        System.out.println("Elige el número de la bebida en caso de que sí.");
                        System.out.println("En caso de que no elige 0.");
                        beverage = in.nextInt();
                        switch (beverage){
                            case 0:
                                System.out.println("\n¿Te gustaría comprar alguna bebida?");
                                System.out.println("Elige el número de la que te gustaría comprar, en caso de que no elige 0.");
                                int finalanswer= in.nextInt();
                                switch (finalanswer){
                                    case 0:
                                        System.out.println("Gracias y hasta pronto.");
                                        break;
                                    case 1:
                                        if (p1.getVida()==100&& p1.getDinero() >= 50){
                                            System.out.println("\nTienes la vida completa, no puedes comprar la poción, vuelve luego.");
                                        }else if (p1.getVida()<100&& p1.getDinero() >= 50){
                                            if (p1.getVida()+10 <100){
                                                p1.setVida(10);
                                                p1.setDinero(-50);  
                                            }else if (p1.getDinero() >= 50){
                                                p1.meditate();
                                                p1.setDinero(-50);
                                            }
                                            System.out.println("\nLa poción ha hecho sus efectos.");
                                        }else if (p1.getDinero()<  50){
                                            System.out.println("\nNo se pudo realizar el pago por créditos insuficientes.");
                                        }
                                        break;
                                    case 2:
                                        if (p1.getVida()==100&& p1.getDinero() >= 70){
                                            System.out.println("\nTienes la vida completa, no puedes comprar la poción, vuelve luego.");
                                        }else if (p1.getVida()<100&& p1.getDinero() >= 70){
                                            if (p1.getVida()+20 <100){
                                                p1.setVida(20);
                                                p1.setDinero(-70);  
                                            }else if (p1.getDinero() >= 70){
                                                p1.meditate();
                                                p1.setDinero(-70);
                                            }
                                            System.out.println("\nLa poción ha hecho sus efectos.");
                                        }else if (p1.getDinero()<  70){
                                            System.out.println("\nNo se pudo realizar el pago por créditos insuficientes.");
                                        }
                                        break;
                                    case 3:
                                        if (p1.getVida()==100&& p1.getDinero() >= 90){
                                            System.out.println("\nTienes la vida completa, no puedes comprar la poción, vuelve luego.");
                                        }else if (p1.getVida()<100&& p1.getDinero() >= 90){
                                            if (p1.getVida()+30 <100){
                                                p1.setVida(30);
                                                p1.setDinero(-90);  
                                            }else if (p1.getDinero() >= 90){
                                                p1.meditate();
                                                p1.setDinero(-90);
                                            }
                                            System.out.println("\nLa poción ha hecho sus efectos.");
                                        }else if (p1.getDinero()<  90){
                                            System.out.println("\nNo se pudo realizar el pago por créditos insuficientes.");
                                        }
                                        break;
                                }
                                break;
                            case 1:
                                System.out.println("\nEl Abrax es un coñac aguamarina con vapor de especias.");
                                System.out.println("Al comprarla obtendrá +10 de vida y costará 50 créditos.");
                                break;  
                            case 2:
                                System.out.println("\nLa Cerveza Agárica es una bebida neimodiana.");
                                System.out.println("Al comprarla obtendrá +20 de vida y costará 70 créditos.");
                                break;
                            case 3:
                                System.out.println("\nLa Champaña Daruvviana es una bebida de Daruvvia.");
                                System.out.println("Al comprarla obtendrá +30 de vida y costará 90 créditos.");
                                break;
                            } 
                    }
                }else{
                    System.out.println("Gracias y hasta pronto.");
                }
                break;
            case 2:
                System.out.println("-------------------------------------------------------------------------------");
                System.out.println("\nHas entrado a una nueva caverna;");
                if (treasure1==0){
                    System.out.println("\nEn esta caverna reside un tesoro.");
                    System.out.println("Tendrás que contestar una pregunta sobre STAR WARS para ganarlo.");
                    System.out.println("\n¿Cuál es el nombre del hogar de Yoda? Contesta con el número correspondiente.");
                    System.out.println("1. Naboo");
                    System.out.println("2. Hoth");
                    System.out.println("3. Dagobah");
                    int trivia = in.nextInt();
                    if (trivia== 3){
                        System.out.println("\nFelicidades, has ganado 100 créditos.");
                        p1.setDinero(100);
                        treasure1= treasure1+1;
                    }else{
                        System.out.println("\nNo has dado la respuesta correcta, vuelve a intentarlo luego.");
                    }    
                }else{
                    System.out.println("\nAl parecer ya has ganado el tesoro que residía en esta caverna.");
                }
                break;
            case 3:
                System.out.println("-------------------------------------------------------------------------------");
                System.out.println("\nHas entrado a una nueva caverna;");
                System.out.println("\nHola, bienvenido a la tienda de armas, aquí podrás comprar armas para derrotar a los monstruos.");
                System.out.println("¿Deseas ver las armas disponibles?");
                System.out.println("1. Sí");
                System.out.println("2. No");
                int weapons = in.nextInt();
                if (weapons ==1){
                    System.out.println("\nArmas:");
                    System.out.println("1. Bláster");
                    System.out.println("2. Látigo Láser");
                    System.out.println("3. Cañón de Partículas");
                    int weapons2 = 1;
                    while (weapons2!= 0){
                        System.out.println("\n¿Te interesa saber sobre un arma en específico?");
                        System.out.println("Elige el número del arma en caso de que sí.");
                        System.out.println("En caso de que no elija 0.");
                        weapons2 = in.nextInt();
                        switch (weapons2){
                            case 0:
                                System.out.println("\n¿Te gustaría comprar algún arma?");
                                System.out.println("Elige el número del arma que te gustaría comprar, en caso de que no elige 0.");
                                int finalanswer= in.nextInt();
                                switch (finalanswer){
                                    case 0:
                                        System.out.println("\nGracias y hasta pronto.");
                                        break;
                                    case 1:
                                        if (p1.getDinero()>= 300){
                                            Weapons blaster = new Weapons("Bláster", 1);
                                            p1.setWeapon(blaster);
                                            System.out.println("\nEl arma se te ha sido equipada.");
                                        }else{
                                            System.out.println("\nDisculpa, no tienes los créditos necesarios.");
                                        }
                                        break;
                                    case 2:
                                        if (p1.getDinero()>=400){
                                            Weapons latigo = new Weapons("Látigo Láser", 0);
                                            p1.setWeapon(latigo);
                                            System.out.println("\nEl arma se te ha sido equipada.");
                                        }else{
                                            System.out.println("\nDisculpa, no tienes los créditos necesarios."); 
                                        }
                                        break;
                                    case 3:   
                                        if (p1.getDinero()>=500){
                                            Weapons cannon = new Weapons("Cañón de Partículas", 2);
                                            p1.setWeapon(cannon);
                                            System.out.println("\nEl arma se te ha sido equipada.");
                                        }else{
                                            System.out.println("\nDisculpa, no tienes los créditos necesarios."); 
                                        }
                                        break;
                                }
                                break;
                            case 1:
                                System.out.println("\nEl Bláster es el tipo de arma más usado en la galaxia tanto por militares, criminales y civiles, al disparar el arma salen ráfagas de luz basados en energía.");
                                System.out.println("Esta arma cuesta 300 créditos.");
                                break;  
                            case 2:
                                System.out.println("\nEl Látigo Láser es una de la más exótica de todas las armas que aplican la tecnología de energía de cristal. ");
                                System.out.println("Esta arma cuesta 400 créditos.");                             
                                break;
                            case 3:
                                System.out.println("\nEl Cañón de Partículas es un tipo de arma que disparaba partículas altamente ionizadas o plasma altamente ionizado. ");
                                System.out.println("Esta arma cuesta 500 créditos.");
                                break;
                            } 
                    }
                }else{
                    System.out.println("Gracias y hasta pronto.");
                }
                break;
            case 4:
                System.out.println("-------------------------------------------------------------------------------");
                System.out.println("\nHas entrado a una nueva caverna;");
                System.out.println("\nBienvenido al centro de meditación.");
                System.out.println("Aquí podrás sanar toda tu vida si deseas meditar.");
                System.out.println("El entrar a este proceso de concentración cuesta 200 créditos.");
                System.out.println("\n¿Deseas meditar?");
                System.out.println("1.Sí");
                System.out.println("2.No");
                int meditate = in.nextInt();
                if (meditate==1){
                    if (p1.getDinero()>= 200){
                        System.out.println("\nTu vida se ha restaurado completamente.");
                        System.out.println("Gracias y hasta pronto.");
                        p1.meditate();
                    }else{
                        System.out.println("\nNo tienes los créditos suficientes, hasta pronto.");
                    }
                }else{
                    System.out.println("\nHasta pronto.");
                }
                break;
            case 5:
                System.out.println("-------------------------------------------------------------------------------");
                System.out.println("\nHas entrado a una nueva caverna;");
                System.out.println("\nHola, yo soy Darth Momin, experto en la historia Sith.");
                switch (sithhistory){
                    case 1:
                        System.out.println("\nPor se tu primera vez aquí, hoy te contaré sobre la regla de dos.");
                        System.out.println("\nMil años antes de la Invasión de Naboo, los Sith vacilaron al borde de la extinción como resultado de luchas internas. ");
                        System.out.println("Después de su casi destrucción, Darth Bane emergió como el único Señor Oscuro de los Sith, lo que le permitió promulgar la Regla de Dos.");
                        System.out.println("De ahora en adelante, solo habría dos Lores Sith —un Maestro y un aprendiz— en cualquier momento dado.");
                        System.out.println("\nEso fue todo, hasta luego.");
                        break;
                    case 2:
                        System.out.println("\nHola de nuevo amigo.");
                        System.out.println("\nHoy te contaré del lado oscuro de la fuerza.");
                        System.out.println("Las personas que utilizaban el Lado Oscuro obtenían su poder de emociones desatadas como la ira, el odio y la agresividad.");
                        System.out.println("Los Sith fueron los mayores practicantes del Lado Oscuro y eran los enemigos mortales de la Orden Jedi, que seguía el Lado Luminoso de la Fuerza.");
                        System.out.println("Hubo otros como la Inquisición, que también explotaron los poderes del Lado Oscuro.");
                        System.out.println("\nEso fue todo, hasta luego.");
                        break;
                    case 3:
                        System.out.println("\nHola de nuevo amigo.");
                        System.out.println("\nHoy te contaré sobre el fundador de los Sith.");
                        System.out.println("Miles de años antes de las Guerras Clon, un «Jedi rebelde» estudió las artes prohibidas del lado oscuro de la Fuerza y se exilió de la Orden Jedi.");
                        System.out.println("Él y sus seguidores desataron el período de tiempo conocido como los Cien Años de Oscuridad, de donde nacieron los Sith.");
                        System.out.println("\nEso fue todo, hasta luego.");                        
                        break;
                    case 4:
                        System.out.println("\nHola de nuevo amigo.");
                        System.out.println("\nEl Código de los Sith, también conocido como Qotsisajak, era un mantra que expresaba las creencias centrales de los Sith.");
                        System.out.println("Le enseñaba especialmente a sus seguidores que los fuertes debian destruir a los débiles.");
                        System.out.println("\nEso fue todo, hasta luego.");                       
                        break;
                    default:
                        System.out.println("\nAl parecer ya has estado 4 veces en esta caverna, creo que ya se me acabó la historia Sith para contarte.");
                        break;
                }
                break;
            case 6:
                System.out.println("-------------------------------------------------------------------------------");  
                System.out.println("\nHas entrado a una nueva caverna;");
                if (passwep1== 0){
                    System.out.println("\nEn esta caverna reside un arma.");
                    System.out.println("Esta arma es una lanza.");
                    System.out.println("El arma se te ha sido equipada.");
                    Weapons lanza = new Weapons ("Lanza", 3);        
                    p1.setWeapon(lanza);
                    passwep1=passwep1+1;
                }else{
                    System.out.println("\nYa has equipado el arma que residía en esta caverna.");
                }
                break;
            case 7:
                System.out.println("-------------------------------------------------------------------------------");  
                System.out.println("\nHas entrado a una nueva caverna;");  
                if (passshield1== 0){
                    System.out.println("\nEn esta caverna reside un escudo.");
                    System.out.println("Este escudo equivale a 10 puntos extra de protección.");
                    System.out.println("El escudo se te ha sido equipada.");
                    p1.setShield(10);
                    passshield1= passshield1+1;
                }else{
                    System.out.println("\nYa has equipado el escudo que residía en esta caverna.");
                }                             
                break;
            case 8:
                System.out.println("-------------------------------------------------------------------------------");               
                System.out.println("\nHas entrado a una nueva caverna;");
                if (passpotion1== 0){
                    System.out.println("\nEn esta caverna reside una poción.");
                    System.out.println("Esta poción te sanará 10 puntos de vida.");
                    if (p1.getVida()==100){
                        System.out.println("Tienes la vida completa, no puedes usar la poción, vuelve luego.");
                    }else if (p1.getVida()<100){
                        if (p1.getVida()+10 <100){
                            p1.setVida(10);   
                        }else{
                            p1.meditate();
                        }
                        System.out.println("La poción ha hecho sus efectos.");
                        passpotion1=passpotion1+1;
                    }
                }else{
                    System.out.println("\nYa has tomado la poción que residía en esta caverna.");
                } 
                break;
            case 9:
                System.out.println("-------------------------------------------------------------------------------");               
                System.out.println("\nHas entrado a una nueva caverna;");
                if (passwep2== 0){
                    System.out.println("\nEn esta caverna reside un arma.");
                    System.out.println("Esta arma es una espada mandaloriana.");
                    System.out.println("El arma se te ha sido equipada.");
                    Weapons sword = new Weapons ("Dark Sword", 4);
                    p1.setWeapon(sword);
                    passwep2= passwep2+1;
                }else{
                    System.out.println("\nYa has equipado el arma que residía en esta caverna.");
                }
                break;                
            case 10:
                System.out.println("-------------------------------------------------------------------------------");  
                System.out.println("\nHas entrado a una nueva caverna;");  
                if (passshield2== 0){
                    System.out.println("\nEn esta caverna reside un escudo.");
                    System.out.println("Este escudo equivale a 15 puntos extra de protección.");
                    System.out.println("El escudo se te ha sido equipado.");
                    p1.setShield(15);
                    passshield2= passshield2+1;
                }else{
                    System.out.println("\nYa has equipado el escudo que residía en esta caverna.");
                }                             
                break;
                
            case 11:
                System.out.println("-------------------------------------------------------------------------------");
                System.out.println("\nHas entrado a una nueva caverna;");
                if (passpotion2== 0){
                    System.out.println("\nEn esta caverna reside una poción.");
                    System.out.println("Esta poción te sanará 15 puntos de vida.");
                    if (p1.getVida()==100){
                        System.out.println("\nTienes la vida completa, no puedes usar la poción, vuelve luego.");
                    }else if (p1.getVida()<100){
                        if (p1.getVida()+15 <100){
                            p1.setVida(15);   
                        }else{
                            p1.meditate();
                        }
                        System.out.println("La poción ha hecho sus efectos.");
                        passpotion2=passpotion2+1;
                    }
                }else{
                    System.out.println("\nYa has tomado la poción que residía en esta caverna.");
                } 
                break;  
            case 12:
                System.out.println("-------------------------------------------------------------------------------");
                System.out.println("\nHas entrado a una nueva caverna;");
                if (treasure2==0){
                    System.out.println("\nEn esta caverna reside un tesoro.");
                    System.out.println("Tendrás que contestar una pregunta sobre STAR WARS para ganarlo.");
                    System.out.println("\n¿Dónde comenzaron las Guerras Clon? Contesta con el número correspondiente.");
                    System.out.println("1. Tatooine");
                    System.out.println("2. Geonosis");
                    System.out.println("3. Naboo");
                    int trivia = in.nextInt();
                    if (trivia== 2){
                        System.out.println("\nFelicidades, has ganado 100 créditos.");
                        p1.setDinero(100);
                        treasure2= treasure2+1;
                    }else{
                        System.out.println("\nNo has dado la respuesta correcta, vuelve a intentarlo.");
                    }    
                }else{
                    System.out.println("\nAl parecer ya has ganado el tesoro que residía en esta caverna.");
                }               
                break;
            case 13:
                Monsters m1 = new Monsters ("Count Dooku", 85,1);
                System.out.println("-------------------------------------------------------------------------------");
                System.out.println("\nHas entrado a una nueva caverna;");
                System.out.println("\nEn esta caverna reside un Sith que tendrás que derrotar para acabar con su plan.");
                Fights pelea1 = new Fights (1);
                pelea1.Fighting(p1, m1, 0);
                if (p1.getMonsterspassed()==1){
                    System.out.println("\nHas encontrado la primera parte de los planos del arma de supresión Sith.");
                    System.out.println(ANSI_BLUE+"\n                      Planos del Arma de Supresión Sith\n" +
                                        "\n" +ANSI_BLUE+
                                        "          ______         ______      El arma definitiva para los planes Sith\n" +ANSI_BLUE+
                                        "         / ____ \\_______/ ____ \\     Cada nivel está diseñado sistemáticamente\n" +ANSI_BLUE+
                                        "        / /    \\_________/    \\ \\    para traer orden a la galaxia.\n" +ANSI_BLUE+
                                        "       / /      |   3   |  5   \\ \\   Los que se rieron del grandioso Darth Jar Jar\n" +ANSI_BLUE+
                                        "       \\ \\       \\_____/_______/ /   serán vueltos cenizas. Ubicación: Exegol\n" +ANSI_BLUE+
                                        "       / /    o   |o o|   o    \\ \\\n" +ANSI_BLUE+
                                        "    __/ /  2    .' o4o `.    6  \\ \\__    1 ... Galería de almacén (levels 1-2),"+ANSI_RESET);
                }
                break;
            case 14:
                Monsters m2 = new Monsters ("Darth Bane", 90, 2);
                System.out.println("-------------------------------------------------------------------------------");                
                System.out.println("\nHas entrado a una nueva caverna;");
                System.out.println("\nEn esta caverna reside un Sith que tendrás que derrotar para acabar con su plan.");
                Fights pelea2 = new Fights (1);
                pelea2.Fighting(p1, m2, 1);
                if (p1.getMonsterspassed()==2){
                    System.out.println("\nHas encontrado la segunda parte de los planos del arma de supresión Sith.");
                    System.out.println(ANSI_BLUE+"\n                      Planos del Arma de Supresión Sith\n" +
                                        "\n" +ANSI_BLUE+
                                        "          ______         ______      El arma definitiva para los planes Sith\n" +ANSI_BLUE+
                                        "         / ____ \\_______/ ____ \\     Cada nivel está diseñado sistemáticamente\n" +ANSI_BLUE+
                                        "        / /    \\_________/    \\ \\    para traer orden a la galaxia.\n" +ANSI_BLUE+
                                        "       / /      |   3   |  5   \\ \\   Los que se rieron del grandioso Darth Jar Jar\n" +ANSI_BLUE+
                                        "       \\ \\       \\_____/_______/ /   serán vueltos cenizas. Ubicación: Exegol\n" +ANSI_BLUE+
                                        "       / /    o   |o o|   o    \\ \\\n" +ANSI_BLUE+
                                        "    __/ /  2    .' o4o `.    6  \\ \\__    1 ... Galería de almacén (levels 1-2),\n" +ANSI_BLUE+
                                        "   / __/      .' ._o_o_. `.      \\__ \\         Armeria (levels 3-4), Sala de\n" +ANSI_BLUE+
                                        "  / /  `-.  .' .'  10   `. `.  .-'  \\ \\        recreación y entrenamiento\n" +ANSI_BLUE+
                                        " / /      ~' .'`-._____.-'`. `~      \\ \\       (level 5)\n" +ANSI_BLUE+
                                        " \\ \\     o  <  C  | | |  D  >  o  7  / / 2 ... Stormtrooper check in(levels\n" +ANSI_BLUE+
                                        "  \\ \\__      \\    ' ' '    /      __/ /        1-3), Sala de monitoreo y control.\n" +ANSI_BLUE+
                                        "   \\__ \\  1  |----  9  ----|~-._ / __/         (levels 4-5)\n" +ANSI_BLUE+
                                        "      \\ \\    |====    B====|    Y /      3 .. Generadores de energía (levels 1-5)\n" +ANSI_BLUE+
                                        "       \\ \\   |----     ----|   / /       4 ..... Computadora central (levels 1-6)\n" +ANSI_BLUE+
                                        "       / /   |__A_     _ __| 8 \\ \\       5 .... Bloque de detención(levels 1-5)"+ANSI_RESET);
                }
                break;
            case 15:
                Monsters m3 = new Monsters ("Darth Vader", 95, 3);
                System.out.println("-------------------------------------------------------------------------------");              
                System.out.println("\nHas entrado a una nueva caverna;");
                System.out.println("\nEn esta caverna reside un Sith que tendrás que derrotar para acabar con su plan.");
                Fights pelea3 = new Fights (1);
                pelea3.Fighting(p1, m3, 2);
                if (pelea3.getFinalizer()==true){
                    System.out.println("\nHas encontrado la última parte de los planos del arma de supresión Sith.");
                    System.out.println(ANSI_BLUE+"\n                      Planos del Arma de Supresión Sith\n" +
                                        "\n" +ANSI_BLUE+
                                        "          ______         ______      El arma definitiva para los planes Sith\n" +ANSI_BLUE+
                                        "         / ____ \\_______/ ____ \\     Cada nivel está diseñado sistemáticamente\n" +ANSI_BLUE+
                                        "        / /    \\_________/    \\ \\    para traer orden a la galaxia.\n" +ANSI_BLUE+
                                        "       / /      |   3   |  5   \\ \\   Los que se rieron del grandioso Darth Jar Jar\n" +ANSI_BLUE+
                                        "       \\ \\       \\_____/_______/ /   serán vueltos cenizas. Ubicación: Exegol\n" +ANSI_BLUE+
                                        "       / /    o   |o o|   o    \\ \\\n" +ANSI_BLUE+
                                        "    __/ /  2    .' o4o `.    6  \\ \\__    1 ... Galería de almacén (levels 1-2),\n" +ANSI_BLUE+
                                        "   / __/      .' ._o_o_. `.      \\__ \\         Armeria (levels 3-4), Sala de\n" +ANSI_BLUE+
                                        "  / /  `-.  .' .'  10   `. `.  .-'  \\ \\        recreación y entrenamiento\n" +ANSI_BLUE+
                                        " / /      ~' .'`-._____.-'`. `~      \\ \\       (level 5)\n" +ANSI_BLUE+
                                        " \\ \\     o  <  C  | | |  D  >  o  7  / / 2 ... Stormtrooper check in(levels\n" +ANSI_BLUE+
                                        "  \\ \\__      \\    ' ' '    /      __/ /        1-3), Sala de monitoreo y control.\n" +ANSI_BLUE+
                                        "   \\__ \\  1  |----  9  ----|~-._ / __/         (levels 4-5)\n" +ANSI_BLUE+
                                        "      \\ \\    |====    B====|    Y /      3 .. Generadores de energía (levels 1-5)\n" +ANSI_BLUE+
                                        "       \\ \\   |----     ----|   / /       4 ..... Computadora central (levels 1-6)\n" +ANSI_BLUE+
                                        "       / /   |__A_     _ __| 8 \\ \\       5 .... Bloque de detención(levels 1-5)\n" +ANSI_BLUE+
                                        "       \\ \\      | |   | |      / /       6 ... Zona de atención\n" +ANSI_BLUE+
                                        "        \\ \\_____| |   | |_____/ /              (levels 1-5)\n" +ANSI_BLUE+
                                        "         \\_____ `o|   |o' _____/         7 ... Tienda de recuerdos (levels 1-2),\n" +ANSI_BLUE+
                                        "               `--'   `--'                     Ala médica   (level   3),\n" +ANSI_BLUE+
                                        "                                               Laboratorios (levels 4-5)"+ANSI_RESET);
                    
                    System.out.println("-------------------------------------------------------------------------------");  
                    if (p1.getMonsterspassed()==3){
                        System.out.println("\nDespués de haber encontrado todos los planos sabes dónde reside el Sith supremo, por lo tanto puedes acabar con él.");
                        System.out.println("\nSube a la nave y usa la parte trasera de los planos, estas contienen las coordenadas del Sith supremo.");
                        int travfin;
                        do{
                            System.out.println("\n¿Qué deseas hacer?");
                            System.out.println("1. Viajar a las coordenadas del Sith supremo.");
                            System.out.println("2. Quedarse en las cavernas.");
                            travfin= in.nextInt();
                            if (travfin==1){
                                System.out.println(ANSI_CYAN+"\n"+"               |||      |||\n" +ANSI_CYAN+
                                                    "               | |  __  | |\n" +ANSI_CYAN+
                                                    "|-|_____-----/   |_|  |_|   \\-----_____|-|\n" +ANSI_CYAN+
                                                    "|_|_________{   }|  (^) |{  }__________|_|\n" +ANSI_CYAN+
                                                    " ||          |_| |   ^  | |_|          ||\n" +ANSI_CYAN+
                                                    " |              \\|  /\\  |/              |\n" +ANSI_CYAN+
                                                    " |               \\ |--| /               |\n" +ANSI_CYAN+
                                                    " =               \\ |__| /               =\n" +ANSI_CYAN+
                                                    " +               \\      /               +\n" +ANSI_CYAN+
                                                    "                  \\    /\n" +ANSI_CYAN+
                                                    "                  \\    /\n" +ANSI_CYAN+
                                                    "                   \\  /\n" +ANSI_CYAN+
                                                    "                   \\  /\n" +ANSI_CYAN+
                                                    "                   \\  /\n" +ANSI_CYAN+
                                                    "                   \\  /\n" +ANSI_CYAN+
                                                    "                   \\  /\n" +ANSI_CYAN+
                                                    "                   \\  /\n" +ANSI_CYAN+
                                                    "                    \\/\n" +ANSI_RESET);
                                System.out.println("-------------------------------------------------------------------------------");
                                System.out.println("\nHAS LLEGADO AL FINAL DE ESTA TRAVESÍA.;");
                                System.out.println("TODO DEPENDERÁ DE ACABAR CON EL SITH SUPREMO.");
                                System.out.println("\nHoladola, "+p1.getName()+ ". Imagino que no esperabas que misa fuera el Sith supremo.");
                                System.out.println("\n*Darth Jar Jar Binks es introducido como el Sith Supremo*");
                                System.out.println("\nNormal, todos me subestiman desde el Episodio I.");
                                System.out.println("Pero, misa veo que has logrado derrotar misa discípulos.");
                                System.out.println("Misa no seré mui fácil."); 
                                Monsters finalMonster = new Monsters ("Darth Jar Jar Binks", 100, 4);
                                Fights pelea4 = new Fights (2);
                                pelea4.Fighting(p1, finalMonster, 3);
                                acabemos = pelea4.getAcabemos();
                            }else{
                                System.out.println("\nEs indispensable que confrontes al Sith supremo para salvar la galaxia.");
                            }
                        }while (travfin!=1);
                        
                    }
                    
                }
                break;
            case 16:               
                System.out.println("-------------------------------------------------------------------------------");               
                System.out.println("\nHas entrado a una nueva caverna;");
                System.out.println("\n¿Qué hace en Exegol, acaso es un nuevo Sith?");
                System.out.println("Estoy a los servicios de todos los Sith.");
                System.out.println(YELLOW+"           ____\n" +YELLOW+
                                    "          / ___\\\n" +YELLOW+
                                    "         |: =O =O\n" +YELLOW+
                                    "         |:: __ |\n" +YELLOW+
                                    "          \\_/LLL\\\n" +YELLOW+
                                    "    __ __./:__:\\.__ __\n" +YELLOW+
                                    "   (%%i \\ |<__>| / i%%)\n" +YELLOW+
                                    "   |--|:/\\/ :: \\/\\:|--|\n" +YELLOW+
                                    "   |  |:  :====:  :|  |\n" +YELLOW+
                                    "  .':.'Y-\" |::| \"-Y`.:`.\n" +YELLOW+
                                    "  |__| | : |__|.-.| |__|\n" +YELLOW+
                                    "  (%%) | : /++\\`-'! (%%)\n" +YELLOW+
                                    "   \\  \\|n._\\++/_.n| /  /\n" +YELLOW+
                                    "    \\ xT::::--::::T/  /\n" +YELLOW+
                                    "     \\Xl-. `\"\"' .-lXX'\n" +YELLOW+
                                    "       |: \\    / :|\n" +YELLOW+
                                    "       |:  i--i  :|\n" +YELLOW+
                                    "       |:  |  |  :| LS\n" +YELLOW+
                                    "       |___|  |__;|\n" +YELLOW+
                                    "       P%%%Y  P%%%Y\n" +YELLOW+
                                    "       b%%%d  b%%%d               "+ANSI_RESET);
                break;
            case 17:
                System.out.println("-------------------------------------------------------------------------------");               
                System.out.println("\nHas entrado a una nueva caverna;");
                System.out.println("\n¡Hola! El imperio está tramando en construir un arma de destrucción masiva. \n" +
                                    "Vader está apoyando a su construcción.\n" +
                                    "Nos queda poco tiempo si es que deseamos detenerlos. \n" +
                                    "Los wookie como yo nos quedaremos aquí escondidos. \n" +
                                    "Suerte en tu travesía "+p1.getName()+".");
                break;
            case 18:
                System.out.println("-------------------------------------------------------------------------------");               
                System.out.println("\nHas entrado a una nueva caverna;");
                System.out.println("\n¡NO PORFAVOR! Ah eres tú. Si los rumores son ciertos, los Sith están \n"  +
                                    "más cerca que nunca de generar un arma capaz de esclavizar a toda la \n" +
                                    "galaxia. Huye mientras puedas.");
                break;
            case 19:
                System.out.println("-------------------------------------------------------------------------------");               
                System.out.println("\nHas entrado a una nueva caverna;");
                System.out.println("\nAAAAAH AAAAAAAH. Te haz topado con un Porg. Los porg son pequeñas \n" +
                                    "criaturas aviares nativas del planeta Ahch-To. Los rumores dicen que \n" +
                                    "saben muy bien cocinadas.");
                break;
            case 20:
                System.out.println("-------------------------------------------------------------------------------");               
                System.out.println("\nHas entrado a una nueva caverna;");
                System.out.println("\nEy tú sí tú. Ay no. Si no. No sé. Vader. Bane. Dooku. Broma. Sale. \n" +
                                    "Caverna. Muerte. No tiene fin. No puedo. Sal. No tú sal. ¡TODA LA \n" +
                                    "GALAXIA ESTÁ PERDIDA!");
                break;
            case 21:
                System.out.println("-------------------------------------------------------------------------------");               
                System.out.println("\nHas entrado a una nueva caverna;");
                System.out.println("\nEsta es una caverna rara porque contiene una imagen del maestro Yoda en el planeta Sith.");
                System.out.println("Probablemente es una muestra de su odio hacia este sabio Jedi.\n");
                System.out.println(GREEN+"         _.=+._\n" +GREEN+
                                    ":.\\`--._/[_/~|;\\_.--'/.:::\n" +GREEN+
                                    "::.`.  ` __`\\.-.(  .'.::::\n" +GREEN+
                                    "::::.`-:.`'..`-'/\\'.::::::\n" +GREEN
                                    + ":::::::.\\ `--')/  ) ::::::\n"+GREEN
                                    +"          `--'\n" +
                                    "\n"+ANSI_RESET);
                break;
            case 22:
                System.out.println("-------------------------------------------------------------------------------");               
                System.out.println("\nHas entrado a una nueva caverna;");
                System.out.println("\nHola, soy Boba Fett, cazarecompensas para Darth Vader, ¿lo has visto?\n");               
                System.out.println(GREEN+"           |~\n" +GREEN+
                "           |.---.\n" +GREEN+
                "          .'_____`. /\\\n" +GREEN+
                "          |~xxxxx~| ||\n" +GREEN+
                "          |_  #  _| ||\n" +GREEN+
                "     .------`-#-'-----.\n" +GREEN+
                "    (___|\\_________/|_.`.\n" +GREEN+
                "     /  | _________ | | |\n" +GREEN+
                "    /   |/   _|_   \\| | |\n" +GREEN+
                "   /   /X|  __|__  |/ `.|\n" +GREEN+
                "  (  --< \\\\/    _\\//|_ |`.\n" +GREEN+
                "  `.    ~----.-~=====,:=======\n" +GREEN+
                "    ~-._____/___:__(``/| |\n" +GREEN+
                "      |    |      XX|~ | |\n" +GREEN+
                "       \\__/======| /|  `.|\n" +GREEN+
                "       |_\\|\\    /|/_|    )\n" +GREEN+
                "       |_   \\__/   _| .-'\n" +GREEN+
                "       | \\ .'||`. / |(_|\n" +GREEN+
                "       |  ||.'`.||  |   )\n" +GREEN+
                "       |  `'|  |`'  |  /\n" +GREEN+
                "       |    |  |    |\\/   t\n"+ANSI_RESET);
                break;
            case 23:
                System.out.println("-------------------------------------------------------------------------------");               
                System.out.println("\nHas entrado a una nueva caverna;");
                if (passshield3== 0){
                    System.out.println("\nEn esta caverna reside un escudo.");
                    System.out.println("Este escudo equivale a 10 puntos extra de protección.");
                    System.out.println("El escudo se te ha sido equipado.");
                    p1.setShield(10);
                    passshield3= passshield3+1;
                }else{
                    System.out.println("\nYa has equipado el escudo que residía en esta caverna.");
                }
                break;
            case 24:
                System.out.println("-------------------------------------------------------------------------------");               
                System.out.println("\nHas entrado a una nueva caverna;");
                if (passpotion3== 0){
                    System.out.println("\nEn esta caverna reside una poción.");
                    System.out.println("Esta poción te sanará 15 puntos de vida.");
                    if (p1.getVida()==100){
                        System.out.println("\nTienes la vida completa, no puedes usar la poción, vuelve luego.");
                    }else if (p1.getVida()<100){
                        if (p1.getVida()+15 <100){
                            p1.setVida(15);   
                        }else{
                            p1.meditate();
                        }
                        System.out.println("La poción ha hecho sus efectos.");
                        passpotion3=passpotion3+1;
                    }
                }else{
                    System.out.println("\nYa has tomado la poción que residía en esta caverna.");
                } 
                break;
            case 25:
                System.out.println("-------------------------------------------------------------------------------");               
                System.out.println("\nHas entrado a una nueva caverna;");
                System.out.println("\nEsta es la entrada a las cavernas.");
                System.out.println("Aquí puede ver sus puntos de vida y sus créditos.");
                System.out.println("\n¿Desea ver esta información?");
                System.out.println("1. Sí");
                System.out.println("2. No");
                int ans = in.nextInt();
                if (ans == 1){
                    System.out.println("\nSALUD Y DINERO");
                    System.out.println("-Vida: "+ p1.getVida());
                    System.out.println("-Dinero: "+p1.getDinero());
                    System.out.println("\nHasta pronto.");
                }else{
                    System.out.println("\nGracias y hasta pronto.");
                }
                break;                
        }
    }
    int getNumber(){
        return number;
    }
    void setAcabemos(int v){
        this.acabemos = v;
    }
    int getAcabemos (){
        return acabemos;
    }
}

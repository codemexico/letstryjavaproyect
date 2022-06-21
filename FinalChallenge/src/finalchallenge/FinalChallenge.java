/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalchallenge;

import java.util.Scanner;

public class FinalChallenge {
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String YELLOW = "\033[0;33m";
    static Scanner in = new Scanner (System.in);
    static MainCharacter p1;
    static int decisión;
    static MainCharacter lista [] = new MainCharacter[11];
    static Monsters list []= new Monsters [5];
    static Cavernas [] [] mapa = new Cavernas [5][5];
    static int positionx;
    static int positiony;
    static int movement;
    static int treasure= 0;
    static int sithhistory=0;
    static int r;
    static int f;
    static int acabemos = 0;
    
    public static void main(String[] args) {
        CharCreator();       
        p1.print();
        wait(2);
        int dec = 1;
        while (dec ==1){
            p1.chances();
            positionx= 0;
            positiony= 0;
            System.out.println("-------------------------------------------------------------------------------");
            System.out.println("Antes de empezar o continuar con el juego ¿Deseas leer las instrucciones?");
            System.out.println("1. Sí");
            System.out.println("2. No");
            int instrucciones = in.nextInt();
            if (instrucciones==1){
                instrucciones();
                wait(25);
            }               
            decisión = Decision();           
            if (decisión ==1){
                int x ;
                int y;
                System.out.println("-------------------------------------------------------------------------------");
                System.out.println("\nHas aceptado el viaje más peligroso de la galaxia. ");
                System.out.println("Sígueme, tenemos que dirigirnos a Exegol inmediatamente para acabar con el plan de los Sith.");
                System.out.println("\n*DISPAROS SE ESCUCHAN EN EL FONDO*");
                System.out.println("\nMe siguieron hasta tu planeta.");
                System.out.println("Tendrás que enfrentar este viaje solo, corre a la nave mientras los distraigo.");
                do {
                    System.out.println("\n¿Qué deseas hacer, "+ p1.getName() + "?");
                    System.out.println("\n1. Disparar y correr.");
                    System.out.println("2. Ayudar a Kanan Jarrus.");
                    x = in.nextInt();
                    if (x==1) {
                        System.out.println("\nHas logrado llegar a la nave, excelente.");
                        do{
                            System.out.println("\n¿Qué deseas hacer, "+ p1.getName() + "?");
                            System.out.println("1. Saltar al hiperespacio");
                            System.out.println("2. Regresar a "+p1.getPlanet()+".");
                            y=in.nextInt();
                            if (y==1) {
                                System.out.println("\nAhora nos dirijimos a Exegol para detener a los Sith.");
                            }
                            if (y!=1) {
                                System.out.println("\nNecesitas saltar al hiperespacio para detener a los Sith, es muy tarde para darse la vuelta.");
                            }
                        }while(y!=1);
                    }
                    if (x!=1) {
                        System.out.println("\n"+p1.getName() + ", es muy tarde para salvarlo.");
                        System.out.println("Es más importante salvar a la galaxia.");
                    }
                } while (x!=1);        
                System.out.println(ANSI_CYAN+"               __\n" +ANSI_CYAN+
                                    "    .-.__      \\ .-.  ___  __|_|\n" +ANSI_CYAN+
                                    "'--.-.-(   \\/\\;;\\_\\.-._______.-.\n" +ANSI_CYAN+
                                    "    (-)___     \\ \\ .-\\ \\;;\\(   \\       \\ \\\n" +ANSI_CYAN+
                                    "     Y    '---._\\_((Q)) \\;;\\\\ .-\\     __(_)\n" +ANSI_CYAN+
                                    "     I           __'-' / .--.((Q))---'    \\,\n" +ANSI_CYAN+
                                    "     I     ___.-:    \\|  |   \\'-'_          \\\n" +ANSI_CYAN+
                                    "     A  .-'      \\ .-.\\   \\   \\ \\ '--.__     '\\\n" +ANSI_CYAN+
                                    "     |  |____.----((Q))\\   \\__|--\\_      \\     '\n" +ANSI_CYAN+
                                    "        ( )        '-'  \\_  :  \\-' '--.___\\\n" +ANSI_CYAN+
                                    "         Y                \\  \\  \\       \\(_)\n" +ANSI_CYAN+
                                    "         I                 \\  \\  \\         \\,\n" +ANSI_CYAN+
                                    "         I                  \\  \\  \\          \\\n" +ANSI_CYAN+
                                    "         A                   \\  \\  \\          '\\\n" +ANSI_CYAN+
                                    "         |                    \\  \\__|           '\n" +ANSI_CYAN+
                                    "                               \\_:.  \\\n" +ANSI_CYAN+
                                    "                                 \\ \\  \\\n" +ANSI_CYAN+
                                    "                                  \\ \\  \\\n" +ANSI_CYAN+
                                    "                                   \\_\\_|\n"+ANSI_RESET );
                System.out.println("\nHas llegado a las cavernas de Exegol, donde encontrarás a los Sith para derrotarlos.");
                map();
                while (p1.getVida()>0&& acabemos==0){
                   System.out.println("-------------------------------------------------------------------------------");
                    System.out.println("\n¿A dónde deseas ir, "+ p1.getName() + "?");
                    System.out.println("1. Adelante");
                    System.out.println("2. Atrás");
                    System.out.println("3. Derecha");
                    System.out.println("4. Izquierda");               
                    movement = in.nextInt();                   
                    moving (movement); 
                    if (r!=positionx || f!= positiony ){
                        switch (mapa[positiony][positionx].getNumber()){
                            case 5:
                                sithhistory = sithhistory+1;
                                break;                              
                        }
                        mapa[positiony][positionx].action(p1, sithhistory); 
                        acabemos =mapa[positiony][positionx].getAcabemos();
                        if (acabemos==1){
                            dec = 2;
                        }
                    }        
                }
                if (p1.getVida()== 0&&acabemos !=1){
                    System.out.println("-------------------------------------------------------------------------------");
                    System.out.println("\n¿Deseas volver a jugar con el mismo personaje?");
                    System.out.println("1. Sí");
                    System.out.println("2. No");
                    dec = in.nextInt();
                    if (dec == 2){
                        System.out.println("\nEsperamos volver a verte pronto, gracias por jugar STAR WARS MIDDLE BATTLE.");
                    }
                }
                if (acabemos==1){
                    System.out.println("-------------------------------------------------------------------------------");
                    System.out.println(ANSI_BLUE+"\n                     GRACIAS POR JUGAR STAR WARS MIDDLE BATTLE");
                    System.out.println(ANSI_BLUE+"\n                               HAS SALVADO LA GALAXIA.");
                    System.out.println(ANSI_BLUE+"   ______________________________________________________________________\n" +ANSI_BLUE+
                                        "            ________   ___   ____\n" +ANSI_BLUE+
                                        "           / __   __| / _ \\ |  _ \\\n" +ANSI_BLUE+
                                        "     ______> \\ | |   |  _  ||    /_____________________________\n" +ANSI_BLUE+
                                        "    / _______/ |_|   |_| |_||_|\\______________________________ \\\n" +ANSI_BLUE+
                                        "   / /                                                        \\ \\\n" +ANSI_BLUE+
                                        "  | |                                                          | |\n" +ANSI_BLUE+
                                        "  | |                        CRÉDITOS:                         | |\n" +ANSI_BLUE+
                                        "  | |                        Creadores:                        | |\n" +ANSI_BLUE+
                                        "  | |                      -Santiago Mejía                     | |\n" +ANSI_BLUE+
                                        "  | |                      -Gerardo Calderón                   | |\n" +ANSI_BLUE+
                                        "  | |                        Arte Ascii:                       | |\n" +ANSI_BLUE+
                                        "  | |                   -Christopher Johnson                   | |\n" +ANSI_BLUE+
                                        "  | |                          Trivia:                         | |\n" +ANSI_BLUE+
                                        "  | |                     -Starwars.fandom                     | |\n" +ANSI_BLUE+
                                        "   \\ \\____________________________    _   ___   ____   _______/ /\n" +ANSI_BLUE+
                                        "    \\___________________________  |  | | / _ \\ |  _ \\ / _______/\n" +ANSI_BLUE+
                                        "                                | |/\\| ||  _  ||    / > \\        LS\n" +ANSI_BLUE+
                                        "                                 \\_/\\_/ |_| |_||_|\\_\\|__/\n");
                }
            }else{
                System.out.println("\nBueno, entonces seguiré por mi camino y trataré de salvar la galaxia.");
                System.out.println("Tú regresa a dormir, a tu simple vida.");
                System.out.println("No te conviertas en un héroe.");
                System.out.println("Regresa con mucha vergüenza.");
                System.out.println("\n*VUELVES A DORMIRTE*");
                System.out.println(ANSI_RED+"                             ____\n" +ANSI_RED+
                                    "                     __,-~~/~    `---.\n" +ANSI_RED+
                                    "                   _/_,---(      ,    )\n" +ANSI_RED+
                                    "               __ /        <    /   )  \\___\n" +ANSI_RED+
                                    "- ------===;;;'====------------------===;;;===----- -  -\n" +ANSI_RED+
                                    "                  \\/  ~\"~\"~\"~\"~\"~\\~\"~)~\"/\n" +ANSI_RED+
                                    "                  (_ (   \\  (     >    \\)\n" +ANSI_RED+
                                    "                   \\_( _ <         >_>'\n" +ANSI_RED+
                                    "                      ~ `-i' ::>|--\"\n" +ANSI_RED+
                                    "                          I;|.|.|\n" +ANSI_RED+
                                    "                         <|i::|i|`.\n" +ANSI_RED+
                                    "                        (` ^'\"`-' \")\n"+ANSI_RESET);
                System.out.println(ANSI_RED+"\n                     FIN DE LA GALAXIA."+ANSI_RESET);
                break;
            }   
        } 
    }
    public static void instrucciones(){
        System.out.println("-------------------------------------------------------------------------------");
        System.out.println ("                     MANUAL DE INSTRUCCIONES");
        System.out.println("\nEl juego es una aventura en el universo Star Wars para evitar que los Sith lleven a cabo un plan maligno.");
        System.out.println("Para ganar el juego es necesario derrotar al jefe final.");
        System.out.println("El mapa estará dividido por cuadros que serán cavernas.");
        System.out.println("En estas cavernas encontrarás armas, enemigos, piezas de las historia del juego, y tesoros.");
        System.out.println("Iniciarás el juego con 100 puntos de vida y 50 créditos.");
        System.out.println("Los créditos sirven para comprar armas o bebidas que facilitarán tu camino.");
        System.out.println("Si tu vida llega a 0, el juego te dará la oportunidad de volver a jugar.");
        System.out.println("En caso de que elijas que sí, empezarás la aventura con el mismo personaje.");
        System.out.println("\nDespués de leer esto, estás listx para iniciar esta aventura.");
    }
    public static void CharCreator (){
        System.out.println("-------------------------------------------------------------------------------");
        System.out.println("                     Bienvenido a STAR WARS: MIDDLE BATTLE");
        System.out.println(YELLOW+
                            "               _________________      ____         __________\n" +YELLOW+
                            " .       .    /                 |    /    \\    .  |          \\\n" +YELLOW+
                            "     .       /    ______   _____| . /      \\      |    ___    |     .     .\n" +YELLOW+
                            "             \\    \\    |   |       /   /\\   \\     |   |___>   |\n" +YELLOW+
                            "           .  \\    \\   |   |      /   /__\\   \\  . |         _/               .\n" +YELLOW+
                            " .     ________>    |  |   | .   /            \\   |   |\\    \\_______    .\n" +YELLOW+
                            "      |            /   |   |    /    ______    \\  |   | \\           |\n" +YELLOW+
                            "      |___________/    |___|   /____/      \\____\\ |___|  \\__________|    .\n" +YELLOW+
                            "  .     ____    __  . _____   ____      .  __________   .  _________\n" +YELLOW+
                            "       \\    \\  /  \\  /    /  /    \\       |          \\    /         |      .\n" +YELLOW+
                            "        \\    \\/    \\/    /  /      \\      |    ___    |  /    ______|  .\n" +YELLOW+
                            "         \\              /  /   /\\   \\ .   |   |___>   |  \\    \\\n" +YELLOW+
                            "   .      \\            /  /   /__\\   \\    |         _/.   \\    \\            +\n" +YELLOW+
                            "           \\    /\\    /  /            \\   |   |\\    \\______>    |   .\n" +YELLOW+
                            "            \\  /  \\  /  /    ______    \\  |   | \\              /          .\n" +YELLOW+
                            " .       .   \\/    \\/  /____/      \\____\\ |___|  \\____________/  LS\n" +YELLOW+
                            "                               .                                        .\n" +YELLOW+
                            "     .                           .         .               .                 .\n" +YELLOW+
                            "                .                                   .            .\n" +YELLOW+
                            "\n" +ANSI_RESET);
        wait(2);
        System.out.println("\nEmpecemos esta travesía por crear tu personaje.");
        System.out.println("\nNombre de tu personaje:");
        String name = in.next();
        System.out.println("\nEdad de tu personaje:");
        int age = in.nextInt();
        System.out.println("\nPlaneta de tu personaje:");
        System.out.println("\t-Kamino");
        System.out.println("\t-Bespin");
        System.out.println("\t-Tatooine");
        System.out.println("\t-Hoth");
        System.out.println("\t-Coruscant");
        String planet = in.next();
        System.out.println("\nEspecie de tu personaje:");
        System.out.println("\t-Humanx");
        System.out.println("\t-Gungan");
        System.out.println("\t-Trandoshanx");
        String race = in.next();
        System.out.println("\nProfesión de tu personaje:");
        System.out.println("\t-Artillerx");
        System.out.println("\t-Pilotx");
        System.out.println("\t-Astrofísicx");
        System.out.println("\t-Contrabandista");
        String profession = in.next();
        System.out.println("");
        p1 = new MainCharacter (name,  50, age, planet, 100, profession, race, false, 0);        
    }
    public static int Decision (){
        System.out.println("-------------------------------------------------------------------------------");     
        System.out.println("*DESPERTANDO*");
        System.out.println("\nBienvenido, "+ p1.getName()+ ", a una galaxia muy muy lejana.");
        System.out.println("\nYo soy Kanan Jarrus, Caballero Jedi que logró sobrevivir a la orden 66, y necesito de tu ayuda.");
        System.out.println("Sé que probablemente estás confundido sobre porque entré a tu hogar mientras dormías.");
        System.out.println("Pero para explicar todo lo que está pasando, utilizaré la intro más famosa de la franquicia a la que pertenezco.");
        System.out.println("Espero te agrade.");
        wait(15);
        System.out.println(ANSI_BLUE+".    .        .      .             . .     .        .          .          .\n" +ANSI_BLUE+
                            "         .                 .                    .                .\n" +ANSI_BLUE+
                            "  .            Hace mucho tiempo en una galaxia muy muy lejana....\n" +ANSI_BLUE+
                            "     .               .           .               .        .             .\n" +ANSI_BLUE+
                            "     .      .            .                 .                                .\n" +ANSI_BLUE+
                            " .      .         .         .   . :::::+::::...      .          .         .\n" +ANSI_BLUE+
                            "     .         .      .    ..::.:::+++++:::+++++:+::.    .     .\n" +ANSI_BLUE+
                            "                        .:.  ..:+:..+|||+..::|+|+||++|:.             .     .\n" +ANSI_BLUE+
                            "            .   .    :::....:::::::::++||||O||O#OO|OOO|+|:.    .\n" +ANSI_BLUE+
                            ".      .      .    .:..:..::+||OO#|#|OOO|O|||####OO###O+:+|+               .\n" +ANSI_BLUE+
                            "                 .:...:+||O####O##||+|OO|||O#####O#O||OO|++||:     .    .\n" +ANSI_BLUE+
                            "  .             ..::||+++|+++++|+::|+++++O#O|OO|||+++..:OOOOO|+  .         .\n" +ANSI_BLUE+
                            "     .   .     +++||++:.:++:..+#|. ::::++|+++||++O##O+:.++|||#O+    .\n" +ANSI_BLUE+
                            ".           . ++++++++...:+:+:.:+: ::..+|OO++O|########|++++||##+            .\n" +ANSI_BLUE+
                            "  .       .  :::+++|O+||+::++++:::+:::+++::+|+O###########OO|:+OO       .  .\n" +ANSI_BLUE+
                            "     .       +:+++|OO+|||O:+:::::.. .||O#OOO||O||#@###@######:+|O|  .\n" +ANSI_BLUE+
                            " .          ::+:++|+|O+|||++|++|:::+O#######O######O@############O\n" +ANSI_BLUE+
                            "          . ++++: .+OO###O++++++|OO++|O#@@@####@##################+         .\n" +ANSI_BLUE+
                            "      .     ::::::::::::::::::::++|O+..+#|O@@@@#@###O|O#O##@#OO####     .\n" +ANSI_BLUE+
                            " .        . :. .:.:. .:.:.: +.::::::::  . +#:#@:#@@@#O||O#O@:###:#| .      .\n" +ANSI_BLUE+
                            "                           `. .:.:.:.:. . :.:.:%::%%%:::::%::::%:::\n" +ANSI_BLUE+
                            ".      .                                      `.:.:.:.:   :.:.:.:.  .   ."+ANSI_RESET);
        System.out.println("\nLa Galaxia está sumida en el lado oscuro.");
        System.out.println("\nLos Sith se han hecho del control de casi toda la galaxia y han oprimido a los pocos grupos rebeldes a lo largo de los sistemas estelares.");
        System.out.println("\nLos imperiales han recurrido al uso de la fuerza.");
        System.out.println("\nLos pocos Jedi sobrevivientes se encuentran en exilio y nadie conoce su paradero.");
        System.out.println("\nEn una galaxia con conflictos sin un fin próximo y una situación alarmante. Queda un rayo de esperanza en la galaxia.");
        wait(20);
        System.out.println("\nTú eres ese rayo de esperanza, necesitas acabar con los Sith y su plan de destrucción masiva.");
        System.out.println("Existe una cantidad incomparable de midiclorianos en ti.");
        System.out.println("Eres el elegido por los profetas Jedi para acabar con el reinado del Sith supremo.");
        System.out.println("Necesitas derrocarlo antes de que construya su láser de sumisión Sith con la fuerza.");
        System.out.println("Si logran llevar a cabo su plan, todas las personas en la galaxia podrán ser esclavizadas por los Sith.");
        wait(15);
        System.out.println("\nDespués de escuchar todo esto ¿Deseas empezar este viaje?");
        System.out.println("1. Sí");
        System.out.println("2. No");
        return in.nextInt();
    }
    public static void moving (int motion){
        r = positionx;
        f = positiony;  
        switch (motion){
            case 1:
                if (positiony !=  4){
                    positiony= positiony +1;
                }else{
                    System.out.println("\nNo puedes moverte hacia delante, ya estás en el borde del mapa.");
                }
                break;
            case 2:
                if (positiony!= 0){
                    positiony = positiony-1;
                }else{
                    System.out.println("\nNo puedes moverte hacia atrás, ya estás en el borde del mapa.");                  
                }
                break;
            case 3:
                if (positionx !=  4){
                    positionx= positionx +1;
                }else{
                    System.out.println("\nNo puedes moverte hacia la derecha, ya estás en el borde del mapa.");
                }
                break;
            case 4:
                if (positionx!= 0){
                    positionx = positionx-1;
                }else{
                    System.out.println("\nNo puedes moverte hacia la izquierda, ya estás en el borde del mapa.");                  
                }
                break;                
        }      
    }
    public static void map (){
        mapa [0][0]= new Cavernas (25); 
        mapa [0][1]= new Cavernas (7);
        mapa [0][2]= new Cavernas (22);
        mapa [0][3]= new Cavernas (11);
        mapa [0][4]= new Cavernas (5);
        mapa [1][0]= new Cavernas (17);
        mapa [1][1]= new Cavernas (6);
        mapa [1][2]= new Cavernas (18);
        mapa [1][3]= new Cavernas (4); 
        mapa [1][4]= new Cavernas (13);
        mapa [2][0]= new Cavernas (14);
        mapa [2][1]= new Cavernas (1); 
        mapa [2][2]= new Cavernas (10);
        mapa [2][3]= new Cavernas (15);
        mapa [2][4]= new Cavernas (20);
        mapa [3][0]= new Cavernas (8);
        mapa [3][1]= new Cavernas (19);
        mapa [3][2]= new Cavernas (24);
        mapa [3][3]= new Cavernas (3);
        mapa [3][4]= new Cavernas (12);
        mapa [4][0]= new Cavernas (2); 
        mapa [4][1]= new Cavernas (21);
        mapa [4][2]= new Cavernas (23);
        mapa [4][3]= new Cavernas (16);   
        mapa [4][4]= new Cavernas (9);
    }
    static void wait(int x){
        try{
            Thread.sleep(x*1000);
        }catch(InterruptedException e){
        }
    }
}

package pkg24lukacmsemestralproject;

import java.util.Scanner;

/**
 * Program má vstup rozměr matice a hodnoty matice
 * Zjišťuje zda matice se zdá zredukovat -> řádek a sloupec obsahuje jen jednu nenulovou hodnotu
 * Zredukovanou matici následně vypíše
 * 
 * Číslo semestrální práce: 24
 * @author Lukáč Matěj
 * Vypracováno 19.12.2022
 */
public class RedukceMatice {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        int rozmer, choice;
        menu();
        choice = sc.nextInt();
        while (choice > 0) {
            if (choice == 1) {
                System.out.println("Zadejte rozměr čtvercové matice");
                rozmer = sc.nextInt();
                if (rozmer <= 0){
                    System.out.println("Zadali jste špatný vstup");
                }
                    while (rozmer > 0) {
                        System.out.println("Zadejte čísla do matice");
                        int[][] a = nacti(rozmer);
                        int[][] b = reduce(a, canReduce(a));
                        while (canReduce(b).reduce) {
                        b = reduce(b, canReduce(b));
                        }
                        System.out.println("Redukovana matice (" + b.length + " x " + b.length + ")");
                        print(b);
                        System.out.println("Zadejte další rozměr matice nebo 0 a menší pro ukončení");
                        rozmer = sc.nextInt();
                }
            }
            else if (choice == 2){
                int deerNumber,housesNumber;
                System.out.println("Napiš počet santových sobů");
                deerNumber = sc.nextInt();
                System.out.println("Napiš počet domků nad kterými letí santa");
                housesNumber = sc.nextInt();
                DrawSantaDeer(deerNumber);
                DrawHouses(housesNumber);
            }
            else
                System.out.println("Zadali jste špatný vstup");
            menu();
            choice = sc.nextInt();
            
        }

    }
    /**
     * Prints out menu
     */
    public static void menu() {
        System.out.println("Zadejte číslo úlohy");
        System.out.println("1. Redukce matice");
        System.out.println("2. Vánoční úloha");
        System.out.println("Zadejte záporné číslo nebo nulu k ukončení programu");
    }

    /**
     * Nacita hodnoty do dvou rozmerne matice pomoci scanneru
     *
     * @param rozmer
     * @return dvourozmerna matice
     */
    public static int[][] nacti(int rozmer) {
        int[][] a = new int[rozmer][rozmer];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                a[i][j] = sc.nextInt();
            }
        }
        return a;
    }

    /**
     * Finds out if array can be reduced -> row and column can contain only one
     * number that is not zero
     *
     * @param a - array
     * @return Object with results as row column boolean
     */
    public static rcb canReduce(int[][] a) {
        boolean delRadek = false, delSloupec = false;
        int count=0;
        int r = 0, s = 0;
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {//goes through whole matrix looking for just 1 non-zero number in row and column
                if (a[i][j] != 0) {
                    for (int k = 0; k < a.length; k++) {// checks row for only one non-zero number
                        if (a[i][k] != 0 ) {
                            count++;
                        }
                        if (count > 1)
                            break;
                        if (k == a.length - 1) {
                            r = i;
                            delRadek = true;
                        }
                    }
                    count = 0;
                    for (int k = 0; k < a.length; k++) {//checks column for only one non-zero number
                        if (a[k][j] != 0 ) {
                            count++;
                        }
                        if (count > 1)
                            break;
                        if (k == a.length - 1) {
                            s = j;
                            delSloupec = true;
                        }
                    }
                    count=0;
                }
            }
        }
        if (delSloupec && delRadek) {
            return new rcb(r,s,true);
        }
        return new rcb(r, s, false);
    }

    /**
     * Reduce matrix if canReduce is true, reduces number that is the only
     * number in row and column
     *
     * @param a
     * @param rcb row-row that can be reduced column-column that can be reduced
     * boolean- if can be reduced
     */
    private static int[][] reduce(int[][] a, rcb result) {
        int rozmer = a.length;
        int[][] b = new int[rozmer - 1][rozmer - 1];
        if (result.getReduce()) {
            int x = 0;
            for (int j = 0; j < a.length; j++) {
                if (j == result.getRow()) {
                    x = 1;
                }
                else{
                    int y = 0;
                    for (int k = 0; k < a[j].length; k++) {
                        if (k == result.getColumn()) {
                            y=1;
                        }
                        else{
                            b[j-x][k-y] = a[j][k];
                        }
                    }
                }
            }
        } else {
            return a;
        }
        return b;
    }

    /**
     * Prints array
     *
     * @param a array
     */
    public static void print(int[][] a) {
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                System.out.format("%-6d",a[i][j]);
            }
            System.out.println("");

        }
    }

    /**
     * Object with results from canReduce method
     */
    public static class rcb {

        public int row;
        public int column;
        public boolean reduce;

        public rcb(int row, int column, boolean reduce) {
            this.row = row;
            this.column = column;
            this.reduce = reduce;
        }
        
        public int getRow() {
            return row;
        }

        public int getColumn() {
            return column;
        }

        public boolean getReduce() {
            return reduce;
        }
    }
    public static void DrawSantaDeer(int num){
            System.out.println("                    _...");
            System.out.println("              o_.-\"`    `\\");
            System.out.println("       .--.  _ `'-._.-'\"\"-;     _");
            System.out.println("     .'    \\`_\\_  {_____--}  _ / \\");
            System.out.println("   _/     .-'  '. {c-._o_.){\\|`  |");
            System.out.println("  (@`-._ /       \\{    ^  } \\\\ _/");
            System.out.println("   `~\\  '-._      /'.     }  \\}  .-.");
            System.out.println("     |>:<   '-.__/   '._,} \\_/  / ())");
            System.out.print("     |     >:<   `'---. ____'-.|(`\"`     ");
            for(int i=0; i < num;i++){
                System.out.print("         { }    ");
            }
            System.out.println("");
            
            System.out.print("     \\            >:<  \\\\_\\\\_\\ | ;       ");
            for(int i=0; i < num;i++){
                System.out.print("         {^^,   ");
            }
            System.out.println("");
            
            System.out.print("      \\                 \\\\-{}-\\/  \\      ");
            for(int i=0; i < num;i++){
                System.out.print("         (   `-;");
            }
            System.out.println("");
            
            System.out.print("       \\                 '._\\\\'   /)     ");
            for(int i=0; i < num;i++){
                System.out.print("    _     `;;~~ ");
            }
            System.out.println("");
            
            System.out.print("        '.                       /(      ");
            for(int i=0; i < num;i++){
                System.out.print("   /(______);   ");
            }
            System.out.println("");
            //santa
            System.out.print("          `-._ _____ _ _____ __.'\\ \\     ");
            //reindeer
            for(int i=0; i < num;i++){
                System.out.print("  (          (  ");
            }
            System.out.println("");
            
            System.out.print("            / \\     / \\     / \\   \\ \\    ");
            for(int i=0; i < num;i++){
                System.out.print("   |:------( )  ");
            }
            System.out.println("");
            
            System.out.print("         _.'/^\\'._.'/^\\'._.'/^\\'.__) \\   ");
            for(int i=0; i < num;i++){
                System.out.print(" _//         \\ ");
            }
            System.out.println("");
            
            System.out.print("     ,=='  `---`   '---'   '---'      )  ");
            for(int i=0; i < num;i++){
                System.out.print("/ /           vv");
            }
            System.out.println("");
            System.out.println("");  
    }
    private static void DrawHouses(int num) {
        String[] domek = new String[] {
            "           .:'    .:'    .:'             ",
            "         /\\||   /\\||   /\\||              ",
            "        //\\\\|  //\\\\|  //\\\\|              ",
            "       //  \\\\ //  \\\\ //  \\\\              ",
            "      //    \\^/    \\^/    \\\\             ",
            "      |[]  []|[]  []|[]  []|             ",
            "     &|  ||  %  ||  |  ||  |%            ",
            "\"\"\"\"\"\"&%&--==--&%-==--%&\"\"\"\"\"%&%\"\"\"\"\"\"\"\"\""};
            for(int x = 0; x < domek.length;x++){
                for(int p = 0; p < num; p++){
                    System.out.print(domek[x]);
                }
                System.out.println("");
            }       
    }
}

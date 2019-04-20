package exerciseTris;

import java.util.Scanner;

public class Main {

    public static void main (String []args){
        int choice, x, y;
        Player player1 = new Player();
        Player player2 = new Player();
        Tris tris = new Tris(player1, player2);
        Scanner input = new Scanner(System.in);
        do{
            System.out.println("\t\tTris");
            System.out.println("Inserire il nome del Primo Giocatore a cui è assegnato il segno X");
            player1.name= input.next();
            player1.sign= 'X';
            System.out.println("Inserire il nome del Secondo Giocatore a cui è assegnato il segno O");
            player2.name= input.next();
            player2.sign= 'O';
            System.out.println(tris.startingGame());
            while (tris.turn<9) {
                do {
                    if (!player1.completedTurn)
                        if (tris.turn!=0)
                            System.out.println("Adesso tocca a " + player1.name);
                    if (!player2.completedTurn)
                        if (tris.turn!=0)
                            System.out.println("Adesso tocca a " + player2.name);
                    System.out.println("Dove vuoi mettere il segno?" + tris);
                    System.out.println("Indicare la riga (1 - 2 - 3):");
                    x = input.nextInt();
                    x--;
                    System.out.println("Indicare la colonnna (1 - 2 - 3) :");
                    y = input.nextInt();
                    y--;
                    if (!(x>=0 && x<=2) || !(y>=0 && y<=2))
                    System.out.println("Riga e/o colonna non trovata/e!\n Riprova.");
                    if (x==-1 && y==-1) tris.resetGame();
                }while ((x==-1 && y==-1) || !(x>=0 && x<=2) || !(y>=0 && y<=2) );
                    if (!player1.completedTurn) {
                        System.out.println(tris.play(x, y, player1.sign));
                    } else
                        System.out.println(tris.play(x, y, player2.sign));
            }
            System.out.println(tris);
            System.out.println("Vuoi iniziare da capo? 0 - No   (1 - ∞) - Sì");
            choice=input.nextInt();
            if (choice!=0) tris.resetGame();
        }while(choice!=0);
        System.out.println("Grazie per aver giocato :D");
    }
}

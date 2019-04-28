package exerciseTris;

import java.util.Scanner;

public class Main {

    public static void main (String []args) {
        int game;
        Scanner input = new Scanner(System.in);
        int choice, x, y;
        Player player1 = new Player();
        Player player2 = new Player();
        System.out.println("A che gioco vuoi giocare? \n 1 - Tris\n 2 - Morra Cinese");
        game =input.nextInt();
        switch (game) {
            case 1:
                Tris tris = new Tris(player1, player2);
                do {
                    System.out.println("\t\tTris");
                    System.out.println("Inserire il nome del Primo Giocatore a cui è assegnato il segno X");
                    player1.name = input.next();
                    player1.sign = 'X';
                    System.out.println("Inserire il nome del Secondo Giocatore a cui è assegnato il segno O");
                    player2.name = input.next();
                    player2.sign = 'O';
                    System.out.println(tris.startingGame());
                    while (tris.turn < 9) {
                        do {
                            if (!player1.completedTurn)
                                if (tris.turn != 0)
                                    System.out.println("Adesso tocca a " + player1.name);
                            if (!player2.completedTurn)
                                if (tris.turn != 0)
                                    System.out.println("Adesso tocca a " + player2.name);
                            System.out.println("Dove vuoi mettere il segno?" + tris);
                            System.out.println("Indicare la riga (1 - 2 - 3):");
                            x = input.nextInt();
                            x--;
                            System.out.println("Indicare la colonnna (1 - 2 - 3) :");
                            y = input.nextInt();
                            y--;
                            if (!(x >= 0 && x <= 2) || !(y >= 0 && y <= 2))
                                System.out.println("Riga e/o colonna non trovata/e!\n Riprova.");
                            if (x == -1 && y == -1) tris.resetGame();
                        } while ((x == -1 && y == -1) || !(x >= 0 && x <= 2) || !(y >= 0 && y <= 2));
                        if (!player1.completedTurn) {
                            System.out.println(tris.play(x, y, player1.sign));
                        } else
                            System.out.println(tris.play(x, y, player2.sign));
                    }
                    System.out.println(tris);
                    System.out.println("Vuoi iniziare da capo? 0 - No   (1 - ∞) - Sì");
                    choice = input.nextInt();
                    if (choice != 0) tris.resetGame();
                } while (choice != 0);
                System.out.println("Grazie per aver giocato :D");
                break;
            case 2:
                System.out.println("\t Morra Cinese");
                System.out.println("Nome Giocatore 1:");
                player1.name = input.next();
                System.out.println("Nome Giocatore 2:");
                player2.name = input.next();
                MorraCinese morraCinese = new MorraCinese(player1, player2);
                do {
                    System.out.println(morraCinese.startingGame());
                    if (!player1.completedTurn) {
                        if (morraCinese.turn != 0)
                            System.out.println("Adesso tocca a " + player1.name);
                        System.out.println("Nasconditi da "+player2.name+" e scrivi cosa vuoi tirare: Carta, Forbice o Sasso?");
                        player1.sign = input.next().charAt(0);
                        System.out.println("\n\n\n\n\n\n\n\n\n\n");
                        player1.completedTurn = true;
                        player2.completedTurn = false;
                        morraCinese.turn=1;
                    }
                    if (!player2.completedTurn) {
                        if (morraCinese.turn != 0)
                            System.out.println("Adesso tocca a " + player2.name);
                        System.out.println("Adesso nasconditi da "+player1.name+" e scrivi cosa vuoi tirare: Carta, Forbice o Sasso?");
                        player2.sign = input.next().charAt(0);
                        System.out.println("\n\n\n\n\n\n\n\n\n\n");
                        player2.completedTurn = true;
                        player1.completedTurn = false;
                        morraCinese.turn=1;
                    }
                    if (morraCinese.checkWin(player1.sign, player2.sign) == (player1.sign))
                        System.out.println("\t " + player1.name + " Vince");
                    else if (morraCinese.checkWin(player1.sign, player2.sign) == (player2.sign))
                        System.out.println("\t " + player2.name + " Vince");
                    else if (morraCinese.checkWin(player1.sign, player2.sign) == null)
                        System.out.println("\tParità!");
                    morraCinese.turn=0;
                    System.out.println("Vuoi giocare ancora? 1 - Sì 0 - No");
                    choice = input.nextInt();
                }while (choice!=0);
                System.out.println("Grazie per aver giocato :D");
                break;
        default:
            System.out.println("Gioco inesistente");
            break;
        }
    }
}

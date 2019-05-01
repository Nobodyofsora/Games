package exerciseGames;

import java.util.Arrays;

public class ConnectFour {
    public Character grid[][]= new Character[7][6];
    public Player player1;
    public Player player2;
    public int turn=0;


    public String startingGame(){
        for (int i=0;i<7;i++) {
            for (int j = 0; j < 6; j++)
                grid[i][j] = null;
        }
        this.turn=0;
        if (Math.random()<=0.5){
            player1.completedTurn=false;
            return "Inizia prima " + player1.name;
        }
        else {
            player2.completedTurn=false;
            return "Inizia prima " +player2.name;
        }
    }
    public String set(int x, Player player) {
        if (x < 0 || x > 7) return "Posizione inesistente";
        if (grid[x][5] != null) return "Colonna occupata";
        for (int i = 0; i < 6; i++) {
            if (grid[x][i] == null) {
                grid[x][i] = player.sign;
                if (checkwin(x, i, player)) {
                    turn=43;
                    return player.name + " Ha Vinto";
                }
                turn++;
                checkTurn();
                if (turn == 42) {
                    turn++;
                    return "\tParità";
                }
                break;
            }
        }
        return "Inserimento Riuscito";
    }
    public boolean checkwin(int x, int y,Player player){
        //i e shift sono per controllare che i segni siano ADIACENTI
        //Righe
       if (!checkRows(x, y ,player))
        //Colonne
            if (!checkColumns(x,y,player))
        //Diagonali Principali
               if (!checkSlash(x,y,player))
        //Diagonali Secondarie
                   return checkBackSlash(x, y, player);
        return true;
    }
    private boolean checkRows (int x, int y, Player player){
        int counter=0;
        for (int shift=0; shift<4;shift++)
            if (y+shift<6&&grid[x][y + shift]!=null && grid[x][y + shift].equals(player.sign))
                counter++;
            else for (int i = 1; i < 4; i++)
                if (y-i>=0 && grid[x][y - i]!=null && grid[x][y - i].equals(player.sign))
                    counter++;
                else {
                    shift=4; break;
                }
        return counter >= 4;
    }
    private boolean checkColumns(int x, int y, Player player){
        int counter=0;
        for (int shift=0; shift<4;shift++)
            if (x+shift<5&&grid[x + shift][y]!=null && grid[x + shift][y].equals(player.sign))
                counter++;
            else for (int i=1; i<4;i++)
                if (x-i >=0 && grid[x - i][y]!=null && grid[x - i][y].equals(player.sign))
                    counter++;
                else  {
                    shift=4; break;
                }
        return counter >= 4;
    }
    private boolean checkSlash(int x, int y, Player player){
        int counter=0;
        for (int shift=0; shift<4;shift++)
            if (y+shift<6&&x+shift<5&&grid[x + shift][y +shift]!= null && grid[x + shift][y +shift].equals(player.sign))
                counter++;
            else for (int i=1; i<4;i++)
                if (x-i>=0&&y-i>=0&&grid[x - i][y - i]!= null && grid[x - i][y - i].equals(player.sign))
                    counter++;
                else {
                    shift=4; break;
                }
        return counter >= 4;
    }
    private boolean checkBackSlash(int x, int y, Player player){
        int counter=0;
        for (int shift=0; shift<4;shift++)
            if (y-shift>=0&&x+shift<5&&grid[x + shift][y - shift]!= null && grid[x + shift][y - shift].equals(player.sign))
                counter++;
            else for (int i=1; i<4;i++)
                if (x-i>=0&&y+i<6&&grid[x - i][y + i]!=null && grid[x - i][y + i].equals(player.sign))
                    counter++;
                else  {
                    shift=4; break;
                }
        return counter >= 4;
    }

    public ConnectFour(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
    }

    public void checkTurn(){
        if(!this.player1.completedTurn) {
            this.player1.completedTurn = true;
            this.player2.completedTurn = false;
        }
        else{
            this.player2.completedTurn = true;
            this.player1.completedTurn = false;
        }
    }

    @Override
    public String toString() {
        String s= "\n";
        for (int i=5;i>=0;i--) {
            for (int j = 0; j<7; j++) {
                if (grid[j][i]==null)
                    if (j==0) s+="|\t\t|";
                    else s+="\t\t|";
                else if (j==0) s+="|\t"+this.grid[j][i] + "\t|";
                else s+="\t"+this.grid[j][i] + "\t|";
            }
            s+="\n";
        }
            return s;
    }
}

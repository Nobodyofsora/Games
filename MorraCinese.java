package exerciseGames;

public class MorraCinese {
    public Player player1;
    public Player player2;
    public int turn=0;

    public MorraCinese(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
    }
    public String startingGame(){
        if (Math.random()<=0.5){
            player1.completedTurn=false;
            return "Inizia prima " + player1.name;
        }
        else {
            player2.completedTurn=false;
            return "Inizia prima " +player2.name;
        }
    }
    public static Character checkWin(Character one, Character two) {
        if (
                (one=='C'&& two=='S')||(one=='S'&& two=='F') || (one=='F'&& two=='C')
                || (one=='c'&& two=='s')||(one=='s'&& two=='f') || (one=='f'&& two=='c')
        ) return one;
        else if (
                (two=='C'&& one=='S')||(two=='S'&& one=='F') || (two=='F'&& one=='C')
                || (two=='c'&& one=='s')||(two=='s'&& one=='f') || (two=='f'&& one=='c')
        ) return two;
        else return null;
    }
}

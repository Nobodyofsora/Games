package exerciseTris;

public class Tris {
    public Sign[][] tris;
    public Player player1;
    public Player player2;
    public int turn=0;

    public Tris(Player player1, Player player2) {
        this.tris = new Sign[3][3];
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
    public String play(int x, int y, Character sign){
        if (checkEmpty(x, y).equals("Posizione Libera")) {
            if (!player1.completedTurn){
                tris[x][y] = new Sign(player1.sign, x, y);
                if (checkWin(sign)!=null)
                    return checkWin(sign);
                player1.completedTurn=true;
                player2.completedTurn=false;
                turn++;
                if (checkDraw()==null)
                    return "";
                else return checkDraw() ;
            }
            else {
                tris[x][y] = new Sign(player2.sign, x, y );
                if (checkWin(sign)!=null) return checkWin(sign);
                player2.completedTurn=true;
                player1.completedTurn=false;
                turn++;
                if (checkDraw()==null)
                    return "";
                else return checkDraw() ;
            }
        } else return checkEmpty(x,y);
    }

    private String checkEmpty(int x, int y){
        if (tris[x][y]!=null) {
            return "Posizione Occupata";
        }
        return "Posizione Libera";
    }
    private String checkWin(Character sign){
        if(
                (tris[0][0]!= null && tris[0][0].getSign().equals(sign)) && (tris[0][1]!= null && tris[0][1].getSign().equals(sign)) && (tris[0][2]!= null && tris[0][2].getSign().equals(sign))||
                (tris[1][0]!= null && tris[1][0].getSign().equals(sign)) && (tris[1][1]!= null && tris[1][1].getSign().equals(sign)) && (tris[1][2]!= null && tris[1][2].getSign().equals(sign))||
                (tris[2][0]!= null && tris[2][0].getSign().equals(sign)) && (tris[2][1]!= null && tris[2][1].getSign().equals(sign)) && (tris[2][2]!= null && tris[2][2].getSign().equals(sign))||
                (tris[0][0]!= null && tris[0][0].getSign().equals(sign)) && (tris[1][0]!= null && tris[1][0].getSign().equals(sign)) && (tris[2][0]!= null && tris[2][0].getSign().equals(sign))||
                (tris[0][1]!= null && tris[0][1].getSign().equals(sign)) && (tris[1][1]!= null && tris[1][1].getSign().equals(sign)) && (tris[2][1]!= null && tris[2][1].getSign().equals(sign))||
                (tris[0][2]!= null && tris[0][2].getSign().equals(sign)) && (tris[1][2]!= null && tris[1][2].getSign().equals(sign)) && (tris[2][2]!= null && tris[2][2].getSign().equals(sign))||
                (tris[0][0]!= null && tris[0][0].getSign().equals(sign)) && (tris[1][1]!= null && tris[1][1].getSign().equals(sign)) && (tris[2][2]!= null && tris[2][2].getSign().equals(sign))||
                (tris[0][2]!= null && tris[0][2].getSign().equals(sign)) && (tris[1][1]!= null && tris[1][1].getSign().equals(sign)) && (tris[2][0]!= null && tris[2][0].getSign().equals(sign))
        )
            if (!player1.completedTurn) {
                turn=100;
                return ("\t"+player1.name + " Ha vinto");
            }
            else {
                turn=100;
                return ("\t"+player2.name + " Ha vinto");
            }
        else return null;
    }
    private String checkDraw(){
        if (this.turn==9) {
            return "\tParità";
        }
        return null;
    }
    public void resetGame (){
        for (int i=0; i<3; i++)
            for (int j=0; j<3;j++)
                tris[i][j]=null;
            turn=0;
    }

    @Override
    public String toString() {
        StringBuilder s= new StringBuilder("\n");
        for (int i=0;i<3;i++){
         for (int j=0; j<3; j++){
             if(j<2 && tris[i][j]!=null)
                 s.append("\t"+tris[i][j].getSign()+ "|");
             else if (tris[i][j]!=null)s.append("\t"+tris[i][j].getSign());
             else if (j<2) s.append("\t |");
         }
         if (i<2)s.append("\n ____ ___ ____\n");
        }
        return s.toString();
    }
}

import java.util.ArrayList;

public class Dama {

    enum Move {UP_RIGHT, UP_LEFT, DOWN_RIGHT, DOWN_LEFT};
    enum ForbidenMove {RIGHT,LEFT,UP,DOWN;

        public Move valueOf(ForbidenMove RIGHT, ForbidenMove LEFT, ForbidenMove UP, ForbidenMove DOWN) {
            return null;
        }
    };

    enum Status {IN_GAME, LOSE, WIN};

    int [][] box;
    //private ForbidenMove forbidenMOve;
    //private Move forbidenMove;
    //private Move startMove;
    //private Move startFirst;
    public Status currentStatus = Status.IN_GAME;
    ArrayList<Pawn>playerTop = new ArrayList<>();
    ArrayList<Pawn>playerBottom = new ArrayList<>();
    private int row;
    private int column;

    public Dama(){
        this.box = new int[9][9];
        pawnGenerator();

    }

    public void pawnGenerator(){
        for (int row = 1; row < 4; row++) {   //player top
            for (int column = 1; column < 9; column++) {
                if((row==1 || row==3) && column==1){
                    column=2;
                }
                this.playerTop.add(new Pawn(row,column, true, false));
                column++;
            }
        }
        for (int row = 6; row < 9; row++) {//player bottom
            for (int column = 1; column < 9; column++) {
                if(row==7 && column==1){
                    column=2;
                }
                this.playerBottom.add(new Pawn(row,column, false, false));
                column++;
            }
        }
    }

    public Pawn getBrownPawn(int row, int column){
        for(Pawn pawn: playerTop){
            if(pawn.getRow()==row && pawn.getColumn()==column){
                return pawn;
            }
        }
        return new Pawn(-1,-1, true, true);
    }
    public Pawn getWhitePawn(int row, int column){
        for(Pawn pawn: playerBottom){
            if(pawn.getRow()==row && pawn.getColumn()==column){
                return pawn;
            }
        }
        return new Pawn(-1,-1, false, true);
    }

    public void eatPawnAndMoveLeft(boolean isBrown, Pawn pawn, Pawn toEatPawn){
        if(isBrown){
            if(pawn.getRow()==toEatPawn.getRow() && pawn.getColumn()==toEatPawn.getColumn()){
                for(Pawn pawn2: playerBottom){
                    if(pawn2.equals(toEatPawn)){
                        pawn2.isEaten=true;
                    }
                }
                pawn.setRow(pawn.getRow()+1);
                pawn.setColumn(pawn.getColumn()-1);
            }
        }
        else{
            if(pawn.getRow()==toEatPawn.getRow() && pawn.getColumn()==toEatPawn.getColumn()){
                for(Pawn pawn2: playerTop){
                    if(pawn2.equals(toEatPawn)){
                        pawn2.isEaten=true;
                    }
                }
                pawn.setRow(pawn.getRow()-1);
                pawn.setColumn(pawn.getColumn()-1);
            }
        }
    }

    public void eatPawnAndMoveRight(boolean isBrown, Pawn pawn, Pawn toEatPawn){
        if(isBrown){
            if(pawn.getRow()==toEatPawn.getRow() && pawn.getColumn()==toEatPawn.getColumn()){
                for(Pawn pawn2: playerBottom){
                    if(pawn2.equals(toEatPawn)){
                        pawn2.isEaten=true;
                    }
                }
                pawn.setRow(pawn.getRow()+1);
                pawn.setColumn(pawn.getColumn()+1);
            }
        }
        else{
            if(pawn.getRow()==toEatPawn.getRow() && pawn.getColumn()==toEatPawn.getColumn()){
                for(Pawn pawn2: playerTop){
                    if(pawn2.equals(toEatPawn)){
                        pawn2.isEaten=true;
                    }
                }
                pawn.setRow(pawn.getRow()-1);
                pawn.setColumn(pawn.getColumn()+1);
            }
        }
    }

    public String toString() {
        String result = this.currentStatus + "\n";
        for (int row = 1; row<9; row++) {
            result+="\n[";
            for (int column = 1; column < 9; column++) {
                if (this.playerTop.contains(new Pawn(row, column, true, false))){
                    result += "[🟤]";
                } else if (this.playerBottom.contains(new Pawn(row,column, false, false))){
                    result +="[⚪]";
                }
                else {
                    result += "["+row+","+column+"]";
                }
            } result += "]\n";
        }
        return result;
    }
}
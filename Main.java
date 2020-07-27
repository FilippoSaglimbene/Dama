import java.util.Scanner;


public class Main {

    public static void main(String[] args) throws Exception {
        Dama dama = new Dama();
        //System.out.println(dama.toString());
        Scanner scan = new Scanner(System.in);
        while(true){
            System.out.println(dama.toString());
            System.out.println("Insert row for Brown: ");
            int brownRow=scan.nextInt();

            System.out.println("Insert column for Brown: ");
            int brownColumn=scan.nextInt();
            System.out.println("Press 1 to go Left or 2 go Right: ");
            int choise=scan.nextInt();
            switch (choise) {
                case 1: {
                    dama.getBrownPawn(brownRow, brownColumn).move(Pawn.moveDirections.LEFT);
                    dama.eatPawnAndMoveLeft(true, dama.getBrownPawn(brownRow+1, brownColumn-1),dama.getWhitePawn(brownRow+1, brownColumn-1));
                    break;
                }
                case 2: {
                    dama.getBrownPawn(brownRow, brownColumn).move(Pawn.moveDirections.RIGHT);
                    dama.eatPawnAndMoveLeft(true, dama.getBrownPawn(brownRow+1, brownColumn+1),dama.getWhitePawn(brownRow+1, brownColumn+1));
                    break;
                }
            }
            System.out.println(dama.toString());
            System.out.println("Insert row for White: ");
            int whiteRow=scan.nextInt();

            System.out.println("Insert column for White: ");
            int whiteColumn=scan.nextInt();
            System.out.println("Press 1 to go Left or 2 to go Right: ");
            int choise2=scan.nextInt();
            switch (choise2) {
                case 1: {
                    dama.getWhitePawn(whiteRow, whiteColumn).move(Pawn.moveDirections.LEFT);
                    dama.eatPawnAndMoveLeft(false, dama.getWhitePawn(whiteRow-1, whiteColumn-1), dama.getBrownPawn(whiteRow-1, whiteColumn-1));
                    break;
                }
                case 2: {
                    dama.getWhitePawn(whiteRow, whiteColumn).move(Pawn.moveDirections.RIGHT);
                    dama.eatPawnAndMoveRight(false, dama.getWhitePawn(whiteRow-1, whiteColumn+1), dama.getBrownPawn(whiteRow-1, whiteColumn+1));
                    break;
                }
            }
            System.out.println(dama.toString());
        }
    }
}
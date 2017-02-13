import java.util.ArrayList;

/**
 * Created by piscary on 13.02.17.
 */


public class SudokuSolver {
    public static void main(String[] args){
        String field = "000670504250030000060050982301000000070529103000000078000000405010306000826000000";
        ArrayList<Square> squares = new ArrayList<>();
        int counter = 0;
        for(int row = 0; row<9; row++){
            for(int column = 0; column<9; column++){
                int cipher = Integer.parseInt(field.substring(counter, counter+1));
                Square s = new Square(column, row, counter, cipher);
                squares.add(s);
                counter++;
            }
        }
        for(Square s: squares){
            s.findPeers(squares);
        }

        for(int i = 0; i<10; i++){
            for(Square s: squares){
                s.updatePossibilities();
                if(s.posX == 3 && s.posY == 1) {
                    System.out.println(s.cipher + ":" + s.possibilities);
                    for(Square p: s.peers){
                        System.out.println("\t" + p.cipher + ":" + p.possibilities);
                    }
                }
            }

        }
    }
}

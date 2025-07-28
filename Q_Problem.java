import java.util.ArrayList;
import java.util.Random;
class Board{
   private ArrayList<ArrayList<String>> board = new ArrayList<>();
    public void initBoard(){
        board.clear();
        for (int i = 0; i < 8; i++) {
            ArrayList<String> currRow  = new ArrayList<>();
            for (int j = 0; j < 8; j++) {
                currRow.add("0 ");    
            }
            board.add(currRow);
        }
    }

   public void getBoard(){
      try {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                System.out.print(board.get(i).get(j));
            }
            System.out.println();
        }
    } catch (IndexOutOfBoundsException e) {
        System.out.println("Error: Tried to access an index out of bounds.");
        }
    }

    public testQueen(ArrayList board){
        int x,y;
        int x = (int)(Math.random() * 9)
    }
} 

class Queen{
   private String Queen = "Q ";
    public ArrayList coordinates = new ArrayList<>();
    public String x,y; 
   public void Queen (String q){
        this.Queen = Queen;
    }

   public String getQueen (){
        return Queen;
    }

    public String QueenMoves(ArrayList board){
        //get queen coordinates and highlight queen moves on board
    }
}

public class Q_Problem {
    public static void main(String[] args){
        Board board = new Board();
        board.initBoard();
        board.getBoard();
    }
}
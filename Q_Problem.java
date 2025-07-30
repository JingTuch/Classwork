import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
class Board{
   private ArrayList<ArrayList<String>> board = new ArrayList<>();
   Queen queen = new Queen();
   public void showQueenPosition() {
    Coordinate pos = queen.coordinates.get(0);
    System.out.println("Queen is at: " + pos.x + ", " + pos.y);
}
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
   public void setPiece(int x, int y, String Piece){
    board.get(x).set(y,Piece);
    queen.saveCoordinate(x,y);
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
    public void queenChecker(){
        for(int i = 0; i < 8; i++){
            for(int j = 0; j < 8; j++){
                if(board.get(i).get(j) == "Q "){
                    pathing(i,j);
                }
            }
        }
    }
    public void pathing(int currx, int curry){
         for(int i = 0; i < 8; i++){
            for(int j = 0; j < 8; j++){
        if( ((Math.abs(i - currx) == Math.abs(j - curry)) || Math.abs(i) == currx || Math.abs(j) == curry) && !(i == currx && j == curry) ){
            board.get(i).set(j, "1 ");
                }
            }
         }
    }
      public void placeQueen(){;
        for(int i = 0; i < 8; i++){
            for(int j = 0; j < 8; j++){
                if(board.get(i).get(j) =="0 "){
                    setPiece(i,j,queen.getQueen());
                    queenChecker();
                    
                }
            }
        }
    }
} 
class Coordinate{
    int x,y;

    public Coordinate(int x, int y){
        this.x = x;
        this.y = y;
    }
}
class Queen{
   private String queen = "Q ";
   public ArrayList<Coordinate> coordinates = new ArrayList<>();
   public String x,y; 

   public String getQueen (){
        return queen;
    }
    public void saveCoordinate(int x, int y){
        coordinates.add(new Coordinate(x, y));
    }
}

public class Q_Problem {
    public static void main(String[] args){
        Queen queen = new Queen();
        Board board = new Board();
        board.initBoard();
        board.placeQueen();
        board.getBoard();
    }  
}
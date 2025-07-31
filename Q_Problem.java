import java.util.ArrayList;
import java.util.Scanner;
class Board{
    public int recursiveCalls = 0;
    public int sol = 1;
    private ArrayList<ArrayList<String>> board = new ArrayList<>();
    Queen queen = new Queen();
    public void initBoard(){
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
   }
     public void printRecursiveCalls() {
        System.out.println("Total recursive calls: " + recursiveCalls);
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
    public void pathing(int currx, int curry){
         for(int i = 0; i < 8; i++){
            for(int j = 0; j < 8; j++){
        if( ((Math.abs(i - currx) == Math.abs(j - curry)) || Math.abs(i) == currx || Math.abs(j) == curry) && !(i == currx && j == curry) ){
            board.get(i).set(j, "1 ");
                }
            }
         }
    }
    public boolean isValid(int currx,int curry){
      for(int i = 0; i < 8; i++){
        if(board.get(i).get(curry).equals("Q ")){
            return false;
        }
      }
        for(int i = currx - 1, j = curry - 1; i >= 0 && j >= 0; i--,j--){
            if(board.get(i).get(j).equals("Q ")){
                return false;
            }
        }
         for(int i = currx - 1, j = curry + 1; i >= 0 && j < 8; i--,j++){
            if(board.get(i).get(j).equals("Q ")){
                return false;
            }
        }
        return true;
    }
    public void Nth_QueenSolver(int i){
        recursiveCalls++;
        if(i == 8){//goal is i == 8th
        System.out.println("Solution No:"+ sol);
            getBoard();
            System.out.println();
            // Scanner Scan = new Scanner(System.in);
            //String buff = Scan.nextLine();
            sol++;
            return;
        }
        for(int j = 0; j < 8; j++){
            if(isValid(i,j)){//constraints
            placeQueen(i,j); //Choice
            Nth_QueenSolver(i+1);
            }
            board.get(i).set(j,"0 ");//undo
           // getBoard();
           // Scanner Scan = new Scanner(System.in);
           // String buff = Scan.nextLine();

        }      
    }
      public void placeQueen(int i,int j){
        setPiece(i,j,queen.getQueen());
        pathing(i,j);
    }
} 
class Queen{
   private String queen = "Q ";
   public String getQueen (){
        return queen;
    }
}

public class Q_Problem {
    public static void main(String[] args){
        Board board = new Board();
        board.initBoard();
        board.Nth_QueenSolver(0);
        board.printRecursiveCalls();
    }  
}
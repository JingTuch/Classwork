public class Game {

    private Board board;
    private int moveCounter = 0;
    
    public Game(Board board) {
        this.board = board;
    }

    public void incrementMoveCounter() {
        moveCounter++;
    }
    public boolean TurnAnnouncer(){
    boolean Verdict = (moveCounter%2==0||moveCounter==0) ? true : false;
    return Verdict;
    }
    public boolean PosChecker(int startX, int startY) {
        char[][] boardArray = board.getBoard();
        char piece = boardArray[startY - 1][startX - 1];
        
        if (piece == ' ' || piece == '#') {
            System.out.println("This is What is on that coordinates: "+boardArray[startY - 1][startX - 1]+" :");
            System.out.println("There is no Piece There");
            return true;  
        }  
        if (TurnAnnouncer()) {          
            if (!Character.isUpperCase(piece)) {
                System.out.println("This is What is on that coordinates: "+boardArray[startY - 1][startX - 1]+" :");
                System.out.println("That is not your Piece");
                return true;  
            }
        } else {  
            if (!Character.isLowerCase(piece)) {
                System.out.println("This is What is on that coordinates: "+boardArray[startY - 1][startX - 1]+" :");
                System.out.println("That is not your Piece");
                return true;  
            }
        }  
        return false;  
    }  
    public void movePiece(int startX, int startY, int endX, int endY) {
        char[][] boardArray = board.getBoard();
         WhiteMoveLogic whitemoveLogic = new WhiteMoveLogic(this, board);
        BlackMoveLogic blackmovelogic = new BlackMoveLogic(this, board);
        char piece = boardArray[startY - 1][startX - 1];

        if (startX > boardArray.length || startY >  boardArray.length || endX >  boardArray.length ||endY >  boardArray.length) {
            System.out.println("Can't Move Beyond The Board");
            return;
        }

        switch (piece) {
            case 'P':
            case 'p': 
            if (TurnAnnouncer()) {
                whitemoveLogic.Pawn(startX, startY, endX, endY);              
            }
            else{
                blackmovelogic.Pawn(startX, startY, endX, endY);
            }
            break;
            
            case 'N':
            case 'n':
            if (TurnAnnouncer()) {
                whitemoveLogic.Knight(startX, startY, endX, endY);              
            }
            else{
                blackmovelogic.Knight(startX, startY, endX, endY);
            }
            break;
          
            case 'R':
            case 'r':
            if (TurnAnnouncer()) {
                whitemoveLogic.Rook(startX, startY, endX, endY);              
            }
            else{
                blackmovelogic.Rook(startX, startY, endX, endY);
            }
            break;
            case 'K':
            case 'k':
            if (TurnAnnouncer()) {
                whitemoveLogic.King(startX, startY, endX, endY);              
            }
            else{
                blackmovelogic.King(startX, startY, endX, endY);
            }
            break;
            case 'B':
            case 'b':
            if (TurnAnnouncer()) {
                whitemoveLogic.Bishop(startX, startY, endX, endY);              
            }
            else{
                blackmovelogic.Bishop(startX, startY, endX, endY);
            }
            break;
            case 'Q':
            case 'q':
            if (TurnAnnouncer()) {
                whitemoveLogic.Queen(startX, startY, endX, endY);              
            }
            else{
                blackmovelogic.Queen(startX, startY, endX, endY);
            }
            break;
            default:
            System.out.println("There Is no Piece There From Switch case");
            break;
        }
    }

    public void GameStats(){
        System.out.println("Player moved:"+moveCounter+" Times");
    }

}

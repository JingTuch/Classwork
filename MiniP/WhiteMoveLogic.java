public class WhiteMoveLogic {

    private Board board;
    private Game game;

    public WhiteMoveLogic(Game game, Board board) { 
        this.game = game;
        this.board = board;
    }

    public void clearPrevPos(int startX, int startY) {
        char[][] boardArray = board.getBoard();
        if ((startX + startY) % 2 == 0) {  
            boardArray[startY - 1][startX - 1] = '#';
        } else {
            boardArray[startY - 1][startX - 1] = ' ';
        }
    } 
    public boolean isKingCheckedChecker(){
        boolean legalmove = true;
        GameRules gamerules = new GameRules(game, board);
        if (gamerules.isWhiteUnderCheck() == true) {
            legalmove = false;
            return legalmove;
        }
        else{
            return legalmove;
        }
    }
    public boolean Pawn(int startX, int startY, int endX, int endY){
        char[][] boardArray = board.getBoard();

        if (Character.isUpperCase(boardArray[endY - 1][endX - 1])) {
            System.out.println("Cannot move to a square occupied by your own piece.");
            return false;
            
        }else if ((startY == 2 && endY == startY + 2 && endX == startX) && boardArray[endY - 1][endX - 1] == ' ' || boardArray[endY - 1][endX - 1] == '#' || !(Character.isLowerCase(boardArray[endY - 1][endX - 1]))  ) {
             boardArray[endY - 1][endX - 1] = 'P';
            System.out.println("you move your pawn 2 squares");
            clearPrevPos(startX, startY);
            game.incrementMoveCounter();
            return true;

        }  else if ((endY == startY + 1 && endX == startX) && boardArray[endY - 1][endX - 1] == ' ' || boardArray[endY - 1][endX - 1] == '#' || !(Character.isLowerCase(boardArray[endY - 1][endX - 1]))  ) {
            boardArray[endY - 1][endX - 1] = 'P';
            System.out.println("you move your pawn 1 square");
            clearPrevPos(startX, startY);
            game.incrementMoveCounter();
            return true;

        }  else if (endY == startY + 1 && Math.abs(endX - startX) == 1 && boardArray[endY - 1][endX - 1] != ' ' && boardArray[endY - 1][endX - 1] != '#') {
            boardArray[endY - 1][endX - 1] = 'P';
            System.out.println("Your Pawn captured a piece");
            clearPrevPos(startX, startY);
            game.incrementMoveCounter();
            return true;

        }else if(!(isKingCheckedChecker())){
            System.out.println("You are under check");
            return false;
        }
        else{
            System.out.println("Pawns Can't move like that");
            return false;
        }
       
    }
    public boolean Knight(int startX, int startY, int endX, int endY){
        char[][] boardArray = board.getBoard();

        if (Character.isUpperCase(boardArray[endY - 1][endX - 1])) {
            System.out.println("Cannot move to a square occupied by your own piece.");
            return false;
            
        } 
        boolean isKnightMove = ((Math.abs(startY - endY) == 2 && Math.abs(startX - endX) == 1) ||
        (Math.abs(startY - endY) == 1 && Math.abs(startX - endX) == 2));
        
        if (isKnightMove) {
            if(boardArray[endY - 1][endX - 1] != ' ' || boardArray[endY - 1][endX - 1] != '#'){
                boardArray[endY - 1][endX - 1] = 'N'; 
                clearPrevPos(startX, startY);
                game.incrementMoveCounter(); 
                System.out.println("your knight Captured a piece");
                return true;
            }
            else{
            boardArray[endY - 1][endX - 1] = 'N'; 
            clearPrevPos(startX, startY);
            if (!(isKingCheckedChecker())) {
                boardArray[startY - 1][startX - 1] = 'N'; 
                clearPrevPos(endY, endX);
                System.out.println("Your King is underChecked Try again");
                return false;
            }
            System.out.println("You moved your knight");
            game.incrementMoveCounter(); 
            return true;
        }
        }else {
            System.out.println("Knight Can't move like that");
            return false;
        }
    }
    public boolean isXpathClear(int startX, int startY, int endX, int endY) {
        char[][] boardArray = board.getBoard();
    
        if (startX == endX) { 
            int direction = (endY > startY) ? 1 : -1;
            for (int y = startY + direction; y != endY; y += direction) {
                if (boardArray[y - 1][startX - 1] != ' ' && boardArray[y - 1][startX - 1] != '#') {
                    return false; 
                }
            }
        } else if (startY == endY) { 
            int direction = (endX > startX) ? 1 : -1;
            for (int x = startX + direction; x != endX; x += direction) {
                if (boardArray[startY - 1][x - 1] != ' ' && boardArray[startY - 1][x - 1] != '#') {
                    return false; 
                }
            }
        } else {
            return false; 
        }
        return true; 
    } 
    public boolean isYpathClear(int startX, int startY, int endX, int endY) {
        char[][] boardArray = board.getBoard();
           
        if (Math.abs(endX - startX) != Math.abs(endY - startY)) {
            return false;  
        }          
        int yDirection = (endY > startY) ? 1 : -1;
        int xDirection = (endX > startX) ? 1 : -1;
           
        int x = startX + xDirection;
        int y = startY + yDirection;
        while (x != endX && y != endY) {
            if (boardArray[y - 1][x - 1] != ' ' && boardArray[y - 1][x - 1] != '#') {
                return false;  
            }
            x += xDirection;
            y += yDirection;
        }   
        return true;  
    }
    public boolean Rook(int startX, int startY, int endX, int endY){
        char[][] boardArray = board.getBoard();

        if (Character.isUpperCase(boardArray[endY - 1][endX - 1])) {
            System.out.println("Cannot move to a square occupied by your own piece.");
            return false;
        } 
        boolean isRookMove = ((startY == endY || startX == endX) && isXpathClear(startX, startY, endX, endY));

        if (isRookMove) {
            if(boardArray[endY - 1][endX - 1] != ' ' || boardArray[endY - 1][endX - 1] != '#'){
                boardArray[endY - 1][endX - 1] = 'R'; 
                clearPrevPos(startX, startY);
                game.incrementMoveCounter(); 
                System.out.println("your knight Captured a piece");
                return true;
            }
                boardArray[endY - 1][endX - 1] = 'R';
                clearPrevPos(startX, startY);
                game.incrementMoveCounter(); 
                System.out.println("You moved your knight");
                return true;
        }
        else{
            System.out.println("Rook Can't move like that");
            return false;
        }
    }
    public boolean King(int startX, int startY, int endX, int endY){
        char[][] boardArray = board.getBoard();
        if (Character.isUpperCase(boardArray[endY - 1][endX - 1])) {
            System.out.println("Cannot move to a square occupied by your own piece.");
            return false;
        } 
        boolean isKingMove = (Math.abs(endX - startX) == 1 || Math.abs(endY - startY) == 1);
        if (isKingMove) {
            if(boardArray[endY - 1][endX - 1] != ' ' || boardArray[endY - 1][endX - 1] != '#'){
                boardArray[endY - 1][endX - 1] = 'K'; 
                clearPrevPos(startX, startY);
                game.incrementMoveCounter(); 
                System.out.println("your King Captured a piece");
                return true;
            }
                boardArray[endY - 1][endX - 1] = 'K';
                clearPrevPos(startX, startY);
                game.incrementMoveCounter(); 
                System.out.println("You moved your King");
                return true;
        }else{
            System.out.println("King Can't move like that");
            return false;
        }
    }
    public boolean Bishop(int startX, int startY, int endX, int endY) {
        char[][] boardArray = board.getBoard();
        

        if (Character.isUpperCase(boardArray[endY - 1][endX - 1])) {
            System.out.println("Cannot move to a square occupied by your own piece.");
            return false;
        }
        
        boolean isBishopMove = (Math.abs(startX - endX) == Math.abs(startY - endY)) && isYpathClear(startX, startY, endX, endY);
        
        if (isBishopMove) {
            if (boardArray[endY - 1][endX - 1] != ' ' && boardArray[endY - 1][endX - 1] != '#') {
                System.out.println("Your Bishop captured a piece");
            } else {
                System.out.println("You moved your Bishop");
            }
            boardArray[endY - 1][endX - 1] = 'B';
            clearPrevPos(startX, startY);
            game.incrementMoveCounter();
            return true;
        } else {
            System.out.println("Bishop can't move like that");
            return false;
        }
    }
    public boolean Queen(int startX, int startY, int endX, int endY) {
        char[][] boardArray = board.getBoard();
    
       
        if ((Character.isUpperCase(boardArray[endY - 1][endX - 1]))) {
            System.out.println("Cannot move to a square occupied by your own piece.");
            return false;
        }
    
        boolean isQueenMove;
        if (Math.abs(startX - endX) == Math.abs(startY - endY)) {
            isQueenMove = isYpathClear(startX, startY, endX, endY);
        }
        else if (startX == endX || startY == endY) {
            isQueenMove = isXpathClear(startX, startY, endX, endY);
        } else {
            isQueenMove = false;
        }
    
        if (isQueenMove) {
            if (boardArray[endY - 1][endX - 1] != ' ' && boardArray[endY - 1][endX - 1] != '#') {
                System.out.println("Your Queen captured a piece");
            } else {
                System.out.println("You moved your Queen");
            }
            boardArray[endY - 1][endX - 1] = 'Q';
            clearPrevPos(startX, startY);
            game.incrementMoveCounter();
            return true;
        } else {
            System.out.println("Queen can't move like that");
            return false;
        }
    }
    
    
}

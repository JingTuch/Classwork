public class GameRules {
    private Board board;
    private Game game;

    public GameRules(Game game, Board board) { 
        this.game = game;
        this.board = board;
    }
  //checkmate logic 
 public boolean GameOver(){
    char[][] boardArray = board.getBoard();
    Game game = new Game(board);
    int WK=0,BK=0;
    boolean winnner = false;
    //need's revise to handle checkmate only
    for (int y = 0; y < boardArray.length; y++) {
        for (int x = 0; x < boardArray.length; x++) {
            if (boardArray[y][x] == 'K') {
                ++WK;
            }
            else if (boardArray[y][x] == 'k') {
                ++BK;
            }
        }
    }
   if (WK == 0) {
    System.out.println("Black Win");
    winnner = true;
   }
   else if (BK == 0) {
    System.out.println("White Win");
    winnner = true;
   }
   return winnner;
}
public boolean isBlackUnderCheck() {
    char[][] boardArray = board.getBoard();
    int kingX = -1, kingY = -1;
    
    for (int y = 0; y < boardArray.length; y++) {
        for (int x = 0; x < boardArray[y].length; x++) {
            if (boardArray[y][x] == 'k') {
                kingX = x;
                kingY = y;
                break;
            }
        }
    }

    int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    for (int[] dir : directions) {
        int x = kingX + dir[0], y = kingY + dir[1];
        while (x >= 0 && x < boardArray.length && y >= 0 && y < boardArray.length) {
            char piece = boardArray[y][x];
            if (piece != ' ') {
                if (piece == 'R' || piece == 'Q') {
                    return true; 
                } else {
                    break; 
                }
            }
            x += dir[0];
            y += dir[1];
        }
    }

 
    int[][] diagonalDirections = {{1, 1}, {-1, -1}, {1, -1}, {-1, 1}};
    for (int[] dir : diagonalDirections) {
        int x = kingX + dir[0], y = kingY + dir[1];
        while (x >= 0 && x < boardArray.length && y >= 0 && y < boardArray.length) {
            char piece = boardArray[y][x];
            if (piece != ' ') {
                if (piece == 'B' || piece == 'Q') {
                    return true;
                } else {
                    break; 
                }
            }
            x += dir[0];
            y += dir[1];
        }
    }

   
    int[][] knightMoves = {{2, 1}, {2, -1}, {-2, 1}, {-2, -1}, {1, 2}, {1, -2}, {-1, 2}, {-1, -2}};
    for (int[] move : knightMoves) {
        int x = kingX + move[0], y = kingY + move[1];
        if (x >= 0 && x < boardArray.length && y >= 0 && y < boardArray.length && boardArray[y][x] == 'N') {
            return true; 
        }
    }

    
    if (kingY > 0) {
        if (kingX > 0 && boardArray[kingY - 1][kingX - 1] == 'P') return true; 
        if (kingX < boardArray.length - 1 && boardArray[kingY - 1][kingX + 1] == 'P') return true;
    }

    return false; 
}
public boolean isWhiteUnderCheck() {
    char[][] boardArray = board.getBoard();
    int kingX = -1, kingY = -1;
    
    for (int y = 0; y < boardArray.length; y++) {
        for (int x = 0; x < boardArray[y].length; x++) {
            if (boardArray[y][x] == 'K') {
                kingX = x;
                kingY = y;
                break;
            }
        }
    }



    int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    for (int[] dir : directions) {
        int x = kingX + dir[0], y = kingY + dir[1];
        while (x >= 0 && x < boardArray.length && y >= 0 && y < boardArray.length) {
            char piece = boardArray[y][x];
            if (piece != ' ') {
                if (piece == 'r' || piece == 'q') {
                    return true; 
                } else {
                    break; 
                }
            }
            x += dir[0];
            y += dir[1];
        }
    }

 
    int[][] diagonalDirections = {{1, 1}, {-1, -1}, {1, -1}, {-1, 1}};
    for (int[] dir : diagonalDirections) {
        int x = kingX + dir[0], y = kingY + dir[1];
        while (x >= 0 && x < boardArray.length && y >= 0 && y < boardArray.length) {
            char piece = boardArray[y][x];
            if (piece != ' ') {
                if (piece == 'b' || piece == 'q') {
                    return true;
                } else {
                    break; 
                }
            }
            x += dir[0];
            y += dir[1];
        }
    }

   
    int[][] knightMoves = {{2, 1}, {2, -1}, {-2, 1}, {-2, -1}, {1, 2}, {1, -2}, {-1, 2}, {-1, -2}};
    for (int[] move : knightMoves) {
        int x = kingX + move[0], y = kingY + move[1];
        if (x >= 0 && x < boardArray.length && y >= 0 && y < boardArray.length && boardArray[y][x] == 'n') {
            return true; 
        }
    }

    
    if (kingY > 0) {
        if (kingX > 0 && boardArray[kingY - 1][kingX - 1] == 'p') return true; 
        if (kingX < boardArray.length - 1 && boardArray[kingY - 1][kingX + 1] == 'p') return true;
    }

    return false; 
}
public boolean KingsStatus(){
    boolean News = false;
    boolean WAnnounce = (isWhiteUnderCheck()) ? true:false;
    boolean BAnnounce = (isBlackUnderCheck()) ? true:false;
    if (BAnnounce) {
        System.out.println("Black is under Check");
        News = true;
    }
    else if (WAnnounce) {
        System.out.println("White is under Check");
        News = true;
    }
    return News;
}
 //pinned condition
 //promotion logic

}
 
public class Board {

    private char[][] board;
    public Board() {
        initializeBoard();
    }

    public void initializeBoard() {
        board = new char[][] {
            {'R', 'N', 'B', 'Q', 'K', 'B', 'N', 'R'},// white
            {'P', 'P', 'P', 'P', 'P', 'P', 'P', 'P'},
            {'#', ' ', '#', ' ', '#', ' ', '#', ' '},
            {' ', '#', ' ', '#', ' ', '#', ' ', '#'},
            {'#', ' ', '#', ' ', '#', ' ', '#', ' '},
            {' ', '#', ' ', '#', ' ', '#', ' ', '#'},
            {'p', 'p', 'p', 'p', 'p', 'p', 'p', 'p'},
            {'r', 'n', 'b', 'q', 'k', 'b', 'n', 'r'} // black
        };
    }

    public void displayBoard() {
        for (int y = 0; y < board.length; y++) {
            for (int x = 0; x < board[y].length; x++) {
                System.out.print(board[y][x] + " ");
            }
            System.out.print( " "+(1+y) );
            System.out.println();
        }
        System.out.println("\nA B C D E F G H <-X Y^");
    }

    public char[][] getBoard() {
        return board;
    }
}
/* 
            {'R', 'N', 'B', 'Q', 'K', 'B', 'N', 'R'},// white
            {'P', 'P', 'P', 'P', 'P', 'P', 'P', 'P'},
            {'#', ' ', '#', ' ', '#', ' ', '#', ' '},
            {' ', '#', ' ', '#', ' ', '#', ' ', '#'},
            {'#', ' ', '#', ' ', '#', ' ', '#', ' '},
            {' ', '#', ' ', '#', ' ', '#', ' ', '#'},
            {'p', 'p', 'p', 'p', 'p', 'p', 'p', 'p'},
            {'r', 'n', 'b', 'q', 'k', 'b', 'n', 'r'} // black



{'#', ' ', '#', ' ', '#', ' ', '#', ' '},
{' ', '#', ' ', '#', ' ', '#', 'K', '#'},
{'#', ' ', '#', ' ', '#', ' ', '#', ' '},
{' ', '#', ' ', '#', ' ', '#', ' ', '#'},
{'#', ' ', 'B', 'B', '#', 'b', 'b', ' '},
{' ', '#', ' ', '#', ' ', '#', ' ', '#'},
{'#', 'k', '#', ' ', '#', ' ', '#', ' '},
{' ', '#', ' ', '#', ' ', '#', ' ', '#'},
*/
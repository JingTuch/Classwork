import java.util.Scanner;

public class Main {
    private static Scanner in = new Scanner(System.in);
    
    public static int letterToNumber(char letter) {
        letter = Character.toUpperCase(letter); // Convert to uppercase to handle both cases
        switch (letter) {
            case 'A': return 1;
            case 'B': return 2;
            case 'C': return 3;
            case 'D': return 4;
            case 'E': return 5;
            case 'F': return 6;
            case 'G': return 7;
            case 'H': return 8;
            default: return -1; 
        }
    }

    public static void Input(Game game) {
        int startX, endX, startY, endY;

        // Announce whose turn it is
        System.out.println(game.TurnAnnouncer() ? "White's turn" : "Black's turn");

    
    do {
        System.out.println("Enter the starting coordinates (format: Column Row, e.g., A 2):");
        char startColumn = in.next().charAt(0);
        startX = letterToNumber(startColumn);
        startY = in.nextInt();
        } while ((game.PosChecker(startX, startY)));
        System.out.println("Enter the ending coordinates (format: Column Row):");
        char endColumn = in.next().charAt(0);
        endX = letterToNumber(endColumn);
        endY = in.nextInt();
        game.movePiece(startX, startY, endX, endY);
        System.out.println(startX+" "+endX);
    }

    public static void main(String[] args) {
        Board board = new Board();
        Game game = new Game(board);
        GameRules gamerule = new GameRules(game, board);
        board.displayBoard();

        while (!(gamerule.GameOver())) {
            gamerule.KingsStatus();
            Input(game);
            board.displayBoard();
            game.GameStats();
        }
    }
}

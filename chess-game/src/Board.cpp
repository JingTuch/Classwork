#include <iostream>
#include "Board.h"
#include "Pawn.h"
#include "King.h"
#include "Rook.h"
#include "Bishop.h"
#include "Queen.h"
#include "Knight.h"
Board::Board(){
	for(int row = 0; row < 8; row++)
		for(int col = 0; col < 8; col++)
			squares[row][col] = nullptr;
	setupInitialPosition();
}
Board::~Board(){
	for(int row = 0; row < 8; row++){
		for(int col = 0; col < 8; col++){
	delete squares[row][col];
		}
	}
}
void Board::setupInitialPosition() {
// Black king cornered
squares[0][0] = new King(false);
squares[1][2] = new Queen(true);
squares[2][1] = new Rook(true);
squares[7][7] = new King(true);
	/*Default Scenario
    for (int col = 0; col < 8; ++col) {
        squares[1][col] = new Pawn(false); 
        squares[6][col] = new Pawn(true);  
    }
	squares[0][0] = new Rook(false);
    squares[0][7] = new Rook(false);
    squares[7][0] = new Rook(true);
    squares[7][7] = new Rook(true);

    squares[0][1] = new Knight(false);
    squares[0][6] = new Knight(false);
    squares[7][1] = new Knight(true);
    squares[7][6] = new Knight(true);

    squares[0][2] = new Bishop(false);
    squares[0][5] = new Bishop(false);
    squares[7][2] = new Bishop(true);
    squares[7][5] = new Bishop(true);

    squares[0][3] = new Queen(false);
    squares[7][3] = new Queen(true);
	
    squares[0][4] = new King(false);
    squares[7][4] = new King(true);
	*/
}
void Board::display()const{
	std::cout<<"\n  a b c d e f g h\n";
	for(int row = 0; row < 8 ; ++row){
		std::cout<<8-row<<' ';
		for(int col = 0; col < 8 ; ++col){
			if (squares[row][col] == nullptr) {
                std::cout << ". ";
            } else {
                std::cout << squares[row][col]->getSymbol() << ' ';
            }
		}
		std::cout<<8-row<<'\n';
	}
	std::cout<<"\n  a b c d e f g h\n";
}
bool Board::isInCheck(bool isWhite) const {
    int kingRow = -1, kingCol = -1;

    // Step 1: Find the King of the given color
    for (int row = 0; row < 8; ++row) {
        for (int col = 0; col < 8; ++col) {
            Piece* piece = squares[row][col];
            if (piece != nullptr && dynamic_cast<King*>(piece) && piece->getIsWhite() == isWhite) {
                kingRow = row;
                kingCol = col;
                break;
            }
        }
    }

    if (kingRow == -1 || kingCol == -1) {
        std::cerr << "Error: King not found.\n";
        return false;
    }

    // Step 2: Check if any opposing piece can move to the King's square
    for (int row = 0; row < 8; ++row) {
        for (int col = 0; col < 8; ++col) {
            Piece* attacker = squares[row][col];
            if (attacker != nullptr && attacker->getIsWhite() != isWhite) {
                if (attacker->isValidMove(row, col, kingRow, kingCol, squares)) {
                    return true; // King is under attack
                }
            }
        }
    }

    return false; // King is safe
}
bool Board::isCheckmate(bool isWhite) {
    if (!isInCheck(isWhite)) return false; // not even in check

    // Try every piece of current player
    for (int startRow = 0; startRow < 8; ++startRow) {
        for (int startCol = 0; startCol < 8; ++startCol) {
            Piece* piece = squares[startRow][startCol];
            if (piece == nullptr || piece->getIsWhite() != isWhite) continue;

            // Try moving to every square
            for (int endRow = 0; endRow < 8; ++endRow) {
                for (int endCol = 0; endCol < 8; ++endCol) {
                    // Skip if it's the same square
                    if (startRow == endRow && startCol == endCol) continue;

                // Backup
                Piece* backupStart = squares[startRow][startCol];
                Piece* backupEnd = squares[endRow][endCol];

                // Simulate
                squares[endRow][endCol] = backupStart;
                squares[startRow][startCol] = nullptr;

                if (!isInCheck(isWhite)) {
                // Restore
                squares[startRow][startCol] = backupStart;
                squares[endRow][endCol] = backupEnd;
                return false; // legal escape move exists
                }

                // Restore
                squares[startRow][startCol] = backupStart;
                squares[endRow][endCol] = backupEnd;
                }
            }
        }
    }

    return true; // No legal moves to escape check
}
bool Board::movePiece(int startRow, int startCol, int endRow, int endCol,bool isWhiteTurn){
	Piece* movingPiece = squares[startRow][startCol];
	Piece* targetPiece = squares[endRow][endCol];
	if(!movingPiece){
		std::cout<<"No piece at the starting position.\n";
		return false;
	}
	if(movingPiece->getIsWhite() != isWhiteTurn){
		std::cout<<"Not your turn.\n";
		return false;
	}
	if (targetPiece && targetPiece->getIsWhite() == isWhiteTurn){
		 std::cout << "You can't capture your own piece.\n";
        return false;
	}
	if(!movingPiece->isValidMove(startRow,startCol,endRow,endCol,squares)){
		std::cout<<"invalid move for that piece.\n";
		return false;
	}
	movingPiece->setHasMoved(true);
	if(targetPiece){
		delete targetPiece;
	}
    squares[endRow][endCol] = movingPiece;
    squares[startRow][startCol] = nullptr;

	return true;
}
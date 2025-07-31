#ifndef BOARD_H
#define BOARD_H
#include "Piece.h"
class Board{
	public:
		Board();
		~Board();
		bool movePiece(int startRow, int startCol, int endRow, int endCol,bool isWhiteTurn);
		bool isInCheck(bool isWhite) const;
		bool isCheckmate(bool isWhite);
		void display() const;
		
	private:
		Piece* squares[8][8];
		void setupInitialPosition();
		
};

#endif
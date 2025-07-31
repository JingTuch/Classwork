#ifndef KING_H
#define KING_H 
#include "Piece.h"

class King : public Piece {
    public:
        King(bool isWhite);

        char getSymbol() const override;
        bool isValidMove(int startRow, int startCol, int endRow, int endCol,Piece* const squares[8][8]) const override;
};
#endif
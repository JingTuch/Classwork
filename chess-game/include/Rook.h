#ifndef ROOK_H
#define ROOK_H 
#include "Piece.h"

class Rook : public Piece {
    public:
        Rook(bool isWhite);

        char getSymbol() const override;
        bool isValidMove(int startRow, int startCol, int endRow, int endCol,Piece* const squares[8][8]) const override;
};
#endif
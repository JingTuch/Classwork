#ifndef BISHOP_H
#define BISHOP_H

#include "Piece.h"

class Bishop : public Piece {
    public:
        Bishop(bool isWhite);

        char getSymbol() const override;
        bool isValidMove(int startRow, int startCol, int endRow, int endCol, Piece* const squares[8][8]) const override;
};
#endif
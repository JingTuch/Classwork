#ifndef KNIGHT_H
#define KNIGHT_H

#include "Piece.h"

class Knight : public Piece {
    public:
        Knight(bool isWhite);

        char getSymbol() const override;
        bool isValidMove(int startRow, int startCol, int endRow, int endCol, Piece* const squares[8][8]) const override;
};
#endif
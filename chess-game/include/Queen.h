#ifndef QUEEN_H
#define QUEEN_H

#include "Piece.h"

class Queen : public Piece {
    public:
        Queen(bool isWhite);

        char getSymbol() const override;
        bool isValidMove(int startRow, int startCol, int endRow, int endCol, Piece* const squares[8][8]) const override;
};
#endif
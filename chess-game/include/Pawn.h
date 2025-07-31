#ifndef PAWN_H
#define PAWN_H

#include "Piece.h"

class Pawn : public Piece {
    public:
        Pawn(bool isWhite);

        char getSymbol() const override;
        bool isValidMove(int, int, int, int, Piece* const squares[8][8]) const override;
};
#endif
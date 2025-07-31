#include <iostream>
#include <cmath> 
#include "King.h"

King::King(bool isWhite) : Piece(isWhite) {}

char King::getSymbol() const {
    return isWhite ? 'K' : 'k';
}

bool King::isValidMove(int startRow, int startCol, int endRow, int endCol,Piece* const squares[8][8]) const {
    int rowDiff = std::abs(endRow - startRow);
    int colDiff = std::abs(endCol - startCol);

    if ((rowDiff <= 1 && colDiff <= 1) && !(rowDiff == 0 && colDiff == 0)) {
        Piece* target = squares[endRow][endCol];
        return (target == nullptr || target->getIsWhite() != getIsWhite());
    }
    //castling here
    return false;
}

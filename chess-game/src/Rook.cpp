#include <iostream>
#include <cmath> 
#include "Rook.h"

Rook::Rook(bool isWhite) : Piece(isWhite) {}

char Rook::getSymbol() const {
    return isWhite ? 'R' : 'r';
}

bool Rook::isValidMove(int startRow, int startCol, int endRow, int endCol,Piece* const squares[8][8]) const {
    Piece* target = squares[endRow][endCol];
    if (startRow == endRow && startCol == endCol)
        return false;

    if (startRow != endRow && startCol != endCol)
        return false;

    if (startRow == endRow) {
        int step = (endCol > startCol) ? 1 : -1;
        for (int col = startCol + step; col != endCol; col += step) {
            if (squares[startRow][col] != nullptr)
                return false;
        }
    } else if (startCol == endCol) {
        int step = (endRow > startRow) ? 1 : -1;
        for (int row = startRow + step; row != endRow; row += step) {
            if (squares[row][startCol] != nullptr)
                return false;
        }
    }
    return true;
}

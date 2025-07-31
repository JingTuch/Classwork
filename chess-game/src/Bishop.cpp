#include<iostream>
#include "Bishop.h"
#include "Board.h"

Bishop::Bishop(bool isWhite) : Piece(isWhite){}

char Bishop::getSymbol() const{
    return isWhite ? 'B' : 'b';
}

bool Bishop::isValidMove(int startRow, int startCol, int endRow, int endCol,Piece* const squares[8][8]) const{

    if (abs(endRow - startRow) != abs(endCol - startCol)) {
        return false;
    }
     int colStep = (endCol > startCol) ? 1 : -1;
     int rowStep = (endRow > startRow) ? 1 : -1;

     int row = startRow + rowStep;
     int col = startCol + colStep;
     while (row != endRow && col != endCol) {
        if (squares[row][col] != nullptr) {
            return false;
        }
        row += rowStep;
        col += colStep;
    }
    Piece* target = squares[endRow][endCol];
    return (target == nullptr || target->getIsWhite() != getIsWhite());
}
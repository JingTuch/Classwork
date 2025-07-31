#include<iostream>
#include "Knight.h"
#include "Board.h"
Knight::Knight(bool isWhite) : Piece(isWhite){}

char Knight::getSymbol() const{
    return isWhite ? 'N' : 'n';
}

bool Knight::isValidMove(int startRow, int startCol, int endRow, int endCol,Piece* const squares[8][8]) const{
    int rowDiff = abs(endRow - startRow);
    int colDiff = abs(endCol - startCol);

    Piece* target = squares[endRow][endCol];
  if(((rowDiff == 1 && colDiff == 2) || (rowDiff == 2 && colDiff == 1))){
     if (target != nullptr && target->getIsWhite() != this->getIsWhite()) {
            return true;
     }
    return true;
  }

return false;
}
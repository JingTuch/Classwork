#include<iostream>
#include "Pawn.h"
#include "Board.h"
Pawn::Pawn(bool isWhite) : Piece(isWhite){}

char Pawn::getSymbol() const{
    return isWhite ? 'P' : 'p';
}

bool Pawn::isValidMove(int startRow, int startCol, int endRow, int endCol,Piece* const squares[8][8]) const{
    int direction = getIsWhite() ? -1 : 1; 
    int startRank = getIsWhite() ? 6 : 1;  

    Piece* target = squares[endRow][endCol];
    if (startCol == endCol && endRow == startRow + direction && target == nullptr) {
        return true;
    }
    if (startCol == endCol && startRow == startRank && endRow == startRow + 2 * direction) {
        if (squares[startRow + direction][startCol] == nullptr && target == nullptr) {
            return true;
        }
    }
    if (abs(endCol - startCol) == 1 && endRow == startRow + direction) {
        if (target != nullptr && target->getIsWhite() != this->getIsWhite()) {
            return true;
        }
    
    }
    return false;
}
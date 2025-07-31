#include<iostream>
#include "Queen.h"
#include "Board.h"

Queen::Queen(bool isWhite) : Piece(isWhite){}

char Queen::getSymbol() const{
    return isWhite ? 'Q' : 'q';
}

bool Queen::isValidMove(int startRow, int startCol, int endRow, int endCol,Piece* const squares[8][8]) const{
    if (startRow == endRow && startCol == endCol)
        return false;

    int rowDiff = abs(endRow - startRow);
    int colDiff = abs(endCol - startCol);

    if (rowDiff == colDiff) {
        int rowStep = (endRow > startRow) ? 1 : -1;
        int colStep = (endCol > startCol) ? 1 : -1;

        int row = startRow + rowStep;
        int col = startCol + colStep;

        while (row != endRow && col != endCol) {
            if (squares[row][col] != nullptr)
                return false;
            row += rowStep;
            col += colStep;
        }

        Piece* target = squares[endRow][endCol];
        return (target == nullptr || target->getIsWhite() != getIsWhite());
    }

    if (startRow == endRow) {
        int step = (endCol > startCol) ? 1 : -1;
        for (int col = startCol + step; col != endCol; col += step) {
            if (squares[startRow][col] != nullptr)
                return false;
        }

        Piece* target = squares[endRow][endCol];
        return (target == nullptr || target->getIsWhite() != getIsWhite());
    }

    if (startCol == endCol) {
        int step = (endRow > startRow) ? 1 : -1;
        for (int row = startRow + step; row != endRow; row += step) {
            if (squares[row][startCol] != nullptr)
                return false;
        }

        Piece* target = squares[endRow][endCol];
        return (target == nullptr || target->getIsWhite() != getIsWhite());
    }

    return false;
}
#ifndef PIECE_H
#define PIECE_H

class Piece{
    protected:
        bool isWhite;
        bool hasMoved = false;
    public:
        Piece(bool isWhite);
        virtual ~Piece() = default;
        bool getIsWhite() const {return isWhite;}
        bool isWhitePiece() const;

        bool getHasMoved() const { return hasMoved; }
        void setHasMoved(bool moved) { hasMoved = moved; }
        virtual char getSymbol() const = 0;
        virtual bool isValidMove(int startRow, int startCol, int endRow, int endCol,Piece* const squares[8][8]) const = 0;

};
#endif
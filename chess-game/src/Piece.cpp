#include "Piece.h"

Piece::Piece(bool isWhite) : isWhite(isWhite) {}

bool Piece::isWhitePiece() const{
	return isWhite;
}

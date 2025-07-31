#ifndef GAME_H
#define GAME_H
#include "Board.h"
class Game{
	public:
		Game();
		void start();
		
	private:
		bool isWhiteTurn;
		bool gameOver;
		Board board;
};

#endif
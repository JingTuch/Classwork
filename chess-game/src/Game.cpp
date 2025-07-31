#include <iostream>
#include <cstdlib>
#include <cctype>
#include <string>
#include "Game.h"
/*
Not Im plemented yet
bishop
knight
queen
promotion
castling
checkmate
tactics 

*/
Game::Game() {
	isWhiteTurn = true;
	gameOver = false;
}
void clearScreen() {
#ifdef _WIN32
    std::system("cls");
#else
    std::system("clear"); // for Unix/Linux/macOS
#endif
}
bool parseMove(const std::string& input, int& startRow, int& startCol, int& endRow, int& endCol){
	if(input.length()!=5||input[2]!=' '){
		std::cout<< "invalid input format. Use format like: e2 e4";
		return false;
	}
	char startFile = std::tolower(input[0]);
	char startRank = std::tolower(input[1]);
	char endFile = std::tolower(input[3]);
	char endRank = std::tolower(input[4]);
	if (startFile < 'a' || startFile > 'h' || endFile < 'a' || endFile > 'h' ||
	startRank < '1' || startRank > '8' || endRank < '1' || endRank > '8'){
		return false;
	}
	startCol = startFile - 'a';
    startRow = 8 - (startRank - '0');
    endCol = endFile - 'a';
    endRow = 8 - (endRank - '0');

    return true;
}
void Game::start() {
	std::string input;
	std::string buff;
	int startRow, startCol, endRow, endCol;
	std::string lastMessage = ""; 

	while (!gameOver) {
		//clearScreen();
		board.display();
		
		if (!lastMessage.empty()) {
			std::cout << "\n" << lastMessage << "\n";
			lastMessage = "";
		}

		std::cout << (isWhiteTurn ? "White's Move: " : "Black's Move: ");
		std::cout << "Enter Coordinates (e.g., e2 e4): ";
		std::getline(std::cin, input);

		if (parseMove(input, startRow, startCol, endRow, endCol)) {
			if (board.movePiece(startRow, startCol, endRow, endCol, isWhiteTurn)) {

				// Check for check/checkmate BEFORE toggling the turn
				if (board.isInCheck(!isWhiteTurn)) { // the opponent's king is now under attack
					if (board.isCheckmate(!isWhiteTurn)) {
						board.display();
						std::cout << "CHECKMATE! " << (isWhiteTurn ? "White" : "Black") << " wins!\n";
						std::getline(std::cin, buff);
						gameOver = true;
						return;
					} else {
						lastMessage = "Check!";
					}
				}

				isWhiteTurn = !isWhiteTurn;  // only flip the turn after check/checkmate evaluation
				if (lastMessage.empty()) {
					lastMessage = "Move successful.";
				}

			} else {
				lastMessage = "Invalid move: piece can't move there or trying to capture own piece.";
			}
		} else {
			lastMessage = "Invalid move format. Please use e.g. e2 e4.";
		}
	}
}


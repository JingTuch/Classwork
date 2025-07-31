#include <iostream>
#include "Game.h"

int main() {
    std::cout << "==============================\n";
    std::cout << "     Welcome to Chess Game!   \n";
    std::cout << "==============================\n\n";

    Game game;
    game.start();

    return 0;
}

package org.example.game;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BoardTest {

  @Test
  void initBoard() {
    Game game = new Game();

    Assertions.assertEquals(game.getBoard().boardState[3][0].getName(), FigureName.EMPTY);

    Assertions.assertEquals(game.getBoard().boardState[0][0].getName(), FigureName.ROOK);
    Assertions.assertEquals(game.getBoard().boardState[6][1].getName(), FigureName.PAWN);

    Assertions.assertEquals(game.getBoard().boardState[0][4].getColor(), Color.WHITE);
    Assertions.assertEquals(game.getBoard().boardState[7][6].getColor(), Color.BLACK);
  }
}
package org.example.game;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {
  Game game;

  @BeforeEach
  void gameInit() {
    game = new Game();
  }

  @Test
  void testCheckColor() {
    Figure startFigure = new Figure(FigureName.PAWN, Color.WHITE);
    Figure finishFigure = new Figure(FigureName.EMPTY, Color.NONE);
    assertTrue(game.checkColor(startFigure, finishFigure));
  }

  @Test
  public void testOnBeginningCheckIsOver() {
    assertFalse(game.checkIsOver());
  }

  @Test
  void testMove() {
    assertTrue(game.checkMovement(1, 1, 2, 2));

    assertFalse(game.checkMovement(1, 1, 2, 3));
  }

  @Test
  public void testGetActivePlayer() {
    Player activePlayer = game.getActivePlayer();
    assertNotNull(activePlayer);
    assertEquals("Player 1", activePlayer.getName());
  }

  @Test
  void testValidateMovePattern() {
    Assertions.assertTrue(game.checkPattern("e2-e4"));
    Assertions.assertFalse(game.checkPattern("r2-e10"));
  }

  @Test
  public void testNextMove() {
    Player activePlayerBefore = game.getActivePlayer();
    game.nextMove();
    Player activePlayerAfter = game.getActivePlayer();

    assertNotEquals(activePlayerBefore, activePlayerAfter);
  }
}
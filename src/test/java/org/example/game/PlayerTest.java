package org.example.game;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {
  Game game;

  @BeforeEach
  void gameInit() {
    game = new Game();
  }

  @Test
  void testGetName() {
    Assertions.assertEquals(game.getActivePlayer().getName(), "Player 1");
  }

  @Test
  void testGetColor() {
    Assertions.assertEquals(game.getActivePlayer().getColor(), Color.WHITE);
  }

  @Test
  void testGetActive() {
    Assertions.assertTrue(game.getActivePlayer().getActive());
  }

  @Test
  void testChangeActive() {
    game.getActivePlayer().changeActive();
    Assertions.assertFalse(game.getActivePlayer().getActive());
  }
}
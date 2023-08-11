package org.example;

import org.example.game.Game;

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Game chessGame = new Game();
    System.out.println("Hi, this is simple console Chess Game.\n");
    while (!chessGame.checkIsOver()) {
      System.out.println("Current board state:\n");
      System.out.println(chessGame.displayGame());

      System.out.println(chessGame.getActivePlayer().getName() + " is your turn.\n");
      Scanner scannerMove = new Scanner(System.in);
      String playerMove = scannerMove.nextLine();

      while (!chessGame.validateMove(playerMove)) {
        System.out.println("Invalid move! Try again!");
        playerMove = scannerMove.nextLine();
      }

      chessGame.nextMove();
    }
    System.out.println("Checkmate " + chessGame.getActivePlayer().getName() + "!");
  }
}
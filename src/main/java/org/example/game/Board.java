package org.example.game;

import java.util.List;

public class Board {
  public Figure[][] boardState;
  public final static int BOARD_SIZE = 64;
  public final static int BOARD_SIDE = 8;
  public final static int PIECES_PER_PLAYER = 16;

  public Board() {
    initBoard();
  }

  public void initBoard() {
    boardState = new Figure[Board.BOARD_SIDE][Board.BOARD_SIDE];

    boardState[0][0] = new Figure(FigureName.ROOK, Color.WHITE);
    boardState[0][1] = new Figure(FigureName.KNIGHT, Color.WHITE);
    boardState[0][2] = new Figure(FigureName.BISHOP, Color.WHITE);
    boardState[0][3] = new Figure(FigureName.QUEEN, Color.WHITE);
    boardState[0][4] = new Figure(FigureName.KING, Color.WHITE);
    boardState[0][5] = new Figure(FigureName.BISHOP, Color.WHITE);
    boardState[0][6] = new Figure(FigureName.KNIGHT, Color.WHITE);
    boardState[0][7] = new Figure(FigureName.ROOK, Color.WHITE);

    for (int i = 0; i < Board.BOARD_SIDE; i++) {
      boardState[1][i] = new Figure(FigureName.PAWN, Color.WHITE);
    }

    boardState[7][0] = new Figure(FigureName.ROOK, Color.BLACK);
    boardState[7][1] = new Figure(FigureName.KNIGHT, Color.BLACK);
    boardState[7][2] = new Figure(FigureName.BISHOP, Color.BLACK);
    boardState[7][3] = new Figure(FigureName.QUEEN, Color.BLACK);
    boardState[7][4] = new Figure(FigureName.KING, Color.BLACK);
    boardState[7][5] = new Figure(FigureName.BISHOP, Color.BLACK);
    boardState[7][6] = new Figure(FigureName.KNIGHT, Color.BLACK);
    boardState[7][7] = new Figure(FigureName.ROOK, Color.BLACK);

    for (int i = 0; i < Board.BOARD_SIDE; i++) {
      boardState[6][i] = new Figure(FigureName.PAWN, Color.BLACK);
    }

    for (int i = 2; i < 6; i++) {
      for (int j = 0; j < Board.BOARD_SIDE; j++) {
        boardState[i][j] = new Figure();
      }
    }
  }
}

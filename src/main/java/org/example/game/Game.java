package org.example.game;

import java.util.regex.Pattern;

public class Game {
  private final Player[] players;
  private final Board board;

  public Game() {
    board = new Board();
    players = new Player[2];
    initPlayers();
  }

  public String displayGame() {
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < Board.BOARD_SIDE; i++) {
      for (int j = 0; j < Board.BOARD_SIDE; j++) {
        Figure figure = board.boardState[i][j];
        String figureRepresentation = " ";

        if (figure.getName() != FigureName.EMPTY) {
          String colorCode = (figure.getColor() == Color.BLACK) ? "\u001B[31m" : "";
          figureRepresentation = colorCode + getFigureSymbol(figure) + "\u001B[0m";
        } else {
          String cellColor = (i + j) % 2 == 1 ? "\u001B[31m" : "\u001B[0m";
          figureRepresentation = cellColor + "#" + "\u001B[0m";
        }

        sb.append(figureRepresentation);

        if (j != Board.BOARD_SIZE - 1) {
          sb.append(" ");
        }
      }
      if (i != Board.BOARD_SIZE - 1) {
        sb.append("\n");
      }
    }
    return sb.toString();
  }

  private char getFigureSymbol(Figure figure) {
    switch (figure.getName()) {
      case PAWN:
        return 'P';
      case ROOK:
        return 'R';
      case KNIGHT:
        return 'N';
      case BISHOP:
        return 'B';
      case QUEEN:
        return 'Q';
      case KING:
        return 'K';
      default:
        return ' ';
    }
  }

  public boolean checkIsOver() {
    Player activePlayer = getActivePlayer();
    Player opponentPlayer = (activePlayer == players[0]) ? players[1] : players[0];

    for (int startX = 0; startX < Board.BOARD_SIDE; startX++) {
      for (int startY = 0; startY < Board.BOARD_SIDE; startY++) {
        Figure startFigure = board.boardState[startY][startX];
        if (startFigure.getColor() == activePlayer.getColor()) {
          for (int finishX = 0; finishX < Board.BOARD_SIDE; finishX++) {
            for (int finishY = 0; finishY < Board.BOARD_SIDE; finishY++) {
              if (checkMovement(startX, startY, finishX, finishY)) {
                Board tempBoard = new Board();
                tempBoard.boardState = cloneBoard(board.boardState);

                tempBoard.boardState[finishY][finishX] = tempBoard.boardState[startY][startX];
                tempBoard.boardState[startY][startX] = new Figure();

                if (!isKingUnderAttack(tempBoard, opponentPlayer.getColor())) {
                  return false;
                }
              }
            }
          }
        }
      }
    }

    return true;
  }

  private boolean isKingUnderAttack(Board tempBoard, Color kingColor) {
    int kingX = -1;
    int kingY = -1;

    for (int i = 0; i < Board.BOARD_SIDE; i++) {
      for (int j = 0; j < Board.BOARD_SIDE; j++) {
        Figure figure = tempBoard.boardState[i][j];
        if (figure.getName() == FigureName.KING && figure.getColor() == kingColor) {
          kingX = j;
          kingY = i;
          break;
        }
      }
      if (kingX != -1) {
        break;
      }
    }

    if (kingX == -1) {
      return false;
    }

    for (int i = 0; i < Board.BOARD_SIDE; i++) {
      for (int j = 0; j < Board.BOARD_SIDE; j++) {
        Figure figure = tempBoard.boardState[i][j];
        if (figure.getColor() != kingColor) {
          if (checkMovement(j, i, kingX, kingY)) {
            return true;
          }
        }
      }
    }

    return false;
  }

  private Figure[][] cloneBoard(Figure[][] original) {
    Figure[][] clone = new Figure[Board.BOARD_SIDE][Board.BOARD_SIDE];
    for (int i = 0; i < Board.BOARD_SIDE; i++) {
      for (int j = 0; j < Board.BOARD_SIDE; j++) {
        clone[i][j] = new Figure(original[i][j].getName(), original[i][j].getColor());
      }
    }
    return clone;
  }

  public void move(int startX, int startY, int finishX, int finishY) {
    Figure currentFigure = board.boardState[startX][startY];
    board.boardState[startX][startY] = new Figure();
    board.boardState[finishX][finishY] = currentFigure;
  }

  public Player getActivePlayer() {
    return players[0].getActive() ? players[0] : players[1];
  }

  public void nextMove() {
    for (Player player : players) {
      player.changeActive();
    }
  }

  public boolean validateMove(String move) {
    if (!checkPattern(move)) return false;

    String[] moveArray = move.split("-");

    int startX = moveArray[0].charAt(0) - 'a';
    int startY = 8 - (moveArray[0].charAt(1) - '1');
    int finishX = moveArray[1].charAt(0) - 'a';
    int finishY = 8 - (moveArray[1].charAt(1) - '1');

    if (!checkColor(board.boardState[startX][startY], board.boardState[finishX][finishY])) return false;
    if (!checkMovement(startX, startY, finishX, finishY)) return false;

    move(startX, startY, finishX, finishY);
    return true;
  }

  public boolean checkPattern(String move) {
    return Pattern.matches("^[a-h][1-8]\\-[a-h][1-8]$", move);
  }

  public boolean checkColor(Figure startFigure, Figure finishFigure) {
    if (startFigure.getName() == FigureName.EMPTY) return false;
    if (getActivePlayer().getColor() != startFigure.getColor()) return false;
    return getActivePlayer().getColor() != finishFigure.getColor();
  }

  public boolean checkMovement(int startX, int startY, int finishX, int finishY) {
    Figure startFigure = board.boardState[startY][startX];
    Figure finishFigure = board.boardState[finishY][finishX];

    int dx = Math.abs(finishX - startX);
    int dy = Math.abs(finishY - startY);

    if (startFigure.getName() == FigureName.PAWN) {
      if (startY == 1 && finishY == 3 && board.boardState[2][startX].getName() == FigureName.EMPTY) {
        return dx == 0 && dy == 2;
      }
      return dx == 1 && dy == 1 && finishFigure.getColor() != startFigure.getColor();
    } else if (startFigure.getName() == FigureName.ROOK) {
      return (startX == finishX || startY == finishY) && checkPathClear(startX, startY, finishX, finishY);
    } else if (startFigure.getName() == FigureName.KNIGHT) {
      return (dx == 2 && dy == 1) || (dx == 1 && dy == 2);
    } else if (startFigure.getName() == FigureName.BISHOP) {
      return dx == dy && checkPathClear(startX, startY, finishX, finishY);
    } else if (startFigure.getName() == FigureName.QUEEN) {
      return ((startX == finishX || startY == finishY) || dx == dy) && checkPathClear(startX, startY, finishX, finishY);
    } else if (startFigure.getName() == FigureName.KING) {
      return dx <= 1 && dy <= 1;
    }

    return false;
  }

  private boolean checkPathClear(int startX, int startY, int finishX, int finishY) {
    int stepX = Integer.compare(finishX, startX);
    int stepY = Integer.compare(finishY, startY);

    int x = startX + stepX;
    int y = startY + stepY;
    while (x != finishX || y != finishY) {
      if (board.boardState[y][x].getName() != FigureName.EMPTY) {
        return false;
      }
      x += stepX;
      y += stepY;
    }
    return true;
  }

  public Board getBoard() {
    return board;
  }

  private void initPlayers() {
    players[0] = new Player("Player 1", Color.WHITE);
    players[0].setActive();
    players[1] = new Player("Player 2", Color.BLACK);
  }
}

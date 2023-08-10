package org.example.game;

public class Player {
  private final String name;
  private Color color;

  public Player(String name, Color color) {
    this.name = name;
    this.color = color;
  }

  public String getName() {
    return name;
  }

  public Color getColor() {
    return color;
  }
}

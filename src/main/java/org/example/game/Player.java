package org.example.game;

public class Player {
  private final String name;
  private final Color color;
  private boolean isActive;

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

  public void setActive () {
    this.isActive = true;
  }

  public boolean getActive() {
    return isActive;
  }

  public void changeActive () {
    this.isActive = !this.isActive;
  }
}

package org.example.game;

public class Figure {
  private FigureName name;
  private Color color;

  public Figure() {
    this.name = FigureName.EMPTY;
    this.color = Color.NONE;
  }

  public Figure(FigureName name, Color color) {
    this.name = name;
    this.color = color;
  }

  public FigureName getName() {
    return name;
  }

  public Color getColor() {
    return color;
  }
}

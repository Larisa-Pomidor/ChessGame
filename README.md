# ChessGame
Chess Game is a basic console Java chess game.

## Functional Requirements:

**Game Setup:** 
- The game should start with the initial setup of the chessboard, including the placement of all pieces in their standard positions.

**Player Interaction:**

- Players should take turns making legal moves based on the rules of chess.
- The game should alternate between the two players, allowing each player to move their pieces.
- Players should input their moves using algebraic notation (e.g., "e2-e4") or a graphical interface.

**Piece Movement:**

- Each type of piece (pawn, rook, knight, bishop, queen, king) should have its specific movement rules.
- Pieces should only be able to move to legal and unoccupied positions on the board.
- Special moves like castling and en passant should be implemented where appropriate.
  
**Capture and Elimination:**

- Pieces should be able to capture opponent pieces by moving to their positions.
- Captured pieces should be removed from the board.
- Capturing should be based on the specific capture rules of each piece.

**Winning and Losing:**

- The game should detect when a checkmate occurs, indicating a win for one player.
- If a player's king is in a position that cannot be moved to any safe square, the game should declare a checkmate.
  
## Non-Functional Requirements:

**User Interface:**

- The graphical user interface should be user-friendly and intuitive.
- It should provide clear visual representations of the chessboard and pieces.
- The game should include comments and rules explanation.

**Performance:**

- The game should respond promptly to player actions.

# Objects, classes, and relationships:

**Objects:**

- Game: Represents the chess game itself. Contains players, a board, and manages the game flow.
- Player: Represents a player participating in the game. Contains the player's name, color (white or black), and manages their turns.
- Board: Represents the chessboard, which is an 8x8 grid of squares. Contains the state of the pieces on the board.
- Square: Represents a single square on the chessboard. May contain a piece or be empty.
- Piece: Represents a chess piece (pawn, rook, knight, bishop, queen, king). Contains information about its type, color, and movement rules.
- Move: Represents a move made by a player, indicating the starting and ending positions of a piece.

**Classes:**

- Game: Manages the overall game state, including player turns, board state, and game over conditions.
- Player: Defines player attributes such as name, color, and manages their turn status.
- Board: Represents the chessboard and contains the 2D array of squares.
- Figure: Defines the attributes and behavior of different chess pieces.
- FigureName: Enum class defining the different types of chess pieces.
- Color: Enum class defining the colors of chess pieces.

**Relationships:**

- Game - Player Relationship: The Game class contains instances of two Player objects representing the two participants in the game.
- Game - Board Relationship: The Game class contains an instance of the Board class to manage the state of the chessboard.
- Piece - FigureName Relationship: Each Piece object has a FigureName attribute that indicates the type of chess piece it represents (KING, QUEEN, ROOK, etc.).
- Piece - Color Relationship: Each Piece object has a Color attribute that determines whether it's white or black.
- Board - Piece Relationship: The Board class maintains a 2D array of Figure objects.


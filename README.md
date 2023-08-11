# ChessGame
Chess Game is a basic console Java chess game.

### Functional Requirements:

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
  
### Non-Functional Requirements:

**User Interface:**

- The graphical user interface should be user-friendly and intuitive.
- It should provide clear visual representations of the chessboard and pieces.
- The game should include comments and rules explanation.

**Performance:**

- The game should respond promptly to player actions.

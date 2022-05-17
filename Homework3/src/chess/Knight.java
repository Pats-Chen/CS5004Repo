package chess;

/**
 * Author: Jiazhe Chen, NUID: 002162461
 * A concrete class for Knight in Chess. Should inherit from Chess class.
 */
public class Knight extends Chess {

  /**
   * Instantiate a Knight instance for inherited from Chess class.
   *
   * @param row   an integer that shows the starting row of this Knight.
   * @param col   an integer that shows the starting column of this Knight.
   * @param color a Color type that shows the color of this Knight.
   */
  public Knight(int row, int col, Color color) {
    super(row, col, color);
  }

  /**
   * Return a boolean that shows if (row, col) is within the reach of this Knight.
   *
   * @param row an integer that shows the row number of the position.
   * @param col an integer that shows the column number of the position.
   * @return true if (row, col) is within the reach of this Knight. False otherwise.
   */
  public boolean isKnightReach(int row, int col) {
    if ((Math.abs(this.row - row) == 2 && Math.abs(this.column - col) == 1)
            ^ (Math.abs(this.row - row) == 1 && Math.abs(this.column - col) == 2)) {
      return true;
    } else {
      return false;
    }
  }

  /**
   * Return a boolean that shows if this Knight can move to (row, col).
   * A Knight moves in the following way: two cells horizontally and one vertically or vice versa.
   *
   * @param row an integer that shows the row number of the position.
   * @param col an integer that shows the column number of the position.
   * @return true if this Knight can move to (row, col). False otherwise.
   */
  @Override
  public boolean canMove(int row, int col) {
    if (Chess.onBoard(row, col)) {
      if (!this.isSameLocation(row, col)) {
        if (this.isKnightReach(row, col)) {
          return true;
        } else {
          return false;
        }
      } else {
        return false;
      }
    } else {
      return false;
    }
  }

  /**
   * Return a boolean that shows if this Knight can kill the other ChessPiece piece.
   *
   * @param piece a ChessPiece type of the abstract class Chess.
   * @return true if this Knight can kill piece. False otherwise.
   */
  @Override
  public boolean canKill(ChessPiece piece) {
    if (this.color == piece.getColor()) {
      return false;
    } else {
      if (this.isKnightReach(piece.getRow(), piece.getColumn())) {
        return true;
      } else {
        return false;
      }
    }
  }
}
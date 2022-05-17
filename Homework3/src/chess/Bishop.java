package chess;

/**
 * Author: Jiazhe Chen, NUID: 002162461
 * A concrete class for Bishop in Chess. Should inherit from Chess class.
 */
public class Bishop extends Chess {

  /**
   * Instantiate a Bishop instance for inherited from Chess class.
   *
   * @param row   an integer that shows the starting row of this Bishop.
   * @param col   an integer that shows the starting column of this Bishop.
   * @param color a Color type that shows the color of this Bishop.
   */
  public Bishop(int row, int col, Color color) {
    super(row, col, color);
  }

  /**
   * Return a boolean that shows if this Bishop can move to (row, col).
   * A Bishop moves diagonally.
   *
   * @param row an integer that shows the row number of the position.
   * @param col an integer that shows the column number of the position.
   * @return true if this Bishop can move to (row, col). False otherwise.
   */
  @Override
  public boolean canMove(int row, int col) {
    if (Chess.onBoard(row, col)) {
      if (!this.isSameLocation(row, col)) {
        if (Math.abs(this.row - row) == Math.abs(this.column - col)) {
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
   * Return a boolean that shows if this Bishop can kill the other ChessPiece piece.
   *
   * @param piece a ChessPiece type of the abstract class Chess.
   * @return true if this Bishop can kill piece. False otherwise.
   */
  @Override
  public boolean canKill(ChessPiece piece) {
    if (this.color == piece.getColor()) {
      return false;
    } else {
      if (Math.abs(this.row - piece.getRow()) == Math.abs(this.column - piece.getColumn())) {
        return true;
      } else {
        return false;
      }
    }
  }
}

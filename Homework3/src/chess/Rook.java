package chess;

/**
 * Author: Jiazhe Chen, NUID: 002162461
 * A concrete class for Rook in Chess. Should inherit from Chess class.
 */
public class Rook extends Chess {

  /**
   * Instantiate a Rook instance for inherited from Chess class.
   *
   * @param row   an integer that shows the starting row of this Rook.
   * @param col   an integer that shows the starting column of this Rook.
   * @param color a Color type that shows the color of this Rook.
   */
  public Rook(int row, int col, Color color) {
    super(row, col, color);
  }

  /**
   * Return a boolean that shows if this Rook can move to (row, col).
   * A Rook moves horizontally or vertically.
   *
   * @param row an integer that shows the row number of the position.
   * @param col an integer that shows the column number of the position.
   * @return true if this Rook can move to (row, col). False otherwise.
   */
  @Override
  public boolean canMove(int row, int col) {
    if (Chess.onBoard(row, col)) {
      if (!this.isSameLocation(row, col)) {
        if (this.row == row ^ this.column == col) {
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
   * Return a boolean that shows if this Rook can kill the other ChessPiece piece.
   *
   * @param piece a ChessPiece type of the abstract class Chess.
   * @return true if this Rook can kill piece. False otherwise.
   */
  @Override
  public boolean canKill(ChessPiece piece) {
    if (this.color == piece.getColor()) {
      return false;
    } else {
      if (this.row == piece.getRow() ^ this.column == piece.getColumn()) {
        return true;
      } else {
        return false;
      }
    }
  }
}

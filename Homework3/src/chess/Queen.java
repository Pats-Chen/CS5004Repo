package chess;

/**
 * Author: Jiazhe Chen, NUID: 002162461
 * A concrete class for Queen in Chess. Should inherit from Chess class.
 */
public class Queen extends Chess {

  /**
   * Instantiate a Queen instance for inherited from Chess class.
   *
   * @param row   an integer that shows the starting row of this Queen.
   * @param col   an integer that shows the starting column of this Queen.
   * @param color a Color type that shows the color of this Queen.
   */
  public Queen(int row, int col, Color color) {
    super(row, col, color);
  }

  /**
   * Return a boolean that shows if (row, col) is within the reach of this Queen.
   *
   * @param row an integer that shows the row number of the position.
   * @param col an integer that shows the column number of the position.
   * @return true if (row, col) is within the reach of this Queen. False otherwise.
   */
  public boolean isQueenReach(int row, int col) {
    if (this.row == row) {
      return true;
    } else if (this.column == col) {
      return true;
    } else if (Math.abs(this.row - row) == Math.abs(this.column - col)) {
      return true;
    } else {
      return false;
    }
  }

  /**
   * Return a boolean that shows if this Queen can move to (row, col).
   * A Queen moves horizontally or vertically or diagonally.
   *
   * @param row an integer that shows the row number of the position.
   * @param col an integer that shows the column number of the position.
   * @return true if this Queen can move to (row, col). False otherwise.
   */
  @Override
  public boolean canMove(int row, int col) {
    if (Chess.onBoard(row, col)) {
      if (!this.isSameLocation(row, col)) {
        if (this.isQueenReach(row, col)) {
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
   * Return a boolean that shows if this Queen can kill the other ChessPiece piece.
   *
   * @param piece a ChessPiece type of the abstract class Chess.
   * @return true if this Queen can kill piece. False otherwise.
   */
  @Override
  public boolean canKill(ChessPiece piece) {
    if (this.color == piece.getColor()) {
      return false;
    } else {
      if (this.isQueenReach(piece.getRow(), piece.getColumn())) {
        return true;
      } else {
        return false;
      }
    }
  }
}

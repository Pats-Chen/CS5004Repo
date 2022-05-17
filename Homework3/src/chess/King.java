package chess;

import java.util.Random;

/**
 * Author: Jiazhe Chen, NUID: 002162461
 * A concrete class for King in Chess. Should inherit from Chess class.
 */
public class King extends Chess {

  /**
   * Instantiate a King instance for inherited from Chess class.
   *
   * @param row   an integer that shows the starting row of this King.
   * @param col   an integer that shows the starting column of this King.
   * @param color a Color type that shows the color of this King.
   */
  public King(int row, int col, Color color) {
    super(row, col, color);
  }

  /**
   * Return a boolean that shows if (row, col) is within the reach of this King.
   *
   * @param row an integer that shows the row number of the position.
   * @param col an integer that shows the column number of the position.
   * @return true if (row, col) is within the reach of this King. False otherwise.
   */
  public boolean isKingReach(int row, int col) {
    if (Math.abs(this.row - row) == 1 && this.column == col) {
      return true;
    } else if (this.row == row && Math.abs(this.column - col) == 1) {
      return true;
    } else if (Math.abs(this.row - row) == 1 && Math.abs(this.column - col) == 1) {
      return true;
    } else {
      return false;
    }
  }

  /**
   * Return a boolean that shows if this King can move to (row, col).
   * A King moves in the following way: one cell horizontally or one cell vertically.
   *
   * @param row an integer that shows the row number of the position.
   * @param col an integer that shows the column number of the position.
   * @return true if this King can move to (row, col). False otherwise.
   */
  @Override
  public boolean canMove(int row, int col) {
    if (Chess.onBoard(row, col)) {
      if (!this.isSameLocation(row, col)) {
        if (isKingReach(row, col)) {
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
   * Return a boolean that shows if this King can kill the other ChessPiece piece.
   *
   * @param piece a ChessPiece type of the abstract class Chess.
   * @return true if this King can kill piece. False otherwise.
   */
  @Override
  public boolean canKill(ChessPiece piece) {
    if (this.color == piece.getColor()) {
      return false;
    } else {
      if (isKingReach(piece.getRow(), piece.getColumn())) {
        return true;
      } else {
        return false;
      }
    }
  }
}

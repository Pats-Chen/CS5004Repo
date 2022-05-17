package chess;

import java.util.Random;

/**
 * Author: Jiazhe Chen, NUID: 002162461
 * A concrete class for Pawn in Chess. Should inherit from Chess class.
 */
public class Pawn extends Chess {
  private int startRow;
  private int startColumn;


  /**
   * Instantiate a Pawn instance for inherited from Chess class.
   *
   * @param row   an integer that shows the starting row of this Pawn.
   * @param col   an integer that shows the starting column of this Pawn.
   * @param color a Color type that shows the color of this Pawn.
   * @throws IllegalArgumentException an exception when this Pawn is created in its royal row.
   *     A royal row is row 0 to WHITE Pawns, and row 7 to BLACK Pawns.
   */
  public Pawn(int row, int col, Color color) throws IllegalArgumentException {
    super(row, col, color);
    this.startRow = row;
    this.startColumn = col;
    if (color == Color.WHITE) {
      if (row == 0) {
        throw new IllegalArgumentException("Pawns cannot be created in the royal row.");
      }
    } else {
      if (row == 7) {
        throw new IllegalArgumentException("Pawns cannot be created in the royal row.");
      }
    }
  }

  /**
   * Return a boolean that shows if this Pawn is at its starting position.
   * @return true if this King can move to (row, col). False otherwise.
   */
  public boolean isStartLocation() {
    return (this.getRow() == this.startRow && this.getColumn() == this.startColumn);
  }

  /**
   * Return a boolean that shows if this Pawn can move to (row, col).
   * A Pawn moves in the following way: one cell upward for WHITE Pawns or downward for BLACK Pawns.
   * If this is the first time for this Pawn to move, and it is on row 1 for WHITE Pawns or
   * row 6 for BLACK Pawns, then it can move one cell or two cells upward for WHITE Pawns or
   * downward for BLACK Pawns.
   *
   * @param row an integer that shows the row number of the position.
   * @param col an integer that shows the column number of the position.
   * @return true if this Pawn can move to (row, col). False otherwise.
   */
  @Override
  public boolean canMove(int row, int col) {
    if (Chess.onBoard(row, col)) {
      if (!this.isSameLocation(row, col)) {
        if (this.color == Color.WHITE) {
          if (this.getRow() == 1 && this.isStartLocation()) {
            if ((row - this.row == 2 && this.column == col)
                    ^ (row - this.row == 1 && this.column == col)) {
              return true;
            } else {
              return false;
            }
          } else {
            if (row - this.row == 1 && this.column == col) {
              return true;
            } else {
              return false;
            }
          }
        } else {
          if (this.getRow() == 6 && this.isStartLocation()) {
            if ((this.row - row == 2 && this.column == col)
                    ^ (this.row - row == 1 && this.column == col)) {
              return true;
            } else {
              return false;
            }
          } else {
            if (this.row - row == 1 && this.column == col) {
              return true;
            } else {
              return false;
            }
          }
        }
      } else {
        return false;
      }
    } else {
      return false;
    }
  }

  /**
   * Return a boolean that shows if this Pawn can kill the other ChessPiece piece.
   * A pawn can kill the other piece that is located one cell diagonally upward for WHITE Pawns or
   * downward for BLACK Pawns.
   *
   * @param piece a ChessPiece type of the abstract class Chess.
   * @return true if this Pawn can kill piece. False otherwise.
   */
  @Override
  public boolean canKill(ChessPiece piece) {
    if (this.color == piece.getColor()) {
      return false;
    } else {
      if (this.color == Color.WHITE) {
        if (Math.abs(this.column - piece.getColumn()) == 1 && piece.getRow() - this.row == 1) {
          return true;
        } else {
          return false;
        }
      } else {
        if (Math.abs(this.column - piece.getColumn()) == 1 && this.row - piece.getRow() == 1) {
          return true;
        } else {
          return false;
        }
      }
    }
  }
}

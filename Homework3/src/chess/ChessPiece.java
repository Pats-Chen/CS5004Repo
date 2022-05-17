package chess;

/**
 * Author: Jiazhe Chen, NUID: 002162461
 * An interface that represents a ChessPiece.
 * It is the super-type for any other types of Chess pieces on the game board.
 */
public interface ChessPiece {

  /**
   * Return an int showing the current row of this Chess piece on the game board.
   *
   * @return an int that is between 0 and 7.
   */
  int getRow();

  /**
   * Return an int showing the current column of this Chess piece on the game board.
   *
   * @return an int that is between 0 and 7.
   */
  int getColumn();

  /**
   * Return an enumerated type named Color, showing the color of this Chess piece.
   *
   * @return an Color that is either Color.WHITE or Color.BLACK.
   */
  Color getColor();

  /**
   * Return a boolean showing if this Chess piece can move to position (row, col).
   *
   * @return true if it can move to (row, col), false otherwise.
   */
  boolean canMove(int row, int col);

  /**
   * Return a boolean showing if this Chess piece can kill the other ChessPiece piece.
   *
   * @return true if it can kill piece, false otherwise.
   */
  boolean canKill(ChessPiece piece);
}

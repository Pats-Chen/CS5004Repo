package chess;

/**
 * Author: Jiazhe Chen, NUID: 002162461
 * An abstract class for chess pieces. Should implement all methods for ChessPiece interface.
 */
public abstract class Chess implements ChessPiece {
  protected int row;
  protected int column;
  protected Color color;

  /**
   * Instantiate a Chess instance for child class instances to inherit from.
   *
   * @param row   an integer that shows the starting row of this Chess piece.
   * @param col   an integer that shows the starting column of this Chess piece.
   * @param color a Color type that shows the color of this Chess piece.
   * @throws IllegalArgumentException an exception when position (row, col) is
   *                                  not on the game board.
   */
  public Chess(int row, int col, Color color) throws IllegalArgumentException {
    if (!Chess.onBoard(row, col)) {
      throw new IllegalArgumentException("The chess pieces cannot be created "
              + "outside of the chess board.");
    } else {
      this.row = row;
      this.column = col;
      this.color = color;
    }
  }

  /**
   * Return the number of current row of this Chess piece.
   *
   * @return an integer that shows the current row.
   */
  public int getRow() {
    return this.row;
  }

  /**
   * Return the number of current column of this Chess piece.
   *
   * @return an integer that shows the current column.
   */
  public int getColumn() {
    return this.column;
  }

  /**
   * Return the Color of this Chess piece.
   *
   * @return a Color type that shows the color of this Chess piece.
   */
  public Color getColor() {
    return this.color;
  }

  /**
   * Return a boolean that shows if (row, col) is on the game board.
   *
   * @param row an integer that shows the row number of the position.
   * @param col an integet that shows the column number of the position.
   * @return true if row is between 0 and 7, and col is also between 0 and 7. False otherwise.
   */
  public static boolean onBoard(int row, int col) {
    if (row >= 0 && row <= 7 && col >= 0 && col <= 7) {
      return true;
    } else {
      return false;
    }
  }

  /**
   * Return a boolean that shows if (row, col) is the same location as this Chess piece.
   *
   * @param row an integer that shows the row number of the position.
   * @param col an integer that shows the column number of the position.
   * @return true if row is the same as the row number of this Chess piece,
   *     and col is the same as the column number of this Chess piece. False otherwise.
   */
  public boolean isSameLocation(int row, int col) {
    if (this.row == row && this.column == col) {
      return true;
    } else {
      return false;
    }
  }

  /**
   * Return a boolean that shows if this Chess piece can move to (row, col).
   * An empty method for all concrete classes to override for behavior variations.
   *
   * @param row an integer that shows the row number of the position.
   * @param col an integer that shows the column number of the position.
   * @return true this Chess piece can move to (row, col). False otherwise.
   */
  public boolean canMove(int row, int col) {
    return false;
  }

  /**
   * Return a boolean that shows if this Chess piece can kill the other ChessPiece piece.
   * An empty method for all concrete classes to override for behavior variations.
   *
   * @param piece a ChessPiece type of the abstract class Chess.
   * @return true this Chess piece can kill piece. False otherwise.
   */
  public boolean canKill(ChessPiece piece) {
    return false;
  }
}

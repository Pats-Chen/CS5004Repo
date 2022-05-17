package chess;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

/**
 * Author: Jiazhe Chen, NUID: 002162461
 * A test class for all kinds of Chess class.
 */
public class ChessTest {
  private Bishop bishop1;
  private Bishop bishop2;
  private Rook rook1;
  private Rook rook2;
  private Queen queen1;
  private Queen queen2;
  private Knight knight1;
  private Knight knight2;
  private King king1;
  private King king2;
  private Pawn pawn1;
  private Pawn pawn2;

  /**
   * Setup some concrete Chess instances for tests.
   */
  @Before
  public void setUp() {
    bishop1 = new Bishop(0, 2, Color.WHITE);
    bishop2 = new Bishop(7, 5, Color.BLACK);
    rook1 = new Rook(0, 0, Color.WHITE);
    rook2 = new Rook(7, 7, Color.BLACK);
    queen1 = new Queen(0, 4, Color.WHITE);
    queen2 = new Queen(7, 4, Color.BLACK);
    knight1 = new Knight(0, 1, Color.WHITE);
    knight2 = new Knight(7, 6, Color.BLACK);
    king1 = new King(0, 3, Color.WHITE);
    king2 = new King(7, 3, Color.BLACK);
    pawn1 = new Pawn(1, 1, Color.WHITE);
    pawn2 = new Pawn(6, 5, Color.BLACK);
  }

  /**
   * Test to see if Chess.onBoard method works properly.
   */
  @Test
  public void onBoard() {
    assertEquals(true, Chess.onBoard(4, 3));
    assertEquals(false, Chess.onBoard(0, 8));
    assertEquals(false, Chess.onBoard(8, 0));
    assertEquals(false, Chess.onBoard(0, -1));
    assertEquals(false, Chess.onBoard(-1, 0));
  }

  /**
   * Test to see if canKill method works properly for all concrete classes.
   */
  @Test
  public void canKill() {
    assertEquals(true, bishop1.canKill(new Bishop(2, 0, Color.BLACK)));
    assertEquals(true, bishop1.canKill(new Pawn(4, 6, Color.BLACK)));
    assertEquals(true, bishop1.canKill(new Rook(1, 1, Color.BLACK)));
    assertEquals(true, bishop1.canKill(new Queen(3, 5, Color.BLACK)));
    assertEquals(true, bishop1.canKill(new Knight(5, 7, Color.BLACK)));
    assertEquals(true, bishop1.canKill(new King(2, 4, Color.BLACK)));
    assertEquals(false, bishop1.canKill(new King(2, 4, Color.WHITE)));
    assertEquals(false, bishop2.canKill(new King(6, 4, Color.BLACK)));
    assertEquals(false, bishop1.canKill(new Bishop(0, 3, Color.BLACK)));
    assertEquals(false, bishop1.canKill(new Bishop(1, 2, Color.BLACK)));
    assertEquals(true, rook1.canKill(new Bishop(1, 0, Color.BLACK)));
    assertEquals(true, rook1.canKill(new Pawn(0, 5, Color.BLACK)));
    assertEquals(true, rook2.canKill(new Queen(5, 7, Color.WHITE)));
    assertEquals(true, rook2.canKill(new King(7, 2, Color.WHITE)));
    assertEquals(true, rook2.canKill(new Rook(1, 7, Color.WHITE)));
    assertEquals(false, rook2.canKill(new King(7, 6, Color.BLACK)));
    assertEquals(false, rook1.canKill(new Rook(2, 2, Color.BLACK)));
    assertEquals(false, rook1.canKill(new Rook(4, 3, Color.BLACK)));
    assertEquals(false, rook2.canKill(new Rook(2, 5, Color.WHITE)));
    assertEquals(false, rook2.canKill(new Rook(4, 4, Color.WHITE)));
    assertEquals(true, queen1.canKill(new Queen(1, 5, Color.BLACK)));
    assertEquals(true, queen1.canKill(new Bishop(0, 6, Color.BLACK)));
    assertEquals(true, queen1.canKill(new Pawn(5, 4, Color.BLACK)));
    assertEquals(true, queen1.canKill(new Rook(3, 1, Color.BLACK)));
    assertEquals(true, queen1.canKill(new Knight(0, 0, Color.BLACK)));
    assertEquals(true, queen1.canKill(new King(3, 7, Color.BLACK)));
    assertEquals(false, queen1.canKill(new King(2, 6, Color.WHITE)));
    assertEquals(false, queen1.canKill(new Queen(2, 1, Color.BLACK)));
    assertEquals(false, queen1.canKill(new Queen(5, 6, Color.BLACK)));
    assertEquals(false, queen2.canKill(new Queen(6, 0, Color.WHITE)));
    assertEquals(false, queen2.canKill(new Queen(2, 5, Color.WHITE)));
    assertEquals(true, king1.canKill(new King(1, 3, Color.BLACK)));
    assertEquals(true, king1.canKill(new Bishop(0, 2, Color.BLACK)));
    assertEquals(true, king1.canKill(new Pawn(0, 4, Color.BLACK)));
    assertEquals(true, king1.canKill(new Rook(1, 2, Color.BLACK)));
    assertEquals(true, king1.canKill(new Knight(1, 4, Color.BLACK)));
    assertEquals(true, king2.canKill(new King(6, 2, Color.WHITE)));
    assertEquals(true, king2.canKill(new King(6, 3, Color.WHITE)));
    assertEquals(true, king2.canKill(new King(6, 4, Color.WHITE)));
    assertEquals(false, king2.canKill(new King(6, 3, Color.BLACK)));
    assertEquals(false, king1.canKill(new King(0, 0, Color.BLACK)));
    assertEquals(false, king1.canKill(new King(7, 3, Color.BLACK)));
    assertEquals(false, king1.canKill(new King(2, 1, Color.BLACK)));
    assertEquals(false, king1.canKill(new King(5, 2, Color.BLACK)));
    assertEquals(true, pawn1.canKill(new Pawn(2, 0, Color.BLACK)));
    assertEquals(true, pawn1.canKill(new Bishop(2, 2, Color.BLACK)));
    assertEquals(true, pawn1.canKill(new Rook(2, 0, Color.BLACK)));
    assertEquals(true, pawn2.canKill(new Knight(5, 4, Color.WHITE)));
    assertEquals(true, pawn2.canKill(new King(5, 6, Color.WHITE)));
    assertEquals(true, pawn2.canKill(new Queen(5, 4, Color.WHITE)));
    assertEquals(false, pawn2.canKill(new King(4, 5, Color.BLACK)));
    assertEquals(false, pawn1.canKill(new Pawn(2, 1, Color.BLACK)));
    assertEquals(false, pawn1.canKill(new Pawn(3, 1, Color.BLACK)));
    assertEquals(false, pawn2.canKill(new King(5, 5, Color.BLACK)));
    assertEquals(false, pawn1.canKill(new Pawn(4, 5, Color.BLACK)));
    assertEquals(true, knight1.canKill(new Knight(2, 0, Color.BLACK)));
    assertEquals(true, knight1.canKill(new Bishop(2, 2, Color.BLACK)));
    assertEquals(true, knight1.canKill(new Pawn(1, 3, Color.BLACK)));
    assertEquals(true, knight2.canKill(new Rook(5, 5, Color.WHITE)));
    assertEquals(true, knight2.canKill(new King(5, 7, Color.WHITE)));
    assertEquals(true, knight2.canKill(new Queen(6, 4, Color.WHITE)));
    assertEquals(true, knight1.canKill(new King(2, 0, Color.BLACK)));
    assertEquals(false, knight1.canKill(new Knight(0, 0, Color.BLACK)));
    assertEquals(false, knight1.canKill(new Knight(1, 0, Color.BLACK)));
    assertEquals(false, knight1.canKill(new Knight(2, 1, Color.BLACK)));
    assertEquals(false, knight1.canKill(new Knight(1, 2, Color.BLACK)));
    assertEquals(false, knight1.canKill(new Knight(0, 2, Color.BLACK)));
    assertEquals(false, knight1.canKill(new Knight(0, 3, Color.BLACK)));
  }
}
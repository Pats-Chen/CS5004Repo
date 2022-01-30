package test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import stock.Stock;

/**
 * Author: Jiazhe Chen, NUID: 002162461
 * A test class for Stock objects.
 */
public class StockTest {
  private Stock apple;
  private static final double DELTA = 0.001;

  /**
   * Setup test a instance for Stock class.
   */
  @Before
  public void setUp() {
    apple = new Stock("AAPL", "Apple Computer", 161.62);
  }

  /**
   * Test to see if cost basis can be set properly.
   */
  @Test
  public void testSetCostBasis() {
    apple.setCostBasis(0.0);
    assertEquals(0.0, apple.getCostBasis(), DELTA);
  }

  /**
   * Test to see if current price can be set properly.
   */
  @Test
  public void testSetCurrentPrice() {
    apple.setCurrentPrice(202.12);
    assertEquals(202.12, apple.getCurrentPrice(), DELTA);
  }

  /**
   * Test to see if percentage change can be calculated properly.
   */
  @Test
  public void testGetChangePercent() {
    apple.setCurrentPrice(202.12);
    assertEquals((202.12 - 161.62) / 161.62, apple.getChangePercent(), DELTA);
  }

  /**
   * Test to see if string information can be shown properly.
   */
  @Test
  public void testToString() {
    apple.setCurrentPrice(202.12);
    assertEquals("Apple Computer Current Price: $ 202.12\n Gain/Loss: 25.06%", apple.toString());
  }
}
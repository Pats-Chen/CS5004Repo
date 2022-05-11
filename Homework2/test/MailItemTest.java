package hw2;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

/**
 * Author: Jiazhe Chen, NUID: 002162461.
 * A test class for the MailItem class.
 */
public class MailItemTest {
  private MailItem mailItem1;
  private Recipient recipient1;

  /**
   * Instantiate a new Recipient and a new MailItem for tests.
   */
  @Before
  public void setUp() {
    recipient1 = new Recipient("Jiazhe", "Chen", "jiazhechen@aol.com");
    mailItem1 = new MailItem(5, 5, 10, recipient1);
  }

  /**
   * Test to see if MailItem constructor handles exception type 1 properly.
   * Exception type 1: The width of the mail item is less than 1.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testMailItemException1() {
    MailItem mailItem2 = new MailItem(-1, 5, 10, recipient1);
  }

  /**
   * Test to see if MailItem constructor handles exception type 2 properly.
   * Exception type 2: The height of the mail item is less than 1.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testMailItemException2() {
    MailItem mailItem2 = new MailItem(5, 0, 10, recipient1);
  }

  /**
   * Test to see if MailItem constructor handles exception type 3 properly.
   * Exception type 3: The depth of the mail item is less than 1.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testMailItemException3() {
    MailItem mailItem2 = new MailItem(5, 5, -500, recipient1);
  }

  /**
   * Test to see if MailItem constructor handles exception type 4 properly.
   * Exception type 4: The recipient of the mail item is null.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testMailItemException4() {
    MailItem mailItem2 = new MailItem(5, 5, 10, null);
  }

  /**
   * Test to see if getWidth method works properly.
   */
  @Test
  public void testGetWidth() {
    assertEquals(5, mailItem1.getWidth());
  }

  /**
   * Test to see if getHeight method works properly.
   */
  @Test
  public void testGetHeight() {
    assertEquals(5, mailItem1.getHeight());
  }

  /**
   * Test to see if getDepth method works properly.
   */
  @Test
  public void testGetDepth() {
    assertEquals(10, mailItem1.getDepth());
  }

  /**
   * Test to see if getRecipient method works properly.
   */
  @Test
  public void testGetRecipient() {
    assertEquals("Jiazhe Chen Email:jiazhechen@aol.com",
            mailItem1.getRecipient().toString());
  }
}
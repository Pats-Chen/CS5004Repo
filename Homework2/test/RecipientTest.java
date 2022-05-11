package hw2;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

/**
 * Author: Jiazhe Chen, NUID: 002162461.
 * A test class for the Recipient class.
 */
public class RecipientTest {
  private Recipient recipient1;

  /**
   * Instantiate a new Recipient for tests.
   */
  @Before
  public void setUp() {
    recipient1 = new Recipient("Jiazhe", "Chen", "jiazhechen@aol.com");
  }

  /**
   * Test to see if Recipient constructor handles exception type 1 properly.
   * Exception type 1: The first name of the recipient is null.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testRecipientException1() {
    Recipient recipient2 = new Recipient(null, "Chen", "jiazhechen@aol.com");
  }

  /**
   * Test to see if Recipient constructor handles exception type 2 properly.
   * Exception type 2: The last name of the recipient is null.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testRecipientException2() {
    Recipient recipient2 = new Recipient("Jiazhe", null, "jiazhechen@aol.com");
  }

  /**
   * Test to see if Recipient constructor handles exception type 3 properly.
   * Exception type 3: The email of the recipient is null.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testRecipientException3() {
    Recipient recipient2 = new Recipient("Jiazhe", "Chen", null);
  }

  /**
   * Test to see if Recipient constructor handles exception type 4 properly.
   * Exception type 4: The first name of the recipient is empty.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testRecipientException4() {
    Recipient recipient2 = new Recipient("", "Chen", "jiazhechen@aol.com");
  }

  /**
   * Test to see if Recipient constructor handles exception type 5 properly.
   * Exception type 5: The last name of the recipient is empty.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testRecipientException5() {
    Recipient recipient2 = new Recipient("Jiazhe", "", "jiazhechen@aol.com");
  }

  /**
   * Test to see if Recipient constructor handles exception type 6 properly.
   * Exception type 6: The email of the recipient is empty.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testRecipientException6() {
    Recipient recipient2 = new Recipient("Jiazhe", "Chen", "");
  }

  /**
   * Test to see if toString method works properly.
   */
  @Test
  public void testToString() {
    assertEquals("Jiazhe Chen Email:jiazhechen@aol.com", recipient1.toString());
  }
}
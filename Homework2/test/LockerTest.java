package hw2;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

/**
 * Author: Jiazhe Chen, NUID: 002162461.
 * A test class for the Locker class.
 */
public class LockerTest {
  private Recipient recipient1;

  private MailItem mailItem1;
  private Locker locker1;

  /**
   * Set initial recipient, mail item and locker objects for tests.
   */
  @Before
  public void setUp() {
    recipient1 = new Recipient("Jiazhe", "Chen", "jiazhechen@aol.com");
    mailItem1 = new MailItem(5, 5, 10, recipient1);
    locker1 = new Locker(20, 20, 30);
  }

  /**
   * Test to see if Locker constructor handles exception type 1 properly.
   * Exception type 1: The max width of the locker is less than 1.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testLockerException1() {
    Locker locker2 = new Locker(0, 50, 50);
  }

  /**
   * Test to see if Locker constructor handles exception type 2 properly.
   * Exception type 2: The max height of the locker is less than 1.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testLockerException2() {
    Locker locker2 = new Locker(50, -1, 50);
  }

  /**
   * Test to see if Locker constructor handles exception type 3 properly.
   * Exception type 3: The max depth of the locker is less than 1.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testLockerException3() {
    Locker locker2 = new Locker(50, 50, -9999);
  }

  /**
   * Test to see if isMailItem method works properly.
   */
  @Test
  public void testIsMailItem() {
    assertEquals(false, locker1.isMailItem());
  }

  /**
   * Test to see if addMail method works properly.
   * Case 1: mailItem width larger than maxWidth of the locker.
   * Case 2: mailItem height larger than maxHeight of the locker.
   * Case 3: mailItem depth larger then maxDepth of the locker.
   * Case 4: mailItem has a size that can be contained by the locker.
   */
  @Test
  public void testAddMail() {
    MailItem mailItem2 = new MailItem(50, 10, 20, recipient1);
    locker1.addMail(mailItem2);
    assertEquals(false, locker1.isMailItem());
    MailItem mailItem3 = new MailItem(10, 100, 20, recipient1);
    locker1.addMail(mailItem3);
    assertEquals(false, locker1.isMailItem());
    MailItem mailItem4 = new MailItem(10, 10, 100, recipient1);
    locker1.addMail(mailItem4);
    assertEquals(false, locker1.isMailItem());
    locker1.addMail(mailItem1);
    assertEquals(true, locker1.isMailItem());
  }

  /**
   * Test to see if pickupMail method works properly.
   * Case 1: A new locker has no mailItem to pickupMail.
   * Case 2: A locker with a mailItem cannot pickupMail if the first name doesn't match.
   * Case 3: A locker with a mailItem cannot pickupMail if the last name doesn't match.
   * Case 4: A locker with a mailItem cannot pickupMail if the email doesn't match.
   * Case 5: A locker with a mailItem cannot pickupMail if the recipient info doesn't match.
   * Case 6: A locker with a mailItem can pickupMail if the recipient info does match.
   * Case 7: A locker with a mailItem after pickupMail cannot pickup again
   * even if the recipient info does match.
   */
  @Test
  public void testPickupMail() {
    assertEquals(null, locker1.pickupMail(recipient1));
    locker1.addMail(mailItem1);
    Recipient recipient2 = new Recipient("Keith", "Chen",
            "jiazhechen@aol.com");
    assertEquals(null, locker1.pickupMail(recipient2));
    Recipient recipient3 = new Recipient("Jiazhe", "Bagley",
            "jiazhechen@aol.com");
    assertEquals(null, locker1.pickupMail(recipient3));
    Recipient recipient4 = new Recipient("Jiazhe", "Chen",
            "keithbagley@aol.com");
    assertEquals(null, locker1.pickupMail(recipient4));
    Recipient recipient5 = new Recipient("Keith", "Bagley",
            "keithbagley@aol.com");
    assertEquals(null, locker1.pickupMail(recipient5));
    assertEquals("Jiazhe Chen Email:jiazhechen@aol.com",
            locker1.pickupMail(recipient1).getRecipient().toString());
    assertEquals(null, locker1.pickupMail(recipient1));
  }

  /**
   * Test to see if addMail method and pickupMail method can work properly when used together.
   * Case 1: A locker can addMail again after pickupMail.
   * Case 2: The locker contains mailItem again after case 1.
   * Case 3: The locker can pickupMail again using the same recipient info.
   */
  @Test
  public void testAddMailPickupMail() {
    locker1.addMail(mailItem1);
    locker1.pickupMail(recipient1);
    locker1.addMail(mailItem1);
    assertEquals(true, locker1.isMailItem());
    assertEquals("Jiazhe Chen Email:jiazhechen@aol.com",
            locker1.pickupMail(recipient1).getRecipient().toString());
  }
}
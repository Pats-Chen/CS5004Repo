package hw2;

/**
 * Author: Jiazhe Chen, NUID: 002162461
 * A class for creating an object as a locker.
 */
public class Locker {
  private int maxWidth;
  private int maxHeight;
  private int maxDepth;
  private MailItem mailItem;

  /**
   * Return a Locker object.
   *
   * @param maxWidth  The max width of the locker.
   * @param maxHeight The max height of the locker.
   * @param maxDepth  The max depth of the locker.
   * @throws IllegalArgumentException an exception if width, height, or depth is less than one.
   */
  public Locker(int maxWidth, int maxHeight, int maxDepth) throws IllegalArgumentException {
    if (maxWidth < 1 || maxHeight < 1 || maxDepth < 1) {
      throw new IllegalArgumentException("The width, height and depth cannot be less than 1.");
    }
    this.maxWidth = maxWidth;
    this.maxHeight = maxHeight;
    this.maxDepth = maxDepth;
    this.mailItem = null;
  }

  /**
   * Return a boolean value.
   *
   * @return True if this locker is not empty. False otherwise.
   *         If the locker is empty, the mail item in the locker should be null.
   */
  public boolean isMailItem() {
    if (this.mailItem != null) {
      return true;
    } else {
      return false;
    }
  }

  /**
   * Set the mail item in this locker to be the parameter.
   *
   * @param mailItem A mail item that is going to be stored in this locker.
   */
  public void addMail(MailItem mailItem) {
    if (this.mailItem == null && mailItem.getWidth() <= this.maxWidth
            && mailItem.getHeight() <= this.maxHeight
            && mailItem.getDepth() <= this.maxDepth) {
      this.mailItem = mailItem;
    }
  }

  /**
   * Get the mail item in this locker.
   *
   * @param recipient The recipient of the mail item in this locker.
   * @return the mail item in this locker. Return null if there is no mail item in it,
   *         or the info of the recipient does not match.
   */
  public MailItem pickupMail(Recipient recipient) {
    if (this.mailItem != null
            && this.mailItem.getRecipient().toString().equals(recipient.toString())) {
      MailItem mailItemOut = this.mailItem;
      this.mailItem = null;
      return mailItemOut;
    } else {
      return null;
    }
  }
}

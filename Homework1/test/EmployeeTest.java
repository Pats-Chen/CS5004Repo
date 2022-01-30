import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

/**
 * Author: Jiazhe Chen, NUID: 002162461.
 * A test class for the Employee class.
 */
public class EmployeeTest {
  private Employee jiazhe;

  /**
   * Initialize a new Employee instance for tests.
   */
  @Before
  public void setUp() {
    jiazhe = new Employee("Jiazhe Chen", "002162461", 15.15);
  }

  /**
   * Test to see if the method can get work hour properly.
   */
  @Test
  public void getHoursWorked() {
    assertEquals(0.0, jiazhe.getHoursWorked(), 0.001);
  }

  /**
   * Test to see if the method can add work hour properly.
   * The increase of work hour can be negative.
   * The total work hour cannot be less than 0.
   */
  @Test
  public void addHoursWorked() {
    jiazhe.addHoursWorked(-2.0);
    assertEquals(0.0, jiazhe.getHoursWorked(), 0.001);
    jiazhe.addHoursWorked(4.0);
    assertEquals(4.0, jiazhe.getHoursWorked(), 0.001);
    jiazhe.addHoursWorked(-2.0);
    assertEquals(2.0, jiazhe.getHoursWorked(), 0.001);
  }

  /**
   * Test to see if the method can reset work hour to 0 properly.
   */
  @Test
  public void resetHoursWorked() {
    jiazhe.addHoursWorked(4.0);
    jiazhe.resetHoursWorked();
    assertEquals(0.0, jiazhe.getHoursWorked(), 0.001);
  }

  /**
   * Test to see if the method can show the information of the employee and his/her
   * payment after taxes properly, round to 2 decimal places.
   */
  @Test
  public void testToString() {
    jiazhe.addHoursWorked(4.0);
    assertEquals("Name: Jiazhe Chen" + "\nID: 002162461"
            + "\nPayment after taxes: $ 54.54", jiazhe.toString());
    jiazhe.resetHoursWorked();
    jiazhe.addHoursWorked(30.25);
    assertEquals("Name: Jiazhe Chen" + "\nID: 002162461"
            + "\nPayment after taxes: $ 389.54", jiazhe.toString());
    jiazhe.resetHoursWorked();
    assertEquals("Name: Jiazhe Chen" + "\nID: 002162461"
            + "\nPayment after taxes: $ 0.00", jiazhe.toString());
  }
}
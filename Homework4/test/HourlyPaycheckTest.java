import static org.junit.Assert.assertEquals;

import employee.HourlyPaycheck;
import org.junit.Before;
import org.junit.Test;

/**
 * Author: Jiazhe Chen, NUID: 002162461.
 * A test class for the HourlyPaycheck class.
 */
public class HourlyPaycheckTest {
  private HourlyPaycheck payment1;

  /**
   * Initialize some HourlyPaycheck instances for tests.
   */
  @Before
  public void setUp() {
    payment1 = new HourlyPaycheck(10.0, 20);
  }

  /**
   * Test to see if HourlyPaycheck constructor handles exception properly.
   * Exception1: The pay rate cannot be negative.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testHourlyPaycheckException1() {
    HourlyPaycheck payment2 = new HourlyPaycheck(-10.0, 10);
  }

  /**
   * Test to see if HourlyPaycheck constructor handles exception properly.
   * Exception2: The hours worked of the hourly employee cannot be negative.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testHourlyPaycheckException2() {
    HourlyPaycheck payment2 = new HourlyPaycheck(12.0, -100);
  }

  /**
   * Test to see if getPayRate method works properly.
   */
  @Test
  public void testGetPayRate() {
    assertEquals(10.0, payment1.getPayRate(), 0.001);
  }

  /**
   * Test to see if getTotalPay method works properly.
   */
  @Test
  public void testGetTotalPay() {
    assertEquals(200.0, payment1.getTotalPay(), 0.001);
    HourlyPaycheck payment2 = new HourlyPaycheck(12.0, 30);
    assertEquals(360.0, payment2.getTotalPay(), 0.001);
    HourlyPaycheck payment3 = new HourlyPaycheck(12.0, 40);
    assertEquals(480.0, payment3.getTotalPay(), 0.001);
    HourlyPaycheck payment4 = new HourlyPaycheck(12.0, 50);
    assertEquals(660.0, payment4.getTotalPay(), 0.001);
  }

  /**
   * Test to see if getPayAfterTaxes method works properly.
   * If the total pay is larger than 400, the overall tax rate should be 0.85. Otherwise,
   * the overall tax rate should be 0.9.
   * If the total pay after taxes is larger than 0 but less than 0.01, 0.01 should be paid.
   * It should return total pay after taxes as a double.
   */
  @Test
  public void testGetPayAfterTaxes() {
    HourlyPaycheck payment2 = new HourlyPaycheck(15.0, 30.0);
    assertEquals(382.50, payment2.getPayAfterTaxes(), 0.001);
    HourlyPaycheck payment3 = new HourlyPaycheck(15.15, 20.2);
    assertEquals(275.427, payment3.getPayAfterTaxes(), 0.001);
    HourlyPaycheck payment4 = new HourlyPaycheck(10.0, 0.0001);
    assertEquals(0.01, payment4.getPayAfterTaxes(), 0.001);
  }

  /**
   * Test to see if toString method works properly.
   */
  @Test
  public void testToString() {
    assertEquals("Payment after taxes: $ 180.00", payment1.toString());
  }

  /**
   * Test to see if getHoursWorked method works properly.
   */
  @Test
  public void testGetHoursWorked() {
    assertEquals(20.0, payment1.getHoursWorked(), 0.001);
  }

  /**
   * Test to see if addHoursWorked method works properly.
   */
  @Test
  public void testAddHoursWorked() {
    payment1.addHoursWorked(10);
    assertEquals(30, payment1.getHoursWorked(), 0.001);
    payment1.addHoursWorked(14.5);
    assertEquals(44.5, payment1.getHoursWorked(), 0.001);
    payment1.addHoursWorked(-4.5);
    assertEquals(40.0, payment1.getHoursWorked(), 0.001);
    payment1.addHoursWorked(-50);
    assertEquals(0.0, payment1.getHoursWorked(), 0.001);
    payment1.addHoursWorked(15);
    assertEquals(15.0, payment1.getHoursWorked(), 0.001);
    payment1.addHoursWorked(100);
    assertEquals(115.0, payment1.getHoursWorked(), 0.001);
    payment1.addHoursWorked(-1);
    assertEquals(114.0, payment1.getHoursWorked(), 0.001);
    payment1.addHoursWorked(-200);
    assertEquals(0.0, payment1.getHoursWorked(), 0.001);
    payment1.addHoursWorked(0.1);
    assertEquals(0.1, payment1.getHoursWorked(), 0.001);
    payment1.addHoursWorked(-0.1);
    assertEquals(0.0, payment1.getHoursWorked(), 0.001);
    payment1.addHoursWorked(0.2);
    assertEquals(0.2, payment1.getHoursWorked(), 0.001);
  }

  /**
   * Test to see if resetHoursWorked method works properly.
   */
  @Test
  public void testResetHoursWorked() {
    payment1.resetHoursWorked();
    assertEquals(0.0, payment1.getHoursWorked(), 0.001);
  }
}

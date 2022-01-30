import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

/**
 * Author: Jiazhe Chen, NUID: 002162461.
 * This is a test class for the Paycheck class.
 */
public class PaycheckTest {
  private Paycheck payment;

  /**
   * A setup method to initialize a new Employee instance for tests.
   */
  @Before
  public void setUp() {
    payment = new Paycheck(12.75, 20.0);
  }

  /**
   * A test method to get total pay. If the work hour is larger than 40,
   * then the total pay should be multiplied by 1.5.
   */
  @Test
  public void getTotalPay() {
    assertEquals(255, payment.getTotalPay(), 0.001);
    payment = new Paycheck(12.75, 45.0);
    assertEquals(605.625, payment.getTotalPay(), 0.001);
  }

  /**
   * A test method to get total pay after taxes.
   * If the total pay is larger than 400, the overall tax rate should be 0.85. Otherwise,
   * the overall tax rate should be 0.9.
   * If the total pay after taxes is larger than 0 but less than 0.01, 0.01 should be paid.
   * It should return total pay after taxes as a double, rounded to 2 decimal places.
   */
  @Test
  public void getPayAfterTaxes() {
    payment = new Paycheck(15.0, 30.0);
    assertEquals(382.50, payment.getPayAfterTaxes(), 0.001);
    payment = new Paycheck(15.15, 20.2);
    assertEquals(275.427, payment.getPayAfterTaxes(), 0.001);
    payment = new Paycheck(10.0, 0.0001);
    assertEquals(0.01, payment.getPayAfterTaxes(), 0.001);
  }

  /**
   * A test method to get information of the paycheck. The payment should be 0.00 if
   * work hour is 0.0.
   */
  @Test
  public void testToString() {
    assertEquals("Payment after taxes: $ 229.50", payment.toString());
    payment = new Paycheck(15.0, 0.0);
    assertEquals("Payment after taxes: $ 0.00", payment.toString());
  }
}
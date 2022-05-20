import static org.junit.Assert.assertEquals;

import employee.SalariedPaycheck;
import org.junit.Before;
import org.junit.Test;

/**
 * Author: Jiazhe Chen, NUID: 002162461.
 * A test class for the SalariedPaycheck class.
 */
public class SalariedPaycheckTest {
  private SalariedPaycheck payment1;

  /**
   * Initialize some SalariedPaycheck instances for tests.
   */
  @Before
  public void setUp() {
    payment1 = new SalariedPaycheck(150000.0, 4);
  }

  /**
   * Test to see if SalariedPaycheck constructor handles exception properly.
   * Exception1: The pay rate cannot be negative.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testSalariedPaycheckException1() {
    SalariedPaycheck payment2 = new SalariedPaycheck(-10.0, 1);
  }

  /**
   * Test to see if SalariedPaycheck constructor handles exception properly.
   * Exception2: The pay interval of SalariedPaycheck can only be one, two, or four.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testSalariedPaycheckException2() {
    SalariedPaycheck payment2 = new SalariedPaycheck(14.5, 3);
  }

  /**
   * Test to see if getPayRate method works properly.
   */
  @Test
  public void testGetPayRate() {
    assertEquals(150000.0, payment1.getPayRate(), 0.001);
  }

  /**
   * Test to see if getTotalPay method works properly.
   */
  @Test
  public void testGetTotalPay() {
    assertEquals(11538.461538, payment1.getTotalPay(), 0.001);
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
    SalariedPaycheck payment2 = new SalariedPaycheck(15600.0, 1);
    assertEquals(270.0, payment2.getPayAfterTaxes(), 0.001);
    SalariedPaycheck payment3 = new SalariedPaycheck(20800.0, 1);
    assertEquals(340.0, payment3.getPayAfterTaxes(), 0.001);
    SalariedPaycheck payment4 = new SalariedPaycheck(0.52, 1);
    assertEquals(0.01, payment4.getPayAfterTaxes(), 0.001);
  }

  /**
   * Test to see if toString method works properly.
   */
  @Test
  public void testToString() {
    assertEquals("Payment after taxes: $ 9807.69", payment1.toString());
  }
}


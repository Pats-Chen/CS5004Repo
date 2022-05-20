import static org.junit.Assert.assertEquals;

import employee.Employee;
import org.junit.Before;
import org.junit.Test;

/**
 * Author: Jiazhe Chen, NUID: 002162461.
 * A test class for the Employee class.
 */
public class EmployeeTest {
  private Employee jiazhe;
  private Employee keith;

  /**
   * Initialize some Employee instances for tests.
   */
  @Before
  public void setUp() {
    keith = new Employee("Keith Bagley", "000000001", 104000.0, 4, true);
    jiazhe = new Employee("Jiazhe Chen", "002162461", 12.45, 20);
  }

  /**
   * Test to see if Employee constructor for salaried employees handles exception properly.
   * Exception1: The name of the salaried employee is null.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testEmployeeException1() {
    Employee ramzi = new Employee(null, "000000002", 20.0, 1, false);
  }

  /**
   * Test to see if Employee constructor for salaried employees handles exception properly.
   * Exception2: The name of the salaried employee is empty.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testEmployeeException2() {
    Employee ramzi = new Employee("", "000000002", 20.0, 1, false);
  }

  /**
   * Test to see if Employee constructor for salaried employees handles exception properly.
   * Exception3: The id of the salaried employee is null.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testEmployeeException3() {
    Employee ramzi = new Employee("Ramzi Adil", null, 20.0, 1, false);
  }

  /**
   * Test to see if Employee constructor for salaried employees handles exception properly.
   * Exception4: The id of the salaried employee is empty.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testEmployeeException4() {
    Employee ramzi = new Employee("Ramzi Adil", "", 20.0, 1, false);
  }

  /**
   * Test to see if Employee constructor for salaried employees handles exception properly.
   * Exception5: The pay rate of the salaried employee is negative.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testEmployeeException5() {
    Employee ramzi = new Employee("Ramzi Adil", "000000002", -15.0, 1, false);
  }

  /**
   * Test to see if Employee constructor for salaried employees handles exception properly.
   * Exception6: The pay interval of the salaried employee is not one, two or four.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testEmployeeException6() {
    Employee ramzi = new Employee("Ramzi Adil", "000000002", 20.0, 10, false);
  }

  /**
   * Test to see if Employee constructor for hourly employees handles exception properly.
   * Exception7: The name of the hourly employee is null.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testEmployeeException7() {
    Employee ramzi = new Employee(null, "000000002", 15.0, 20.0);
  }

  /**
   * Test to see if Employee constructor for hourly employees handles exception properly.
   * Exception8: The name of the hourly employee is empty.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testEmployeeException8() {
    Employee ramzi = new Employee("", "000000002", 15.0, 20.0);
  }

  /**
   * Test to see if Employee constructor for hourly employees handles exception properly.
   * Exception9: The id of the hourly employee is null.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testEmployeeException9() {
    Employee ramzi = new Employee("Ramzi Adil", null, 15.0, 20.0);
  }

  /**
   * Test to see if Employee constructor for hourly employees handles exception properly.
   * Exception10: The id of the hourly employee is empty.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testEmployeeException10() {
    Employee ramzi = new Employee("Ramzi Adil", "", 15.0, 20.0);
  }

  /**
   * Test to see if Employee constructor for hourly employees handles exception properly.
   * Exception11: The pay rate of the hourly employee is negative.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testEmployeeException11() {
    Employee ramzi = new Employee("Ramzi Adil", "000000002", -999.0, 20.0);
  }

  /**
   * Test to see if Employee constructor for hourly employees handles exception properly.
   * Exception12: The hours worked of the hourly employee is negative.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testEmployeeException12() {
    Employee ramzi = new Employee("Ramzi Adil", "000000002", 15.0, -0.1);
  }

  /**
   * Test to see if isManager method works properly.
   */
  @Test
  public void testIsManager() {
    assertEquals(true, keith.isManager());
    assertEquals(false, jiazhe.isManager());
  }

  /**
   * Test to see if getPaycheck method works properly.
   */
  @Test
  public void testGetPaycheck() {
    assertEquals(104000.0, keith.getPaycheck().getPayRate(), 0.001);
    assertEquals(8000.0, keith.getPaycheck().getTotalPay(), 0001);
    assertEquals(12.45, jiazhe.getPaycheck().getPayRate(), 0.001);
    assertEquals(249.0, jiazhe.getPaycheck().getTotalPay(), 0.001);
  }

  /**
   * Test to see if toString method works properly.
   */
  @Test
  public void testToString() {
    assertEquals("Name: Jiazhe Chen" + "\nID: 002162461"
            + "\nPayment after taxes: $ 224.10", jiazhe.toString());
    assertEquals("Name: Keith Bagley" + "\nID: 000000001"
            + "\nPayment after taxes: $ 6800.00", keith.toString());
    Employee ramzi = new Employee("Ramzi Adil", "000000002", 20.0, 0.0);
    assertEquals("Name: Ramzi Adil" + "\nID: 000000002"
            + "\nPayment after taxes: $ 0.00", ramzi.toString());
  }
}
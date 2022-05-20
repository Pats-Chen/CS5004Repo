package employee;

/**
 * Author: Jiazhe Chen, NUID: 002162461.
 * An interface for Paycheck class to implement.
 */
public interface IPaycheck {
  /**
   * An interface method for Paycheck class to implement.
   *
   * @return a double that shows the total payment of the paycheck.
   */
  double getTotalPay();

  /**
   * An interface method for Paycheck class to implement.
   *
   * @return a double that shows the total payment of the paycheck after taxes.
   */
  double getPayAfterTaxes();

  /**
   * An interface method for Paycheck class to implement.
   *
   * @return a double that shows the pay rate of the paycheck.
   */
  double getPayRate();
}
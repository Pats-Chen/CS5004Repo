package stock;

import java.math.RoundingMode;
import java.text.DecimalFormat;

/**
 * Author: Jiazhe Chen, NUID: 002162461
 * A class for Stock objects. Instances can interact with Transaction objects.
 */
public class Stock {
  private String symbol;
  private String name;
  private double costBasis;
  private double currentPrice;
  private static final DecimalFormat df = new DecimalFormat("0.00");

  /**
   * Initialize a stock instance. Note that the initial current price is set as 0.
   *
   * @param symbol    this is the shorthand for this stock.
   * @param name      this is the full name for this stock.
   * @param costBasis this is the price when the user bought this stock.
   */
  public Stock(String symbol, String name, double costBasis) {
    this.symbol = symbol;
    this.name = name;
    this.costBasis = costBasis;
    this.currentPrice = 0.0;
  }

  /**
   * Get the stock symbol.
   *
   * @return the string value of the stock symbol.
   */
  public String getSymbol() {
    return this.symbol;
  }

  /**
   * Get the name of the stock.
   *
   * @return the string value of the stock name.
   */
  public String getName() {
    return this.name;
  }

  /**
   * Get the cost basis of the stock.
   *
   * @return the cost of the stock as a double.
   */
  public double getCostBasis() {
    return this.costBasis;
  }

  /**
   * Get the current price of the stock.
   *
   * @return the current price of the stock as a double.
   */
  public double getCurrentPrice() {
    return this.currentPrice;
  }

  /**
   * Set the cost basis of the stock.
   *
   * @param costBasis This parameter expects a double as input.
   */
  public void setCostBasis(double costBasis) {
    this.costBasis = costBasis;
  }

  /**
   * Set the current price of the stock.
   *
   * @param currentPrice This parameter expects a double as input.
   */
  public void setCurrentPrice(double currentPrice) {
    this.currentPrice = currentPrice;
  }

  /**
   * Calculate the fractional change between the cost basis and the current price.
   *
   * @return it returns the fractional change as a double.
   */
  public double getChangePercent() {
    return (this.currentPrice - this.costBasis) / this.costBasis;
  }

  /**
   * Show the information of the stock instance, including its name, current price, and
   * the gain and loss in percentage.
   */
  @Override
  public String toString() {
    return this.name + " Current Price: $ " + this.currentPrice
           + "\n Gain/Loss: " + df.format(this.getChangePercent() * 100) + "%";
  }
}

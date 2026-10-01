package Arrays;

public class BestTimeToBuyAndSell {
  public static int maxProfit(int prices[]) {
    int n = prices.length;

    int maxProfit = 0;
    int buyingPrice = prices[0];

    for (int i = 1; i < n; i++) {
      if (prices[i] < buyingPrice) {
        buyingPrice = prices[i];
      } else {
        int sellingProfit = prices[i] - buyingPrice;
        maxProfit = (sellingProfit > maxProfit) ? sellingProfit : maxProfit;
      }
    }

    return maxProfit;
  }

  public static void main(String[] args) {
    int prices[] = { 2, 4, 1 };
    System.out.println("MAX PROFIT: " + maxProfit(prices));
  }
}

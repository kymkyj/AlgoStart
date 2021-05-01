public class StockPriceTest {
private int[] increaseStockPricesTimes(int[] prices) {
        int length = prices.length;
        int[] answer = new int[length];
        for (int i = 0; i < length; i++) {
            for (int j = i+1; j < length; j++) {
                answer[i]++;
                if (prices[i] <= prices[j]) {
                    continue;
                }
                break;
            }
        }
        return answer;
    }
}

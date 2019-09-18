package practice.array;

/**
 * @Classname MaxProfit
 * @Description TODO
 * @Date 2019/9/18 9:38
 * @Created by MichaelCS
 */
public class MaxProfit {
    static class SolutionV01 {
        public int maxProfit(int[] prices) {

            int minPrice = Integer.MAX_VALUE;
            // int minPrice = prices[0]; 不能确定数组是否为空！！
            int maxProfit = 0;
            for(int i=0; i<prices.length; i++){
                int currPrice = prices[i];
                minPrice = currPrice < minPrice ? currPrice : minPrice;
                int profit = currPrice>minPrice ? currPrice-minPrice : maxProfit;
                maxProfit = profit>maxProfit ? profit : maxProfit;
            }
            return maxProfit;
        }
    }
    static class SolutionV02 {
        public int maxProfit(int[] prices) {

            int minPrice = Integer.MAX_VALUE;
            // int minPrice = prices[0]; 不能确定数组是否为空！！
            int maxProfit = 0;
            for(int i=0; i<prices.length; i++){
                int currPrice = prices[i];
                if(currPrice <= minPrice){
                    minPrice = currPrice;
                }else if(currPrice-minPrice > maxProfit){
                    maxProfit = currPrice -minPrice;
                }
            }
            return maxProfit;
        }
    }

    public static void main(String[] args){
        int[] prices = {1,2};
        SolutionV01 solution = new SolutionV01();
        int result = solution.maxProfit(prices);
        System.out.println(result);
    }
}

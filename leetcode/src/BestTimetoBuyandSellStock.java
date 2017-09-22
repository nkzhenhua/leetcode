//https://leetcode.com/problems/best-time-to-buy-and-sell-stock/description/
public class BestTimetoBuyandSellStock {
	public static void main(String[] argv){
		BestTimetoBuyandSellStock tmp = new BestTimetoBuyandSellStock();
		int[] maxAfter = {1,2};
		tmp.maxProfit(maxAfter);
	}
    public int maxProfit(int[] prices) {
        if( prices == null || prices.length <= 1 ) return 0;
    	int[] maxAfter = new int[prices.length];
    	maxAfter[maxAfter.length-1] = prices[prices.length-1];
        for( int idx = prices.length -2; idx >= 0 ; idx-- ){
        	if( prices[idx] >  maxAfter[idx+1]){
        		maxAfter[idx] = prices[idx];
        	}else{
        		maxAfter[idx] = maxAfter[idx+1];
        	}
        }
        int max=0;
        for( int i = 0; i< maxAfter.length; i++){
        	int benifit = maxAfter[i] - prices[i];
        	if( max < benifit ){
        		max = benifit;
        	}
        }
        return max;
    }
}

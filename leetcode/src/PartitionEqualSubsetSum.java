
public class PartitionEqualSubsetSum {
    public static void main(String argvs[]){
    	int[] nums={1,5,11,5};
    	boolean result = PartitionEqualSubsetSum.canPartition(nums);
    }
    public static boolean canPartition(int[] nums) {
    	int sum = 0;
        for( int i=0;i<nums.length;i++ ){
        	sum+=nums[i];
        }
        if( sum%2 != 0 ){
        	return false;
        }
        return elementsWithSum(nums,sum/2);
    }
    //backpack problem solution
    private static boolean elementsWithSum(int[] numbs, int target){
    	boolean[] dp = new boolean[target+1];
    	//init with 0;
    	for( int i = 1; i<dp.length; i++){
    		dp[i] = false;
    	}
    	//init dp[0] to true, because the backpack size=0 , there is a solution to fill the backpack with 0 item
    	dp[0] = true;
    	//iterate the items and remember that dp[backpack size] is the dp problem, not nums[i];
    	for( int idx = 1; idx < numbs.length; idx++){
    		//update the dp from max size
    		for( int j = dp.length-1; j >= numbs[idx]; j--){
    			dp[j] = (dp[j] || dp[j-numbs[idx]]); //that's why j must >=number[i]
    		}
    	}
    	return dp[target];
    	
    }

    
    //performance not fine
    private static boolean elementsWithSum_1(int[] numbs, int start, int sum){
    	
    	//current element quit
    	if( sum < 0 ){
    		return false;
    	}
    	
    	//current element end
    	if( numbs[start] == sum ){
    		return true;
    	}

    	if( start == (numbs.length - 1) ){
    		//the last elements, quit condition
            return false;
    	}
    	//next iteration
    	return elementsWithSum_1(numbs, start+1, sum-numbs[start] ) || elementsWithSum_1(numbs, start+1, sum);
    	
    }

}

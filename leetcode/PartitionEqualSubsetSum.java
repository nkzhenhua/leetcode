package leetcode;

public class PartitionEqualSubsetSum {
    public static boolean canPartition(int[] nums) {
    	int sum = 0;
        for( int i=0;i<nums.length;i++ ){
        	sum+=nums[i];
        }
        if( sum%2 != 0 ){
        	return false;
        }
        return elementsWithSum(nums,0,sum/2);
    }
    private static boolean elementsWithSum(int[] numbs, int start, int sum){
    	
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
    	return elementsWithSum(numbs, start+1, sum-numbs[start] ) || elementsWithSum(numbs, start+1, sum);
    	
    }
    public static void main(String argvs[]){
    	
    }
}

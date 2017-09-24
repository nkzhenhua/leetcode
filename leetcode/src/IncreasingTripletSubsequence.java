//https://leetcode.com/problems/increasing-triplet-subsequence/description/
public class IncreasingTripletSubsequence {
    public boolean increasingTriplet(int[] nums) {
        if( nums.length < 3 ) return false;
        int min1 = Integer.MAX_VALUE;
        int min2  = Integer.MAX_VALUE;
        
        for( int j = 0; j< nums.length; j++ ){

        	if( nums[j] <= min1 ){
        		min1 = nums[j];
        	}else if( nums[j] <= min2 ){
        		min2 = nums[j];
        	}else return true;
        }
        return false;
    }
}

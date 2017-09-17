//https://leetcode.com/problems/search-for-a-range/description/
public class SearchforaRange {
	public static void main(String[] argv){
		SearchforaRange tmp = new SearchforaRange();
		int[] nums={5,7,7,8,8,10};
		tmp.searchRange(nums, 8);
	}
    public int[] searchRange(int[] nums, int target) {
    	int[] ret = new int[2];
    	ret[0] = -1;
    	ret[1] = -1;
    	if( nums.length == 0) return ret;
    	int ll=0;
    	int lr=nums.length-1;
    	while( ll < lr){
    		int mid = (ll+lr)/2;
    		if( nums[mid] < target ){
    			ll = mid +1;
    		}else{
    			lr=mid;
    		}
    	}
    	if( nums[lr] != target ) return ret;
    	int rl=lr;
    	int rr=nums.length-1;
    	while( rl < rr ){
    		int mid = (rl + rr + 1)/2;
    		if( nums[mid] > target ){
    			rr = mid-1;
    		}else{
    			rl = mid;
    		}
    	}
    	ret[0]=lr;
    	ret[1]=rl;
    	return ret;
    }
    public int[] searchRange1(int[] nums, int target) {
    	int[] ret = new int[2];
    	ret[0] = -1;
    	ret[1] = -1;
    	if( nums.length == 0) return ret;
        int idx = bisearch( nums, target, 0, nums.length-1);
        if( idx == -1 ){
        	return ret;
        }else{
        	ret[0]=idx;
        	ret[1]=idx;
        }
        for( int start = idx-1; start >=0; start--){
        	if( nums[start] == target){
        		ret[0] = start;
        	}else{
        		break;
        	}
        }
        for( int end = idx+1; end < nums.length; end++){
        	if( nums[end] == target){
        		ret[1] = end;
        	}else{
        		break;
        	}
        }
        return ret;
    }
    public int bisearch(int[] nums, int target, int start, int end){
    	int mid = (start+end)/2;
    	if( nums[mid] == target ) return mid;
    	if( nums[mid] < target ){
    		if( mid < end ){
    			return bisearch( nums, target, mid+1, end);
    		}else{
    			return -1;
    		}
    	}
    	if( nums[mid] > target ){
    		if( mid > start ){
    			return bisearch( nums, target, start, mid-1);
    		}else{
    			return -1;
    		}
    	}
    	//shouldn't be here
    	return -1;
    }
}

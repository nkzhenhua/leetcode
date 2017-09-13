//https://leetcode.com/problems/create-maximum-number/description/
public class CreateMaximumNumber {
	public CreateMaximumNumber(){}
	public  static void main(String argv[]){
		CreateMaximumNumber ttt = new  CreateMaximumNumber();
		int[] arr1 = {6,7};
		int[] arr2 = {6,0,4};
		int[] arr3 = ttt.maxNumber(arr1,arr2,5);
		System.out.println(arr3.toString());
	}
	public int[] maxK(int[] num, int k){
		int[] ret = new int[k];
		if( k == 0 ) return ret;
		int idx = 0;
		ret[idx++] = num[0];
		for( int i=1; i< num.length; i++){
			for( ; idx > 0; ){
				if( ret[idx-1] < num[i] && ( idx + num.length - i >k )){
					idx--;
				}else{
					break;
				}
			}
			if( idx < k ) {
				ret[idx++] = num[i];
			}
		}
		return ret;
	}
	boolean great(int[] nums1,int idx1, int[] nums2, int idx2){
		if( nums2 == null || nums2.length == 0) return true;
		if( nums1 == null || nums1.length == 0) return false;
		int i = idx1;
		int j = idx2;
		while( i<nums1.length && j < nums2.length && nums1[i]==nums2[j] ){
			i++;
			j++;
		}
		if( i == nums1.length ) return false;
		if( j == nums2.length ) return true;
		return nums1[i] > nums2[j];
		
	}
	 public int[] merge(int[] nums1, int[] nums2, int k){
		 int [] ret = new int[k];
		 int i=0;
		 int j=0;
		 for(int idx=0;idx<k;idx++){
			 if(great(nums1,i,nums2,j)){
				 ret[idx] = nums1[i];
				 i++;
			 }else{
				 ret[idx] = nums2[j];
				 j++;
			 }
		 }
		 return ret;
		 
	 }
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
    	int m = nums1.length;
    	int n = nums2.length;
    	int [] max = null;
    	for( int i= Math.max(0, k-n);i<= Math.min(m, k);i++){
    		int[] arr1 = maxK(nums1,i);
    		int[] arr2 = maxK(nums2,k-i);
    		int[] cur = merge(arr1,arr2,k);
    		if( great(cur,0, max,0)){
    			max = cur;
    		}
    	}
         return max;
    }
}

package leetcode;

public class ReverseInteger {
	public static int reverse(int x) {
		long reverse = 0;
		long max = 0x7fffffff;
		long min = 0x80000000;
		while( x != 0 ){
			reverse = reverse * 10 + x%10;
			if( reverse > max || reverse < min) return 0;
			x = x/10;
		}
		return (int)reverse;
	}
	public static void main(String argv[]){
		System.out.println(0x7fffffff);
		System.out.println(0x80000000);
		System.out.println(ReverseInteger.reverse(2147483647));
	}

}


public class HammingDistance {
	public static void main(String argv[]){
		System.out.println(HammingDistance.hammingDistance(1, 4));
	}
    public static int hammingDistance(int x, int y) {
    	int hamdist=0;
        for( int idx = 0; (idx < 31) && ( x!=0 || y!=0); idx ++){
        	if( (x%2) != (y%2)){
        		hamdist++;
        	}
        	x = x>>1;
            y = y>>1;
        }
        return hamdist;
    }
}

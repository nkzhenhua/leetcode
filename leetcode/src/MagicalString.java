
public class MagicalString {
	public static void main(String argv[]){
		MagicalString tmp = new MagicalString();
		tmp.magicalString(12);
	}
	public MagicalString(){}
    public int magicalString(int n) {
    	if( n == 0 ) return 0;
    	if( n<=3 ) return 1;
        StringBuffer magic = new StringBuffer("122");
        int countPointer = 2;
        char cur ='2';
        int numofone=1;
        int repeat=0;
        while( magic.length() < n ){
        	repeat = magic.charAt(countPointer) - '0';
        	if( cur == '2' ){
        		cur = '1';
        		numofone += repeat;
        	}else{
        		cur = '2';
        	}
        	if( repeat == 1){
       		magic.append(cur);
        	}else{
        		magic.append(cur).append(cur);
        	}
        	countPointer++;
        }
        System.out.println(magic);
        if( magic.length() == n || cur == '2') return numofone;
        else return numofone-1;
    }
}

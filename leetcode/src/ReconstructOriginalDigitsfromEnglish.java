
public class ReconstructOriginalDigitsfromEnglish {
	public static void main(String[] argv){
		ReconstructOriginalDigitsfromEnglish tmp = new ReconstructOriginalDigitsfromEnglish();
		System.out.println(tmp.originalDigits("owoztneoer"));
	}
    public String originalDigits(String s) {
        int[] cfreq = new int[26];
        int[] numcount = new int[10];
        for( int i = 0; i< cfreq.length; i++){
        	cfreq[i]=0;
        }
        for( int i = 0; i<numcount.length; i++){
        	numcount[i]=0;
        }
        for( int i = 0; i< s.length(); i++ ){
        	int idx = s.charAt(i) - 'a';
        	cfreq[idx]+=1;
        }
        numcount[0] = cfreq['z'-'a'];
        numcount[2] = cfreq['w'-'a'];
        numcount[4] = cfreq['u'-'a'];
        numcount[6] = cfreq['x'-'a'];
        numcount[8] = cfreq['g'-'a'];
        numcount[2] = cfreq['w'-'a'];
        numcount[2] = cfreq['w'-'a'];
        numcount[2] = cfreq['w'-'a'];
        numcount[1] = cfreq['o'-'a'] - numcount[0] - numcount[2] - numcount[4];
        numcount[3] = cfreq['h'-'a'] - numcount[8];
        numcount[5] = cfreq['f'-'a'] - numcount[4];
        numcount[7] = cfreq['s'-'a'] - numcount[6];
        numcount[9] = cfreq['i'-'a'] - numcount[6] - numcount[8] - numcount[5];
        StringBuffer ret = new StringBuffer();
        for( int i = 0; i< 10; i++){
        	for( int j=0;j<numcount[i];j++){
        		ret.append(i);
        	}
        }
        return ret.toString();
    }
}

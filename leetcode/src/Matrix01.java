import java.util.LinkedList;

																																							
public class Matrix01 {
	public static class Position{
		public int x;
		public int y;
		public Position(int x, int y){
			this.x = x;
			this.y = y;
		}
	};
    public int[][] updateMatrix(int[][] matrix) {
    	int max = 65536;
    	int[][] ret = new int[matrix.length][];
    	for( int idx = 0; idx < ret.length; idx++){
    		ret[idx]= new int[matrix[0].length];
    		for( int j = 0; j< ret[idx].length; j++){
    			if(matrix[idx][j] == 0  ){
    				ret[idx][j] = 0;
    			}else{
        			ret[idx][j] = max;
    			}
    		}
    	}
        LinkedList<Position> queue = new LinkedList<Position>();
        for( int i =0; i< matrix.length; i++){
        	for( int j=0; j< matrix[0].length; j++ ){
        		if( matrix[i][j] == 0 ){
            		queue.add(new Position(i,j));
            		ret[i][j] = 0;
        		}
        	}
        }
        while( queue.size() > 0 ){
        	Position pos = queue.remove();
        	int nextlay=ret[pos.x][pos.y]+1;;
        	//add surround pos to queue
        	if( pos.x-1 >=0 && ret[pos.x-1][pos.y]== max){
        		queue.add(new Position(pos.x-1,pos.y));
        		ret[pos.x-1][pos.y] = nextlay;
        	}
        	if( pos.x+1 < ret.length && ret[pos.x+1][pos.y]== max){
        		queue.add(new Position(pos.x+1,pos.y));
        		ret[pos.x+1][pos.y] = nextlay;
        	}
        	if( pos.y-1 >=0 && ret[pos.x][pos.y-1]== max){
        		queue.add(new Position(pos.x,pos.y-1));
        		ret[pos.x][pos.y-1] = nextlay;
        	}
        	if( pos.y+1 < ret[0].length && ret[pos.x][pos.y+1]== max){
        		queue.add(new Position(pos.x,pos.y+1));
        		ret[pos.x][pos.y+1] = nextlay;
        	}
        }
        return ret;
    }
}

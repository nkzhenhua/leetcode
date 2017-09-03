import java.util.LinkedList;
import java.util.Queue;

//https://leetcode.com/problems/surrounded-regions/description/
public class SurroundedRegions {
	public static void main(String argv[]){
		char [][] board = {{'X','O','X','O','X','O'},{'O','X','O','X','O','X'},{'X','O','X','O','X','O'},{'O','X','O','X','O','X'}};
		SurroundedRegions.solve(board);
	}
	
	//stack overflow
	//start search O from the edge of the board, and tag all the Os interlinked
    public static void solve(char[][] board) {
    	if ( board == null ) return;
    	int xlen = board.length;
    	if( xlen == 0 ) return;
    	int ylen = board[0].length;
        for( int i = 0;i<xlen;i++){
        	for ( int j = 0; j< ylen; j++)
        		if( i == 0 || i == (xlen-1) || j == 0 || j == (ylen-1)){
                	spread(board, i, j);
        		}

        }
        for( int i = 0; i<xlen;i++){
        	for ( int j=0;j<ylen;j++){
        		char cur = board[i][j];
        		if( cur == 'a'){
        			board[i][j] = 'O';
        		}else if( cur == 'O' ){
        			board[i][j] = 'X';
        		}
        		System.out.print(board[i][j]);
        	}
        	System.out.println("\n");
        }
    }
    //DFS
	private static void spread(char[][] board, int px, int py) {
		if (board[px][py] != 'O') return;
		Queue<Pair> queue = new LinkedList<Pair>();
		queue.add(new Pair(px,py));
		while( !queue.isEmpty()){
			Pair position = queue.poll();
			int x = position.x;
			int y = position.y;
			if (x >= 0 && y >= 0 && x < board.length && y < board[x].length) {
				if (board[x][y] != 'O')
					continue;
				board[x][y] = 'a';
				queue.add(new Pair( x-1,  y));
				queue.add(new Pair( x+1,  y));
				queue.add(new Pair(x,  y-1));
				queue.add(new Pair( x,  y+1));
			}
		}

	}
	public static class Pair {  
	    int x;  
	    int y;  
	    Pair(int x,int y) {  
	        this.x = x;  
	        this.y = y;  
	    }  
	}  
}

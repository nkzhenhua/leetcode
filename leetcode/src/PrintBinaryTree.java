//https://leetcode.com/problems/print-binary-tree/description/
import java.util.*;
public class PrintBinaryTree {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}
    public List<List<String>> printTree(TreeNode root) {
        int height = height(root);
        if( height == 0 ) return null;
        int width = (int)Math.pow(2, height) - 1;
        List<List<String>> output = new ArrayList<List<String>>();
        for( int i = 0; i< height; i++){
        	List<String> tmp = new ArrayList<String>();
        	output.add(tmp);
        	for( int j = 0; j < width; j++ ){
        		tmp.add("");
        	}
        }
        print(root,1,0,width-1, output);
        return output;
    }
    int height(TreeNode root){
    	if( root == null ) return 0;
    	int left = height(root.left);
    	int right = height(root.right);
    	return left > right ? (left +1): (right +1);
    }
    
    void print(TreeNode root, int level, int left, int right, List<List<String>> output ){

    	ArrayList<String> curList = (ArrayList<String>)output.get(level-1);

        curList.set((left+right)/2, Integer.toString(root.val));

    	if( root.left != null ){
    		print( root.left, level+1, left, (left+right)/2-1, output);
    	}
    	if( root.right != null ){
    		print( root.right, level + 1, (left+right)/2+1, right, output);
    	}
    }
    
}

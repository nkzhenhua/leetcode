import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

//https://leetcode.com/problems/average-of-levels-in-binary-tree/description/
public class AverageofLevelsinBinaryTree {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public List<Double> averageOfLevels(TreeNode root) {
		ArrayList<Double> ret = new ArrayList<Double>();
		LinkedList<TreeNode> processq = new LinkedList<TreeNode>();
		processq.push(root);
		while( !processq.isEmpty() ){
			int num = processq.size();
			long sum = 0;
			for( int i = 0; i< num; i++){
				TreeNode cur = processq.poll();
				sum += cur.val;
				if( cur.left != null ){
					processq.add(cur.left);
				}
				if( cur.right != null ){
					processq.add(cur.right);
				}
			}
			double avg = (double)sum/num;
			ret.add(avg);
		}
		return ret;
	}

}


import java.util.LinkedList;
import java.util.Queue;

public class MyStack {
	
	private Queue<Integer> q1;
	private Queue<Integer> q2;
	private Queue<Integer> cur;
	private Queue<Integer> another;

    /** Initialize your data structure here. */
    public MyStack() {
    	q1 = new LinkedList<>();
    	q2 = new LinkedList<>();
    	cur = q1;
    	another = q2;
    }
    
    /** Push element x onto stack. */
    public void push(int x) {
        cur.add(x);
    }
    
    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
    	//pull all the elements in cur to another;
    	Integer top;
    	while( cur.size() > 1 ){
    		another.add(cur.poll());
    	}
    	top = cur.poll();
    	//switch
    	Queue<Integer> tmp = another;
    	another = cur;
    	cur = tmp;
    	return top;
    }
    
    /** Get the top element. */
    public int top() {
    	//pull all the elements in cur to another;
    	Integer top = null;
    	while( cur.size() > 0 ){
    		top = cur.poll();
    		another.add(top);
    	}
    	//switch
    	Queue<Integer> tmp = another;
    	another = cur;
    	cur = tmp;
    	return top;
    }
    
    /** Returns whether the stack is empty. */
    public boolean empty() {
        return cur.isEmpty();
    }
}

package advanced_class_02;

import java.util.LinkedList;

public class UpdateMaxWindowStructure {

	public static class MaxUpdate{
		public int[] arr;
		public int L;
		public int R;
		public LinkedList<Integer> queue;
		
		public MaxUpdate(int[] arr) {
			this.arr = arr;
			L = -1;
			R = -1;
			queue = new LinkedList<>();
		}
		
		public void AddNumFromRight() {
			// arr[R+1]
			if(R==arr.length-1) {
				return;
			}
			while(!queue.isEmpty()&&arr[queue.peekLast()] <= arr[R+1]) {
				queue.pollLast();
			}
			queue.addLast(R+1);
		}
		
		public void deleteNumFromLeft() {
			if(L == R) {
				return;
			}
			L++;
			if(!queue.isEmpty()&&queue.peekFirst() == L) {
				queue.pollFirst();
			}
		}
		
		public Integer getMax() {
			if(queue.isEmpty()) {
				return null;
			}
			return arr[queue.peekFirst()];
		}
		
		
		
	}
	
	
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

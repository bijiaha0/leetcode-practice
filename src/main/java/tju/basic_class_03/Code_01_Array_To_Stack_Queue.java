package tju.basic_class_03;
/*栈和队列
*题目：
*  用数组结构实现大小固定的队列和栈
* 栈是先入后出
* 队列是先入先出
* */
public class Code_01_Array_To_Stack_Queue {
	//用数组实现栈
	public static class ArrayStack {
		private Integer[] arr;
		private Integer index;

		public ArrayStack(int initSize) {
			if (initSize < 0) {
				throw new IllegalArgumentException("The init size is less than 0");
			}
			arr = new Integer[initSize];
			index = 0;
		}
        //获取顶部的数
		public Integer peek() {
			if (index == 0) {
				return null;
			}
			return arr[index - 1];
		}
        //加数的逻辑
		public void push(int obj) {
			if (index == arr.length) {
				throw new ArrayIndexOutOfBoundsException("The queue is full");
			}
			arr[index++] = obj;
		}
        //减数的逻辑
		public Integer pop() {
			if (index == 0) {
				throw new ArrayIndexOutOfBoundsException("The queue is empty");
			}
			return arr[--index];
		}
	}
	//用数组实现队列
	public static class ArrayQueue {
		private Integer[] arr;
		private Integer size;
		private Integer first;
		private Integer last;
		public ArrayQueue(int initSize) {
			if (initSize < 0) {
				throw new IllegalArgumentException("The init size is less than 0");
			}
			arr = new Integer[initSize];
			size = 0;
			first = 0;
			last = 0;
		}
		public Integer peek() {
			if (size == 0) {
				return null;
			}
			return arr[first];
		}
		public void push(int obj) {
			if (size == arr.length) {
				throw new ArrayIndexOutOfBoundsException("The queue is full");
			}
			size++;
			arr[last] = obj;
			last = netIndex(arr.length , last);//这里变化last的值
		}
		public Integer poll() {
			if (size == 0) {
				throw new ArrayIndexOutOfBoundsException("The queue is empty");
			}
			size--;
			int tmp = first;
			first =netIndex(arr.length , first);//这里变化first的值
			return arr[tmp];
		}
		public int netIndex(int size, int index){
            return  index == size - 1 ?  0 : index + 1;
        }
	}
	public static void main(String[] args) {
        int iniSize = 3;
        ArrayQueue myQueue = new ArrayQueue(iniSize);
        myQueue.push(12);
        myQueue.push(13);
        myQueue.push(15);
        System.out.println(myQueue.poll());
        System.out.println(myQueue.poll());
        System.out.println(myQueue.poll());
        myQueue.push(23);
        myQueue.push(24);
        System.out.println(myQueue.poll());
        System.out.println(myQueue.peek());
        int len = 13;
        ArrayStack myStack = new ArrayStack(len);
        for (int i = 0; i < len; i++) {
            myStack.push(i);
        }
        for (int i = 0; i < len; i++) {
            System.out.println(myStack.pop());
        }
    }
}

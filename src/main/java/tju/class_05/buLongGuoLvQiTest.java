package tju.class_05;
//布隆过滤器位数组
public class buLongGuoLvQiTest {
	public static void main(String[] args) {
		int[] arr = new int[10]; // 0 ~ 319 bit类型的数组
		int index = 237;
		System.out.println(index / 32);//第7个整数上
		System.out.println(index % 32);//第13位
		int res = (arr[index / 32]   >> (index % 32))  & 1;// 第7个整数向右位移13位，取到这个位上是0还是1
		arr[index / 32] = arr[index / 32]   |  ( 1 << index % 32);//1向左移动13位和原来的13的位置上的数或一下，则设置这个位上为1
	}
}

package tju.basic_class_08;
import java.util.Arrays;
import java.util.Comparator;
/*
* 给定一个字符串类型的数组strs，
* 找到一种拼接方式，使得把所有字符串拼起来之后
* 形成的字符串具有最低的字典序。
* */
public class Code_06_LowestLexicography {
	public static class MyComparator implements Comparator<String> {//自定义比较器
		@Override
		public int compare(String a, String b) {
			return (a + b).compareTo(b + a);//前面参数比后面参数小，返回负的。
		}
	}
	public static String lowestString(String[] strs) {
		if (strs == null || strs.length == 0) {
			return "";
		}
		Arrays.sort(strs, new MyComparator());//我自己传进去的比较器
		String res = "";
		for (int i = 0; i < strs.length; i++) {
			res += strs[i];//拼接
		}
		return res;
	}
	public static void main(String[] args) {
		String[] strs1 = { "jibw", "ji", "jp", "bw", "jibw" };
		System.out.println(lowestString(strs1));
		String[] strs2 = { "ba", "b" };
		System.out.println(lowestString(strs2));
	}
}

package tju.class_07;
import java.util.Arrays;
import java.util.Comparator;
//拼接字符串以达到字典序是最低的
public class LowestLexicography {
	public static class MyComparator implements Comparator<String> {
		//compareTo方法表达的意思是前一个参数更下就返回负。
		@Override
		public int compare(String str1, String str2) {			
			return (str1 + str2).compareTo(str2 + str1);//字符串拼接以后，进行比较。
		}
	}
	public static String lowestString(String[] strs) {
		if (strs == null || strs.length == 0) {
			return "";
		}
		Arrays.sort(strs, new MyComparator());
		String res = "";
		for (int i = 0; i < strs.length; i++) {
			res += strs[i];
		}
		return res;
	}
	public static void main(String[] args) {
		String[] strs1 = { "jibw", "ji", "jp", "bw", "jibw" };
		System.out.println(lowestString(strs1));
		String[] strs2 = { "ba", "b" };
		System.out.println(lowestString(strs2));
		String str1 = "abc";
		String str2 = "bcd";
		System.out.println(str1.compareTo(str2));
	}
}

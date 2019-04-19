package tju.recursion;
/*
打印一个字符串的全部子序列，包括空字符串
* */
public class Code_03_Print_All_Subsquences {
	public static void printAllSubsquence(String str) {
		char[] chs = str.toCharArray();
		process(chs, 0,"");
		System.out.println("");
	}
	public static void process(char[] chs, int index,String pre) {
		if (index == chs.length) {
			if(!pre.equals("")){
				System.out.println(pre);
			}
			return;
		}
		process(chs, index + 1,pre+String.valueOf(chs[index]));//要index上的字符
		process(chs, index + 1,pre);//不要index上的字符
	}
	public static void main(String[] args) {
		String test = "abc";
		printAllSubsquence(test);
	}

}

package advanced_class_07;
//字符串字典序最小
public class Code_01_Remove_Duplicate_Letters {
	// 假设str中都是小写字母
	public static String removeDuplicateLetters1(String s) {
		int[] cnt = new int[26];
		for (int i = 0; i < s.length(); i++) {
			cnt[s.charAt(i) - 'a']++;
		}
		int pos = 0; // 挑出来的，最小ascii字符的位置
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) < s.charAt(pos)) {
				pos = i;
			}
			if (--cnt[s.charAt(i) - 'a'] == 0) {
				break;
			}
		}
		// 0..i  pos
		// pos 位置字符被选出
		// 删掉pos之前的字符
		// pos之后的字符串，一律去掉pos位置上的字符
		return s.length() == 0 ? "" : s.charAt(pos) // 我当前选择了最小的字符作为开头
				+ removeDuplicateLetters1(
						s.substring(pos + 1).replaceAll(
								String.valueOf(s.charAt(pos)), "")
						);
	}
	public static String removeDuplicateLetters2(String str) {
		String res = "";
		char[] chas = str.toCharArray();
		int[] cnt = new int[26];
		for (int i = 0; i < chas.length; i++) {
			cnt[chas[i] - 'a']++;
		}
		int L = 0;
		int R = 0;
		while (R != chas.length) {
			if (chas[R] != 0 && --cnt[chas[R] - 'a'] == 0) {
				int choose = L;
				for (int i = L; i <= R; i++) {
					if (chas[choose] == 0
							|| (chas[i] != 0 && chas[i] < chas[choose])) {
						choose = i;
					}
				}
				res += String.valueOf(chas[choose]);
				cnt = new int[26];
				for (int i = choose + 1; i < chas.length; i++) {
					if (chas[i] == chas[choose]) {
						chas[i] = 0;
					}
					if (chas[i] != 0) {
						cnt[chas[i] - 'a']++;
					}
				}
				L = choose + 1;
				R = choose;
			}
			R++;
		}
		return res;
	}
	public static void main(String[] args) {
	}
}

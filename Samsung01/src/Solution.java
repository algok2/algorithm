
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str1 = "��su���ϼ�[],_??";
		String str2 = "��";
		String str3 = "ABCDE FGHI";
		String str4 = "��";
		String str5 = "��";
		String str7 = str1 + str2;

		System.out.println(str1);
		System.out.println(str2);
		System.out.println("str1 = "+str1.length());
		for (int i = 0; i < str3.length(); i++) {
			System.out.println("str3["+i+"] = "+str3.charAt(i));
		}
		System.out.println(str3.substring(1, 4));
		char[] cArr = str3.toCharArray();
		
		for (int i = 0; i < cArr.length; i++) {
			System.out.println(cArr[i]);			
		}
	}

}

import java.util.Arrays;

public class Inverse {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		Inverse inv = new Inverse();
		int[] base = {1,2,3,4,5,6,7,8,9};
		int[] num = {8,1,3,7,6,2,9,4,5};

		System.out.println(Arrays.toString(base));
		System.out.println(Arrays.toString(num));
		inv.invers(num);
	}
	public void invers(int[] a) {
		int N = a.length;
		int[] b = new int[N];
		for (int i = 0; i < N; i++) {
			b[a[i] -1] = i+1;
		}
		System.out.println(Arrays.toString(b));
	}
}

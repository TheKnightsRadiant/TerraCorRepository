package mainPackage;

public class Main {
	public static void main(String[] args) {
		int a = 1;
		int y = 1;
		int x = 1;
		int f = 1;

		while (a < 100) {
			System.out.println("" + f);
			f = x + y;
			y = x;
			x = f;
			a++;
		}
	}
}
public class Main
{
	public static void main(String[] args) {
		System.out.println("Hello World");
		
		String[] languages = {"C", "C++", "C#", "Python", "Go", "Rust", "JavaScript", "PHP", "Swift", "Java"};
		
		int n = (int) (Math.random() * 1_000_000);
		
		n=n*3;
		n=n+0b10101;
		n=n+0xFF;
		n=n*6;
		
		int result=sumaC(n);
		System.out.println("Willy-nilly, this semester I will learn " + languages[result] + ".");
		System.out.println(result);
	}
	
	private static int sumaC(int num) {
        while (num >= 10) {
            int sum = 0;
            while (num > 0) {
                sum += num % 10;
                num /= 10;
            }
            num = sum;
        }
        return num;
    }
}


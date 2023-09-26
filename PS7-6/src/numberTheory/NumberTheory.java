package numberTheory;

import java.util.Scanner;

public class NumberTheory {
	public static void main(String args[]) {
//		Scanner scan = new Scanner(System.in);
//		String nextLine;
//		String type;
//		Long num1;
//		Long num2;
//		Long num3;
//		while (scan.hasNext()) {
//			nextLine = scan.nextLine();
//			type = nextLine.substring(0, nextLine.indexOf(' '));
//			nextLine = nextLine.substring(nextLine.indexOf(' ') + 1, nextLine.length());
//			switch (type) {
//			case "gcd":
//				num1 = Long.parseLong(nextLine.substring(0, nextLine.indexOf(' ')));
//				nextLine = nextLine.substring(nextLine.indexOf(' ') + 1, nextLine.length());
//				num2 = Long.parseLong(nextLine.substring(0, nextLine.length()));
//				System.out.println(gcd(num1, num2));
//				break;
//			case "exp":
//				num1 = Long.parseLong(nextLine.substring(0, nextLine.indexOf(' ')));
//				nextLine = nextLine.substring(nextLine.indexOf(' ') + 1, nextLine.length());
//				num2 = Long.parseLong(nextLine.substring(0, nextLine.indexOf(' ')));
//				num3 = Long.parseLong(nextLine.substring(nextLine.indexOf(' ') + 1, nextLine.length()));
//				System.out.println(exp(num1, num2, num3));
//				break;
//			case "inverse":
//				num1 = Long.parseLong(nextLine.substring(0, nextLine.indexOf(' ')));
//				nextLine = nextLine.substring(nextLine.indexOf(' ') + 1, nextLine.length());
//				num2 = Long.parseLong(nextLine.substring(0, nextLine.length()));
//				Long temp = inverse(num1, num2);
//				if (temp < 0)
//					System.out.println("none");
//				else
//					System.out.println(temp);
//				break;
//			case "isprime":
//				num1 = Long.parseLong(nextLine.substring(0, nextLine.length()));
//				System.out.println(isprime(num1));
//				break;
//			case "key":
//				num1 = Long.parseLong(nextLine.substring(0, nextLine.indexOf(' ')));
//				nextLine = nextLine.substring(nextLine.indexOf(' ') + 1, nextLine.length());
//				num2 = Long.parseLong(nextLine.substring(0, nextLine.length()));
//				System.out.println(key(num1, num2));
//				break;
//			}
//		}
//		scan.close();
		test("gcd 6 15");
		test("gcd 2 13");
		test("exp 6 5 7");
		test("inverse 7 13");
		test("inverse 6 9");
		test("isprime 13");
		test("isprime 10");
		test("key 2 7");
		test("key 5 3");
	}

	public static void test(String nextLine) {
		String type;
		Long num1;
		Long num2;
		Long num3;
		type = nextLine.substring(0, nextLine.indexOf(' '));
		nextLine = nextLine.substring(nextLine.indexOf(' ') + 1, nextLine.length());
		switch (type) {
		case "gcd":
			num1 = Long.parseLong(nextLine.substring(0, nextLine.indexOf(' ')));
			nextLine = nextLine.substring(nextLine.indexOf(' ') + 1, nextLine.length());
			num2 = Long.parseLong(nextLine.substring(0, nextLine.length()));
			System.out.println(gcd(num1, num2));
			break;
		case "exp":
			num1 = Long.parseLong(nextLine.substring(0, nextLine.indexOf(' ')));
			nextLine = nextLine.substring(nextLine.indexOf(' ') + 1, nextLine.length());
			num2 = Long.parseLong(nextLine.substring(0, nextLine.indexOf(' ')));
			num3 = Long.parseLong(nextLine.substring(nextLine.indexOf(' ') + 1, nextLine.length()));
			System.out.println(exp(num1, num2, num3));
			break;
		case "inverse":
			num1 = Long.parseLong(nextLine.substring(0, nextLine.indexOf(' ')));
			nextLine = nextLine.substring(nextLine.indexOf(' ') + 1, nextLine.length());
			num2 = Long.parseLong(nextLine.substring(0, nextLine.length()));
			Long temp = inverse(num1, num2);
			if (temp < 0)
				System.out.println("none");
			else
				System.out.println(temp);
			break;
		case "isprime":
			num1 = Long.parseLong(nextLine.substring(0, nextLine.length()));
			System.out.println(isprime(num1));
			break;
		case "key":
			num1 = Long.parseLong(nextLine.substring(0, nextLine.indexOf(' ')));
			nextLine = nextLine.substring(nextLine.indexOf(' ') + 1, nextLine.length());
			num2 = Long.parseLong(nextLine.substring(0, nextLine.length()));
			System.out.println(key(num1, num2));
			break;
		}
	}

	private static Long gcd(Long num1, Long num2) {
		if (num2 == 0) 
			return num1;
		else
			return gcd(num2, num1 % num2);
	}

	private static Long exp(Long A, Long B, Long C) {
		if (A == 0)
			return (long) 0;
		if (B == 0)
			return (long) 1;
		long y;
		if (B % 2 == 0) {
			y = exp(A, B / 2, C);
			y = (y * y) % C;
		} else {
			y = A % C;
			y = (y * exp(A, B - 1, C) % C) % C;
		}
		return ((y + C) % C);
	}

	private static Long inverse(Long a, Long prime) {
		a = a % prime;
		for (Long x = (long) 1; x < prime; x++)
			if ((a * x) % prime == 1)
				return x;

		return (long) -1;
	}

	private static String isprime(Long n) {
		if (n <= 1)
			return "no";
		if (n <= 3)
			return "yes";

		if (n % 2 == 0 || n % 3 == 0)
			return "no";

		for (int i = 5; i * i <= n; i = i + 6)
			if (n % i == 0 || n % (i + 2) == 0)
				return "no";

		return "yes";
	}

	private static String key(long a, long b) {
		long N = a * b;
		long x = (a - 1) * (b - 1);
		long e = 0;
		for (long i = 2; i <= x; i++) {
			if (gcd(i, x) == 1) {
				e = i;
				break;
			}
		}
		long d = inverse(e, x);
		return N + " " + e + " " + d;
	}
}

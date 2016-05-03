import java.io.*;

public class Main {
	public static void main(String args[]) throws IOException {
		int testCase = 1;
		String line;
		StringBuilder answer = new StringBuilder();
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		while ((line = in.readLine()) != null) {
			int z, i, m, l, slow, fast, length;
			String[] numbers = line.split(" ");
			if (numbers.length != 4)
				break;
			z = Integer.parseInt(numbers[0]);
			i = Integer.parseInt(numbers[1]);
			m = Integer.parseInt(numbers[2]);
			l = Integer.parseInt(numbers[3]);
			if (z == 0 && i == 0 && m == 0 && l == 0)
				break;
			slow = nextRandom(z, i, m, l);
			fast = nextRandom(z, i, m, slow);
			while (slow != fast) {
				slow = nextRandom(z, i, m, slow);
				fast = nextRandom(z, i, m, nextRandom(z, i, m, fast));
			}
			length = 1;
			fast = nextRandom(z, i, m, slow);
			while (slow != fast) {
				fast = nextRandom(z, i, m, fast);
				++length;
			}
			answer.append("Case " + testCase + ": " + length + "\n");
			++testCase;
		}
		System.out.print(answer);
	}

	public static int nextRandom(int z, int i, int m, int l)
	{
		return (z * l + i) % m;
	}
}

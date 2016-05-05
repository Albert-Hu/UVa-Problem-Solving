import java.io.*;
import java.util.Arrays;

public class Main {
	public static void main(String args[]) throws IOException {
		int n;
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(in.readLine());
		while (n-- > 0) {
			String line = in.readLine();
			StringBuilder answer = new StringBuilder();
			char[] string = line.toCharArray();
			char[] stack = new char[string.length];
			boolean[] used = new boolean[string.length];
			Arrays.sort(string);
			generate(answer, string, stack, 0, used);
			System.out.println(answer);
		}
	}

	public static void generate(StringBuilder answer, char[] string, char[] stack, int stackIndex, boolean[] used) {
		if (stackIndex == string.length) {
			answer.append(new String(stack));
			answer.append('\n');
			return;
		}
		for (int i = 0; i < string.length; ++i) {
			if (used[i])
				continue;
			if ((i < (string.length - 1)) && (string[i] == string[i + 1] && used[i + 1])) {
				continue;
			}
			used[i] = true;
			stack[stackIndex] = string[i];
			generate(answer, string, stack, stackIndex + 1, used);
			used[i] = false;
		}
	}
}

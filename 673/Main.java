import java.io.*;

public class Main {
	public static void main(String args[]) throws IOException {
		int n;
		char[] stack = new char[128];
		String line;
		StringBuilder answer = new StringBuilder();
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(in.readLine());
		while (n-- > 0) {
			int i = 0, s = -1;
			line = in.readLine();
			while (i < line.length()) {
				if (line.charAt(i) == '[' || line.charAt(i) == '(') {
					++s;
					stack[s] = line.charAt(i);
				} else {
					if (s < 0 || (line.charAt(i) == ']' && stack[s] != '[') || (line.charAt(i) == ')' && stack[s] != '(')) {
						break;
					}
					--s;
				}
				++i;
			}
			answer.append((s == -1 && i == line.length()) ? "Yes\n" : "No\n");
		}
		System.out.print(answer);
	}
}

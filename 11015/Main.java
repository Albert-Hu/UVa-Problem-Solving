import java.io.*;

public class Main {
	final static int MAX_DISTANCE = 1000;
	public static void main(String args[]) throws IOException {
		int testCase = 1;
		String line;
		StringBuilder answer = new StringBuilder();
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		while ((line = in.readLine()) != null) {
			String[] sp = line.split(" ");
			int n = Integer.parseInt(sp[0]);
			int m = Integer.parseInt(sp[1]);
			if (n == 0)
				break;
			int[][] distance = new int[n][n];
			String[] name = new String[n];
			for (int i = 0; i < n; ++i) {
				name[i] = in.readLine();
				for (int j = 0; j < n; ++j) {
					distance[i][j] = (i == j) ? 0 : MAX_DISTANCE;
				}
			}
			while (m-- > 0) {
				line = in.readLine();
				sp = line.split(" ");
				int i = Integer.parseInt(sp[0]) - 1;
				int j = Integer.parseInt(sp[1]) - 1;
				int k = Integer.parseInt(sp[2]);
				distance[i][j] = distance[j][i] = k;
			}
			for (int k = 0; k < n; ++k) {
				for (int i = 0; i < n; ++i) {
					for (int j = 0; j < n; ++j) {
						if (distance[i][j] > (distance[i][k] + distance[k][j])) {
							distance[i][j] = distance[i][k] + distance[k][j];
						}
					}
				}
			}
			int min = Integer.MAX_VALUE;
			int index = 0;
			for (int i = 0; i < n; ++i) {
				int sum = 0;
				for (int j = 0; j < n; ++j) {
					sum += distance[i][j];
				}
				if (sum < min) {
					index = i;
					min = sum;
				}
			}
			answer.append("Case #");
			answer.append(Integer.toString(testCase));
			answer.append(" : ");
			answer.append(name[index]);
			answer.append("\n");
			++testCase;
		}
		System.out.print(answer);
	}
}

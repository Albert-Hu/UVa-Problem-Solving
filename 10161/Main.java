import java.io.*;

public class Main {
	public static void main(String args[]) throws IOException {
		String line;
		StringBuilder answer = new StringBuilder();
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		while ((line = in.readLine()) != null) {
			int step;
			int sqrt;
			int m, x, y;
			step = Integer.parseInt(line);
			if (step == 0)
				break;
			sqrt = (int) Math.sqrt((double) step);
			if ((sqrt * sqrt) != step)
				++sqrt;
			m = (sqrt * sqrt) - (sqrt - 1);
			if ((sqrt % 2) == 0) {
				if (step > m) {
					answer.append(Integer.toString(sqrt) + " " + Integer.toString(sqrt - (step - m)) + "\n");
				} else {
					answer.append(Integer.toString(sqrt - (m - step)) + " " + Integer.toString(sqrt) + "\n");
				}
			} else {
				if (step > m) {
					answer.append(Integer.toString(sqrt - (step - m)) + " " + Integer.toString(sqrt) + "\n");
				} else {
					answer.append(Integer.toString(sqrt) + " " + Integer.toString(sqrt - (m - step)) + "\n");
				}
			}
		}
		System.out.print(answer);
	}
}

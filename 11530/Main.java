import java.io.*;

public class Main {
   final static int[] pressTimes = {
      1, 2, 3,
      1, 2, 3,
      1, 2, 3,
      1, 2, 3,
      1, 2, 3,
      1, 2, 3, 4,
      1, 2, 3,
      1, 2, 3, 4
   };
   public static void main(String args[]) throws IOException {
      String answer = "";
      BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
      BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

      int n = Integer.parseInt(in.readLine());
      for (int testCase = 1; testCase <= n; testCase++) {
         int count = 0;
         String line = in.readLine();
         for (int i = 0; i < line.length(); i++) {
            char c = line.charAt(i);
            if (c == ' ') {
               ++count;
            } else {
               count += pressTimes[c - 'a'];
            }
         }
         answer += ("Case #" + Integer.toString(testCase) + ": " + Integer.toString(count) + "\n");
      }
      out.write(answer);
      out.flush();
   }
}

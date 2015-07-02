import java.io.*;

public class Main {
   public static void main(String args[]) throws IOException {
      StringBuilder answer = new StringBuilder();
      BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
      int t = Integer.parseInt(in.readLine());

      while (t-- > 0) {
         int checksum = 0;
         String input = in.readLine();
         for (int i = 0, j = 0; i < input.length(); i++, j++) {
            if (input.charAt(i) == ' ') {
               --j;
               continue;
            }
            int n = input.charAt(i) - '0';
            if (j % 2 == 0) {
               n += n;
               checksum += ((n / 10) + (n % 10));
            } else {
               checksum += n;
            }
         }
         answer.append((checksum % 10 == 0) ? "Valid\n" : "Invalid\n");
      }
      System.out.print(answer);
   }
}

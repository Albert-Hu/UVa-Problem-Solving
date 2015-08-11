import java.io.*;

public class Main {
   public static void main(String args[]) throws IOException {
      boolean[] prime = new boolean[2002];
      StringBuilder answer = new StringBuilder();
      BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
      int testCase = Integer.parseInt(in.readLine());

      for (int i = 3; i < prime.length; i += 2)
         prime[i] = true;

      prime[2] = true;
      for (int i = 3; i * i < prime.length; i++) {
         for (int j = 3; j * i < prime.length; j++) {
            prime[j * i] = false;
         }
      }

      for (int t = 1; t <= testCase; t++) {
         boolean empty = true;
         int[] count = new int[128];
         String line = in.readLine();

         answer.append("Case ");
         answer.append(Integer.toString(t));
         answer.append(": ");

         for (int i = 0; i < line.length(); i++) {
            int index = line.charAt(i);
            ++count[index];
         }

         for (int i = 32; i < 128; i++) {
            if (prime[count[i]]) {
               empty = false;
               answer.append((char) i);
            }
         }
         answer.append(empty ? "empty\n" : "\n");
      }
      System.out.print(answer);
   }
}

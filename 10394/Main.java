import java.io.*;

public class Main {
   public static void main(String args[]) throws IOException {
      int[] prime = new int[100000];
      boolean[] isPrime = new boolean[20000000];
      String line;
      StringBuilder answer = new StringBuilder();
      BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

      for (int i = 3; i < isPrime.length; i += 2) {
         isPrime[i] = true;
      }

      for (int i = 3; i * i < isPrime.length; i += 2) {
         for (int j = i; j * i < isPrime.length; j += 2) {
            isPrime[j * i] = false;
         }
      }

      for (int index = 0, pre = 3, i = 5; i < isPrime.length && index < prime.length; i += 2) {
         if (isPrime[i]) {
            if ((i - pre) == 2) {
               prime[index++] = pre;
            }
            pre = i;
         }
      }

      while ((line = in.readLine()) != null) {
         int s = Integer.parseInt(line) - 1;
         answer.append('(');
         answer.append(Integer.toString(prime[s]));
         answer.append(", ");
         answer.append(Integer.toString(prime[s] + 2));
         answer.append(")\n");
      }
      System.out.print(answer);
   }
}

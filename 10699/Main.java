import java.io.*;
import java.util.*;

public class Main {
   public static void main(String args[]) throws IOException {
      boolean[] isPrime = new boolean[1000000];
      ArrayList<Integer> prime = new ArrayList<Integer>();
      String line;
      StringBuilder answer = new StringBuilder();
      BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

      for (int i = 3; i < 1000000; i += 2)
         isPrime[i] = true;

      for (int i = 3; i * i < 1000000; i += 2) {
         for (int j = i; i * j < 1000000; j += 2) {
            isPrime[i * j] = false;
         }
      }

      prime.add(2);
      for (int i = 3; i < 1000000; i += 2) {
         if (isPrime[i]) prime.add(i);
      }

      while ((line = in.readLine()) != null) {
         int n = Integer.parseInt(line);
         if (n == 0) break;
         answer.append(Integer.toString(n));
         answer.append(" : ");
         int count = 0;
         for (int i = 0; i < prime.size(); i++) {
            int p = prime.get(i);
            if (n < p) break;
            if (n % p == 0) {
               n /= p;
               ++count;
            }
         }
         answer.append(Integer.toString(count));
         answer.append('\n');
      }
      System.out.print(answer);
   }
}

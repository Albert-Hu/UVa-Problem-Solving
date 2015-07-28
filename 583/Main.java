import java.io.*;
import java.util.*;

public class Main {
   public static void main(String args[]) throws IOException {
      boolean[] isPrime = new boolean[46340];
      ArrayList<Integer> prime = new ArrayList<Integer>();
      String line;
      StringBuilder answer = new StringBuilder();
      BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

      for (int i = 3; i < 46340; i += 2) {
         isPrime[i] = true;
      }

      for (int i = 3; i * i < 46340; i += 2) {
         for (int j = 3; i * j < 46340; j += 2) {
            isPrime[i * j] = false;
         }
      }

      prime.add(2);
      for (int i = 3; i < 46340; i += 2) {
         if (isPrime[i]) prime.add(i);
      }

      while ((line = in.readLine()) != null) {
         int n = Integer.parseInt(line);
         boolean x = false;
         if (n == 0) break;

         answer.append(line);
         answer.append(" =");
         if (n < 0) {
            x = true;
            n = -n;
            answer.append(" -1");
         }
         for (int i = 0; i < prime.size(); i++) {
            int p = prime.get(i);
            if (n < p) break;
            String s = Integer.toString(p);
            while (n % p == 0) {
               if (x) {
                  answer.append(" x ");
               } else {
                  answer.append(" ");
                  x = true;
               }
               answer.append(s);
               n /= p;
            }
         }
         if (n > 1) {
            if (x) answer.append(" x ");
            else answer.append(" ");
            answer.append(Integer.toString(n));
         }
         answer.append('\n');
      }
      System.out.print(answer);
   }
}

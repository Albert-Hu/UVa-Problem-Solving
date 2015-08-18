import java.io.*;
import java.util.*;

public class Main {
   public static void main(String args[]) throws IOException {
      String line;
      StringBuilder answer = new StringBuilder();
      BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
      boolean[] isPrime = new boolean[10002];
      ArrayList<Integer> prime = new ArrayList<Integer>();

      isPrime[2] = true;
      for (int i = 3; i < isPrime.length; i += 2) {
         isPrime[i] = true;
      }

      for (int i = 3; i * i < isPrime.length; i += 2) {
         for (int j = i; j * i < isPrime.length; j += 2) {
            isPrime[j * i] = false;
         }
      }

      prime.add(2);
      for (int i = 3; i < isPrime.length; i += 2) {
         if (isPrime[i]) {
            prime.add(i);
         }
      }

      for (int i = 0; i < isPrime.length; i++) {
         int n = i * i + i + 41;
         if (n < isPrime.length) {
            isPrime[i] = isPrime[n];
         } else {
            isPrime[i] = true;
            for (int j = 0; j < prime.size(); j++) {
               int p = prime.get(j);
               if (n < p) break;
               if (n % p == 0) {
                  isPrime[i] = (n == p);
                  break;
               }
            }
         }
      }

      prime.clear();
      prime.add(1);
      for (int i = 1; i < isPrime.length; i++) {
         prime.add((prime.get(i - 1) + (isPrime[i] ? 1 : 0)));
      }

      while ((line = in.readLine()) != null) {
         StringTokenizer tokenizer = new StringTokenizer(line);
         int a = Integer.parseInt(tokenizer.nextToken());
         int b = Integer.parseInt(tokenizer.nextToken());
         double result = (((prime.get(b) - prime.get(a)) + (isPrime[a] ? 1 : 0)) * 100.0) / (b - a + 1);

         answer.append(String.format("%.2f\n", result));
      }
      System.out.print(answer);
   }
}

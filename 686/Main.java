import java.io.*;
import java.util.*;

public class Main {
   public static void main(String args[]) throws IOException {
      boolean[] primeTable = new boolean[32768];
      String line;
      StringBuilder answer = new StringBuilder();
      ArrayList<Integer> prime = new ArrayList<Integer>();
      BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

      primeTable[2] = true;
      for (int i = 3; i < primeTable.length; i += 2)
         primeTable[i] = true;

      for (int i = 3; i * i < 32768; i += 2) {
         for (int j = i; i * j < 32768; j += 2) {
            primeTable[i * j] = false;
         }
      }

      prime.add(2);
      for (int i = 3; i < 32768; i += 2) {
         if (primeTable[i]) prime.add(i);
      }

      while ((line = in.readLine()) != null) {
         int n = Integer.parseInt(line);
         int count = 0;
         if (n == 0) break;
         for (int i = 0; i < prime.size(); i++) {
            int p = prime.get(i);
            if ((p * 2) > n) break;
            count += primeTable[(n - p)] ? 1 : 0;
         }
         answer.append(Integer.toString(count));
         answer.append('\n');
      }
      System.out.print(answer);
   }
}

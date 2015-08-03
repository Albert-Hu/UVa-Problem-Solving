import java.io.*;
import java.util.*;

public class Main {
   public static void main(String args[]) throws IOException {
      int testCase = 1;
      String line;
      StringBuilder answer = new StringBuilder();
      BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

      while ((line = in.readLine()) != null) {
         if (line.charAt(0) == '0') break;

         StringTokenizer tokenizer = new StringTokenizer(line);
         String n = tokenizer.nextToken();
         String binaryString = tokenizer.nextToken();

         answer.append("Case ");
         answer.append(Integer.toString(testCase));
         answer.append(": ");
         answer.append(Integer.toString(countTriple(binaryString, 0, 0)));
         answer.append('\n');
         ++testCase;
      }
      System.out.print(answer);
   }

   public static int countTriple(String binaryString, int binary, int n) {
      for (int bit = n / 3; bit > 0; bit--) {
         if (isTripleFree(binary, bit))
         return 0;
      }

      if (n == binaryString.length())
         return 1;

      if (binaryString.charAt(n) == '*')
         return countTriple(binaryString, binary << 1, n + 1) + countTriple(binaryString, (binary << 1) + 1, n + 1);

      if (binaryString.charAt(n) == '0')
         return countTriple(binaryString, binary << 1, n + 1);
      else
         return countTriple(binaryString, (binary << 1) + 1, n + 1);
   }

   public static boolean isTripleFree(int binary, int bit) {
      int[] t = new int[2];
      int mask = (1 << bit) - 1;

      t[0] = binary & mask;
      binary >>= bit;
      t[1] = binary & mask;
      binary >>= bit;
      binary &= mask;

      return (t[0] == t[1] && t[1] == binary);
   }
}

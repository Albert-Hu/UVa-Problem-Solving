import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
   public static void main(String args[]) throws IOException {
      String line;
      StringBuilder answer = new StringBuilder();
      BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
      int n = Integer.parseInt(in.readLine());

      while (n-- > 0) {
         StringTokenizer tokenizer = new StringTokenizer(in.readLine());
         int begin, end;
         String a = tokenizer.nextToken();
         String b = tokenizer.nextToken();

         begin = 0;
         end = a.length() - 1;
         while (a.charAt(begin) == '0' && begin < end) ++begin;
         while (a.charAt(end) == '0' && end > 0) --end;
         a = a.substring(begin, end + 1);
         a = new StringBuilder(a).reverse().toString();

         begin = 0;
         end = b.length() - 1;
         while (b.charAt(begin) == '0' && begin < end) ++begin;
         while (b.charAt(end) == '0' && end > 0) --end;
         b = b.substring(begin, end + 1);
         b = new StringBuilder(b).reverse().toString();

         BigInteger result = new BigInteger(a).add(new BigInteger(b));
         String output = result.toString();

         end = output.length() - 1;
         while (output.charAt(end) == '0' && end > 0) --end;
         output = new StringBuilder(output.substring(0, end + 1)).reverse().toString();

         answer.append(output);
         answer.append('\n');
      }
      System.out.print(answer);
   }
}

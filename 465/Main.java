import java.io.*;
import java.util.*;

public class Main {
   public static void main(String args[]) throws IOException {
      String line;
      StringTokenizer tokenizer;
      BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

      while ((line = in.readLine()) != null) {
         System.out.println(line);
         tokenizer = new StringTokenizer(line);
         double a = Double.parseDouble(tokenizer.nextToken());
         char operator = tokenizer.nextToken().charAt(0);
         double b = Double.parseDouble(tokenizer.nextToken());
         if (a > Integer.MAX_VALUE) System.out.println("first number too big");
         if (b > Integer.MAX_VALUE) System.out.println("second number too big");
         if (operator == '+' && (a + b) > Integer.MAX_VALUE)
            System.out.println("result too big");
         if (operator == '*' && (a * b) > Integer.MAX_VALUE)
            System.out.println("result too big");
      }
   }
}

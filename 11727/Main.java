import java.io.*;
import java.util.*;

public class Main {
   public static void main(String args[]) throws IOException {
      BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
      int n = Integer.parseInt(in.readLine());
      for (int testCase = 1; testCase <= n; testCase++) {
         StringTokenizer tokenizer = new StringTokenizer(in.readLine());
         int a = Integer.parseInt(tokenizer.nextToken());
         int b = Integer.parseInt(tokenizer.nextToken());
         int c = Integer.parseInt(tokenizer.nextToken());
         if (((a > b)&&(a < c)) || ((a < b)&&(a > c))) {
            System.out.println("Case " + testCase + ": " + a);
         } else if (((b > a)&&(b < c)) || ((b < a)&&(b > c))) {
            System.out.println("Case " + testCase + ": " + b);
         } else {
            System.out.println("Case " + testCase + ": " + c);
         }
      }
   }
}

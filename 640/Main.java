import java.io.*;

public class Main {
   final static int MAX_NUMBER = 1000001;

   public static void main(String args[]) throws IOException {
      boolean[] isGenerator = new boolean[MAX_NUMBER];
      StringBuilder answer = new StringBuilder();

      for (int i = 1; i < isGenerator.length; ++i) {
         int n = generate(i);
         if (n >= isGenerator.length)
            break;
         while (!isGenerator[n]) {
            isGenerator[n] = true;
            n = generate(n);
            if (n >= isGenerator.length)
               break;
         }
      }

      for (int i = 1; i < isGenerator.length; ++i) {
         if (!isGenerator[i]) {
            answer.append(Integer.toString(i));
            answer.append('\n');
         }
      }

      System.out.print(answer);
   }

   public static int generate(int n) {
      int sum = n;

      while (n > 0) {
         sum += (n % 10);
         n /= 10;
      }

      return sum;
   }
}

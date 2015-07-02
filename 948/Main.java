import java.io.*;

public class Main {
   final static int[] fib = {
              1,               2,               3,               5,               8,
             13,              21,              34,              55,              89,
            144,             233,             377,             610,             987,
           1597,            2584,            4181,            6765,           10946,
          17711,           28657,           46368,           75025,          121393,
         196418,          317811,          514229,          832040,         1346269,
        2178309,         3524578,         5702887,         9227465,        14930352,
       24157817,        39088169,        63245986,       102334155,       165580141,
      267914296,       433494437,       701408733
   };

   public static void main(String args[]) throws IOException {
      StringBuilder answer = new StringBuilder();
      BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
      int t = Integer.parseInt(in.readLine());

      while (t-- > 0) {
         String input = in.readLine();
         int start = fib.length - 1;
         int f = Integer.parseInt(input);
         answer.append(input);
         answer.append(" = ");
         while (fib[start] > f) --start;
         while (start >= 0) {
            if (fib[start] <= f) {
               answer.append('1');
               f -= fib[start];
            } else {
               answer.append('0');
            }
            --start;
         }
         answer.append(" (fib)\n");
      }
      System.out.print(answer);
   }
}

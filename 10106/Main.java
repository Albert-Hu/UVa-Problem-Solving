import java.io.*;
import java.math.*;

public class Main {
   public static void main(String args[]) throws IOException {
      String[] input = new String[2];
      StringBuilder output = new StringBuilder();
      BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

      while ((input[0] = in.readLine()) != null) {
         input[1] = in.readLine();
         BigInteger a = new BigInteger(input[0]);
         BigInteger b = new BigInteger(input[1]);
         output.append(a.multiply(b).toString());
         output.append('\n');
      }
      System.out.print(output);
   }
}

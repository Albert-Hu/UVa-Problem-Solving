import java.io.*;

public class Main {
   public static void main(String args[]) throws IOException {
      char[] output = new char[104];
      String line;
      BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

      for (int i = 0; i < output.length; i++) {
         output[i] = '0';
      }

      while ((line = in.readLine()) != null) {
         int carry = 0;
         int length = output.length - 1;
         for (int i = line.length() - 1; i >= 0; i--, length--) {
            int sum = (line.charAt(i) - (int) '0') + (output[length] - (int) '0') + carry;
            if (sum >= 10) {
               carry = 1;
               sum -= 10;
            } else {
               carry = 0;
            }
            output[length] = (char) (sum + '0');
         }
         while (length > 0 && carry > 0) {
            int sum = (output[length] - (int) '0') + carry;
            if (sum >= 10) {
               carry = 1;
               sum -= 10;
            } else {
               carry = 0;
            }
            output[length] = (char) (sum + '0');
            --length;
         }
      }
      int length = 0;
      while (output[length] == '0') ++length;
      System.out.println(String.valueOf(output, length, (output.length - length)));
   }
}

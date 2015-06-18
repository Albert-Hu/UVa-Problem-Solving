import java.io.*;

public class Main {
   public static void main(String args[]) throws IOException {
      boolean newLine = false;
      String line;
      String answer = "";
      BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

      while ((line = in.readLine()) != null) {
         if (newLine)
            answer += "\n";
         else
            newLine = true;

         int tmp;
         int length = line.length();
         int sum_odd = 0, sum_even = 0;
         int multiple4, multiple400, multiple100;
         boolean isLeap = false, isOrdinary = true;

         for (int i = 0; i < length; i++) {
            if ((i & 1) == 1) {
               sum_odd += (line.charAt(i) - '0');
            } else {
               sum_even += (line.charAt(i) - '0');
            }
         }
         multiple4 = ((line.charAt(length - 2) - '0') * 10) + (line.charAt(length - 1) - '0');
         multiple400 = ((line.charAt(length - 4) - '0') * 10) + (line.charAt(length - 3) - '0');
         multiple100 = (line.charAt(length - 2) - '0') + (line.charAt(length - 1) - '0');
         if ((multiple4 % 4 == 0 && multiple100 != 0) || (multiple400 % 4 == 0 && multiple100 == 0)) {
            answer += "This is leap year.\n";
            isLeap = true;
            isOrdinary = false;
         }
         tmp = line.charAt(length - 1) - '0';
         if (((sum_odd + sum_even) % 3 == 0) && (tmp == 0 || tmp == 5)) {
            answer += "This is huluculu festival year.\n";
            isOrdinary = false;
         }
         if (((sum_odd - sum_even) % 11) == 0 && (tmp == 0 || tmp == 5) && isLeap) {
            answer += "This is bulukulu festival year.\n";
            isOrdinary = false;
         }
         if (isOrdinary) {
            answer += "This is an ordinary year.\n";
         }
      }
      System.out.print(answer);
   }
}

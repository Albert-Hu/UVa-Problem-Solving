import java.io.*;

public class Main {
   final static boolean[] happyTable = {
      false,true,false,false,false,false,false,true,false,false,true,false,false,true,false,false,false,false,false,true,false,false,false,true,false,false,false,false,true,false,
      false,true,true,false,false,false,false,false,false,false,false,false,false,false,true,false,false,false,false,true,false,false,false,false,false,false,false,false,false,false,
      false,false,false,false,false,false,false,false,true,false,true,false,false,false,false,false,false,false,false,true,false,false,true,false,false,false,true,false,false,false,
      false,true,false,false,true,false,false,true,false,false,true,false,false,true,false,false,false,false,false,true,false,false,false,false,false,false,false,false,false,false,
      false,false,false,false,false,false,false,false,false,true,true,false,false,true,false,false,false,false,false,true,false,false,false,false,false,false,false,false,false,false,
      false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,true,false,false,false,false,false,false,false,false,true,false,false,false,
      false,false,false,false,false,false,false,false,true,false,true,false,true,true,false,false,false,false,false,false,false,false,false,true,false,false,false,false,true,false,
      false,false,false,false,false,false,false,false,false,true,false,false,false,false,false,false,true,false,false,false,true,false,false,false,false,false,true,false,false,true,
      false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,true,true,false,false,false,false,false,false,
      false,false,false,false,false,false,false,false,false,false,true,false,false,false,false,false,false,false,false,false,false,true,false,true,false,false,false,false,false,false,
      false,true,true,false,false,false,false,false,false,false,true,false,false,true,false,false,false,false,false,true,true,false,false,false,false,false,true,false,false,true,
      false,true,false,false,false,false,false,false,true,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,true,false,false,false,
      false,false,true,false,false,true,false,true,true,false,false,false,false,false,false,false,true,false,false,true,false,false,false,true,false,false,true,false,false,false,
      false,true,true,false,false,false,false,true,false,false,false,false,false,false,true,false,false,false,false,true,false,false,false,false,false,false,false,false,false,false,
      false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,true,false,false,false,false,false,true,false,false,false,
      false,false,false,false,false,false,false,false,false,false,false,false,false,false,true,false,false,false,false,true,false,false,false,false,false,false,false,false,true,false,
      false,false,false,false,false,false,false,true,false,false,true,false,false,false,false,false,true,false,false,false,false,false,false,false,false,false,false,false,false,false,
      false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,true,false,false,false,
      false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,true,false,false,false,false,false,false,true,false,true,true,false,false,false,
      false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,
      false,false,false,false,false,false,false,false,true,false,false,false,false,false,false,false,false,true,false,false,false,false,true,true,false,false,false,false,false,false,
      false,false,true,false,false,true,false,true,true,false,false,false,false,false,true,false,false,false,false,true,false,false,false,true,false,true,true,false,false,false,
      false,false,false,false,false,true,false,false,false,false,false,true,false,true,false,false,false,false,false,false,true,false,false,true,false,false,false,false,false,false,
      false,false,false,false,true,false,false,false,false,false,true,false,false,false,false,false,false,false,false,true,false,false,false,false,false,false,true,false,false,false,
      false,false,false,false,false,false,false,false,false,false
   };

   public static void main(String args[]) throws IOException {
      BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
      int n = Integer.parseInt(in.readLine());

      for (int testCase = 1; testCase <= n; testCase++) {
         int number = Integer.parseInt(in.readLine());
         int tmp = number;
         int sum = 0;
         while (tmp > 0) {
            int d = tmp % 10;
            sum += (d * d);
            tmp /= 10;
         }
         if (happyTable[sum]) {
            System.out.println("Case #" + testCase + ": " + number + " is a Happy number.");
         } else {
            System.out.println("Case #" + testCase + ": " + number + " is an Unhappy number.");
         }
      }
   }
}

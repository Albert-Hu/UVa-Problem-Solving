import java.io.*;
import java.util.*;

public class Main {
   public static void main(String args[]) throws IOException {
      String line;
      StringBuilder answer = new StringBuilder();
      BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
      int testCase = Integer.parseInt(in.readLine());

      for (int t = 1; t <= testCase; t++) {
         int[] leap_days = new int[2];
         int[] year = new int[2];
         int[] day = new int[2];
         String[] month = new String[2];

         for (int i = 0; i < 2; i++) {
            StringTokenizer tokenizer = new StringTokenizer(in.readLine());
            month[i] = tokenizer.nextToken();
            day[i] = Integer.parseInt(tokenizer.nextToken(", "));
            year[i] = Integer.parseInt(tokenizer.nextToken());
            leap_days[i] = (year[i] / 4) - (year[i] / 100) + (year[i] / 400);
         }

         if (isLeapYear(year[0]) && (isJanuary(month[0]) || (isFebruary(month[0]) && day[0] <= 29)))
            --leap_days[0];

         if (isLeapYear(year[1]) && (isJanuary(month[1]) || (isFebruary(month[1]) && day[1] < 29)))
            --leap_days[1];

         answer.append("Case ");
         answer.append(Integer.toString(t));
         answer.append(": ");
         answer.append(Integer.toString(leap_days[1] - leap_days[0]));
         answer.append('\n');
      }
      System.out.print(answer);
   }

   static boolean isLeapYear(int year) {
      return (((year % 4 == 0) && (year % 100 != 0)) || (year % 400 == 0));
   }

   static boolean isJanuary(String month) {
      return (month.compareTo("January") == 0);
   }

   static boolean isFebruary(String month) {
      return (month.compareTo("February") == 0);
   }
}

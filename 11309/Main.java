import java.io.*;
import java.util.*;

public class Main {
   public static void main(String args[]) throws IOException {
      StringBuilder answer = new StringBuilder();
      BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
      int t = Integer.parseInt(in.readLine());

      while (t-- > 0) {
         StringTokenizer tokenizer = new StringTokenizer(in.readLine(), ":");
         int h = Integer.parseInt(tokenizer.nextToken());
         int m = Integer.parseInt(tokenizer.nextToken());
         int tmp = (h * 100) + m;
         if (tmp < 9) {
            ++tmp;
         } else if (tmp < 55) {
            if ((tmp / 10) <= (tmp % 10)) {
               tmp += 10;
            }
            tmp = (tmp - (tmp % 10)) + (tmp / 10);
         } else if (tmp < 959) {
            if ((tmp / 100) <= (tmp % 10)) {
               if ((tmp % 100) < 50) {
                  tmp += 10;
               } else {
                  tmp = (tmp + 100) - (tmp % 100);
               }
            }
            tmp = (tmp - (tmp % 10)) + (tmp / 100);
         } else {
            if (((h % 10) * 10 + (h / 10)) <= m || h < 10){
               if (tmp < 2300) {
                  tmp += 100;
               } else {
                  tmp = 0;
               }
            }
            tmp = tmp - (tmp % 100);
            if (tmp > 1551 && tmp < 2000) tmp = 2000;
            tmp = tmp + ((tmp % 1000) / 10) + (tmp / 1000);
         }
         answer.append(String.format("%02d:%02d\n", tmp / 100, tmp % 100));
      }
      System.out.print(answer);
   }
}

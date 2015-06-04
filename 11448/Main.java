import java.io.*;
import java.util.*;

public class Main {
   public static void main(String args[]) throws IOException {
      int n;
      String[] number = new String[2];
      StringTokenizer tokenizer;
      BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

      n = Integer.parseInt(in.readLine());
      while (n-- > 0) {
         int cmp;
         int indexMax, indexMin;
         boolean borrow = false;
         char[] max, min;
         tokenizer = new StringTokenizer(in.readLine());
         number[0] = tokenizer.nextToken();
         number[1] = tokenizer.nextToken();
         cmp = compare(number[0], number[1]);
         if (cmp == 0) {
            System.out.println("0");
            continue;
         }
         if (cmp > 0) {
            max = number[0].toCharArray();
            min = number[1].toCharArray();
         } else {
            max = number[1].toCharArray();
            min = number[0].toCharArray();
         }
         indexMax = max.length;
         indexMin = min.length;

         while (--indexMax > -1) {
            if (borrow) {
               if (max[indexMax] == '0') {
                  max[indexMax] = '9';
               } else {
                  --max[indexMax];
                  borrow = false;
               }
            }
            if (--indexMin > -1) {
               if (max[indexMax] < min[indexMin]) {
                  max[indexMax] += (10 - (min[indexMin] - '0'));
                  borrow = true;
               } else {
                  max[indexMax] -= min[indexMin];
                  max[indexMax] += '0';
               }
            }
         }

         if (cmp < 0) System.out.print("-");
         for (indexMax = 0; max[indexMax] == '0'; indexMax++);
         System.out.println(new String(max, indexMax, (max.length - indexMax)));
      }
   }

   public static int compare(String num1, String num2) {
      if (num1.length() == num2.length()) {
         int index = 0;
         while (index < num1.length()) {
            if (num1.charAt(index) != num2.charAt(index))
               break;
            ++index;
         }
         if (index == num1.length())
            return 0;
         return (num1.charAt(index) > num2.charAt(index)) ? 1 : -1;
      }
      return (num1.length() > num2.length()) ? 1 : -1;
   }
}

import java.io.*;
import java.util.*;

public class Main {
   public static void main(String args[]) throws IOException {
      String line;
      StringBuilder answer = new StringBuilder();
      BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

      while ((line = in.readLine()) != null) {
         if (line.length() == 0) break;
         StringTokenizer tokenizer = new StringTokenizer(line);
         int n = Integer.parseInt(tokenizer.nextToken());
         int m = (n * (n - 1)) / 2;
         int[] summation = new int[m];
         int[] number = new int[n];

         for (int i = 0; i < summation.length; i++) {
            if (!tokenizer.hasMoreTokens())
               tokenizer = new StringTokenizer(in.readLine());
            summation[i] = Integer.parseInt(tokenizer.nextToken());
         }

         Arrays.sort(summation);

         boolean found = false;
         int sum = summation[0] + summation[1];
         for (int i = 2; i < summation.length; i++) {
            if ((sum - summation[i]) % 2 == 1)
               continue;
            number[0] = (sum - summation[i]) / 2;
            number[1] = summation[0] - number[0];
            number[2] = summation[1] - number[0];
            boolean[] selected = new boolean[m];
            selected[0] = selected[1] = selected[i] = true;
            if (findOther(number, summation, selected)) {
               if ((found = verify(number, summation)))
                  break;
            }
         }
         if (found) {
            Arrays.sort(number);
            answer.append(Integer.toString(number[0]));
            for (int i = 1; i < number.length; i++) {
               answer.append(' ');
               answer.append(Integer.toString(number[i]));
            }
            answer.append('\n');
         } else {
            answer.append("Impossible\n");
         }
      }
      System.out.print(answer);
   }

   public static boolean verify(int[] number, int[] summation) {
      int count = 0;
      boolean[] selected = new boolean[summation.length];

      for (int i = 0; i < number.length; i++) {
         for (int j = i + 1; j < number.length; j++) {
            int sum = number[i] + number[j];
            for (int k = 0; k < summation.length; k++) {
               if (sum == summation[k]) {
                  ++count;
                  selected[k] = true;
                  break;
               }
            }
         }
      }

      return (count == summation.length);
   }

   public static boolean findOther(int[] number, int[] summation, boolean[] selected) {
      for (int i = 3; i < number.length; i++) {
         int s = indexOfUnselected(selected);
         boolean found = false;
         selected[s] = true;
         number[i] = summation[s] - number[0];
         for (int j = 1; j < i; j++) {
            for (int k = 0; k < summation.length; k++) {
               if (!selected[k] && summation[k] == (number[i] + number[j])) {
                  selected[k] = true;
                  found = true;
                  break;
               }
            }
            if (!found) break;
         }
         if (!found)
            return false;
      }
      return true;
   }

   public static int indexOfUnselected(boolean[] selected) {
      for (int i = 0; i < selected.length; i++)
         if (!selected[i]) return i;
      return -1;
   }
}

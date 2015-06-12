import java.io.*;

public class Main {
   public static void main(String argv[]) throws IOException {
      int rows, middle, maxLength;
      String[] line = new String[101];
      BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

      rows = maxLength = 0;
      while ((line[rows] = in.readLine()) != null) {
         if (line[rows].length() > maxLength) {
            maxLength = line[rows].length();
            middle = rows;
         }
         ++rows;
      }

      for (int i = 0; i < maxLength; i++) {
         for (int j = rows - 1; j >= 0; j--) {
            if (i < line[j].length()) {
               if (line[j].charAt(i) == '\t')
                  System.out.print(' ');
               else
                  System.out.print(line[j].charAt(i));
            } else {
               System.out.print(' ');
            }
         }
         System.out.println();
      }
   }
}

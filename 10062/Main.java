import java.io.*;

public class Main {
   public static void main(String args[]) throws IOException {
      boolean newLine = false;
      String line;
      BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

      while ((line = in.readLine()) != null) {
         int length = line.length();
         int[] ascii = new int[95];
         for (int i = 0; i < length; i++) {
            int index = line.charAt(i) - 32;
            ++ascii[index];
         }
         if (newLine) System.out.println();
         while (length > 0) {
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < 95; i++) {
               if (min > ascii[i] && ascii[i] > 0)
                  min = ascii[i];
            }
            for (int i = 94; i >= 0; i--) {
               if (ascii[i] == min) {
                  System.out.println((i + 32) + " " + ascii[i]);
                  ascii[i] = 0;
                  length -= min;
               }
            }
         }
         newLine = true;
      }
   }
}

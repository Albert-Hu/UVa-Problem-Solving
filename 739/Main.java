import java.io.*;

public class Main {
   final static char[] code = {
      '0', '1', '2', '3', '0', '1', '2', '0',
      '0', '2', '2', '4', '5', '5', '0', '1',
      '2', '6', '2', '3', '0', '1', '0', '2',
      '0', '2'
   };

   public static void main(String args[]) throws IOException {
      String line;
      BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

      System.out.println("         NAME                     SOUNDEX CODE");
      while ((line = in.readLine()) != null) {
         System.out.printf("         %-25s%c", line, line.charAt(0));
         int padding = 3;
         char[] output = new char[line.length()];
         for (int i = 0; i < line.length(); i++) {
            output[i] = code[line.charAt(i) - 'A'];
         }
         for (int i = 1; i < line.length() && padding > 0; i++) {
            if (output[i] != '0' && output[i] != output[i - 1]) {
               System.out.print(output[i]);
               --padding;
            }
         }
         while (padding-- > 0) {
            System.out.print("0");
         }
         System.out.println();
      }
      System.out.println("                   END OF OUTPUT");
   }
}

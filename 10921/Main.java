import java.io.*;

public class Main {
   final static char[] table = {
      '2', '2', '2',
      '3', '3', '3',
      '4', '4', '4',
      '5', '5', '5',
      '6', '6', '6',
      '7', '7', '7', '7',
      '8', '8', '8',
      '9', '9', '9', '9'
   };
   public static void main(String args[]) throws IOException {
      String line;
      BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

      while ((line = in.readLine()) != null) {
         for (int i = 0; i < line.length(); i++) {
            char c = line.charAt(i);
            if (c >= 'A' && c <= 'Z')
               System.out.print(table[c - 'A']);
            else
               System.out.print(c);
         }
         System.out.println();
      }
   }
}

import java.io.*;

public class Main {
   static int code = 1;
   static char[] buffer = new char[6];
   static char[] letter = {
      'a', 'b', 'c', 'd', 'e', 'f', 'g',
      'h', 'i', 'j', 'k', 'l', 'm', 'n',
      'o', 'p', 'q', 'r', 's', 't', 'u',
      'v', 'w', 'x', 'y', 'z'
   };
   static String[] table = new String[83682];

   public static void main(String args[]) throws IOException {
      String line;
      StringBuilder answer = new StringBuilder();
      BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

      for (int max = 1; max < 6; max++)
         generateTable(0, max, 0);

      while ((line = in.readLine()) != null) {
         boolean ignore = false;
         for (int i = 1; i < line.length(); i++) {
            if (line.charAt(i) < line.charAt(i - 1)) {
               ignore = true;
               break;
            }
         }
         if (ignore) {
            answer.append("0\n");
            continue;
         }
         for (int i = 1; i < table.length; i++) {
            if (table[i].equals(line)) {
               answer.append(Integer.toString(i));
               answer.append('\n');
               break;
            }
         }
      }
      System.out.print(answer);
   }

   public static void generateTable(int n, int max, int index) {
      if (n < max) {
         for (; index < letter.length; index++) {
            buffer[n] = letter[index];
            generateTable((n + 1), max, (index + 1));
         }
      } else {
         table[code] = new String(buffer, 0, max);
         ++code;
      }
   }
}

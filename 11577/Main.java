import java.io.*;

public class Main {
   public static void main(String args[]) throws IOException {
      BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
      int n = Integer.parseInt(in.readLine());

      while (n-- > 0) {
         int max = 0;
         int[] count = new int[26];
         String line = in.readLine();

         line = line.toLowerCase();
         for (int i = 0; i < line.length(); i++) {
            char c = line.charAt(i);
            if (c >= 'a' && c <= 'z') {
               ++count[c - 'a'];
            }
         }

         for (int i = 0; i < 26; i++) {
            if (count[i] > max) max = count[i];
         }

         for (int i = 0; i < 26; i++) {
            if (count[i] == max)
               System.out.print((char) (i + 'a'));
         }

         System.out.println();
      }
   }
}

import java.io.*;

public class Main {
   public static void main(String args[]) throws IOException {
      String line;
      BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

      while ((line = in.readLine()) != null) {
         if (line.charAt(0) == '0') break;

         int multiple = 0, degree = 1;

         for (int i = 0; i < line.length(); i++) {
            multiple += (line.charAt(i) - '0');
         }
         if ((multiple % 9) == 0) {
            while ((multiple / 6) != 1) {
               String tmp = Integer.toString(multiple);
               multiple = 0;
               for (int i = 0; i < tmp.length(); i++) {
                  multiple += (tmp.charAt(i) - '0');
               }
               ++degree;
            }
            System.out.println(line + " is a multiple of 9 and has 9-degree " + degree + ".");
         } else {
            System.out.println(line + " is not a multiple of 9.");
         }
      }
   }
}

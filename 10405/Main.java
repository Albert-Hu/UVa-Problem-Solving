import java.io.*;

public class Main {
   public static void main(String args[]) throws IOException {
      int length;
      int[][] table = new int[1001][1001];
      String[] sequences = new String[2];
      BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

      while ((sequences[0] = in.readLine()) != null) {
         sequences[1] = in.readLine();
         length = 0;
         for (int i = 0; i < sequences[0].length(); i++) {
            for (int j = 0; j < sequences[1].length(); j++) {
               if (sequences[0].charAt(i) == sequences[1].charAt(j)) {
                  table[i+1][j+1] = table[i][j] + 1;
               } else {
                  table[i+1][j+1] = Math.max(table[i+1][j], table[i][j+1]);
               }
               length = table[i+1][j+1];
            }
         }
         System.out.println(length);
      }
   }
}

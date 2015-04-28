import java.io.*;
import java.util.*;

public class Main {
   public static void main(String args[]) throws IOException{
      int test_case = 1;
      int[] tile = new int[2];
      int[][] tiles = new int[2][100];
      int[][] lcs_length = new int[101][101];
      String line;
      StringTokenizer tokenizer;
      BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

      while ((line = in.readLine()) != null) {
         tokenizer = new StringTokenizer(line);
         tile[0] = Integer.parseInt(tokenizer.nextToken());
         tile[1] = Integer.parseInt(tokenizer.nextToken());

         if (tile[0] == 0 && tile[1] == 0)
            break;

         for (int i = 0; i < tile.length; i++) {
            tokenizer = new StringTokenizer(in.readLine());
            for (int j = 0; j < tile[i]; j++) {
               tiles[i][j] = Integer.parseInt(tokenizer.nextToken());
            }
         }

         for (int i = 0; i < tile[0]; i++) {
            for (int j = 0; j < tile[1]; j++) {
               if (tiles[0][i] == tiles[1][j]) {
                  lcs_length[i+1][j+1] = lcs_length[i][j] + 1;
               } else {
                  lcs_length[i+1][j+1] = Math.max(lcs_length[i][j+1], lcs_length[i+1][j]);
               }
            }
         }

         System.out.println("Twin Towers #" + test_case);
         System.out.println("Number of Tiles : " + lcs_length[tile[0]][tile[1]] + "\n");
         ++test_case;
      }
   }
}

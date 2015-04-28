import java.io.*;
import java.util.*;

public class Main {
   public static void main(String[] args) throws IOException {
      new Main().run();
   }

   public void run() throws IOException {
      int textRead = 0;
      String line;
      Text[] texts = new Text[2];
      BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

      texts[0] = new Text();
      texts[1] = new Text();

      while ((line = in.readLine()) != null) {
         if (line.equals("#")) {
            ++textRead;
         }

         if (textRead < 2) {
            StringTokenizer tokenizer = new StringTokenizer(line);
            while (tokenizer.hasMoreTokens()) {
               texts[textRead].add(tokenizer.nextToken());
            }
         } else {
            String[] lcs = texts[0].findLongestCommonSubsequence(texts[1]);
            for (int i = 0; i < lcs.length; i++) {
               System.out.print(((i > 0) ? " " : "") + lcs[i]);
            }
            System.out.println();
            textRead = 0;
            texts[0].clear();
            texts[1].clear();
         }
      }
   }

   private class Text {
      final static int DIRECTION_UP = 0;
      final static int DIRECTION_LEFT = 1;
      final static int DIRECTION_UPPER_LEFT = 2;

      int amount = 0;
      String[] words = new String[100];

      void clear() {
         amount = 0;
      }

      void add(String word) {
         words[amount] = word;
         ++amount;
      }

      String[] findLongestCommonSubsequence(Text text) {
         int[][] length = new int[101][101];
         int[][] direction = new int[101][101];
         String[][] subsequence = new String[101][101];

         for (int i = 0; i < amount; i++) {
            for (int j = 0; j < text.amount; j++) {
               if (words[i].equals(text.words[j])) {
                  length[i+1][j+1] = length[i][j] + 1;
                  direction[i+1][j+1] = DIRECTION_UPPER_LEFT;
                  subsequence[i+1][j+1] = words[i];
               } else {
                  if (length[i][j+1] > length[i+1][j]) {
                     length[i+1][j+1] = length[i][j+1];
                     direction[i+1][j+1] = DIRECTION_LEFT;
                  } else {
                     length[i+1][j+1] = length[i+1][j];
                     direction[i+1][j+1] = DIRECTION_UP;
                  }
                  subsequence[i+1][j+1] = null;
               }
            }
         }

         int x = amount;
         int y = text.amount;
         int index = length[x][y] - 1;
         String[] lcs = new String[length[x][y]];

         while (length[x][y] > 0) {
            switch (direction[x][y]) {
               case DIRECTION_UPPER_LEFT:
                  lcs[index] = subsequence[x][y];
                  --x;
                  --y;
                  --index;
                  break;
               case DIRECTION_LEFT:
                  --x;
                  break;
               case DIRECTION_UP:
                  --y;
                  break;
            }
         }

         return lcs;
      }
   }
}

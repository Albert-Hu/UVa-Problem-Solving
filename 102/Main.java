import java.io.*;
import java.util.*;

public class Main {
   final static int B = 0;
   final static int G = 1;
   final static int C = 2;

   final static int[][] colors = {
      {B, C, G},
      {B, G, C},
      {C, B, G},
      {C, G, B},
      {G, B, C},
      {G, C, B}
   };

   final static char[] colorMap = {'B', 'G', 'C'};

   public static void main(String args[]) throws IOException {
      int numberRead;
      int[][] bottles = new int[3][3];
      String line;
      BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

      while ((line = in.readLine()) != null) {
         StringTokenizer tokenizer = new StringTokenizer(line);
         numberRead = 0;
         while (tokenizer.hasMoreTokens()) {
            bottles[numberRead/3][numberRead%3] = Integer.parseInt(tokenizer.nextToken());
            ++numberRead;
         }

         int[] color = null;
         int total = 0;
         int minimum = 0x7fffffff;

         total += bottles[0][0] + bottles[1][0] + bottles[2][0];
         total += bottles[0][1] + bottles[1][1] + bottles[2][1];
         total += bottles[0][2] + bottles[1][2] + bottles[2][2];

         for (int i = 0; i < colors.length; i++) {
            int times_moved = total;
            times_moved -= bottles[0][colors[i][0]];
            times_moved -= bottles[1][colors[i][1]];
            times_moved -= bottles[2][colors[i][2]];
            if (times_moved < minimum) {
               minimum = times_moved;
               color = colors[i];
            }
         }
         System.out.println("" +
            colorMap[color[0]] +
            colorMap[color[1]] +
            colorMap[color[2]] +
            " " +
            minimum);
      }
   }
}

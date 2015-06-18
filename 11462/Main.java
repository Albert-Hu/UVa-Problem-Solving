import java.io.*;
import java.util.*;

public class Main {
   public static void main(String args[]) throws IOException {
      int a, n, next, tmp;
      int[] count = new int[101];
      int[] sequence = new int[101];
      boolean space;
      String line;
      StringTokenizer tokenizer;
      BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
      BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

      while ((line = in.readLine()) != null) {
         if (line.charAt(0) == '0') break;
         n = Integer.parseInt(line);
         tokenizer = new StringTokenizer(in.readLine());

         for (int i = 0; i < 101; i++)
            count[i] = sequence[i] = 0;

         while (n-- > 0) {
            a = Integer.parseInt(tokenizer.nextToken());
            ++count[a];
            if (count[a] == 1) {
               next = 0;
               while (sequence[next] != 0) {
                  if (sequence[next] > a) {
                     tmp = sequence[next];
                     sequence[next] = a;
                     a = tmp;
                  }
                  next = sequence[next];
               }
               sequence[next] = a;
            }
         }

         String output = "";
         space = false;
         for (next = 0; sequence[next] != 0; next = sequence[next]) {
            while (count[sequence[next]]-- > 0) {
               if (space) {
                  output += " ";
                  if (output.length() > 500) {
                     out.write(output);
                     out.flush();
                     output = "";
                  }
               } else {
                  space = true;
               }
               output += Integer.toString(sequence[next]);
               if (output.length() > 500) {
                  out.write(output);
                  out.flush();
                  output = "";
               }
            }
         }
         out.write(output + "\n");
         out.flush();
      }
   }
}

import java.io.*;
import java.util.*;

public class Main {
   public static void main(String args[]) throws IOException {
      int q = 0;
      char[] quote = {'`', '\''};
      String line;
      StringBuilder output = new StringBuilder();
      BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

      while ((line = in.readLine()) != null) {
         StringTokenizer tokenizer = new StringTokenizer(line, "\"", true);
         while (tokenizer.hasMoreTokens()) {
            String slice = tokenizer.nextToken();
            if (slice.charAt(0) == '"') {
               output.append(quote[q]);
               output.append(quote[q]);
               q = (q + 1) % 2;
            } else {
               output.append(slice);
            }
         }
         output.append('\n');
      }
      System.out.print(output);
   }
}

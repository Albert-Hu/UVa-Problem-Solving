import java.io.*;
import java.util.*;

public class Main {
   public static void main(String args[]) throws IOException {
      String line;
      String answer = "";
      BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

      while ((line = in.readLine()) != null) {
         StringTokenizer tokenizer = new StringTokenizer(line);
         int n = Integer.parseInt(tokenizer.nextToken());
         int a = Integer.parseInt(tokenizer.nextToken());
         boolean[] diff = new boolean[n];
         for (int i = 1; i < n; i++) {
            int b = Integer.parseInt(tokenizer.nextToken());
            int c = b - a;
            if (c < 0) c = -c;
            if (c < n) diff[c] = true;
            a = b;
         }
         boolean isJolly = true;
         for (int i = 1; i < n; i++) {
            if (diff[i]) continue;
            isJolly = false;
            break;
         }
         answer += (isJolly ? "Jolly\n" : "Not jolly\n");
      }

      System.out.print(answer);
   }
}

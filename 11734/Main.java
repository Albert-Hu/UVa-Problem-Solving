import java.io.*;
import java.util.*;

public class Main {
   public static void main(String args[]) throws IOException {
      StringBuilder answer = new StringBuilder();
      BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
      int n = Integer.parseInt(in.readLine());

      for (int t = 1; t <= n; t++) {
         String team = in.readLine();
         String judge = in.readLine();
         StringBuilder a = new StringBuilder();
         StringBuilder b = new StringBuilder();
         StringTokenizer tokenizer;

         tokenizer = new StringTokenizer(team);
         while (tokenizer.hasMoreTokens()) {
            a.append(tokenizer.nextToken());
         }

         tokenizer = new StringTokenizer(judge);
         while (tokenizer.hasMoreTokens()) {
            b.append(tokenizer.nextToken());
         }

         answer.append("Case ");
         answer.append(Integer.toString(t));
         answer.append(": ");
         if (!a.toString().equals(b.toString())) {
            answer.append("Wrong Answer\n");
         } else {
            answer.append((team.length() == judge.length()) ? "Yes\n" : "Output Format Error\n");
         }
      }
      System.out.print(answer);
   }
}

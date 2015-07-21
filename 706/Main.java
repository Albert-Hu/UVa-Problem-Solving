import java.io.*;
import java.util.*;

public class Main {
   public static void main(String args[]) throws IOException {
      String line;
      StringBuilder answer = new StringBuilder();
      BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

      while ((line = in.readLine()) != null) {
         StringTokenizer tokenizer = new StringTokenizer(line);
         int s = Integer.parseInt(tokenizer.nextToken());
         String n = tokenizer.nextToken();

         if (s == 0) break;

         answer.append(display(s, n));
         answer.append('\n');
      }
      System.out.print(answer);
   }

   public static String display(int s, String n) {
      boolean space = false;
      StringBuilder output = new StringBuilder();

      for (int c = 0; c < n.length(); c++) {
         if (space) output.append(' ');
         else space = true;
         output.append(' ');
         switch (n.charAt(c)) {
            case '0': case '2': case '3': case '5':
            case '6': case '7': case '8': case '9':
               for (int i = 0; i < s; i++) {
                  output.append('-');
               }
               break;
            default:
               for (int i = 0; i < s; i++) {
                  output.append(' ');
               }
         }
         output.append(' ');
      }

      output.append('\n');
      for (int i = 0; i < s; i++) {
         space = false;
         for (int c = 0; c < n.length(); c++) {
            if (space) output.append(' ');
            else space = true;
            switch (n.charAt(c)) {
               case '0': case '4': case '5':
               case '6': case '8': case '9':
                  output.append('|');
                  break;
               default:
                  output.append(' ');
            }
            for (int j = 0; j < s; j++) output.append(' ');
            switch (n.charAt(c)) {
               case '0': case '1': case '2': case '3':
               case '4': case '7': case '8': case '9':
                  output.append('|');
                  break;
               default:
                  output.append(' ');
            }
         }
         output.append('\n');
      }
      space = false;
      for (int c = 0; c < n.length(); c++) {
         if (space) output.append(' ');
         else space = true;
         output.append(' ');
         switch (n.charAt(c)) {
            case '2': case '3': case '4': case '5':
            case '6': case '8': case '9':
               for (int i = 0; i < s; i++) {
                  output.append('-');
               }
               break;
            default:
               for (int i = 0; i < s; i++) {
                  output.append(' ');
               }
         }
         output.append(' ');
      }
      output.append('\n');
      for (int i = 0; i < s; i++) {
         space = false;
         for (int c = 0; c < n.length(); c++) {
            if (space) output.append(' ');
            else space = true;
            switch (n.charAt(c)) {
               case '0': case '2':case '6': case '8':
                  output.append('|');
                  break;
               default:
                  output.append(' ');
            }
            for (int j = 0; j < s; j++) output.append(' ');
            switch (n.charAt(c)) {
               case '0': case '1': case '3': case '4': case '5':
               case '6': case '7': case '8': case '9':
                  output.append('|');
                  break;
               default:
                  output.append(' ');
            }
         }
         output.append('\n');
      }
      space = false;
      for (int c = 0; c < n.length(); c++) {
         if (space) output.append(' ');
         else space = true;
         output.append(' ');
         switch (n.charAt(c)) {
            case '0': case '2': case '3': case '5':
            case '6': case '8': case '9':
               for (int i = 0; i < s; i++) {
                  output.append('-');
               }
               break;
            default:
               for (int i = 0; i < s; i++) {
                  output.append(' ');
               }
         }
         output.append(' ');
      }

      output.append('\n');
      return output.toString();
   }
}

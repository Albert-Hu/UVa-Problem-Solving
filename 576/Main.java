import java.io.*;

public class Main {
   public static void main(String args[]) throws IOException {
      String line;
      StringBuilder answer = new StringBuilder();
      BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

      while ((line = in.readLine()) != null) {
         if (line.compareTo("e/o/i") == 0)
            break;
         boolean[] isVowel = new boolean[line.length() + 1];
         for (int i = 0; i < line.length(); ++i) {
            switch (line.charAt(i)) {
               case 'a':
               case 'e':
               case 'i':
               case 'o':
               case 'u':
               case 'y':
                  isVowel[i] = true;
                  break;
               default:
                  isVowel[i] = false;
            }
         }
         int[] count = new int[3];
         for (int i = 0, v = 0; i < line.length(); ++i) {
            if (line.charAt(i) == '/')
               ++v;
            if (isVowel[i] && !isVowel[i + 1]) {
               ++count[v];
            }
         }
         if (count[0] != 5) {
            answer.append("1\n");
         } else if (count[1] != 7) {
            answer.append("2\n");
         } else if (count[2] != 5) {
            answer.append("3\n");
         } else {
            answer.append("Y\n");
         }
      }
      System.out.print(answer);
   }
}

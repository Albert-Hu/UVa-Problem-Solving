import java.io.*;

public class Main {
   final static int WAYS = 6001;

   public static void main(String args[]) throws IOException {
      int[] coin = {5, 10, 25, 50};
      long[] way = new long[WAYS];
      String line;
      StringBuilder answer = new StringBuilder();
      BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

      for (int i = 0; i < way.length; i++) {
         way[i] = 1;
      }

      for (int i = 0; i < coin.length; i++) {
         for (int j = (coin[i] / 5); j < way.length; j++) {
            way[j] += way[j - (coin[i] / 5)];
         }
      }

      while ((line = in.readLine()) != null) {
         int cents = Integer.parseInt(line);
         if (cents < 5) {
            answer.append("There is only 1 way to produce ");
         } else {
            answer.append("There are ");
            answer.append(Long.toString(way[cents / 5]));
            answer.append(" ways to produce ");
         }
         answer.append(Integer.toString(cents));
         answer.append(" cents change.\n");
      }
      System.out.print(answer);
   }
}

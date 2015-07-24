import java.io.*;

public class Main {
   final static int G = 34943;
   public static void main(String args[]) throws IOException {
      String line;
      StringBuilder answer = new StringBuilder();
      BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

      while ((line = in.readLine()) != null) {
         if (line.length() == 0) {
            answer.append("00 00\n");
            continue;
         }
         if (line.charAt(0) == '#' && line.length() == 1)
            break;

         long crc = 0;
         for (int i = 0; i < line.length(); i++) {
            crc = ((crc << 8) + line.charAt(i)) % G;
         }
         if (crc > 0) {
            crc = G - ((crc << 16) % G);
         }

         answer.append(String.format("%02X %02X\n", (crc >> 8), (crc & 0xff)));
      }
      System.out.print(answer);
   }
}

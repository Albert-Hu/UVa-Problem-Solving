import java.io.*;

public class Main {
   public static void main(String args[]) throws IOException {
      String line;
      StringBuilder answer = new StringBuilder();
      BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

      while ((line = in.readLine()) != null) {
         boolean end = true;
         int[] box = new int[6];
         String[] number = line.split(" ");
         for (int i = 0; i < number.length && i < box.length; ++i) {
            box[i] = Integer.parseInt(number[i]);
            end &= (box[i] == 0);
         }
         if (end) break;
         box[0] = (box[0] > (box[4] * 11)) ? (box[0] - box[4] * 11) : 0;
         if (box[1] < (box[3] * 5))
            box[0] = (box[0] > ((box[3] * 5 - box[1]) * 4)) ? (((box[3] * 5 - box[1]) * 4)) : 0;
         box[1] = (box[1] > (box[3] * 5) ? (box[1] - box[3] * 5) : 0);
         switch ((4 - (box[2] % 4))) {
            case 1:
               box[0] = (box[0] > 5) ? (box[0] - 5) : 0;
               box[1] = (box[1] > 1) ? (box[1] - 1) : 0;
               break;
            case 2:
               box[0] = (box[0] > 6) ? (box[0] - 6) : 0;
               box[1] = (box[1] > 3) ? (box[1] - 3) : 0;
               break;
            case 3:
               box[0] = (box[0] > 11) ? (box[0] - 11) : 0;
               box[1] = (box[1] > 5 ) ? (box[1] - 5) : 0;
               break;
         }
         if (box[1] % 9 != 0)
            box[0] = (box[0] > ((9 - (box[1] % 9)) * 4)) ? (box[0] - ((9 - (box[1] % 9)) * 4)) : 0;
         box[0] = (box[0] / 36) + (((box[0] % 36) != 0) ? 1 : 0);
         box[1] = (box[1] / 9) + (((box[1] % 9) != 0) ? 1 : 0);
         box[2] = (box[2] / 4) + (((box[2] % 4) != 0) ? 1 : 0);
         answer.append(Integer.toString((box[0] + box[1] + box[2] + box[3] + box[4] + box[5])));
         answer.append('\n');
      }
      System.out.print(answer);
   }
}

import java.io.*;
import java.util.*;

public class Main {
   final static int[] bits = {
      0x00000001,0x00000003,0x00000007,0x0000000f,0x0000001f,
      0x0000003f,0x0000007f,0x000000ff,0x000001ff,0x000003ff,
      0x000007ff,0x00000fff,0x00001fff,0x00003fff,0x00007fff,
      0x0000ffff,0x0001ffff,0x0003ffff,0x0007ffff,0x000fffff,
      0x001fffff,0x003fffff,0x007fffff,0x00ffffff,0x01ffffff,
      0x03ffffff,0x07ffffff,0x0fffffff,0x1fffffff,0x3fffffff
   };

   public static void main(String args[]) throws IOException {
      int number = 0;
      boolean flag = false;
      String line;
      StringBuilder answer = new StringBuilder();
      BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

      while ((line = in.readLine()) != null) {
         StringTokenizer tokenizer = new StringTokenizer(line);
         while (tokenizer.hasMoreTokens()) {
            String s = tokenizer.nextToken();
            switch (s.charAt(0)) {
               case '~': break;
               case '#':
                  answer.append(Integer.toString(number));
                  answer.append('\n');
                  number = 0;
                  flag = false;
                  break;
               default:
                  int length = s.length();
                  if (length < 3) {
                     flag = (length == 1);
                  } else {
                     length -= 2;
                     number <<= length;
                     if (flag) number |= bits[length - 1];
                  }
            }
         }
      }
      System.out.print(answer);
   }
}

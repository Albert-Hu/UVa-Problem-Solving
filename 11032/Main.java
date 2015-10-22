import java.io.*;

public class Main {
   final static int MAX = 10000001;

   public static void main(String args[]) throws IOException {
      int testCase;
      byte[] sod = new byte[MAX];
      StringBuilder answer = new StringBuilder();
      BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

      for (int i = 0; i < sod.length; ++i) {
         if (i < 10) {
            sod[i] = (byte) i;
         } else if (i >= 10 && i < 100) {
            sod[i] = (byte) (sod[i % 10] + i / 10);
         } else if (i >= 100 && i < 1000) {
            sod[i] = (byte) (sod[i % 100] + i / 100);
         } else if (i >= 1000 && i < 10000) {
            sod[i] = (byte) (sod[i % 1000] + i / 1000);
         } else if (i >= 10000 && i < 100000) {
            sod[i] = (byte) (sod[i % 10000] + i / 10000);
         } else if (i >= 100000 && i < 1000000) {
            sod[i] = (byte) (sod[i % 100000] + i / 100000);
         } else if (i >= 1000000 && i < 10000000) {
            sod[i] = (byte) (sod[i % 1000000] + i / 1000000);
         } else {
            sod[i] = 1;
         }
      }

      int[] index = new int[MAX];
      for (int i = 0; i < MAX; ++i) {
         index[i] = -1;
      }

      for (int i = MAX - 1; i > 0; --i) {
         int a = i + sod[i];
         if (a < MAX) {
            index[a] = i;
         }
      }

      sod = null;

      int[] count = new int[MAX];
      count[1] = 1;
      for (int i = 2; i < MAX; ++i) {
         count[i] = count[i - 1] + (index[i] == -1 ? 1 : 0);
      }

      testCase = Integer.parseInt(in.readLine());
      for (int t = 1; t <= testCase; ++t) {
         String[] number = in.readLine().split(" ");
         answer.append("Case ");
         answer.append(Integer.toString(t));
         answer.append(": ");
         if (number.length == 1) {
            int a = Integer.parseInt(number[0]);
            answer.append(Integer.toString(index[a]));
         } else {
            int a = Integer.parseInt(number[0]);
            int b = Integer.parseInt(number[1]);
            answer.append(Integer.toString((count[b] - count[a]) + (index[a] == -1 ? 1 : 0)));
         }
         answer.append('\n');
      }
      System.out.print(answer);
   }
}

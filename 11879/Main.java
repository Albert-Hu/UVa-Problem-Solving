import java.io.*;

public class Main {
   public static void main(String args[]) throws IOException {
      String line;
      StringBuilder answer = new StringBuilder();
      BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

      while ((line = in.readLine()) != null) {
         if (line.charAt(0) == '0' && line.length() == 1)
            break;
         int sum = 0;
         boolean add = false;
         String n = line.substring(0, line.length() % 8);

         if (n.length() > 0)
            sum = Integer.parseInt(n);

         for (int i = line.length() % 8; i < line.length(); i += 8) {
            if (add)
               sum += Integer.parseInt(line.substring(i, i + 8));
            else
               sum -= Integer.parseInt(line.substring(i, i + 8));
            add = !add;
         }
         if (sum % 17 == 0)
            answer.append("1\n");
         else
            answer.append("0\n");
      }
      System.out.print(answer);
   }
}

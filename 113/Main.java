import java.io.*;
import java.util.*;

public class Main {
   public static void main(String args[]) throws IOException {
      String line;
      BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

      while ((line = in.readLine()) != null) {
         double n = Double.parseDouble(line);
         double p = Double.parseDouble(in.readLine());
         System.out.println((int) Math.round(Math.pow(p, 1/n)));
      }
   }
}

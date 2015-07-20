import java.io.*;

public class Main {
   public static void main(String args[]) throws IOException {
      boolean newLine = false;
      String line;
      StringBuilder answer = new StringBuilder();
      BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

      while ((line = in.readLine()) != null) {
         int n = Integer.parseInt(line);
         if (newLine) answer.append('\n');
         else newLine = true;

         int segments = 0, completes = 0;
         double[] corner = new double[4];
         double radius = ((2 * n) - 1) / 2.0;
         radius *= radius;

         for (int x = 0; x < n; x++) {
            for (int y = 0; y < n; y++) {
               corner[0] = get_distance(x, y, n, n);
               corner[1] = get_distance(x + 1, y, n, n);
               corner[2] = get_distance(x, y + 1, n, n);
               corner[3] = get_distance(x + 1, y + 1, n, n);
               if ((corner[0] <= radius) || (corner[1] <= radius) || (corner[2] <= radius) || (corner[3] <= radius)) {
                  if ((corner[0] <= radius) && (corner[1] <= radius) && (corner[2] <= radius) && (corner[3] <= radius)) {
                     ++completes;
                  } else {
                     ++segments;
                  }
               }
            }
         }

         answer.append("In the case n = ");
         answer.append(Integer.toString(n));
         answer.append(", ");
         answer.append(Integer.toString(segments * 4));
         answer.append(" cells contain segments of the circle.\n");
         answer.append("There are ");
         answer.append(Integer.toString(completes * 4));
         answer.append(" cells completely contained in the circle.\n");
      }
      System.out.print(answer);
   }

   public static double get_distance(double x1, double y1, double x2, double y2) {
      return ((x2 - x1) * (x2 - x1)) + ((y2 - y1) * (y2 - y1));
   }
}

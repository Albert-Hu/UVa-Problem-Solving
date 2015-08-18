import java.io.*;
import java.util.*;

public class Main {
   static BufferedReader in = null;
   static StringTokenizer tokenizer = null;

   public static void main(String args[]) throws IOException {
      int t;
      StringBuilder answer = new StringBuilder();

      init();
      t = nextInt();

      while (t-- > 0) {
         int n = nextInt();
         int m = nextInt();
         int[] maze = new int[n * m];
         int[] distance = new int[n * m];
         boolean[] visited = new boolean[n * m];
         PriorityQueue<MazeUnit> queue = new PriorityQueue<MazeUnit>(maze.length, new Comparator<MazeUnit>() {
            public int compare(MazeUnit a, MazeUnit b) {
               return a.getValue() - b.getValue();
            }
         });

         for (int i = 0; i < maze.length; i++) {
            maze[i] = nextInt();
            distance[i] = Integer.MAX_VALUE;
         }

         distance[0] = maze[0];
         queue.add(new MazeUnit(maze[0], 0));
         while (queue.size() > 0) {
            MazeUnit unit = queue.poll();
            int current = unit.getPosition();
            visited[current] = true;

            if (current % m != 0) {
               int left = current - 1;
               if ((distance[current] + maze[left]) < distance[left] && !visited[left]) {
                  distance[left] = distance[current] + maze[left];
                  queue.add(new MazeUnit(distance[left], left));
               }
            }

            if ((current + 1) % m != 0) {
               int right = current + 1;
               if ((distance[current] + maze[right]) < distance[right] && !visited[right]) {
                  distance[right] = distance[current] + maze[right];
                  queue.add(new MazeUnit(distance[right], right));
               }
            }

            if (current >= m) {
               int up = current - m;
               if ((distance[current] + maze[up]) < distance[up] && !visited[up]) {
                  distance[up] = distance[current] + maze[up];
                  queue.add(new MazeUnit(distance[up], up));
               }
            }

            if ((current + m) < maze.length) {
               int down = current + m;
               if ((distance[current] + maze[down]) < distance[down] && !visited[down]) {
                  distance[down] = distance[current] + maze[down];
                  queue.add(new MazeUnit(distance[down], down));
               }
            }
         }
         answer.append(Integer.toString(distance[distance.length - 1]));
         answer.append('\n');
      }
      System.out.print(answer);
   }

   public static void init() throws IOException {
      in = new BufferedReader(new InputStreamReader(System.in));
   }

   public static int nextInt() throws IOException {
      if (tokenizer == null)
         tokenizer = new StringTokenizer(in.readLine());
      if (!tokenizer.hasMoreTokens())
         tokenizer = new StringTokenizer(in.readLine());
      return Integer.parseInt(tokenizer.nextToken());
   }

   private static class MazeUnit {
      int value;
      int position;

      public MazeUnit(int v, int p) {
         value = v;
         position = p;
      }

      public int getValue() {
         return value;
      }

      public int getPosition() {
         return position;
      }
   }
}

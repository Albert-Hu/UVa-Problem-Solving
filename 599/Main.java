import java.io.*;
import java.util.*;

public class Main {
   private boolean visited;
   private int pathNumber;
   private Main[] path = new Main[26];

   public final static int STATE_READ_EDGE = 1;
   public final static int STATE_READ_POINT = 2;

   public static void main(String args[]) throws IOException {
      int state = STATE_READ_EDGE;
      String line;
      Main[] nodes = new Main[26];
      BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

      for (int i = 0; i < nodes.length; i++) {
         nodes[i] = new Main();
      }

      Integer.parseInt(in.readLine());

      while ((line = in.readLine()) != null) {
         switch (state) {
            case STATE_READ_EDGE:
               if (line.charAt(0) == '*') {
                  state = STATE_READ_POINT;
               } else {
                  int p1, p2;
                  p1 = line.charAt(1) - 'A';
                  p2 = line.charAt(3) - 'A';
                  nodes[p1].connect(nodes[p2]);
               }
               break;
            case STATE_READ_POINT:
               int tree = 0, acorn = 0;
               for (int i = 0; i < nodes.length; i++) {
                  if (nodes[i].visit(null)) {
                     ++tree;
                  }
               }
               if (line.charAt(0) != '(') {
                  for (char c: line.toCharArray()) {
                     if (!(c >= 'A' && c <= 'Z'))
                        continue;
                     if (nodes[c - 'A'].pathNumber == 0)
                        ++acorn;
                  }
               }

               System.out.print("There are ");
               System.out.print(tree);
               System.out.print(" tree(s) and ");
               System.out.print(acorn);
               System.out.println(" acorn(s).");

               for (int i = 0; i < nodes.length; i++) {
                  nodes[i].pathNumber = 0;
                  nodes[i].visited = false;
               }
               if (line.charAt(0) == '(') {
                  int p1, p2;
                  p1 = line.charAt(1) - 'A';
                  p2 = line.charAt(3) - 'A';
                  nodes[p1].connect(nodes[p2]);
               }
               state = STATE_READ_EDGE;
               break;
         }
      }
   }

   public void connect(Main node) {
      path[pathNumber] = node;
      node.path[node.pathNumber] = this;
      pathNumber++;
      node.pathNumber++;
   }

   public boolean visit(Main parent) {
      if (pathNumber == 0 || visited)
         return false;

      visited = true;

      if (pathNumber == 1 && path[0] == parent)
         return true;

      boolean isTree = true;;
      for (int i = 0; i < pathNumber; i++) {
         if (path[i] != parent) {
            isTree &= path[i].visit(this);
         }
      }

      return isTree;
   }
}

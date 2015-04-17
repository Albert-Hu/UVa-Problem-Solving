import java.util.*;

public class Main {
   private Block[] blocks;

   public static void main(String args[]) {
      Main test;
      Scanner scan = new Scanner(System.in);

      test = new Main(Integer.parseInt(scan.nextLine()));
      while (scan.hasNextLine()) {
         test.run(scan.nextLine());
      }
      test.result();
   }

   public Main(int n) {
      blocks = new Block[n];
      for (n = 0; n < blocks.length; n++)
         blocks[n] = new Block(n);
   }

   public void result() {
      for (Block block: blocks) {
         System.out.print(block.number + ":");
         if (!block.isMove()) {
            while (block != null) {
               System.out.print(" " + block.number);
               block = block.getTop();
            }
         }
         System.out.println();
      }
   }

   public void run(String command) {
      int a, b;
      String[] parameters = command.split(" ");

      if (parameters[0].equals("quit"))
         return;

      a = Integer.parseInt(parameters[1]);
      b = Integer.parseInt(parameters[3]);

      if (blocks[a].find(blocks[b]))
         return;

      if (parameters[0].equals("move"))
         blocks[a].removeUpper();

      if (parameters[2].equals("onto"))
         blocks[b].removeUpper();

      blocks[b].put(blocks[a]);
   }

   private class Block {
      final int number;
      Block top = null;
      Block above = null;

      public Block(int num) {
         number = num;
      }

      public void put(Block block) {
         Block stack = (top == null) ? this : top;

         if (block.above != null)
            block.above.top = null;

         while (stack.top != null) {
            stack = stack.top;
         }
         stack.top = block;
         block.above = stack;
      }

      public boolean isMove() {
         return (above != null);
      }

      public Block getTop() {
         return top;
      }

      public boolean find(Block block) {
         if (block == this) return true;

         Block stack = above;
         while (stack != null) {
            if (stack == block) return true;
            stack = stack.above;
         }
         stack = top;
         while (stack != null) {
            if (stack == block) return true;
            stack = stack.top;
         }
         return false;
      }

      public void removeUpper() {
         Block block = top;
         while (block != null) {
            Block tmp = block.top;
            block.top = block.above = null;
            block = tmp;
         }
         top = null;
      }
   }
}

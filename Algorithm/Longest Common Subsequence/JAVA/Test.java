import java.io.*;

public class Test {
   public static void main(String args[]) {
      Test.run1();
      Test.run2();
   }

   public static void run1() {
      Integer[] array1 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0};
      Integer[] array2 = {1, 3, 2, 3, 4, 5, 0, 8, 9};
      Object[] lcs = LCS.find(array1, array2);

      System.out.println("Length: " + lcs.length);
      for (int i = 0; i < lcs.length; i++) {
         if (i > 0) System.out.print(", ");
         System.out.print((Integer) lcs[i]);
      }
      System.out.println("\n");
   }

   public static void run2() {
      String[] array1 = {"aaa", "b", "cc", "dddd", "eee", "ff"};
      String[] array2 = {"bbb", "b", "eee", "ff", "dddd"};
      Object[] lcs = LCS.find(array1, array2);

      System.out.println("Length: " + lcs.length);
      for (int i = 0; i < lcs.length; i++) {
         if (i > 0) System.out.print(", ");
         System.out.print((String) lcs[i]);
      }
      System.out.println("\n");
   }
}

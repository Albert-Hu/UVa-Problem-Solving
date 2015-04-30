public class LCS {
   private int length;
   private Object object;
   private LCS prev;

   private LCS() {
      length = 0;
      object = null;
      prev = null;
   }

   public static Object[] find(Object[] seq1, Object[] seq2) {
      LCS element;
      LCS[][] table = new LCS[seq1.length + 1][seq2.length + 1];

      for (int i = 0; i < table.length; i++) {
         for (int j = 0; j < table[i].length; j++) {
            table[i][j] = new LCS();
         }
      }

      for (int i = 0; i < seq1.length; i++) {
         for (int j = 0; j < seq2.length; j++) {
            if (seq1[i].equals(seq2[j])) {
               table[i+1][j+1].length = table[i][j].length + 1;
               table[i+1][j+1].object = seq1[i];
               table[i+1][j+1].prev = table[i][j];
            } else {
               if (table[i][j+1].length > table[i+1][j].length) {
                  table[i+1][j+1].length = table[i][j+1].length;
                  table[i+1][j+1].prev = table[i][j+1];
               } else {
                  table[i+1][j+1].length = table[i+1][j].length;
                  table[i+1][j+1].prev = table[i+1][j];
               }
            }
         }
      }

      element = table[seq1.length][seq2.length];
      Object[] lcs = new Object[element.length];
      int index = element.length;
      while (element != null) {
         if (element.object != null) {
            --index;
            lcs[index] = element.object;
         }
         element = element.prev;
      }

      return lcs;
   }
}

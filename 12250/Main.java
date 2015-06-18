import java.io.*;

public class Main {
   final static String[] language = {
      "ENGLISH",
      "SPANISH",
      "GERMAN",
      "FRENCH",
      "ITALIAN",
      "RUSSIAN"
   };
   final static String[] hello = {
      "HELLO",
      "HOLA",
      "HALLO",
      "BONJOUR",
      "CIAO",
      "ZDRAVSTVUJTE"
   };
   public static void main(String args[]) throws IOException {
      int testCase = 1;
      String line;
      BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

      while ((line = in.readLine()) != null) {
         if (line.charAt(0) == '#') break;
         boolean found = false;
         for (int i = 0; i < hello.length; i++) {
            if (hello[i].equals(line)) {
               found = true;
               System.out.println("Case " + testCase + ": " + language[i]);
               break;
            }
         }
         if (!found) {
            System.out.println("Case " + testCase + ": UNKNOWN");
         }
         ++testCase;
      }
   }
}

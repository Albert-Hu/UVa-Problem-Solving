#include <stdio.h>

const static char x[9][4] = {
   "x^8",
   "x^7",
   "x^6",
   "x^5",
   "x^4",
   "x^3",
   "x^2",
   "x",
   "",
};

int main(int argc, char* argv[])
{
   int i, first;
   int n[9];
   char negative[9];

   while (scanf("%d", &n[0]) == 1) {
      negative[0] = (n[0] < 0) ? 1 : 0;
      if (negative[0]) n[0] = -n[0];
      for (i = 1; i < 9; i++) {
         scanf("%d", &n[i]);
         negative[i] = (n[i] < 0) ? 1 : 0;
         if (negative[i]) n[i] = -n[i];
      }
      first = 0;
      while ((first < 8) && n[first] == 0) ++ first;
      printf("%s", (negative[first] == 1) ? "-" : "");
      if (!((n[first] == 1) && (first < 8))) {
         printf("%d", n[first]);
      }
      printf("%s", x[first]);
      for (i = first + 1; i < 9; i++) {
         if (n[i] == 0) continue;
         printf("%s", (negative[i] == 1) ? " - " : " + ");
         if (!((n[i] == 1) && (i < 8)))
            printf("%d", n[i]);
         printf("%s", x[i]);
      }
      printf("\n");
   }

   return 0;
}

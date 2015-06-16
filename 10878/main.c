#include <stdio.h>

int main(int argc, char* argv[])
{
   int i;
   char c, start, new_line;
   char input[12];

   start = 0;
   new_line = 0;
   while (gets(input) != NULL) {
      if (input[0] == '_') {
         if (start) {
            if (new_line) putchar('\n');
            start = 0;
            new_line = 1;
         } else {
            start = 1;
         }
      } else {
         c = 0;
         for (i = 1; i < 10; i++) {
            if (i == 6) continue;
            c = c << 1;
            if (input[i] == 'o') c |= 1;
         }
         putchar(c);
      }
   }

   return 0;
}

#include <stdio.h>
#include <memory.h>

int main(int argc, char* argv[])
{
   char new_line, c;
   int i, min, length;
   int ascii[95];

   new_line = 0;
   length = 0;
   memset(ascii, 0, sizeof(ascii));
   while ((c = getchar()) != EOF) {
      if (c == '\r') continue;
      if (c == '\n') {
         if (new_line) putchar('\n');
         while (length > 0) {
            min = 0x7fffffff;
            for (i = 0; i < 95; i++) {
               if (min > ascii[i] && ascii[i] > 0)
                  min = ascii[i];
            }
            for (i = 94; i >= 0; i--) {
               if (ascii[i] == min) {
                  printf("%d %d\n", (i+32), ascii[i]);
                  ascii[i] = 0;
                  length -= min;
               }
            }
         }
         new_line = 1;
         length = 0;
         memset(ascii, 0, sizeof(ascii));
      } else {
         ++length;
         ++ascii[c-32];
      }
   }

   return 0;
}

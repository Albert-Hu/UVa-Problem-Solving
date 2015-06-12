#include <stdio.h>
#include <memory.h>

int main(int argc, char* argv[])
{
   int i, j;
   int rows, middle, length, max_length = 0;
   char line[100][101];

   memset(line, 0, sizeof(line));

   rows = 0;
   while (gets(line[rows])) {
      length = strlen(line[rows]);
      if (length > max_length) {
         max_length = length;
         middle = rows;
      }
      ++rows;
   }

   for (i = 0; i < max_length; i++) {
      for (j = rows - 1; j >= 0; j--) {
         if (line[j][i] == '\0') {
            if (j > middle) putchar(' ');
         } else {
            if (line[j][i] == '\t')
               putchar(' ');
            else
               putchar(line[j][i]);
         }
      }
      putchar('\n');
   }

   return 0;
}

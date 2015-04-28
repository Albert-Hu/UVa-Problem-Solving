#include <stdio.h>
#include <memory.h>

#define MAX(a, b) ((a) > (b) ? (a) : (b))

int read_line(char* buf)
{
   int length = 0;

   while ((*buf = getchar()) != '\n') {
      if (*buf == '#') return -1;
      ++length;
      ++buf;
   }

   *buf = '\0';

   return length;
}

int main(int argc, char* argv[])
{
   int i, j;
   int test_case = 1;
   int left, lcs, upper_row[101];
   char cities[2][101];

   while (read_line(cities[0]) >= 0) {
      if (cities[0][0] == '#')
         break;

      read_line(cities[1]);

      left = lcs = 0;
      memset(upper_row, 0, sizeof(upper_row));

      for (i = 0; cities[0][i] != '\0'; i++) {
         for (j = 0; cities[1][j] != '\0'; j++) {
            if (cities[0][i] == cities[1][j]) {
               lcs = upper_row[j] + 1;
            } else {
               lcs = MAX(left, upper_row[j+1]);
            }
            upper_row[j] = left;
            left = lcs;
         }
         left = 0;
         upper_row[j] = lcs;
      }

      printf("Case #%d: you can visit at most %d cities.\n", test_case, lcs);
      ++test_case;
   }

   return 0;
}

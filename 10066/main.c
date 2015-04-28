#include <stdio.h>
#include <memory.h>

#define MAX(a, b) ((a) > (b) ? (a) : (b))

int main(int argc, char* argv[])
{
   int i, j;
   int tile[2];
   int tiles[2][100];
   int test_case = 1;
   int left, lcs, upper_row[101];

   while (scanf("%d%d", &tile[0], &tile[1]) == 2) {
      if (tile[0] == 0 && tile[1] == 0)
         break;

      left = 0;
      memset(upper_row, 0, sizeof(upper_row));

      for (i = 0; i < 2; i++) {
         for (j = 0; j < tile[i]; j++) {
            scanf("%d", &tiles[i][j]);
         }
      }

      for (i = 0; i < tile[0]; i++) {
         for (j = 0; j < tile[1]; j++) {
            if (tiles[0][i] == tiles[1][j]) {
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

      printf("Twin Towers #%d\n", test_case);
      printf("Number of Tiles : %d\n\n", lcs);
      ++test_case;
   }

   return 0;
}

#include <stdio.h>
#include <memory.h>

int find_arbitrage_sequence(int n)
{
   int i, j, k, m;
   int step[20], path[20][20][20];
   double profit, best[20][20][20];

   memset(best, 0, sizeof(best));

   for (i = 0; i < n; i++) {
      for (j = 0; j < n; j++) {
         if (i == j) {
            best[0][i][j] = 1.0;
         } else {
            scanf("%lf", &best[0][i][j]);
         }
      }
   }

   for (k = 0; k < n; k++) {
      for (i = 0; i < n; i++) {
         for (j = 0; j < n; j++) {
            path[k][i][j] = j;
         }
      }
   }

   for (m = 1; m < n; m++) {
      for (k = 0; k < n; k++) {
         for (i = 0; i < n; i++) {
            for (j = 0; j < n; j++) {
               profit = best[m-1][i][k] * best[0][k][j];
               if (best[m][i][j] < profit) {
                  best[m][i][j] = profit;
                  path[m][i][j] = k;
               }
            }
         }
      }
   }

   k = 0;
   for (m = 1; m < n && k == 0; m++) {
      for (i = 0; i < n && k == 0; i++) {
         if (best[m][i][i] >= 1.01) {
            k = m;
         }
      }
   }

   if (k > 0) {
      j = i;
      for (m = k; m >= 0; m--) {
         step[m] = i;
         i = path[m][j][i];
      }
      for (m = 0; m <= k; m++) {
         printf("%d ", step[m] + 1);
      }
      printf("%d\n", i + 1);
   } else {
      printf("no arbitrage sequence exists\n");
   }

   return 0;
}

int main(int argc, char* argv[])
{
   int n;

   while (scanf("%d", &n) == 1) {
      find_arbitrage_sequence(n);
   }

   return 0;
}

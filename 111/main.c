#include <stdio.h>
#include <memory.h>

#define MAX(a,b) ((a) > (b) ? (a) : (b))

int main(int argc, char* argv[])
{
   int i, j, n, order;
   int table[21][21];
   int events[2][20];

   memset(table, 0, sizeof(table));

   scanf("%d", &n);
   for (i = 1; i <= n; i++) {
      scanf("%d", &order);
      events[0][order-1] = i;
   }

   while (scanf("%d", &order) == 1) {
      events[1][order-1] = 1;
      for (i = 2; i <=n ; i++) {
         scanf("%d", &order);
         events[1][order-1] = i;
      }

      for (i = 0; i < n; i++) {
         for (j = 0; j < n; j++) {
            if (events[0][i] == events[1][j]) {
               table[i+1][j+1] = table[i][j] + 1;
            } else {
               table[i+1][j+1] = MAX(table[i][j+1], table[i+1][j]);
            }
         }
      }
      printf("%d\n", table[i][j]);
   }

   return 0;
}

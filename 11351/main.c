#include <stdio.h>
#include <memory.h>

int main(int argc, char* argv[])
{
   int i, j, t, n, k, alive;

   scanf("%d", &t);
   for (i = 1; i <= t; i++) {
      scanf("%d%d", &n, &k);
      alive = 0;
      for (j = 1; j <= n; j++) {
         alive = (alive + k) % j;
      }
      printf("Case %d: %d\n", i, alive + 1);
   }

   return 0;
}

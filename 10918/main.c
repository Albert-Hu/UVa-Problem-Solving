#include <stdio.h>

int main(int argc, char* argv[])
{
   int n;
   int tiles[16];

   tiles[0] = 1;
   tiles[1] = 3;
   for (n = 2; n < 16; ++n) {
      tiles[n] = (tiles[n - 1] * 4) - (tiles[n - 2]);
   }

   while (scanf("%d", &n) == 1 && n != -1) {
      printf("%d\n", (n % 2 == 0) ? tiles[n / 2] : 0);
   }

   return 0;
}

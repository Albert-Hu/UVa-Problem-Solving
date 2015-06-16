#include <stdio.h>
#include <memory.h>

int main(int argc, char* argv[])
{
   int a, b, h;
   int height[10001];

   memset(height, 0, sizeof(height));
   while (scanf("%d%d%d", &a, &h, &b) == 3) {
      while (a < b) {
         if (height[a] < h) height[a] = h;
         ++a;
      }
   }

   for (a = b = h = 0; a < 10001; a++) {
      if (h != height[a]) {
         if (b) putchar(' ');
         printf("%d %d", a, height[a]);
         b = 1;
         h = height[a];
      }
   }
   printf("\n");

   return 0;
}

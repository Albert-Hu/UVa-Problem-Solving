#include <stdio.h>
#include <memory.h>

int main(int argc, char* argv[])
{
   int a, b, h, min, max;
   int height[10001];

   max = 0;
   min = 0x7FFFFFFF;
   memset(height, 0, sizeof(height));
   while (scanf("%d%d%d", &a, &h, &b) == 3) {
      if (a < min) min = a;
      if (b > max) max = b;
      while (a < b) {
         if (height[a] < h) height[a] = h;
         ++a;
      }
   }

   printf("%d %d", min, height[min]);
   while (min <= max) {
      ++min;
      if (height[min] != height[min - 1])
         printf(" %d %d", min, height[min]);
   }
   printf("\n");

   return 0;
}

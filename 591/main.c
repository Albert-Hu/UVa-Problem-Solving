#include <stdio.h>

int main(int argc, char* argv[])
{
   int height[50];
   int n, i, test_case, average, total;

   test_case = 1;
   while (scanf("%d", &n) == 1 && n > 0) {
      average = 0;
      for (i = 0; i < n; i++) {
         scanf("%d", &height[i]);
         average += height[i];
      }
      total = 0;
      average /= n;
      for (i = 0; i < n; i++) {
         if (height[i] > average) {
            total += (height[i] - average);
         }
      }
      printf("Set #%d\n", test_case);
      printf("The minimum number of moves is %d.\n\n", total);
      ++test_case;
   }

   return 0;
}

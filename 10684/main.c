#include <stdio.h>

int main(int argc, char* argv[])
{
   int n, i, max;
   int array[10000];

   while (scanf("%d", &n) == 1 && n != 0) {
      for (i = 0; i < n; i++) {
         scanf("%d", &array[i]);
      }
      max = array[0];
      for (i = 1; i < n; i++) {
         if ((array[i] + array[i - 1]) > array[i]) {
            array[i] += array[i - 1];
         }
         if (max < array[i]) max = array[i];
      }
      if (max > 0) {
         printf("The maximum winning streak is %d.\n", max);
      } else {
         printf("Losing streak.\n");
      }
   }

   return 0;
}

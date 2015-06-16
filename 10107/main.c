#include <stdio.h>
#include <memory.h>

int main(int argc, char* argv[])
{
   int start, middle, end;
   int n, i, count = 0;
   int array[10000];

   while (scanf("%d", &n) == 1) {
      start = 0;
      end = count;
      while (start != end) {
         middle = (end - start) / 2;
         if (array[start + middle] < n) {
            start = start + middle + 1;
         } else {
            end = start + middle;
         }
      }
      for (i = count; i > start; i--)
         array[i] = array[i - 1];
      array[start] = n;
      ++count;
      if (count & 1) {
         printf("%d\n", array[count/2]);
      } else {
         printf("%d\n", ((array[count/2]+array[(count/2)-1])/2));
      }
   }

   return 0;
}

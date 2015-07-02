#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int gcd(int a, int b)
{
   int tmp;

   do {
      tmp = b;
      b = a % b;
      a = tmp;
   } while (b);

   return a;
}

int main(int argc, char* argv[])
{
   int t, i, j, g, max, len;
   int array[100];
   char* n;
   char input[1000];

   scanf("%d\n", &t);
   while (t-- > 0) {
      gets(input);
      max = len = 0;
      n = strtok(input, " ");
      while (n != NULL) {
         array[len] = atoi(n);
         n = strtok(NULL, " ");
         ++len;
      }
      for (i = 0; i < len; i++) {
         for (j = i + 1; j < len; j++) {
            g = gcd(array[i], array[j]);
            if (g > max) max = g;
         }
      }
      printf("%d\n", max);
   }
   return 0;
}

#include <stdio.h>
#include <stdlib.h>
#include <memory.h>

#define MAX_NUM 1000001

int generate(int n)
{
   int sum = n;

   while (n > 0) {
      sum += (n % 10);
      n /= 10;
   }

   return sum;
}

int main(int argc, char* argv[])
{
   int i, n;
   char* generator;

   generator = (char*) malloc(MAX_NUM);
   memset(generator, 1, MAX_NUM);

   for (i = 1; i < MAX_NUM; ++i) {
      n = generate(i);
      while (generator[n]) {
         generator[n] = 0;
         n = generate(n);
         if (n >= MAX_NUM)
            break;
      }
   }

   for (i = 1; i < MAX_NUM; ++i) {
      if (generator[i]) {
         printf("%d\n", i);
      }
   }

   return 0;
}

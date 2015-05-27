#include <stdio.h>

int main(int argc, char* argv[])
{
   int n, t;
   unsigned long long int x;

   while (scanf("%d", &n) == 1) {
      t = 1;
      x = 1;
      while ((x % n) != 0) {
         ++t;
         x = ((x * 10) + 1) % n;
      }
      printf("%d\n", t);
   }

   return 0;
}

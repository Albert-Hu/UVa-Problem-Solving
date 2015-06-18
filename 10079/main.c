#include <stdio.h>

int main(int argc, char* argv[])
{
   long long int n;

   while (scanf("%lld", &n) == 1 && n >= 0) {
      n = (((n + 1) * n) / 2) + 1;
      printf("%lld\n", n);
   }

   return 0;
}

#include <stdio.h>

int main(int argc, char* argv[])
{
   long long int n;

   while (scanf("%lld", &n) == 1) {
      n = ((n + 1) * ((n + 1) / 2)) - 1;
      n = (n * 3) - 6;
      printf("%lld\n", n);
   }

   return 0;
}

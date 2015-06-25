#include <stdio.h>

int main(int argc, char* argv[])
{
   int year;
   long long int n, m, a, b;

   while (scanf("%d", &year) == 1 && year >= 0) {
      a = n = 0;
      b = m = 1;
      while (year-- > 0) {
         n = n + m;
         m = n - m;
         a = a + n;
      }
      b = a + n + m;
      printf("%lld %lld\n", a, b);
   }

   return 0;
}

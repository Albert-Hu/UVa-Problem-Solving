#include <stdio.h>

int main(int argc, char* argv[])
{
   int n, m, i;
   unsigned long long int result;

   while (scanf("%d%d", &n, &m) == 2) {
      if (n == 0 && m == 0) break;
      if ((n - m) < m) m = n - m;
      result = 1;
      for (i = 0; i < m; i++)
         result = result * (n - i) / (i + 1);
      printf("%lld\n", result);
   }

   return 0;
}

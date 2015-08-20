#include <stdio.h>
#include <math.h>

int main(int argc, char* argv[])
{
   int t, a, b, i, n, s;
   long long int result;

   scanf("%d", &t);
   while (t-- > 0) {
      scanf("%d", &n);
      s = sqrt(n);
      result = 0;
      for (i = 1; i <= s; i++) {
         b = n / i;
         a = (b == i) ? b : (n / (i + 1));
         result = result + b + ((b - a) * i);
      }
      printf("%lld\n", result);
   }

   return 0;
}

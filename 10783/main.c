#include <stdio.h>

int main(int argc, char* argv[])
{
   int n, t, a, b;

   scanf("%d", &n);
   for (t = 1; t <= n; t++) {
      scanf("%d%d", &a, &b);
      if (a % 2 == 0 && a == b) {
         printf("Case %d: 0\n", t);
      } else {
         if (a % 2 == 0) ++a;
         if (b % 2 == 0) --b;
         printf("Case %d: %d\n", t, ((a + b) * (((b - a) / 2) + 1)) / 2);
      }
   }

   return 0;
}

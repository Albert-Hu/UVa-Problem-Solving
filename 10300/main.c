#include <stdio.h>

int main(int argc, char* argv[])
{
   int n, m;
   double a, b, c, sum;

   scanf("%d", &n);
   while (n-- > 0) {
      scanf("%d", &m);
      sum = 0;
      while (m-- > 0) {
         scanf("%lf%lf%lf", &a, &b, &c);
         sum += (((a / b) * c) * b);
      }
      printf("%.0lf\n", sum);
   }

   return 0;
}

#include <stdio.h>
#include <math.h>

int main(int argc, char* argv[])
{
   double n, p;

   while (scanf("%lf%lf", &n, &p) == 2) {
      printf("%.0lf\n", pow(p, 1/n));
   }

   return 0;
}

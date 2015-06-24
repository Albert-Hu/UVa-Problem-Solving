#include <stdio.h>
#include <math.h>

int main(int argc, char* argv[])
{
   int n;
   double s;
   char yes;

   while (scanf("%d", &n) == 1 && n != 0) {
      s = sqrt((double) n);
      yes = (((int) s * (int) s) == n);
      printf("%s\n", (yes == 1) ? "yes" : "no");
   }
   return 0;
}

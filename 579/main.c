#include <stdio.h>

int main(int argc, char* argv[])
{
   int h, m;
   double d;

   while (scanf("%d:%d", &h, &m) == 2) {
      if (h == 0 && m == 0)
         break;
      d = (((h * 30) % 360) + ((m / 60.0) * 30)) - (m * 6.0);
      if (d < 0) d = -d;
      if (d > 180) d = 360- d;
      printf("%0.3lf\n", d);
   }

   return 0;
}

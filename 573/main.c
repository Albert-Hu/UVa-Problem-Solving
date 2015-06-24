#include <stdio.h>

int main(int argc, char* argv[])
{
   int h, u, d, f;
   int day, climbed;

   while (scanf("%d%d%d%d", &h, &u, &d, &f) == 4) {
      if (h == 0 && u == 0 && d == 0 && f == 0)
         break;
      f = u * f;
      h *= 100;
      u *= 100;
      d *= 100;
      day = 1;
      climbed = u;
      while (climbed <= h) {
         climbed -= d;
         if (climbed < 0)
            break;
         if (f > u) {
            u = 0;
         } else {
            u -= f;
         }
         climbed += u;
         day++;
      }
      printf("%s on day %d\n", (climbed > 0) ? "success" : "failure", day);
   }

   return 0;
}

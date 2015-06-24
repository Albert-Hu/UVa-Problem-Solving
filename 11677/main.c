#include <stdio.h>

int main(int argc, char* argv[])
{
   int hour[2];
   int minute[2];

   while (scanf("%d%d%d%d", &hour[0], &minute[0], &hour[1], &minute[1]) == 4) {
      if (hour[0] == 0 && hour[1] == 0 && minute[0] == 0 && minute[1] == 0)
         break;
      minute[0] += (hour[0] * 60);
      minute[1] += (hour[1] * 60);
      if (minute[0] <= minute[1]) {
         printf("%d\n", (minute[1] - minute[0]));
      } else {
         minute[0] = (24 * 60) - minute[0];
         printf("%d\n", (minute[0] + minute[1]));
      }
   }

   return 0;
}

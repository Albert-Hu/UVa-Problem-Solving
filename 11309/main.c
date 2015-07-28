#include <stdio.h>

int main(int argc, char* argv[])
{
   int t, h, m, tmp;

   scanf("%d", &t);
   while (t-- > 0) {
      scanf("%d:%d", &h, &m);
      tmp = (h * 100) + m;
      if (tmp < 9) {
         ++tmp;
      } else if (tmp < 55) {
         if ((tmp / 10) <= (tmp % 10)) {
            tmp += 10;
         }
         tmp = (tmp - (tmp % 10)) + (tmp / 10);
      } else if (tmp < 959) {
         if ((tmp / 100) <= (tmp % 10)) {
            if ((tmp % 100) < 50) {
               tmp += 10;
            } else {
               tmp = (tmp + 100) - (tmp % 100);
            }
         }
         tmp = (tmp - (tmp % 10)) + (tmp / 100);
      } else {
         if (((h % 10) * 10 + (h / 10)) <= m || h < 10){
            if (tmp < 2300) {
               tmp += 100;
            } else {
               tmp = 0;
            }
         }
         tmp = tmp - (tmp % 100);
         if (tmp > 1551 && tmp < 2000) tmp = 2000;
         tmp = tmp + ((tmp % 1000) / 10) + (tmp / 1000);
      }
      printf("%02d:%02d\n", tmp / 100, tmp % 100);
   }

   return 0;
}

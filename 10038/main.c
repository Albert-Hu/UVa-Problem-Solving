#include <stdio.h>
#include <memory.h>

int main(int argc, char* argv[])
{
   int n, i, a, b, c;
   char diff[3000];

   while (scanf("%d", &n) == 1) {
      memset(diff, 0, n);
      scanf("%d", &a);
      for (i = 1; i < n; i++) {
         scanf("%d", &b);
         c = b - a;
         if (c < 0) c = -c;
         if (c < n) diff[c] = 1;
         a = b;
      }
      for (i = 1; i < n; i++) {
         if (diff[i] == 0) {
            printf("Not jolly\n");
            break;
         }
      }
      if (i == n) {
         printf("Jolly\n");
      }
   }

   return 0;
}

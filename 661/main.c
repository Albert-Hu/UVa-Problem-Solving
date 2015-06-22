#include <stdio.h>

int main(int argc, char* argv[])
{
   int max, consumed;
   int i, n, m, c;
   int sequence = 1;
   int consumption[21];
   char blown;
   char device[21];

   while (scanf("%d%d%d", &n, &m, &c) == 3) {
      if (n == 0 && m == 0 && c == 0) break;
      for (i = 1; i <= n; i++) {
         scanf("%d", &consumption[i]);
         device[i] = 0;
      }
      blown = 0;
      max = consumed = 0;
      while (m-- > 0) {
         scanf("%d", &i);
         device[i] = !device[i];
         if (device[i]) {
            consumed += consumption[i];
            if (consumed > max) max = consumed;
            if (consumed > c) blown = 1;
         } else {
            consumed -= consumption[i];
         }
      }
      printf("Sequence %d\n", sequence);
      if (blown) {
         printf("Fuse was blown.\n\n");
      } else {
         printf("Fuse was not blown.\n");
         printf("Maximal power consumption was %d amperes.\n\n", max);
      }
      ++sequence;
   }

   return 0;
}

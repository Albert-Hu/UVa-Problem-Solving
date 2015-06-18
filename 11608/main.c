#include <stdio.h>

int main(int argc, char* argv[])
{
   int i, s;
   int test_case = 1;
   int need[12];
   int produce[12];

   while (scanf("%d", &s) == 1 && s >= 0) {
      printf("Case %d:\n", test_case);
      ++test_case;
      for (i = 0; i < 12; i++) {
         scanf("%d", &produce[i]);
      }
      for (i = 0; i < 12; i++) {
         scanf("%d", &need[i]);
      }
      for (i = 0; i < 12; i++) {
         if (i > 0)
            s += produce[i - 1];
         if (s >= need[i]) {
            s -= need[i];
            printf("No problem! :D\n");
         } else {
            printf("No problem. :(\n");
         }
      }
   }

   return 0;
}

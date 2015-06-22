#include <stdio.h>
#include <memory.h>

int main(int argc, char* argv[])
{
   int total;
   int n, m, i, j, tmp;
   int test_case = 1;
   int table[50001];

   while (scanf("%d%d", &n, &m) == 2) {
      if (n == 0 && m == 0) break;
      for (i = 1; i <= n; i++) {
         table[i] = i;
      }
      while (m-- > 0) {
         scanf("%d%d", &i, &j);
         if (table[i] == i) {
            while (table[j] != j) {
               j = table[j];
            }
            table[i] = j;
         } else if (table[j] == j) {
            while (table[i] != i) {
               i = table[i];
            }
            table[j] = i;
         } else {
            while (table[i] != i) {
               i = table[i];
            }
            while (table[j] != j) {
               tmp = table[j];
               table[j] = i;
               j = tmp;
            }
            table[j] = i;
         }
      }
      total = 0;
      for (i = 1; i <= n; i++) {
         if (table[i] == i) {
            ++total;
         }
      }
      printf("Case %d: %d\n", test_case, total);
      ++test_case;
   }

   return 0;
}

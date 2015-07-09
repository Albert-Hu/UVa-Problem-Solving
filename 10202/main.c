#include <stdio.h>
#include <stdlib.h>
#include <memory.h>

int compare(const void* a, const void* b)
{
   return (*(int *) a - *(int *) b);
}

int main(int argc, char* argv[])
{
   int n, m, i, j, k, l;
   int sum;
   int number[10];
   int summation[36];
   char found;
   char selected[36];

   while (scanf("%d", &n) == 1) {
      m = (n * (n - 1)) / 2;
      for (i = 0; i < m; i++) {
         scanf("%d", &summation[i]);
      }
      qsort(summation, m, sizeof(int), compare);
      found = 0;
      sum = summation[0] + summation[1];
      for (i = 2; i < m; i++) {
         if ((sum - summation[i]) % 2 == 1)
            continue;
         number[0] = (sum - summation[i]) / 2;
         number[1] = summation[0] - number[0];
         number[2] = summation[1] - number[0];
         memset(selected, 0, sizeof(selected));
         selected[0] = selected[1] = selected[i] = 1;
         for (j = 3; j < n; j++) {
            for (k = 0; k < m; k++) {
               if (!selected[k]) break;
            }
            if (k == m) break;
            selected[k] = 1;
            number[j] = summation[k] - number[0];
            for (l = 1; l < j; l++) {
               for (k = 0; k < m; k++) {
                  if (!selected[k] && summation[k] == (number[l] + number[j])) {
                     selected[k] = 1;
                     break;
                  }
               }
               if (k == m) break;
            }
            if (l != j) break;
         }
         if (j == n) {
            found = 1;
            break;
         }
      }
      if (found) {
         found = 0;
         memset(selected, 0, sizeof(selected));
         for (i = 0; i < n; i++) {
            for (j = i + 1; j < n; j++) {
               for (k = 0; k < m; k++) {
                  if (!selected[k] && summation[k] == (number[i] + number[j])) {
                     selected[k] = 1;
                     ++found;
                     break;
                  }
               }
            }
         }
      }
      if (found == m) {
         printf("%d", number[0]);
         for (i = 1; i < n; i++)
            printf(" %d", number[i]);
         printf("\n");
      } else {
         printf("Impossible\n");
      }
   }

   return 0;
}

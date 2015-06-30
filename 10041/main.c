#include <stdio.h>
#include <memory.h>

#define LEN 30000

int main(int argc, char* argv[])
{
   int min;
   int t, r, i, j;
   int n[LEN];
   int n_count[LEN];

   scanf("%d", &t);
   while (t-- > 0) {
      memset(n_count, 0, sizeof(n_count));
      scanf("%d", &r);
      for (j = 0; j < r; j++) {
         scanf("%d", &i);
         n_count[i]++;
      }
      for (i = j = 0; i < LEN; i++) {
         if (n_count[i] == 0) continue;
         while (n_count[i]-- > 0) {
            n[j] = i;
            ++j;
         }
      }
      min = 0;
      j = r / 2;
      for (i = 0; i < r; i++) {
         if (i == j) continue;
         min += (n[i] > n[j]) ? (n[i] - n[j]) : (n[j] - n[i]);
      }
      printf("%d\n", min);
   }

   return 0;
}

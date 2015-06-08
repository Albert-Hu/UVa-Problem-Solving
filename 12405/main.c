#include <stdio.h>

int main(int argc, char* argv[])
{
   int n, m, i, j;
   int count, flag;
   char input[101];

   scanf("%d", &n);
   for (i = 1; i <= n;i++) {
      scanf("%d", &m);
      scanf("%s", input);

      count = flag = 0;
      for (j = 0; j < m; j++) {
         if (flag == 4 || flag == 5 || flag == 6 || flag == 7) {
            flag = 0;
            ++count;
         }
         flag = (flag << 1);
         if (input[j] == '.')
            flag |= 1;
      }
      if (flag != 0) ++count;

      printf("Case %d: %d\n", i, count);
   }

   return 0;
}

#include <stdio.h>

int main(int argc, char* argv[])
{
   int n, m;

   while (scanf("%d%d", &n, &m) == 2) {
      printf("%d\n", ((n - 1) + (n * (m - 1))));
   }

   return 0;
}

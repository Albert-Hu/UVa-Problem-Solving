#include <stdio.h>

int main(int argc, char* argv[])
{
   int n;
   while (scanf("%d", &n) == 1 && n != 0) {
      printf("f91(%d) = %d\n", n, (n <= 100) ? 91 : (n - 10));
   }
   return 0;
}

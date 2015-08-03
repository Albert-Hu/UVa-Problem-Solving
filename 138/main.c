#include <stdio.h>

int main(int argc, char* argv[])
{
   int swap, line = 0;
   int x = 8;
   int n[2] = {1, 6};

   while (line < 10) {
      printf("%10d%10d\n", n[1], x);
      swap = n[1];
      n[1] = 6 * n[1] - n[0];
      n[0] = swap;
      x = x + n[0] + n[1];
      ++line;
   }

   return 0;
}

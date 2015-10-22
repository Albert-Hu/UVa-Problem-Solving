#include <stdio.h>

int main(int argc, char* argv[])
{
   int i;
   int length;
   long long int fibonacci[51];

   fibonacci[0] = fibonacci[1] = 1;
   for (i = 2; i < 51; ++i) {
      fibonacci[i] = fibonacci[i - 2] + fibonacci[i - 1];
   }

   while (scanf("%d", &length) == 1 && length != 0) {
      printf("%lld\n", fibonacci[length]);
   }

   return 0;
}

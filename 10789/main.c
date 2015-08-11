#include <stdio.h>

int main(int argc, char* argv[])
{
   int i, j, t;
   int c[128];
   int prime[2002];
   char empty;
   char input[2002];

   for (i = 0; i < 2002; i++)
      prime[i] = i % 2;

   prime[1] = 0;
   prime[2] = 1;
   for (i = 3; i * i <= 2002; i += 2) {
      for (j = i; j * i <= 2002; j += 2) {
         prime[j * i] = 0;
      }
   }

   scanf("%d", &t);
   for (j = 1; j <= t; j++) {
      scanf("%s", input);
      for (i = 0; i < 128; i++)
         c[i] = 0;
      for (i = 0; input[i] != '\0'; i++)
         ++c[input[i]];
      printf("Case %d: ", j);
      empty = 1;
      for (i = 32; i < 128; i++) {
         if (prime[c[i]]) {
            putchar((char) i);
            empty = 0;
         }
      }
      puts((empty == 1) ? "empty" : "");
   }

   return 0;
}

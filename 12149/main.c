#include <stdio.h>

int main(int argc, char* argv[])
{
   int n, answer;

   while (scanf("%d", &n) == 1 && n != 0) {
      answer = 1;
      while (n > 1) {
         answer += (n * n);
         --n;
      }
      printf("%d\n", answer);
   }

   return 0;
}

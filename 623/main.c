#include <stdio.h>
#include <memory.h>

#define LENGTH 428
#define CARRY  1000000

static int factorial_length[1001];
static int factorial[1001][LENGTH];

int main(int argc, char* argv[])
{
   int n, i, j;
   int length;
   int carry;
   int* prev;
   int* result;

   factorial[0][0] = factorial[1][0] = 1;
   factorial_length[0] = factorial_length[1] = 1;
   for (i = 2; i <= 1000; i++) {
      carry = 0;
      result = factorial[i];
      prev = factorial[i - 1];
      length = factorial_length[i - 1];
      for (j = 0; j < length; j++) {
         result[j] = prev[j] * i;
         result[j] += carry;
         carry = result[j] / CARRY;
         result[j] %= CARRY;
      }
      if (carry != 0) {
         result[j] = carry;
         ++length;
      }
      factorial_length[i] = length;
   }

   while (scanf("%d", &n) == 1) {
      result = factorial[n];
      length = factorial_length[n];
      printf("%d!\n", n);
      printf("%d", result[--length]);
      while (length-- > 0) {
         printf("%06d", result[length]);
      }
      printf("\n");
   }

   return 0;
}

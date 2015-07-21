#include <stdio.h>

#define CARRY 10000

int main(int argc, char* argv[])
{
   int i, j, n, pre, carry;
   int number[1001][650];
   int length[1001];
   int sum[1001];

   number[1][0] = length[1] = 1;
   for (i = 2; i < 1001; i++) {
      pre = i - 1;
      carry = 0;
      length[i] = length[pre];
      for (j = 0; j < length[pre]; j++) {
         number[i][j] = (number[pre][j] * i) + carry;
         if (number[i][j] < CARRY) {
            carry = 0;
         } else {
            carry = number[i][j] / CARRY;
            number[i][j] %= CARRY;
         }
      }
      if (carry) {
         number[i][length[i]] = carry;
         ++length[i];
      }
   }

   for (i = 1; i < 1001; i++) {
      sum[i] = 0;
      for (j = 0; j < length[i]; j++) {
         n = number[i][j];
         while (n > 0) {
            sum[i] += (n % 10);
            n /= 10;
         }
      }
   }

   while (scanf("%d", &n) == 1) {
      printf("%d\n", sum[n]);
   }

   return 0;
}

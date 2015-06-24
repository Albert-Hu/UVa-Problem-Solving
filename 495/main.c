#include <stdio.h>
#include <memory.h>

#define MAX   5001
#define CARRY 1000000000

static int number[MAX][120];
static int length[MAX];

void generate_fibonacci_number()
{
   int n, i, a, b, carry;

   memset(number, 0, sizeof(number));

   number[0][0] = 0;
   number[1][0] = 1;
   length[0] = 1;
   length[1] = 1;

   for (n = 2; n < MAX; n++) {
      carry = 0;
      a = n - 2;
      b = n - 1;
      length[n] = length[b];
      for (i = 0; i < length[n]; i++) {
         number[n][i] = number[a][i] + number[b][i] + carry;
         if (number[n][i] >= CARRY) {
            carry = number[n][i] / CARRY;
            number[n][i] %= CARRY;
         } else {
            carry = 0;
         }
      }
      if (carry > 0) {
         number[n][i] = carry;
         ++length[n];
      }
   }
}

int main(int argc, char* argv[])
{
   int n, i;

   generate_fibonacci_number();

   while (scanf("%d", &n) == 1) {
      i = length[n] - 1;
      printf("The Fibonacci number for %d is %d", n, number[n][i]);
      while (i-- > 0) {
         printf("%09d", number[n][i]);
      }
      printf("\n");
   }

   return 0;
}

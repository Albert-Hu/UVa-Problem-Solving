#include <stdio.h>

int main(int argc, char* argv[])
{
   char str[2][10];
   int i, j, carry;
   int a, b, is_carry, sum;

   while (scanf("%d%d", &a, &b) == 2) {
      if (a == 0 && b == 0) break;
      sum = a + b;
      i = sprintf(str[0], "%d", sum);
      j = sprintf(str[1], "%d", (a > b) ? a : b);
      --i, --j;
      carry = is_carry = 0;
      while (j >= 0) {
         if (str[0][i] < str[1][j]) {
            is_carry = 1;
            ++carry;
         } else if (str[0][i] == str[1][j] && is_carry == 1) {
            ++carry;
         } else {
            is_carry = 0;
         }
         --i, --j;
      }
      if (carry) {
         printf("%d carry %s.\n", carry, (carry == 1) ? "operation" : "operations");
      } else {
         printf("No carry operation.\n");
      }
   }

   return 0;
}

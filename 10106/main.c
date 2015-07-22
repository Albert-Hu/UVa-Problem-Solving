#include <stdio.h>
#include <string.h>
#include <memory.h>

#define CARRY      10000
#define ARRAY_SIZE 150

int multiply(int* a, int a_len, int* b, int b_len, int* result)
{
   int i, j, k, carry, len;
   int tmp[ARRAY_SIZE];

   for (i = 0; i < a_len; i++) {
      carry = 0;
      for (len = 0; len < b_len; len++) {
         tmp[len] = (a[i] * b[len]) + carry;
         if (tmp[len] >= CARRY) {
            carry = tmp[len] / CARRY;
            tmp[len] %= CARRY;
         } else {
            carry = 0;
         }
      }
      if (carry) tmp[len++] = carry;
      carry = 0;
      for (j = 0, k = i; j < len; j++, k++) {
         result[k] += (tmp[j] + carry);
         if (result[k] >= CARRY) {
            carry = result[k] / CARRY;
            result[k] %= CARRY;
         } else {
            carry = 0;
         }
      }
      if (carry) {
         result[k++] = carry;
      }
   }

   len = a_len + b_len;
   while (len > 0 && result[len] == 0) --len;

   return len + 1;
}

int str_to_bignumber(char* str, int str_len, int* n)
{
   int i, t, len;

   t = 1;
   len = 0;
   n[0] = 0;
   for (i = str_len - 1; i >= 0; i--) {
      if (t == CARRY) {
         t = 1;
         ++len;
         n[len] = 0;
      }
      n[len] += (str[i] - '0') * t;
      t *= 10;
   }

   return len + 1;
}

int main(int argc, char* argv[])
{
   char input[2][252];
   int i;
   int length[3];
   int number[3][ARRAY_SIZE];

   while (scanf("%s%s", input[0], input[1]) == 2) {
      length[0] = str_to_bignumber(input[0], strlen(input[0]), number[0]);
      length[1] = str_to_bignumber(input[1], strlen(input[1]), number[1]);
      memset(&number[2], 0, sizeof(int) * ARRAY_SIZE);
      length[2] = multiply(number[0], length[0], number[1], length[1], number[2]);

      printf("%d", number[2][length[2] - 1]);
      for (i = length[2] - 2; i >= 0; i--) {
         printf("%04d", number[2][i]);
      }
      printf("\n");
   }

   return 0;
}

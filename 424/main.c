#include <stdio.h>

#define LEN 104

int main(int argc, char* argv[])
{
   int i, sum, carry;
   int input_len, output_len;
   char input[LEN];
   char output[LEN];

   for (i = 0; i < LEN; i++)
      output[i] = '0';
   output[LEN - 1] = '\0';
   while (scanf("%s", input) == 1) {
      for (input_len = 0; input[input_len] != '\0'; input_len++);
      carry = 0;
      output_len = LEN - 2;
      while (input_len-- > 0) {
         sum = (input[input_len] - '0') + (output[output_len] - '0') + carry;
         if (sum >= 10) {
            carry = 1;
            sum -= 10;
         } else {
            carry = 0;
         }
         output[output_len] = sum + '0';
         --output_len;
      }
      while (output_len > 0 && carry > 0) {
         sum = (output[output_len] - '0') + carry;
         if (sum >= 10) {
            carry = 1;
            sum -= 10;
         } else {
            carry = 0;
         }
         output[output_len] = sum + '0';
         --output_len;
      }
   }
   output_len = 0;
   while (output[output_len] == '0') ++output_len;
   printf("%s\n", &output[output_len]);

   return 0;
}

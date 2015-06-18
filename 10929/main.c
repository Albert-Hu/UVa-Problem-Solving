#include <stdio.h>

int main(int argc, char* argv[])
{
   char input[1001];
   int i, sum_odd, sum_even;

   while (gets(input) != NULL) {
      if (input[0] == '0' && input[1] == '\0')
         break;
      sum_odd = sum_even = 0;
      for (i = 0; input[i] != '\0'; i++) {
         if (i & 1) {
            sum_odd += (input[i] - '0');
         } else {
            sum_even += (input[i] - '0');
         }
      }
      printf("%s is%sa multiple of 11.\n", input, ((sum_odd - sum_even) % 11 == 0 ? " " : " not "));
   }

   return 0;
}

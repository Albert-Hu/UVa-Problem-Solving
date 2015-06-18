#include <stdio.h>

int main(int argc, char* argv[])
{
   char input[1000];
   char is_ordinary, is_leap, new_line = 0;
   int length, sum_odd, sum_even, tmp;
   int multiple4, multiple100, multiple400;

   while (scanf("%s", input) == 1) {
      if (new_line) {
         printf("\n");
      } else {
         new_line = 1;
      }
      is_leap = 0;
      is_ordinary = 1;
      sum_odd = sum_even = 0;
      for (length = 0; input[length] != '\0'; length++) {
         if (length & 1) {
            sum_odd += (input[length] - '0');
         } else {
            sum_even += (input[length] - '0');
         }
      }
      multiple4 = ((input[length - 2] - '0') * 10) + (input[length - 1] - '0');
      multiple100 = (input[length - 2] - '0') + (input[length - 1] - '0');
      multiple400 = ((input[length - 4] - '0') * 10) + (input[length - 3] - '0');
      if ((multiple4 % 4 == 0 && multiple100 != 0) || (multiple400 % 4 == 0 && multiple100 == 0)) {
         printf("This is leap year.\n");
         is_leap = 1;
         is_ordinary = 0;
      }
      tmp = input[length - 1] - '0';
      if (((sum_odd + sum_even) % 3 == 0) && (tmp == 0 || tmp == 5)) {
         printf("This is huluculu festival year.\n");
         is_ordinary = 0;
      }
      if (((sum_odd - sum_even) % 11) == 0 && (tmp == 0 || tmp == 5) && is_leap) {
         printf("This is bulukulu festival year.\n");
         is_ordinary = 0;
      }
      if (is_ordinary) {
         printf("This is an ordinary year.\n");
      }
   }

   return 0;
}

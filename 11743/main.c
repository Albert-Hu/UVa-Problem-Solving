#include <stdio.h>

int main(int argc, char* argv[])
{
   int t, i, j;
   int number, checksum;
   char input[32];

   scanf("%d\n", &t);
   while (t-- > 0) {
      gets(input);
      checksum = 0;
      for (i = j = 0; input[i] != '\0'; i++) {
         if (input[i] != ' ') {
            ++j;
            number = input[i] - '0';
            if (j % 2 == 1) {
               number += number;
               checksum += ((number / 10) + (number % 10));
            } else {
               checksum += number;
            }
         }
      }
      puts((checksum % 10 == 0) ? "Valid" : "Invalid");
   }

   return 0;
}

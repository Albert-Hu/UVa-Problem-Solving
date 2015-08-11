#include <stdio.h>

int str_to_int(char* str, int str_len)
{
   int i, n = 0;

   for (i = 0; i < str_len; i++) {
      n *= 10;
      n += (str[i] - '0');
   }

   return n;
}

int main(int argc, char* argv[])
{
   int sum, i, len;
   char add;
   char input[1000];

   while (gets(input) != NULL && !(input[0] == '0' && input[1] == '\0')) {
      for (len = 0; input[len] != '\0'; len++);

      sum = str_to_int(input, (len < 9) ? len : (len % 8));
      for (i = len % 8, add = 0; i < len; i += 8, add = !add) {
         if (add) sum += str_to_int(&input[i], 8);
         else sum -= str_to_int(&input[i], 8);
      }

      puts((sum % 17 == 0) ? "1" : "0");
   }

   return 0;
}

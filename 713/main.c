#include <stdio.h>
#include <string.h>

int main(int argc, char* argv[])
{
   int t, i, tmp, carry;
   char* a;
   char* b;
   char input[2][500];
   char output[500];

   scanf("%d", &t);
   while (t-- > 0) {
      scanf("%s%s", input[0], input[1]);
      a = input[0];
      b = input[1];
      while (*a == '0' && *(a + 1) != '\0') ++a;
      while (*b == '0' && *(b + 1) != '\0') ++b;

      for (i = strlen(a) - 1; i > 0 && a[i] == '0'; i--);
      a[i + 1] = '\0';

      for (i = strlen(b) - 1; i > 0 && b[i] == '0'; i--);
      b[i + 1] = '\0';

      i = carry = 0;
      while (*a != '\0' && *b != '\0') {
         tmp = (*a - '0') + (*b - '0') + carry;
         if (tmp > 9) {
            carry = 1;
            tmp -= 10;
         } else {
            carry = 0;
         }
         output[i++] = tmp + '0';
         ++a, ++b;
      }

      while (*a != '\0') {
         tmp = (*a - '0') + carry;
         if (tmp > 9) {
            carry = 1;
            tmp -= 10;
         } else {
            carry = 0;
         }
         output[i++] = tmp + '0';
         ++a;
      }

      while (*b != '\0') {
         tmp = (*b - '0') + carry;
         if (tmp > 9) {
            carry = 1;
            tmp -= 10;
         } else {
            carry = 0;
         }
         output[i++] = tmp + '0';
         ++b;
      }

      if (carry) output[i++] = '1';

      output[i] = '\0';
      for (i = 0; output[i] == '0' && output[i + 1] != '\0'; i++);
      puts(&output[i]);
   }

   return 0;
}

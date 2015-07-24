#include <stdio.h>

#define LEN 1000004

int main(int argc, char* argv[])
{
   int t, m, i, tmp, carry, new_line = 0;
   char input[2][LEN];
   char output[LEN];

   scanf("%d", &t);
   while (t-- > 0) {
      if (new_line) putchar('\n');
      else new_line = 1;

      scanf("%d", &m);
      for (i = 0; i < m; i++) {
         scanf("%s%s", &input[0][i], &input[1][i]);
      }
      carry = 0;
      output[m] = '\0';
      for (i = m - 1; i >= 0; i--) {
         tmp = (input[0][i] - '0') + (input[1][i] - '0') + carry;
         if (tmp > 9) {
            carry = 1;
            tmp -= 10;
         } else {
            carry = 0;
         }
         output[i] = tmp + '0';
      }
      if (carry) putchar('1');
      for (i = 0; i < m; i++) {
         if (output[i] != '0') {
            puts(&output[i]);
            break;
         }
      }
   }

   return 0;
}

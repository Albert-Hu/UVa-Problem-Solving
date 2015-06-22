#include <stdio.h>

#define BASE3_BITS 18

const static int base3[BASE3_BITS] = {
         3,         9,        27,        81,       243,       729,
      2187,      6561,     19683,     59049,    177147,    531441,
   1594323,   4782969,  14348907,  43046721, 129140163, 387420489
};

int main(int argc, char* argv[])
{
   int n, i, length;
   char output[32];

   while (scanf("%d", &n) == 1 && n >= 0) {
      for (i = 0; i < BASE3_BITS; i++) {
         if (n < base3[i]) break;
      }
      length = 0;
      while (i-- > 0) {
         if (n >= base3[i]) {
            output[length++] = (n / base3[i]) + '0';
            n %= base3[i];
         } else {
            output[length++] = '0';
         }
      }
      output[length++] = n + '0';
      output[length] = '\0';
      printf("%s\n", output);
   }

   return 0;
}

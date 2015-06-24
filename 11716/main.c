#include <stdio.h>

#define SQUARES 101

const static int square[101] = {
       0,     1,     4,     9,    16,    25,    36,    49,    64,    81,
     100,   121,   144,   169,   196,   225,   256,   289,   324,   361,
     400,   441,   484,   529,   576,   625,   676,   729,   784,   841,
     900,   961,  1024,  1089,  1156,  1225,  1296,  1369,  1444,  1521,
    1600,  1681,  1764,  1849,  1936,  2025,  2116,  2209,  2304,  2401,
    2500,  2601,  2704,  2809,  2916,  3025,  3136,  3249,  3364,  3481,
    3600,  3721,  3844,  3969,  4096,  4225,  4356,  4489,  4624,  4761,
    4900,  5041,  5184,  5329,  5476,  5625,  5776,  5929,  6084,  6241,
    6400,  6561,  6724,  6889,  7056,  7225,  7396,  7569,  7744,  7921,
    8100,  8281,  8464,  8649,  8836,  9025,  9216,  9409,  9604,  9801,
   10000
};

int main(int argc, char* argv[])
{
   int n, i, j, s, length;
   char input[10001];
   char output[10001];

   scanf("%d\n", &n);
   while (n-- > 0) {
      gets(input);
      length = 0;
      while (input[++length] != '\0');
      for (s = 0; s < SQUARES; s++) {
         if (length == square[s]) break;
      }
      if (s == SQUARES) {
         printf("INVALID\n");
         continue;
      }
      for (i = 0; i < s; i++) {
         for (j = i; j < s; j++) {
            output[(j * s) + i] = input[(i * s) + j];
            output[(i * s) + j] = input[(j * s) + i];
         }
      }
      output[length] = '\0';
      printf("%s\n", output);
   }

   return 0;
}

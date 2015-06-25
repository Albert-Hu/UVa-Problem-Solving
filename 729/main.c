#include <stdio.h>

const static int bits[16] = {
   0x0001, 0x0003, 0x0007, 0x000f,
   0x001f, 0x003f, 0x007f, 0x00ff,
   0x01ff, 0x03ff, 0x07ff, 0x0fff,
   0x1fff, 0x3fff, 0x7fff, 0xffff
};

void int_to_binary(unsigned int i, int n)
{
   int b, m;
   char output[32];

   output[n] = '\0';
   for (m = 0; m < n; m++) {
      output[m] = ((i >> (n - (m + 1))) & 1) ? '1' : '0';
   }
   printf("%s\n", output);
}

int bits_count(unsigned int i, int n)
{
   int count = 0;
   while (n-- > 0) {
      if ((i >> n) & 1) ++count;
   }
   return count;
}

int main(int argc, char* argv[])
{
   int new_line = 0;
   int i, n, m;
   int tests, start, end;

   scanf("%d", &tests);
   while (tests-- > 0) {
      if (new_line)
         printf("\n");
      else
         new_line = 1;
      scanf("%d%d", &n, &m);
      start = bits[m - 1];
      end = start << (n - m);
      while (start <= end) {
         if (bits_count(start, n) == m)
            int_to_binary(start, n);
         start++;
      }
   }

   return 0;
}

#include <stdio.h>
#include <memory.h>

#define MAX (1000000)

static int table[MAX];

static int cycle_length_3n1(unsigned int n)
{
   int index = n;
   int length = 1;

   while (n != 1) {
      if (n < MAX) {
         if (table[n]) {
            length += (table[n] - 1);
            break;
         }
      }
      n = (n & 1) ? ((n << 1) + n + 1) : (n >> 1);
      ++length;
   }

   if (index < MAX)
      table[index] = length;

   return length;
}

int main(int argc, char* argv[])
{
   int i, j, tmp, max;

   memset(table, 0, MAX);

   while (scanf("%d%d", &i, &j) == 2) {
      printf("%d %d ", i, j);

      if (i > j) {
         tmp = i, i = j, j = tmp;
      }

      max = 0;
      while (i <= j) {
         tmp = cycle_length_3n1(i);

         if (tmp > max) max = tmp;

         ++i;
      }
      printf("%d\n", max);
   }

   return 0;
}

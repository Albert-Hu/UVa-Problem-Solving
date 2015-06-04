#include <stdio.h>
#include <string.h>

#define MAX_LEN 10009

int compare(char* a, int len_a, char* b, int len_b)
{
   if (len_a == len_b) {
      len_a = 0;
      while (a[len_a] == b[len_a] && len_a < len_b)
         ++len_a;
      if (len_a == len_b)
         return 0;
      return (a[len_a] > b[len_a]) ? 1 : -1;
   }
   return (len_a > len_b) ? 1 : -1;
}

int main(int argc, char* argv[])
{
   int n, i;
   int max_index, min_index, cmp;
   int len[2];
   char* max;
   char* min;
   char borrow;
   char input[2][MAX_LEN];

   scanf("%d", &n);
   while (n-- > 0) {
      scanf("%s %s", input[0], input[1]);
      len[0] = strlen(input[0]);
      len[1] = strlen(input[1]);
      cmp = compare(input[0], len[0], input[1], len[1]);

      if (cmp == 0) {
         printf("0\n");
         continue;
      }

      if (cmp > 0) {
         max = input[0];
         max_index = len[0];
         min = input[1];
         min_index = len[1];
      } else {
         max = input[1];
         max_index = len[1];
         min = input[0];
         min_index = len[0];
      }

      borrow = 0;
      while (--max_index >= 0) {
         if (borrow) {
            if (max[max_index] == '0') {
               max[max_index] = '9';
            } else {
               --max[max_index];
               borrow = 0;
            }
         }
         if (--min_index >= 0) {
            if (max[max_index] < min[min_index]) {
               max[max_index] += (10 - (min[min_index] - '0'));
               borrow = 1;
            } else {
               max[max_index] = (max[max_index] - min[min_index]) + '0';
            }
         }
      }
      if (cmp < 0) printf("-");
      for (i = 0; max[i] == '0'; i++);
      printf("%s\n", &max[i]);
   }

   return 0;
}

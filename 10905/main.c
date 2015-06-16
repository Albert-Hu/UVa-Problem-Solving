#include <stdio.h>
#include <string.h>

int compare(char* a, int a_len, char* b, int b_len)
{
   char* ab;
   char* ba;
   int total_len;

   ab = a;
   ba = b;
   total_len = a_len + b_len;
   while (total_len-- > 0) {
      if (*ab == '\0') ab = b;
      if (*ba == '\0') ba = a;
      if (*ab > *ba)
         return 1;
      else if (*ab < *ba)
         return -1;
      ++ab;
      ++ba;
   }
   return 0;
}

int main(int argc, char* argv[])
{
   int n, i, j, max;
   int length[50];
   char new_line = 0;
   char number[50][100];

   while (scanf("%d", &n) == 1) {
      if (new_line) {
         putchar('\n');
      } else {
         new_line = 1;
      }
      for (i = 0; i < n; i++) {
         scanf("%s", number[i]);
         length[i] = strlen(number[i]);
      }
      for (i = 0; i < n; i++) {
         for (j = 0; j < n; j++) {
            if (number[j][0] != '\0') {
               max = j;
               break;
            }
         }
         for (j = 0; j < n; j++) {
            if (number[j][0] == '\0')
               continue;
            if (compare(number[j], length[j], number[max], length[max]) > 0) {
               max = j;
            }
         }
         printf("%s", number[max]);
         number[max][0] = '\0';
      }
   }

   return 0;
}

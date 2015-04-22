#include <stdio.h>
#include <memory.h>

#define MAX(a,b) ((a) > (b) ? (a) : (b))

int read_line(char* buffer)
{
   int len = 0;
   while ((*buffer = getchar()) != '\n') {
      if (*buffer == EOF) return -1;
      ++buffer;
      ++len;
   }
   *buffer = '\0';
   return len;
}

int main(int argc, char* argv[])
{
   int i, j;
   int table[1001][1001];
   char sequences[2][1001];

   memset(table, 0, sizeof(table));

   while (read_line(sequences[0]) >= 0) {
      read_line(sequences[1]);

      i = 0;
      while (sequences[0][i] != '\0') {
         j = 0;
         while (sequences[1][j] != '\0') {
            if (sequences[0][i] == sequences[1][j]) {
               table[i+1][j+1] = table[i][j] + 1;
            } else {
               table[i+1][j+1] = MAX(table[i+1][j], table[i][j+1]);
            }
            ++j;
         }
         ++i;
      }
      printf("%d\n", table[i][j]);
   }

   return 0;
}

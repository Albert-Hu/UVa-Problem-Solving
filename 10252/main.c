#include <stdio.h>
#include <stdlib.h>
#include <memory.h>

#define MIN(a, b) ((a) < (b) ? (a) : (b))

void count(char* c, int* letters)
{
   while (*c != '\0') {
      ++(*(letters + (*c - 'a')));
      ++c;
   }
}

int main(int argc, char* argv[])
{
   char c;
   char line[1001];
   int i, min;
   int letters[2][26];

   while (gets(line) != NULL) {
      memset(letters, 0, sizeof(letters));

      count(line, letters[0]);
      gets(line);
      count(line, letters[1]);

      for (i = 0; i < 26 ; i++) {
         if (letters[0][i] == 0 || letters[1][i] == 0)
            continue;
         c = i + 'a';
         min = MIN(letters[0][i], letters[1][i]);
         while (min-- > 0)
            putchar(c);
      }
      putchar('\n');
   }

   return 0;
}

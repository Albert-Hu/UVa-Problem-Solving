#include <stdio.h>
#include <memory.h>

#define MAX_CODE     83682
#define MAX_LETTERS  5
#define ARRAY_LENGTH (MAX_LETTERS + 1)

static int code = 1;
static char buffer[ARRAY_LENGTH];
static char table[MAX_CODE][ARRAY_LENGTH];
static char letter[26] = {
   'a', 'b', 'c', 'd', 'e', 'f', 'g',
   'h', 'i', 'j', 'k', 'l', 'm', 'n',
   'o', 'p', 'q', 'r', 's', 't', 'u',
   'v', 'w', 'x', 'y', 'z'
};

void generate(int n, int max, int index)
{
   int i;

   if (n < max) {
      for (; index < 26; index++) {
         buffer[n] = letter[index];
         generate((n + 1), max, (index + 1));
      }
   } else {
      for (i = 0; i < max; i++) {
         table[code][i] = buffer[i];
      }
      ++code;
      buffer[max] = '\0';
   }
}

int main(int argc, char* argv[])
{
   int i, found;
   char input[6];

   memset(table, 0, sizeof(table));
   for (i = 1; i <= MAX_LETTERS; i++) {
      generate(0, i, 0);
   }

   while (scanf("%s", input) == 1) {
      found = 0;
      for (i = 1; i < ARRAY_LENGTH; i++) {
         if (input[i] == '\0') break;
         if (input[i] < input[i - 1]) break;
      }
      if (input[i] == '\0') {
         for (i = 1; i < MAX_CODE; i++) {
            if (strcmp(input, table[i]) == 0) {
               found = i;
               break;
            }
         }
      }
      printf("%d\n", found);
   }

   return 0;
}

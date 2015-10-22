#include <stdio.h>
#include <stdlib.h>
#include <memory.h>
#include <string.h>

#define MAX 10000001

int main(int argc, char* argv[])
{
   int a, b, i, test_case;
   int* count;
   int* index;
   char* sod;
   char* tok;
   char line[256];

   sod = (char*) malloc(MAX * sizeof(char));
   index = (int*) malloc(MAX * sizeof(int));
   count = (int*) malloc(MAX * sizeof(int));

   for (i = 0; i < MAX; ++i) {
      if (i < 10) {
         sod[i] = i;
      } else if (i >= 10 && i < 100) {
         sod[i] = sod[i % 10] + i / 10;
      } else if (i >= 100 && i < 1000) {
         sod[i] = sod[i % 100] + i / 100;
      } else if (i >= 1000 && i < 10000) {
         sod[i] = sod[i % 1000] + i / 1000;
      } else if (i >= 10000 && i < 100000) {
         sod[i] = sod[i % 10000] + i / 10000;
      } else if (i >= 100000 && i < 1000000) {
         sod[i] = sod[i % 100000] + i / 100000;
      } else if (i >= 1000000 && i < 10000000) {
         sod[i] = sod[i % 1000000] + i / 1000000;
      } else {
         sod[i] = 1;
      }
   }

   for (i = 0; i < MAX; ++i) {
      index[i] = -1;
   }

   for (i = MAX - 1; i > 0; --i) {
      a = i + sod[i];
      if (a < MAX) {
         index[a] = i;
      }
   }

   count[1] = 1;
   for (i = 2; i < MAX; ++i) {
      count[i] = count[i - 1] + (index[i] == -1);
   }

   gets(line);
   test_case = atoi(line);

   for (i = 1; i <= test_case; ++i) {
      gets(line);
      tok = strtok(line, " ");
      a = atoi(tok);
      if ((tok = strtok(NULL, " ")) != NULL) {
         b = atoi(tok);
         printf("Case %d: %d\n", i, (count[b] - count[a]) + (index[a] == -1));
      } else {
         printf("Case %d: %d\n", i, index[a]);
      }
   }

   return 0;
}

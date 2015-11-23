#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <memory.h>

int main(int argc, char* argv[])
{
   int i, j, n, k, p;
   int* cycles;
   int* positions;
   char* token;
   char* input;
   char* output;

   input = (char*) malloc(sizeof(char) * 300);
   output = (char*) malloc(sizeof(char) * 300);
   cycles = (int*) malloc(sizeof(int) * 200);
   positions = (int*) malloc(sizeof(int) * 200);

   while (gets(input) != NULL) {
      if ((n = atoi(input)) == 0)
         break;

      gets(input);
      token = strtok(input, " ");
      for (i = 0; i < n; ++i) {
         positions[i] = atoi(token) - 1;
         token = strtok(NULL, " ");
      }
      for (i = 0; i < n; ++i) {
         for (j = positions[positions[i]], cycles[i] = 1;
              j != positions[i];
              j = positions[j], ++cycles[i]);
      }
      while (gets(input) != NULL) {
         for (i = 0; input[i] != '\0'; ++i) {
            if (input[i] == ' ') {
               token = &input[i + 1];
               input[i] = '\0';
               break;
            }
         }
         k = atoi(input) - 1;
         if (k < 0)
            break;
         memset(output, ' ', sizeof(char) * n);
         for (i = 0; token[i] != '\0'; ++i) {
            p = positions[i];
            for (j = k % cycles[i]; j > 0; --j)
               p = positions[p];
            output[p] = token[i];
         }
         output[n] = '\0';
         puts(output);
      }
      putchar('\n');
   }

   return 0;
}

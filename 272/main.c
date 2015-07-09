#include <stdio.h>

#define LEN 1024

int main(int argc, char* argv[])
{
   int i, o;
   int q = 0;
   char quote[2] = {'`', '\''};
   char input[LEN];
   char output[LEN * 2];

   while (gets(input) != NULL) {
      i = o = 0;
      while (input[i] != '\0') {
         if (input[i] == '"') {
            output[o++] = quote[q];
            output[o++] = quote[q];
            q = (q + 1) % 2;
         } else {
            output[o++] = input[i];
         }
         ++i;
      }
      output[o] = '\0';
      puts(output);
   }

   return 0;
}

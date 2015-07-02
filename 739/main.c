#include <stdio.h>

#define LEN 40

const static char code[26] = {
   '0', '1', '2', '3', '0', '1', '2', '0',
   '0', '2', '2', '4', '5', '5', '0', '1',
   '2', '6', '2', '3', '0', '1', '0', '2',
   '0', '2'
};

int main(int argc, char* argv[])
{
   int i, padding;
   char input[LEN];

   printf("         NAME                     SOUNDEX CODE\n");
   while (scanf("%s", input) == 1) {
      printf("         %-25s%c", input, input[0]);
      padding = 3;
      for (i = 0; input[i] != '\0'; i++) {
         input[i] = code[input[i] - 'A'];
      }
      for (i = 1; input[i] != '\0' && padding > 0; i++) {
         if (input[i] != '0' && input[i] != input[i - 1]) {
            printf("%c", input[i]);
            --padding;
         }
      }
      while (padding-- > 0) {
         printf("0");
      }
      printf("\n");
   }
   printf("                   END OF OUTPUT\n");
   return 0;
}

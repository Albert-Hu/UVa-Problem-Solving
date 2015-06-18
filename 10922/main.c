#include <stdio.h>

int main(int argc, char* argv[])
{
   char input[1001];
   char buffer[5];
   int i, multiple, degree;

   while (scanf("%s", input) == 1 && input[0] != '0') {
      multiple = 0;
      for (i = 0; input[i] != '\0'; i++) {
         multiple += (input[i] - '0');
      }
      if ((multiple % 9) == 0) {
         degree = 1;
         while ((multiple / 9) != 1) {
            sprintf(buffer, "%d", multiple);
            multiple = 0;
            for (i = 0; buffer[i] != '\0'; i++) {
               multiple += (buffer[i] - '0');
            }
            ++degree;
         }
         printf("%s is a multiple of 9 and has 9-degree %d.\n", input, degree);
      } else {
         printf("%s is not a multiple of 9.\n", input);
      }
   }

   return 0;
}

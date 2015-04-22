#include <stdio.h>

#define IS_LETTER(c) ((c>='a'&&c<='z')||(c>='A'&&c<='Z'))

int main(int argc, char* argv[])
{
   int current, last = ' ';
   unsigned long long int count = 0;

   while ((current = getchar()) != EOF) {
      if (current == '\n') {
         printf("%d\n", count);
         count = 0;
         last = ' ';
         continue;
      }
      if (IS_LETTER(current)) {
         if (!IS_LETTER(last)) {
            ++count;
         }
      }
      last = current;
   }

   return 0;
}

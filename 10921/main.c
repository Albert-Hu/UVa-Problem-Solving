#include <stdio.h>

const static char table[26] = {
   '2', '2', '2',
   '3', '3', '3',
   '4', '4', '4',
   '5', '5', '5',
   '6', '6', '6',
   '7', '7', '7', '7',
   '8', '8', '8',
   '9', '9', '9', '9'
};

int main(int argc, char* argv[])
{
   char c;

   while ((c = getchar()) != EOF) {
      if (c >= 'A' && c <= 'Z')
         putchar(table[c - 'A']);
      else
         putchar(c);
   }

   return 0;
}

#include <stdio.h>
#include <string.h>

int main(int argc, char* argv[])
{
   int i, v;
   int count[3];
   char is_vowel[202];
   char line[202];

   while (gets(line) != NULL) {
      if (strncmp(line, "e/o/i", 5) == 0)
         break;
      for (i = 0; line[i] != '\0'; ++i) {
         switch (line[i]) {
            case 'a':
            case 'e':
            case 'i':
            case 'o':
            case 'u':
            case 'y':
               is_vowel[i] = 1;
               break;
            default:
               is_vowel[i] = 0;
         }
      }
      is_vowel[i] = 0;
      count[0] = count[1] = count[2] = 0;
      for (i = v = 0; line[i] != '\0'; ++i) {
         if (line[i] == '/')
            ++v;
         if (is_vowel[i] && !is_vowel[i + 1]) {
            ++count[v];
         }
      }
      if (count[0] != 5) {
         puts("1");
      } else if (count[1] != 7) {
         puts("2");
      } else if (count[2] != 5) {
         puts("3");
      } else {
         puts("Y");
      }
   }

   return 0;
}

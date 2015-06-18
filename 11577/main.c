#include <stdio.h>
#include <memory.h>

int main(int argc, char* argv[])
{
   int n, i, max;
   int count[26];
   char input[1000];

   scanf("%d\n", &n);
   while (n-- > 0) {
      memset(count, 0, sizeof(count));
      gets(input);
      for (i = 0; input[i] != '\0'; i++) {
         if (input[i] >= 'A' && input[i] <= 'Z') {
            input[i] = (input[i] - 'A') + 'a';
         }
         if (input[i] >= 'a' && input[i] <= 'z') {
            ++count[input[i] - 'a'];
         }
      }
      max = 0;
      for (i = 0; i < 26; i++) {
         if (count[i] > max) max = count[i];
      }
      for (i = 0; i < 26; i++) {
         if (count[i] == max)
            printf("%c", i + 'a');
      }
      printf("\n");
   }

   return 0;
}

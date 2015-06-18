#include <stdio.h>
#include <stdlib.h>

const static int press_times[26] = {
   1, 2, 3,
   1, 2, 3,
   1, 2, 3,
   1, 2, 3,
   1, 2, 3,
   1, 2, 3, 4,
   1, 2, 3,
   1, 2, 3, 4
};

int main(int argc, char* argv[])
{
   char input[101];
   int i, n, count, test_case = 1;

   gets(input);
   n = atoi(input);
   for (test_case = 1; test_case <= n; test_case++) {
      gets(input);
      count = 0;
      for (i = 0; input[i] != '\0'; i++) {
         if (input[i] == ' ') {
            ++count;
         } else {
            count += press_times[input[i] - 'a'];
         }
      }
      printf("Case #%d: %d\n", test_case, count);
   }

   return 0;
}

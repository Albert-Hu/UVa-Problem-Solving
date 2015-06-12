#include <stdio.h>

const static int answer[10][4] = {
   {0, 0, 0, 0},
   {1, 1, 1, 1},
   {6, 2, 4, 8},
   {1, 3, 9, 7},
   {6, 4, 6, 4},
   {5, 5, 5, 5},
   {6, 6, 6, 6},
   {1, 7, 9, 3},
   {6, 8, 4, 2},
   {1, 9, 1, 9}
};

int main(int argc, char* argv[])
{
   int m, n;
   char input[102];

   while (scanf("%s", input) == 1) {
      for (m = 0; input[m] != '\0'; m++);
      m = input[m - 1] - '0';
      scanf("%s", input);
      for (n = 0; input[n] != '\0'; n++);

      if (m == 0 && input[0] == '0') break;

      if (n > 1) {
         n = ((input[n - 2] - '0') * 10) + (input[n - 1] - '0');
      } else {
         n = input[n - 1] - '0';
      }
      printf("%d\n", (n == 0 && input[0] == '0') ? 1 : answer[m][n % 4]);
   }

   return 0;
}

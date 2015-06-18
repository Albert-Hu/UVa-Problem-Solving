#include <stdio.h>

int main(int argc, char* argv[])
{
   int n, a, b, c, test_case;

   scanf("%d", &n);
   for (test_case = 1; test_case <= n; test_case++) {
      scanf("%d%d%d", &a, &b, &c);
      if (((a > b)&&(a < c)) || ((a < b)&&(a > c))) {
         printf("Case %d: %d\n", test_case, a);
      } else if (((b > a)&&(b < c)) || ((b < a)&&(b > c))) {
         printf("Case %d: %d\n", test_case, b);
      } else {
         printf("Case %d: %d\n", test_case, c);
      }
   }

   return 0;
}

#include <stdio.h>

int binary_search(int max, int n, int i)
{
   int l, r;
   l = n * 2;
   r = l + 1;
   if (l < max && r < max) {
      if (i % 2 == 1) {
         n = binary_search(max, l, (i / 2) + 1);
      } else {
         n = binary_search(max, r, i / 2);
      }
   }
   return n;
}

int main(int argc, char* argv[])
{
   int t, d, i;

   scanf("%d", &t);
   while (t-- > 0) {
      scanf("%d%d", &d, &i);
      printf("%d\n", binary_search((1<<d), 1, i));
   }

   return 0;
}

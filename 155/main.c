#include <stdio.h>

int square(int k, int pivot_x, int pivot_y, int x, int y)
{
   int count = 0;

   if (k > 1) {
      count += square((k / 2), (pivot_x - k), (pivot_y - k), x, y);
      count += square((k / 2), (pivot_x + k), (pivot_y - k), x, y);
      count += square((k / 2), (pivot_x - k), (pivot_y + k), x, y);
      count += square((k / 2), (pivot_x + k), (pivot_y + k), x, y);
   }

   if (x >= (pivot_x - k) && x <= (pivot_x + k) && y >= (pivot_y - k) && y <= (pivot_y +k))
      ++count;

   return count;
}

int main(int argc, char* argv[])
{
   int x, y, k;

   while (scanf("%d%d%d", &k, &x, &y) == 3) {
      if (k == 0 && x == 0 && y == 0)
         break;
      printf("%3d\n", square(k, 1024, 1024, x, y));
   }

   return 0;
}

#include <stdio.h>

double get_distance(double x1, double y1, double x2, double y2)
{
   return ((x2 - x1) * (x2 - x1)) + ((y2 - y1) * (y2 - y1));
}

int main(int argc, char* argv[])
{
   double corner[4];
   double radius;
   int x, y, n, segments, completes;
   char new_line = 0;

   while (scanf("%d", &n) == 1) {
      if (new_line) putchar('\n');
      else new_line = 1;

      radius = ((2 * n) - 1) / 2.0;
      radius *= radius;
      segments = completes = 0;
      for (x = 0; x < n; x++) {
         for (y = 0; y < n; y++) {
            corner[0] = get_distance(x, y, n, n);
            corner[1] = get_distance(x + 1, y, n, n);
            corner[2] = get_distance(x, y + 1, n, n);
            corner[3] = get_distance(x + 1, y + 1, n, n);
            if ((corner[0] <= radius) || (corner[1] <= radius) || (corner[2] <= radius) || (corner[3] <= radius)) {
               if ((corner[0] <= radius) && (corner[1] <= radius) && (corner[2] <= radius) && (corner[3] <= radius)) {
                  ++completes;
               } else {
                  ++segments;
               }
            }
         }
      }
      printf("In the case n = %d, %d cells contain segments of the circle.\n", n, segments * 4);
      printf("There are %d cells completely contained in the circle.\n", completes * 4);
   }

   return 0;
}

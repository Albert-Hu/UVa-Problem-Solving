#include <stdio.h>
#include <stdlib.h>
#include <memory.h>

#define MAX 1000001

int gcd(int max, int min)
{
   int tmp;

   do {
      tmp = min;
      min = max % min;
      max = tmp;
   } while (min);

   return max;
}

int main(int argc, char* argv[])
{
   unsigned int* used;
   unsigned int* triple;
   unsigned int* remain;
   int n, i;
   int a, aa, b, bb;
   int x, xx, y, yy, z, zz;

   used = (unsigned int *) malloc(sizeof(unsigned int) * MAX);
   triple = (unsigned int *) malloc(sizeof(unsigned int) * MAX);
   remain = (unsigned int *) malloc(sizeof(unsigned int) * MAX);

   memset(used, 0xff, sizeof(int) * MAX);
   memset(triple, 0, sizeof(int) * MAX);
   memset(remain, 0, sizeof(int) * MAX);

   a = 2, aa = 4;
   b = 1, bb = 1;
   x = 3, y = 4, z = 5;
   while (z < MAX) {
      while (z < MAX) {
         if (gcd(a, b) == 1) {
            ++triple[z];
            xx = x, yy = y, zz = z;
            while (zz < MAX) {
               if (used[xx] > zz) used[xx] = zz;
               if (used[yy] > zz) used[yy] = zz;
               if (used[zz] > zz) used[zz] = zz;
               xx += x, yy += y, zz += z;
            }
         }
         a += 2;
         aa = a * a;
         x = aa - bb;
         y = 2 * a * b;
         z = aa + bb;
      }
      ++b;
      a = b + 1;
      aa = a * a;
      bb = b * b;
      x = aa - bb;
      y = 2 * a * b;
      z = aa + bb;
   }

   for (i = 3; i < MAX; i++) {
      if (used[i] < 0xffffffff)
         ++remain[used[i]];
   }

   for (i = 3; i < MAX; i++) {
      triple[i] += triple[i - 1];
      remain[i] += remain[i - 1];
   }

   while (scanf("%d", &n) == 1) {
      printf("%d %d\n", triple[n], n - remain[n]);
   }

   return 0;
}

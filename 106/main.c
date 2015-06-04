#include <stdio.h>
#include <memory.h>

#define MAX 1000001

int gcd(int a, int b)
{
   int tmp;
   if (a < b) {
      tmp = a;
      a = b;
      b = tmp;
   }
   while ((a % b) > 0) {
      a %= b;
      tmp = a;
      a = b;
      b = tmp;
   }
   return b;
}

int main(int argc, char* argv)
{
   char table[MAX];
   int n, i;
   int x, y, z;
   int a, b, aa, bb;
   int index, triples, others;

   while (scanf("%d", &n) == 1) {
      a = 2;
      b = 1;
      others = n;
      triples = 0;
      memset(table, 1, sizeof(table));
      do {
         while (((a * a) + (b * b)) <= n) {
            aa = a * a;
            bb = b * b;
            x = aa - bb;
            y = 2 * a * b;
            z = aa + bb;
            if (gcd(x, y) == 1) ++triples;
            if (table[x]) {table[x] = 0; --others;}
            if (table[y]) {table[y] = 0; --others;}
            if (table[z]) {table[z] = 0; --others;}
            for (i = 2; i * z <= n; i++) {
               index = x * i;
               if (table[index]) {table[index] = 0; --others;}
               index = y * i;
               if (table[index]) {table[index] = 0; --others;}
               index = z * i;
               if (table[index]) {table[index] = 0; --others;}
            }
            ++a;
         }
         ++b;
         a = b + 1;
      } while (((a * a) + (b * b)) <= n);
      printf("%d %d\n", triples, others);
   }

   return 0;
}

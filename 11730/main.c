#include <stdio.h>

#define INFINITE 0x7fffffff
#define PRIMES 168

int main(int argc, char* argv[])
{
   int a, b, i, next, test_case = 1;
   int transformations[1001];
   int prime[PRIMES] = {
        2,   3,   5,   7,  11,  13,  17,  19,  23,  29,
       31,  37,  41,  43,  47,  53,  59,  61,  67,  71,
       73,  79,  83,  89,  97, 101, 103, 107, 109, 113,
      127, 131, 137, 139, 149, 151, 157, 163, 167, 173,
      179, 181, 191, 193, 197, 199, 211, 223, 227, 229,
      233, 239, 241, 251, 257, 263, 269, 271, 277, 281,
      283, 293, 307, 311, 313, 317, 331, 337, 347, 349,
      353, 359, 367, 373, 379, 383, 389, 397, 401, 409,
      419, 421, 431, 433, 439, 443, 449, 457, 461, 463,
      467, 479, 487, 491, 499, 503, 509, 521, 523, 541,
      547, 557, 563, 569, 571, 577, 587, 593, 599, 601,
      607, 613, 617, 619, 631, 641, 643, 647, 653, 659,
      661, 673, 677, 683, 691, 701, 709, 719, 727, 733,
      739, 743, 751, 757, 761, 769, 773, 787, 797, 809,
      811, 821, 823, 827, 829, 839, 853, 857, 859, 863,
      877, 881, 883, 887, 907, 911, 919, 929, 937, 941,
      947, 953, 967, 971, 977, 983, 991, 997
   };

   while (scanf("%d%d", &a, &b) == 2) {
      if (a == 0 && b == 0)
         break;
      printf("Case %d: ", test_case);
      ++test_case;

      if (a == b) {
         printf("0\n");
         continue;
      }

      if (a > b) {
         printf("-1\n");
         continue;
      }

      transformations[a] = 0;
      for (i = a + 1; i <= b; ++i) {
         transformations[i] = INFINITE;
      }
      for (; a < b; ++a) {
         if (transformations[a] == INFINITE)
            continue;
         for (i = 0; i < PRIMES; ++i) {
            if (prime[i] >= a || (a + prime[i]) > b) {
               break;
            }
            if (a % prime[i] != 0) {
               continue;
            }
            next = a + prime[i];
            if (transformations[next] > (transformations[a] + 1)) {
               transformations[next] = transformations[a] + 1;
            }
         }
      }
      printf("%d\n", transformations[b] == INFINITE ? -1 : transformations[b]);
   }

   return 0;
}

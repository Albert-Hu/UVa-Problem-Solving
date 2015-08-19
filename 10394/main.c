#include <stdio.h>

#define CLEAR_BIT(bit, b) ((~(1 << (b))) & (bit))
#define IS_SET_BIT(bit, b) (((bit) >> (b)) & 1)

int main(int argc, char* argv[])
{
   int i, j, b, pre;
   int prime[100000];
   int prime_len;
   char is_prime[2500000];

   for (i = 0; i < 2500000; i++)
      is_prime[i] = 0xaa;

   for (i = 3; i * i < 20000000; i += 2) {
      for (j = i; j * i < 20000000; j += 2) {
         b = ((j * i) / 8);
         is_prime[b] = CLEAR_BIT(is_prime[b], ((j * i) % 8));
      }
   }

   pre = 3;
   prime_len = 0;
   for (i = 5; i < 20000000; i += 2) {
      if (IS_SET_BIT(is_prime[(i / 8)], (i % 8))) {
         if ((i - pre) == 2) {
            prime[prime_len++] = pre;
         }
         pre = i;
      }
      if (prime_len == 100000)
         break;
   }

   while (scanf("%d", &i) == 1) {
      --i;
      printf("(%d, %d)\n", prime[i], prime[i] + 2);
   }


   return 0;
}

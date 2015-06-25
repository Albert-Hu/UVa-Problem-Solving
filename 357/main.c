#include <stdio.h>

#define MAX_WAYS 6001

int main(int argc, char* argv[])
{
   int i, j, cents;
   int coin[4] = {5, 10, 25, 50};
   long long int way[MAX_WAYS];

   for (i = 0; i < MAX_WAYS; i++)
      way[i] = 1;

   for (i = 0; i < 4; i++) {
      for (j = (coin[i] / 5); j < MAX_WAYS; j++) {
         way[j] += way[j - (coin[i] / 5)];
      }
   }

   while (scanf("%d", &cents) == 1) {
      if (cents < 5) {
         printf("There is only 1 way to produce %d cents change.\n", cents);
      } else {
         printf("There are %lld ways to produce %d cents change.\n", way[cents / 5], cents);
      }
   }

   return 0;
}

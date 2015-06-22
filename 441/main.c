#include <stdio.h>

void dump(int* array, int amount, int* output, int k)
{
   int i;

   if (k < 6) {
      for (i = 0; i < amount; i++) {
         output[k] = array[i];
         dump(&array[i + 1], (amount - (i + 1)), output, (k + 1));
      }
   } else {
      printf("%d %d %d %d %d %d\n",
         output[0],
         output[1],
         output[2],
         output[3],
         output[4],
         output[5]);
   }
}

int main(int argc, char* argv[])
{
   int k, i, new_line = 0;
   int number[12];
   int output[6];

   while (scanf("%d", &k) == 1 && k != 0) {
      if (new_line)
         printf("\n");
      else
         new_line = 1;
      for (i = 0; i < k ; i++) {
         scanf("%d", &number[i]);
      }
      dump(number, k, output, 0);
   }

   return 0;
}

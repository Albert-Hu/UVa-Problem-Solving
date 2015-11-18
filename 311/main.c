#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <stdbool.h>

int main(int argc, char* argv[])
{
   bool end;
   char* token;
   char line[128];
   int size;
   int box[6];

   while (gets(line) != NULL) {
      size = 0;
      end = true;
      token = strtok(line, " ");
      while (token != NULL && size < 6) {
         box[size] = atoi(token);
         end &= (box[size] == 0);
         ++size;
         token = strtok(NULL, " ");
      }
      if (end) break;
      box[0] = (box[0] > (box[4] * 11)) ? (box[0] - box[4] * 11) : 0;
      if (box[1] < (box[3] * 5))
         box[0] = (box[0] > ((box[3] * 5 - box[1]) * 4)) ? (((box[3] * 5 - box[1]) * 4)) : 0;
      box[1] = (box[1] > (box[3] * 5) ? (box[1] - box[3] * 5) : 0);
      switch ((4 - (box[2] % 4))) {
         case 1:
            box[0] = (box[0] > 5) ? (box[0] - 5) : 0;
            box[1] = (box[1] > 1) ? (box[1] - 1) : 0;
            break;
         case 2:
            box[0] = (box[0] > 6) ? (box[0] - 6) : 0;
            box[1] = (box[1] > 3) ? (box[1] - 3) : 0;
            break;
         case 3:
            box[0] = (box[0] > 11) ? (box[0] - 11) : 0;
            box[1] = (box[1] > 5 ) ? (box[1] - 5) : 0;
            break;
      }
      if (box[1] % 9 != 0)
         box[0] = (box[0] > ((9 - (box[1] % 9)) * 4)) ? (box[0] - ((9 - (box[1] % 9)) * 4)) : 0;
      box[0] = (box[0] / 36) + ((box[0] % 36) != 0);
      box[1] = (box[1] / 9) + ((box[1] % 9) != 0);
      box[2] = (box[2] / 4) + ((box[2] % 4) != 0);
      printf("%d\n", (box[0] + box[1] + box[2] + box[3] + box[4] + box[5]));
   }

   return 0;
}

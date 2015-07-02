#include <stdio.h>
#include <stdlib.h>

#define LEN 1000001

static int compare(const void* a, const void* b)
{
   return (*(int*)a - *(int*)b);
}

int main(int argc, char* argv[])
{
   int i, j, pos;
   int seg_len, input_len;
   int seg[50];
   int found;
   char buffer[LEN];
   char input[LEN];

   while (gets(buffer) != NULL) {
      if (buffer[0] == '.' && buffer[1] == '\0')
         break;

      i = input_len = 0;
      while (buffer[i] != '\0') {
         if (buffer[i] != ' ') {
            input[input_len] = buffer[i];
            ++input_len;
         }
         ++i;
      }

      seg[0] = 1;
      for (seg_len = 1, i = 2; i * i <= input_len; i++) {
         if (input_len % i == 0) {
            seg[seg_len++] = i;
            seg[seg_len++] = input_len / i;
         }
      }
      if (seg[seg_len - 2] == seg[seg_len - 1]) --seg_len;

      qsort(seg, seg_len, sizeof(int), compare);

      found = 0;
      for (i = 0; i < seg_len && found == 0; i++) {
         found = seg[i];
         pos = seg[i];
         while (pos < input_len && found) {
            for (j = 0; j < seg[i]; j++) {
               if (input[j] != input[j + pos]) {
                  found = 0;
                  break;
               }
            }
            pos += seg[i];
         }
      }
      printf("%d\n", (found == 0) ? 1 : (input_len / found));
   }

   return 0;
}

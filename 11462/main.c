#include <stdio.h>
#include <stdlib.h>
#include <memory.h>

#define BUF_LEN 1000

static const char number[101][4] = {
   "",
    "1",  "2",  "3",  "4",  "5",  "6",  "7",  "8",  "9", "10",
   "11", "12", "13", "14", "15", "16", "17", "18", "19", "20",
   "21", "22", "23", "24", "25", "26", "27", "28", "29", "30",
   "31", "32", "33", "34", "35", "36", "37", "38", "39", "40",
   "41", "42", "43", "44", "45", "46", "47", "48", "49", "50",
   "51", "52", "53", "54", "55", "56", "57", "58", "59", "60",
   "61", "62", "63", "64", "65", "66", "67", "68", "69", "70",
   "71", "72", "73", "74", "75", "76", "77", "78", "79", "80",
   "81", "82", "83", "84", "85", "86", "87", "88", "89", "90",
   "91", "92", "93", "94", "95", "96", "97", "98", "99", "100"
};

int main(int argc, char* argv[])
{
   int a, n, next, tmp;
   int size;
   int count[101];
   int sequence[101];
   char space;
   char buffer[BUF_LEN];

   while (scanf("%d", &n) == 1 && n > 0) {
      size = 0;
      memset(count, 0, sizeof(count));
      memset(sequence, 0, sizeof(sequence));
      while (n-- > 0) {
         scanf("%d", &a);
         if (a < 10) {
            size += 2;
         } else if (a < 100) {
            size += 2;
         } else {
            size += 4;
         }
         ++count[a];
         if (count[a] == 1) {
            next = 0;
            while (sequence[next] != 0) {
               if (sequence[next] > a) {
                  tmp = sequence[next];
                  sequence[next] = a;
                  a = tmp;
               }
               next = sequence[next];
            }
            sequence[next] = a;
         }
      }
      tmp = space = 0;
      for (next = 0; sequence[next] != 0; next = sequence[next]) {
         while (count[sequence[next]]-- > 0) {
            if (space) {
               if (tmp + 1 >= BUF_LEN) {
                  buffer[tmp] = '\0';
                  tmp = 0;
                  printf("%s", buffer);
               }
               buffer[tmp++] = ' ';
            } else {
               space = 1;
            }
            for (a = 0; number[sequence[next]][a] != '\0'; a++) {
               if (tmp + 3 >= BUF_LEN) {
                  buffer[tmp] = '\0';
                  tmp = 0;
                  printf("%s", buffer);
               }
               buffer[tmp++] = number[sequence[next]][a];
            }
         }
      }
      buffer[tmp] = '\0';
      printf("%s\n", buffer);
   }

   return 0;
}

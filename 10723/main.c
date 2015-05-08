#include <stdio.h>

#define MAX(a, b) ((a) > (b) ? (a) : (b))

int read_line(char* buf)
{
   char* start = buf;
   while ((*buf = getchar()) != '\n')
      ++buf;
   *buf = '\0';
   return (buf - start);
}

int main(int argc, char* argv[])
{
   int i, j, n, test_case;
   int len[2];
   int lcs[31][31];
   int cyborg[31][31];
   char genes[2][31];

   for (i = 0; i < 31; i++) {
      lcs[i][0] = lcs[0][i] = 0;
      cyborg[i][0] = cyborg[0][i] = 1;
   }

   scanf("%d\n", &test_case);
   for (n = 1; n <= test_case; n++) {
      len[0] = read_line(genes[0]);
      len[1] = read_line(genes[1]);

      for (i = 0; i < len[0]; i++) {
         for (j = 0; j < len[1]; j++) {
            if (genes[0][i] == genes[1][j]) {
               lcs[i+1][j+1] = lcs[i][j] + 1;
               cyborg[i+1][j+1] = cyborg[i][j];
            } else {
               lcs[i+1][j+1] = MAX(lcs[i][j+1], lcs[i+1][j]);
               if (lcs[i][j+1] > lcs[i+1][j]) {
                  cyborg[i+1][j+1] = cyborg[i][j+1];
               } else if (lcs[i][j+1] < lcs[i+1][j]) {
                  cyborg[i+1][j+1] = cyborg[i+1][j];
               } else {
                  cyborg[i+1][j+1] = cyborg[i][j+1] + cyborg[i+1][j];
               }
            }
         }
      }
      i = len[0], j = len[1];
      printf("Case #%d: %d %d\n", n, ((i+j)-lcs[i][j]), cyborg[i][j]);
   }

   return 0;
}

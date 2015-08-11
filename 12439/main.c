#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define IS_LEAP_YEAR(y) (((y % 4 == 0) && (y % 100 != 0)) || (y % 400 == 0))
#define IS_JAN(m) (m[0] == 'J' && m[1] == 'a' && m[2] == 'n')
#define IS_FEB(m) (m[0] == 'F' && m[1] == 'e' && m[2] == 'b')

void date_parse(char* input, int* year, char* month, int* day)
{
   char* m;
   m = strtok(input, " ");
   month[0] = m[0];
   month[1] = m[1];
   month[2] = m[2];
   month[3] = '\0';
   *day = atoi(strtok(NULL, ","));
   *year = atoi(strtok(NULL, ","));
}

int main(int argc, char* argv[])
{
   int t, n;
   int leap_days[2];
   int year[2];
   int day[2];
   char month[2][4];
   char input[64];

   gets(input);
   n = atoi(input);
   for (t = 1; t <= n; t++) {
      gets(input);
      date_parse(input, &year[0], month[0], &day[0]);
      gets(input);
      date_parse(input, &year[1], month[1], &day[1]);

      leap_days[0] = (year[0] / 4) - (year[0] / 100) + (year[0] / 400);
      if (IS_LEAP_YEAR(year[0]) && (IS_JAN(month[0]) || (IS_FEB(month[0]) && day[0] <= 29)))
         --leap_days[0];

      leap_days[1] = (year[1] / 4) - (year[1] / 100) + (year[1] / 400);
      if (IS_LEAP_YEAR(year[1]) && (IS_JAN(month[1]) || (IS_FEB(month[1]) && day[1] < 29)))
         --leap_days[1];

      printf("Case %d: %d\n", t, leap_days[1] - leap_days[0]);
   }

   return 0;
}

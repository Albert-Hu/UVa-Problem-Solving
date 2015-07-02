#include <stdio.h>

int main(int argc, char* argv[])
{
   int t, n, i, j;
   int team_len, judge_len, space;
   char wrong_answer;
   char input[30];
   char team[30];
   char judge[30];

   scanf("%d\n", &n);
   for (t = 1; t <= n; t++) {
      space = 0;

      gets(input);
      team_len = 0;
      for (i = 0; input[i] != '\0'; i++) {
         if (input[i] == ' ') {
            ++space;
            continue;
         }
         team[team_len++] = input[i];
      }
      team[team_len++] = '\0';

      gets(input);
      judge_len = 0;
      for (i = 0; input[i] != '\0'; i++) {
         if (input[i] == ' ') {
            --space;
            continue;
         }
         judge[judge_len++] = input[i];
      }
      judge[judge_len++] = '\0';

      wrong_answer = 0;
      if (team_len == judge_len) {
         for (i = j = 0; team[i] != '\0' && judge[j] != '\0'; i++, j++) {
            if (team[i] != judge[j]) {
               wrong_answer = 1;
               break;
            }
         }
      } else {
         wrong_answer = 1;
      }

      if (wrong_answer) {
         printf("Case %d: Wrong Answer\n", t);
      } else {
         printf("Case %d: %s\n", t, (space == 0) ? "Yes" : "Output Format Error");
      }
   }
   return 0;
}

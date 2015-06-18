#include <stdio.h>
#include <string.h>

const static char language[6][8] = {
   "ENGLISH",
   "SPANISH",
   "GERMAN",
   "FRENCH",
   "ITALIAN",
   "RUSSIAN"
};

const static char hello[6][13] = {
   "HELLO",
   "HOLA",
   "HALLO",
   "BONJOUR",
   "CIAO",
   "ZDRAVSTVUJTE"
};

int main(int argc, char* argv[])
{
   int i, test_case = 1;
   char input[15];

   while (scanf("%s", input) ==1 && input[0] != '#') {
      for (i = 0; i < 6; i++) {
         if (strcmp(input, hello[i]) == 0) {
            printf("Case %d: %s\n", test_case, language[i]);
            break;
         }
      }
      if (i == 6) {
         printf("Case %d: UNKNOWN\n", test_case);
      }
      ++test_case;
   }

   return 0;
}

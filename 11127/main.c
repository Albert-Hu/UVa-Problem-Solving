#include <stdio.h>

int is_triple_free(int binary, int bit)
{
   int t[2];
   int mask = (1 << bit) - 1;

   t[0] = binary & mask;
   binary >>= bit;
   t[1] = binary & mask;
   binary >>= bit;
   binary &= mask;

   return (t[0] == t[1] && t[1] == binary);
}

int triple_count(char* input, int binary, int n)
{
   int bit;

   for (bit = n / 3; bit > 0; bit--) {
      if (is_triple_free(binary, bit))
         return 0;
   }

   if (*input == '\0')
      return 1;

   if (*input == '*')
      return triple_count((input + 1), (binary << 1), n + 1) + triple_count((input + 1), (binary << 1) + 1, n + 1);

   if (*input == '0')
      return triple_count((input + 1), (binary << 1), n + 1);
   else
      return triple_count((input + 1), (binary << 1) + 1, n + 1);
}

int main(int argc, char* argv[])
{
   int n, test_case = 1;
   char input[32];

   while (scanf("%d", &n) == 1 && n != 0) {
      scanf("%s", input);
      printf("Case %d: %d\n", test_case, triple_count(input, 0, 0));
      ++test_case;
   }

   return 0;
}

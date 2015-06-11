#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define MAX_VAL 0x7fffffff

int main(int argc, char* argv[])
{
   double a, b;
   char op;
   char number[2][1000];

   while (scanf("%s %c %s", number[0], &op, number[1]) == 3) {
      printf("%s %c %s\n", number[0], op, number[1]);
      a = atof(number[0]);
      b = atof(number[1]);
      if (a > MAX_VAL) printf("first number too big\n");
      if (b > MAX_VAL) printf("second number too big\n");
      if (op == '+' && (a + b) > MAX_VAL)
         printf("result too big\n");
      if (op == '*' && (a * b) > MAX_VAL)
         printf("result too big\n");
   }

   return 0;
}

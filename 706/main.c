#include <stdio.h>

void display(int s, char* n)
{
   char* c;
   int i, j, space;

   c = n;
   space = 0;
   while (*c != '\0') {
      if (space) putchar(' ');
      else space = 1;
      putchar(' ');
      switch (*c) {
         case '0': case '2': case '3': case '5':
         case '6': case '7': case '8': case '9':
            for (i = 0; i < s; i++) {
               putchar('-');
            }
            break;
         default:
            for (i = 0; i < s; i++) {
               putchar(' ');
            }
      }
      putchar(' ');
      ++c;
   }
   putchar('\n');
   for (i = 0; i < s; i++) {
      c = n;
      space = 0;
      while (*c != '\0') {
         if (space) putchar(' ');
         else space = 1;
         switch (*c) {
            case '0': case '4': case '5':
            case '6': case '8': case '9':
               putchar('|');
               break;
            default:
               putchar(' ');
         }
         for (j = 0; j < s; j++) putchar(' ');
         switch (*c) {
            case '0': case '1': case '2': case '3':
            case '4': case '7': case '8': case '9':
               putchar('|');
               break;
            default:
               putchar(' ');
         }
         ++c;
      }
      putchar('\n');
   }
   c = n;
   space = 0;
   while (*c != '\0') {
      if (space) putchar(' ');
      else space = 1;
      putchar(' ');
      switch (*c) {
         case '2': case '3': case '4': case '5':
         case '6': case '8': case '9':
            for (i = 0; i < s; i++) {
               putchar('-');
            }
            break;
         default:
            for (i = 0; i < s; i++) {
               putchar(' ');
            }
      }
      putchar(' ');
      ++c;
   }
   putchar('\n');
   for (i = 0; i < s; i++) {
      c = n;
      space = 0;
      while (*c != '\0') {
         if (space) putchar(' ');
         else space = 1;
         switch (*c) {
            case '0': case '2':case '6': case '8':
               putchar('|');
               break;
            default:
               putchar(' ');
         }
         for (j = 0; j < s; j++) putchar(' ');
         switch (*c) {
            case '0': case '1': case '3': case '4': case '5':
            case '6': case '7': case '8': case '9':
               putchar('|');
               break;
            default:
               putchar(' ');
         }
         ++c;
      }
      putchar('\n');
   }
   c = n;
   space = 0;
   while (*c != '\0') {
      if (space) putchar(' ');
      else space = 1;
      putchar(' ');
      switch (*c) {
         case '0': case '2': case '3': case '5':
         case '6': case '8': case '9':
            for (i = 0; i < s; i++) {
               putchar('-');
            }
            break;
         default:
            for (i = 0; i < s; i++) {
               putchar(' ');
            }
      }
      putchar(' ');
      ++c;
   }
   putchar('\n');
}

int main(int argc, char* argv[])
{
   int s;
   char n[16];

   while (scanf("%d%s", &s, n) == 2) {
      if (s == 0 && n[0] == '0' && n[1] == '\0')
         break;
      display(s, n);
      putchar('\n');
   }

   return 0;
}

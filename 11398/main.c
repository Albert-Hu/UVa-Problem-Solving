#include <stdio.h>
#include <string.h>

const static int bits[30] = {
   0x00000001,0x00000003,0x00000007,0x0000000f,0x0000001f,
   0x0000003f,0x0000007f,0x000000ff,0x000001ff,0x000003ff,
   0x000007ff,0x00000fff,0x00001fff,0x00003fff,0x00007fff,
   0x0000ffff,0x0001ffff,0x0003ffff,0x0007ffff,0x000fffff,
   0x001fffff,0x003fffff,0x007fffff,0x00ffffff,0x01ffffff,
   0x03ffffff,0x07ffffff,0x0fffffff,0x1fffffff,0x3fffffff
};

int main(int argc, char* argv[])
{
   int number, len, flag;
   char c;

   len = flag = number = 0;
   while ((c = getchar()) != '~' && c != EOF) {
      if (c == '0') {
         ++len;
      } else if (c == ' ') {
         if (len < 3) {
            if (len == 1) flag = 1;
            else if (len == 2) flag = 0;
         } else {
            len -= 2;
            number <<= len;
            if (flag) number |= bits[len - 1];
         }
         len = 0;
      } else if (c == '#'){
         printf("%d\n", number);
         len = flag = number = 0;
      }
   }

   return 0;
}

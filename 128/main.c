#include <stdio.h>

#define G 34943

int main(int argc, char* argv[])
{
   int i;
   unsigned int crc;
   char input[2048];

   while (gets(input) != NULL) {
      if (input[0] == '#' && input[1] == '\0')
         break;
      crc = 0;
      for (i = 0; input[i] != '\0'; i++) {
         crc = ((crc << 8) + input[i]) % G;
      }
      if (crc) {
         crc = G - ((crc << 16) % G);
      }
      printf("%02X %02X\n", (crc >> 8), (crc & 0xff));
   }

   return 0;
}

#include <stdio.h>

#define B 0
#define G 1
#define C 2

int main(int argc, char* argv[])
{
   int i, index;
   int total;
   int minimum, times_moved;
   int bottles[3][3];
   int colors[6][3] = {
      {B, C, G},
      {B, G, C},
      {C, B, G},
      {C, G, B},
      {G, B, C},
      {G, C, B}
   };
   char color_map[3] = {'B', 'G', 'C'};

   while (scanf("%d %d %d %d %d %d %d %d %d",
      &bottles[0][0],
      &bottles[0][1],
      &bottles[0][2],
      &bottles[1][0],
      &bottles[1][1],
      &bottles[1][2],
      &bottles[2][0],
      &bottles[2][1],
      &bottles[2][2]) == 9) {

      total = 0;
      total += bottles[0][0] + bottles[1][0] + bottles[2][0];
      total += bottles[0][1] + bottles[1][1] + bottles[2][1];
      total += bottles[0][2] + bottles[1][2] + bottles[2][2];

      minimum = 0x7fffffff;
      for (i = 0; i < 6; i++) {
         times_moved = total;
         times_moved -= bottles[0][colors[i][0]];
         times_moved -= bottles[1][colors[i][1]];
         times_moved -= bottles[2][colors[i][2]];
         if (times_moved < minimum) {
            minimum = times_moved;
            index = i;
         }
      }

      printf("%c%c%c %d\n",
         color_map[colors[index][0]],
         color_map[colors[index][1]],
         color_map[colors[index][2]],
         minimum);
   }

   return 0;
}

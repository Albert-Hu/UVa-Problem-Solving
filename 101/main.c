#include <stdio.h>

#define MAX_BLOCK (24)

#define IS_MOVE(cmd) (cmd[0] == 'm' && cmd[1] == 'o' &&\
                      cmd[2] == 'v' && cmd[3] == 'e')
#define IS_ONTO(cmd) (cmd[0] == 'o' && cmd[1] == 'n' &&\
                      cmd[2] == 't' && cmd[3] == 'o')

struct BLOCK {
   int number;
   struct BLOCK* top;
   struct BLOCK* above;
};

static void block_dump(struct BLOCK* start, struct BLOCK* end)
{
   struct BLOCK* stack;

   do {
      stack = start;
      printf("%d:", start->number);
      if (stack->above == NULL) {
         while (stack != NULL) {
            printf(" %d", stack->number);
            stack = stack->top;
         }
      }
      printf("\n");
   } while (++start < end);
}

static int block_in_same_stack(struct BLOCK* a, struct BLOCK* b)
{
   struct BLOCK* block;

   if (a == b) return 1;

   block = a->above;
   while (block != NULL) {
      if (block == b) return 1;
      block = block->above;
   }

   block = a->top;
   while (block != NULL) {
      if (block == b) return 1;
      block = block->top;
   }

   return 0;
}

static void block_put(struct BLOCK* a, struct BLOCK* b)
{
   if (a->above != NULL) {
      a->above->top = NULL;
   }

   while (b->top != NULL)
      b = b->top;

   a->above = b;
   b->top = a;
}

static void block_return(struct BLOCK* block)
{
   struct BLOCK* top_block = block->top;

   block->top = NULL;

   while (top_block != NULL) {
      block = top_block;
      top_block = block->top;
      block->above = block->top = NULL;
   }
}

int main(int argc, char* argv[])
{
   int n, a, b;
   char cmd[2][5];
   struct BLOCK blocks[MAX_BLOCK];

   scanf("%d", &n);

   a = 0, b = n;
   while (a < b) {
      blocks[a].number = a;
      blocks[a].top = blocks[a].above = NULL;
      ++a;
   }

   while (scanf("%s %d %s %d", &cmd[0], &a, &cmd[1], &b) == 4) {
      if (block_in_same_stack(&blocks[a], &blocks[b]))
         continue;

      if (IS_MOVE(cmd[0])) {
         if (blocks[a].above != NULL) {
            blocks[a].above->top = NULL;
         }
         block_return(&blocks[a]);
      }

      if (IS_ONTO(cmd[1])) {
         block_return(&blocks[b]);
      }

      block_put(&blocks[a], &blocks[b]);
   }

   block_dump(&blocks[0], &blocks[n]);

   return 0;
}

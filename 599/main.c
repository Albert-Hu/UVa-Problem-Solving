#include <stdio.h>
#include <stdlib.h>
#include <memory.h>

#define NOT(exp) (!(exp))

#define STATE_READ_EDGE  1
#define STATE_READ_POINT 2

struct NODE {
   int visited;
   int path_number;
   struct NODE* path[26];
};

void node_connect(struct NODE* a, struct NODE* b)
{
   a->path[a->path_number] = b;
   b->path[b->path_number] = a;
   a->path_number++;
   b->path_number++;
}

int node_visit(struct NODE* node, struct NODE* prev)
{
   int i, is_tree = 1;

   if (node->path_number == 0 || node->visited)
      return 0;

   node->visited = 1;

   if (node->path_number == 1 && node->path[0] == prev)
      return 1;

   for (i = 0; i < node->path_number; i++) {
      if (node->path[i] != prev) {
         is_tree &= node_visit(node->path[i], node);
      }
   }

   return is_tree;
}

int main(int argc, char* argv)
{
   int i;
   int tree, acorn;
   int state;
   char p1, p2;
   char input[52];
   struct NODE nodes[26];

   scanf("%d", &i);

   state = STATE_READ_EDGE;
   memset(nodes, 0, sizeof(nodes));

   while (scanf("%s", input) == 1) {
      switch (state) {
         case STATE_READ_EDGE:
            if (input[0] == '*') {
               state = STATE_READ_POINT;
            } else {
               p1 = input[1];
               p2 = input[3];
               node_connect(&nodes[p1 - 'A'], &nodes[p2 - 'A']);
            }
            break;
         case STATE_READ_POINT:
            tree = acorn = 0;
            for (i = 0; i < 26; i++) {
               tree += node_visit(&nodes[i], NULL);
            }
            if (input[0] != '(') {
               for (i = 0; input[i] != '\0'; i++) {
                  if NOT(input[i] >= 'A' && input[i] <= 'Z')
                     continue;
                  if (nodes[input[i] - 'A'].path_number == 0)
                     ++acorn;
               }
            }
            printf("There are %d tree(s) and %d acorn(s).\n", tree, acorn);
            memset(nodes, 0, sizeof(nodes));
            if (input[0] == '(') {
               p1 = input[1];
               p2 = input[3];
               node_connect(&nodes[p1 - 'A'], &nodes[p2 - 'A']);
            }
            state = STATE_READ_EDGE;
            break;
      }
   }
   return 0;
}

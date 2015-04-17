#include <stdio.h>

struct DIMENSION {
   int number;
   struct DIMENSION* next;
};

struct BOX {
   int number;
   int count;
   struct DIMENSION* dim;
   struct BOX* next;
   struct BOX* inside;
};

int dimension_compare(struct DIMENSION* a, struct DIMENSION* b)
{
   while (a != NULL && b != NULL) {
      if (a->number < b->number) {
         return -1;
      } else if (a->number > b->number) {
         return 1;
      }
      a = a->next;
      b = b->next;
   }

   return 0;
}

void dimension_insert(struct DIMENSION** start, struct DIMENSION* dim)
{
   while (*start != NULL) {
      if ((*start)->number > dim->number) {
         dim->next = *start;
         break;
      }
      start = &(*start)->next;
   }

   *start = dim;
}

void box_nest(struct BOX* from, struct BOX* to)
{
   struct DIMENSION* a;
   struct DIMENSION* b;

   a = from->dim;
   b = to->dim;

   while (a != NULL && b != NULL) {
      if (a->number >= b->number)
         return;
      a = a->next;
      b = b->next;
   }

   if (from->count >= to->count) {
      to->count = from->count + 1;
      to->inside = from;
   }
}

void box_insert(struct BOX** start, struct BOX* box)
{
   while (*start != NULL) {
      if (dimension_compare((*start)->dim, box->dim) > 0) {
         box->next = *start;
         break;
      }
      start = &(*start)->next;
   }

   *start = box;
}

void box_dump(struct BOX* box)
{
   if (box->inside == NULL) {
      printf("%d", box->number);
   } else {
      box_dump(box->inside);
      printf(" %d", box->number);
   }
}

void box_longest_nesting_string(struct BOX* start)
{
   int max_count = 0;
   struct BOX* s = start;
   struct BOX* box;

   while (s != NULL) {
      box = s->next;
      while (box != NULL) {
         box_nest(s, box);
         box = box->next;
      }
      s = s->next;
   }

   box = start;
   while (box != NULL) {
      if (max_count < box->count) {
         s = box;
         max_count = box->count;
      }
      box = box->next;
   }

   printf("%d\n", max_count);

   box_dump(s);
   printf("\n");
}

int main(int argc, char* argv[])
{
   int s, d;
   int seq, dim;
   struct BOX* box;
   struct BOX boxes[30];
   struct DIMENSION dimensions[30][10];

   while (scanf("%d%d", &seq, &dim) == 2) {
      box = NULL;
      for (s = 0; s < seq; s++) {
         boxes[s].number = s + 1;
         boxes[s].count = 1;
         boxes[s].next = NULL;
         boxes[s].inside = NULL;
         boxes[s].dim = NULL;
         for (d = 0; d < dim; d++) {
            dimensions[s][d].next = NULL;
            scanf("%d", &dimensions[s][d].number);
            dimension_insert(&boxes[s].dim, &dimensions[s][d]);
         }
         box_insert(&box, &boxes[s]);
      }

      box_longest_nesting_string(box);
   }

   return 0;
}

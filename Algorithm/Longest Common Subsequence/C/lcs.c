#include <stdlib.h>
#include <memory.h>

#include "lcs.h"

#define MAX(a, b) ((a) > (b) ? (a) : (b))

struct SEQUENCE {
   int length;
   void* elements[0];
};

struct LCS_RECORD {
   int count;
   void* element;
   struct LCS_RECORD* previous;
};

struct LCS {
   int length;
   void* elements[0];
};

struct SEQUENCE* sequence_new(void* array, int size, int length)
{
   int i;
   struct SEQUENCE* seq;

   i = sizeof(struct SEQUENCE) + (sizeof(void*) * length);
   seq = (struct SEQUENCE*) malloc(i);

   seq->length = length;

   for (i = 0; i < length; i++) {
      seq->elements[i] = array + size * i;
   }

   return seq;
}

struct LCS* lcs_find(struct SEQUENCE* a, struct SEQUENCE* b, fn_compare compare)
{
   int i, j;
   struct LCS* lcs;
   struct LCS_RECORD* column;
   struct LCS_RECORD* upper_column;
   struct LCS_RECORD* table;

   i = sizeof(struct LCS_RECORD) * (a->length + 1) * (b->length + 1);
   table = (struct LCS_RECORD*) malloc(i);
   memset(table, 0, i);

   for (i = 0; i < a->length; i++) {
      column = table + (i + 1) * (b->length + 1);
      upper_column = table + i * (b->length + 1);
      for (j = 0; j < b->length; j++) {
         ++column;
         ++upper_column;
         if (compare(a->elements[i], b->elements[j]) == 0) {
            column->count = (upper_column - 1)->count + 1;
            column->element = a->elements[i];
            column->previous = upper_column - 1;
         } else {
            if ((column-1)->count > upper_column->count) {
               column->count = (column - 1)->count;
               column->previous = (column - 1);
            } else {
               column->count = upper_column->count;
               column->previous = upper_column;
            }
            column->element = NULL;
         }
      }
   }

   if (column->count == 0)
      return NULL;

   i = sizeof(struct LCS) + column->count * sizeof(void*);
   lcs = (struct LCS*) malloc(i);
   lcs->length = column->count;

   i = lcs->length - 1;
   while (column != NULL) {
      if (column->element != NULL) {
         lcs->elements[i] = column->element;
         --i;
      }
      column = column->previous;
   }

   free(table);

   return lcs;
}

void* lcs_element_at(struct LCS* lcs, int index)
{
   return (index < lcs->length) ? (void*) lcs->elements[index] : NULL;
}

int lcs_length(struct LCS* lcs)
{
   return lcs->length;
}

void lcs_destroy(struct LCS* lcs)
{
   free(lcs);
}

void sequence_destroy(struct SEQUENCE* seq)
{
   free(seq);
}

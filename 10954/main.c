#include <stdio.h>

struct NODE {
   int n;
   struct NODE* next;
};

struct QUEUE {
   int size;
   struct NODE* list;
};

struct NODE* pop(struct QUEUE* queue)
{
   struct NODE* node = queue->list;

   if (queue->list != NULL) {
      queue->list = node->next;
      queue->size--;
   }

   return node;
}

void push(struct QUEUE* queue, struct NODE* node)
{
   struct NODE** iterator = &(queue->list);

   node->next = NULL;

   while (*iterator != NULL) {
      if ((*iterator)->n > node->n) {
         node->next = *iterator;
         break;
      }
      iterator = &(*iterator)->next;
   }

   *iterator = node;

   queue->size++;
}

int main(int argc, char* argv[])
{
   int n, i;
   long long int cost;
   struct NODE* a;
   struct NODE* b;
   struct NODE list[5000];
   struct QUEUE queue;

   while (scanf("%d", &n) == 1 && n != 0) {
      cost = 0;
      queue.size = 0;
      queue.list = NULL;
      for (i = 0; i < n; i++) {
         scanf("%d", &list[i].n);
         push(&queue, &list[i]);
      }
      while (queue.size > 1) {
         a = pop(&queue);
         b = pop(&queue);
         a->n += b->n;
         cost += a->n;
         push(&queue, a);
      }
      printf("%lld\n", cost);
   }

   return 0;
}

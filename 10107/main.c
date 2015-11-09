#include <stdio.h>
#include <stdlib.h>
#include <memory.h>

#define ARRAY_SIZE 128

struct PriorityQueue {
   int* array;
   int size;
   int max_size;
   int is_little_first;
};

struct MedianFinder {
   struct PriorityQueue* min_queue;
   struct PriorityQueue* max_queue;
};

static struct PriorityQueue* PriorityQueueCreate(int is_little_first)
{
   struct PriorityQueue* queue = (struct PriorityQueue*) malloc(sizeof(struct PriorityQueue));

   queue->is_little_first = (is_little_first != 0);
   queue->size = 0;
   queue->max_size = ARRAY_SIZE;
   queue->array = (int*) malloc(sizeof(int) * ARRAY_SIZE);

   return queue;
}

static void PriorityQueuePush(struct PriorityQueue* queue, int num)
{
   int root, leaf;

   if (queue->size == queue->max_size) {
      int* new_array = (int*) malloc(sizeof(int) * (queue->max_size + ARRAY_SIZE));
      memcpy(new_array, queue->array, sizeof(int) * queue->max_size);
      queue->max_size = queue->max_size + ARRAY_SIZE;
      free(queue->array);
      queue->array = new_array;
   }

   leaf = queue->size;
   root = (leaf - 1) / 2;
   queue->array[leaf] = num;
   do {
      if (queue->is_little_first) {
         if (queue->array[leaf] < queue->array[root]) {
            num = queue->array[root];
            queue->array[root] = queue->array[leaf];
            queue->array[leaf] = num;
         } else {
            break;
         }
      } else {
         if (queue->array[leaf] > queue->array[root]) {
            num = queue->array[root];
            queue->array[root] = queue->array[leaf];
            queue->array[leaf] = num;
         } else {
            break;
         }
      }
      leaf = root;
      root = (leaf - 1) / 2;
   } while (leaf > 0);

   queue->size++;
}

static int PriorityQueuePop(struct PriorityQueue* queue)
{
   int top, tmp, root, left, right;

   top = queue->array[0];
   queue->array[0] = queue->array[queue->size - 1];

   root = 0;
   left = root * 2 + 1;
   right = left + 1;

   while (right < queue->size) {
      if (queue->is_little_first) {
         if (queue->array[root] <= queue->array[left] && queue->array[root] <= queue->array[right])
            break;
         if (queue->array[right] >= queue->array[left]) {
            tmp = queue->array[root];
            queue->array[root] = queue->array[left];
            queue->array[left] = tmp;
            root = left;
         } else {
            tmp = queue->array[root];
            queue->array[root] = queue->array[right];
            queue->array[right] = tmp;
            root = right;
         }
      } else {
         if (queue->array[root] >= queue->array[left] && queue->array[root] >= queue->array[right])
            break;
         if (queue->array[right] <= queue->array[left]) {
            tmp = queue->array[root];
            queue->array[root] = queue->array[left];
            queue->array[left] = tmp;
            root = left;
         } else {
            tmp = queue->array[root];
            queue->array[root] = queue->array[right];
            queue->array[right] = tmp;
            root = right;
         }
      }
      left = root * 2 + 1;
      right = left + 1;
   }
   queue->size--;

   return top;
}

static int PriorityQueueIsEmpty(struct PriorityQueue* queue)
{
   return (queue->size == 0);
}

static int PriorityQueueGetSize(struct PriorityQueue* queue)
{
   return queue->size;
}

static int PriorityQueueGetTop(struct PriorityQueue* queue)
{
   return queue->array[0];
}

static void PriorityQueueFree(struct PriorityQueue* queue)
{
   free(queue->array);
   free(queue);
}

struct MedianFinder* MedianFinderCreate()
{
   struct MedianFinder* mf = (struct MedianFinder*) malloc(sizeof(struct MedianFinder));

   mf->max_queue = PriorityQueueCreate(1);
   mf->min_queue = PriorityQueueCreate(0);

   return mf;
}

void addNum(struct MedianFinder* mf, int num)
{
   int top[2];
   int size[2];

   PriorityQueuePush(mf->max_queue, num);
   size[0] = PriorityQueueGetSize(mf->max_queue);
   size[1] = PriorityQueueGetSize(mf->min_queue);

   if (((size[0] - size[1]) > 1)) {
      PriorityQueuePush(mf->min_queue, PriorityQueuePop(mf->max_queue));
   }

   top[0] = PriorityQueueGetTop(mf->max_queue);
   top[1] = PriorityQueueGetTop(mf->min_queue);
   if (size[0] != 0 && size[1] != 0 && top[0] < top[1]) {
      PriorityQueuePop(mf->max_queue);
      PriorityQueuePush(mf->max_queue, top[1]);
      PriorityQueuePop(mf->min_queue);
      PriorityQueuePush(mf->min_queue, top[0]);
   }
}

int findMedian(struct MedianFinder* mf)
{
   int top[2];
   int size[2];

   top[0] = PriorityQueueGetTop(mf->max_queue);
   top[1] = PriorityQueueGetTop(mf->min_queue);
   size[0] = PriorityQueueGetSize(mf->max_queue);
   size[1] = PriorityQueueGetSize(mf->min_queue);

   if (size[0] == size[1]) {
      return (top[0] + top[1]) / 2;
   }

   return top[0];
}

void MedianFinderFree(struct MedianFinder* mf)
{
   PriorityQueueFree(mf->max_queue);
   PriorityQueueFree(mf->min_queue);
   free(mf);
}


int main(int argc, char* argv[])
{
   int n;
   struct MedianFinder* mf = MedianFinderCreate();

   while (scanf("%d", &n) == 1) {
      addNum(mf, n);
      printf("%d\n", findMedian(mf));
   }
   MedianFinderFree(mf);

   return 0;
}

#include <stdio.h>
#include <stdlib.h>
#include <memory.h>

#define INFINITE 0x7fffffff

int heap_pop(int* heap, int* value, int tail)
{
   int head = heap[0];
   int tmp;
   int root = 0;
   int left = 1;
   int right = 2;
   int index, index_r, index_l;

   --tail;
   heap[0] = heap[tail];
   index = heap[0];
   index_l = heap[1];
   index_r = heap[2];

   while (right <= tail) {
      if (value[index] <= value[index_l] && value[index] <= value[index_r])
         break;
      if (value[index_r] >= value[index_l]) {
         tmp = heap[root];
         heap[root] = heap[left];
         heap[left] = tmp;
         root = left;
      } else {
         tmp = heap[root];
         heap[root] = heap[right];
         heap[right] = tmp;
         root = right;
      }
      left = 2 * root + 1;
      right = left + 1;
      index = heap[root];
      index_l = heap[left];
      index_r = heap[right];
   }

   if (left == tail && value[index] > value[index_l]) {
      tmp = heap[root];
      heap[root] = heap[left];
      heap[left] = tmp;
   }

   return head;
}

void heap_push(int* heap, int* value, int index, int tail)
{
   int root, root_index;

   if (tail == 0) {
      heap[0] = index;
   } else {
      while (tail > 0) {
         root = (tail - 1) / 2;
         root_index = heap[root];
         if (value[index] > value[root_index]) {
            break;
         }
         heap[tail] = heap[root];
         tail = root;
      }
      heap[tail] = index;
   }
}

int main(int argc, char* argv[])
{
   int n, m, i, j, t;
   int index, next;
   int heap_size;
   int* maze;
   int* heap;
   int* distance;
   char* visited;

   heap = (int*) malloc(sizeof(int) * 1000000);
   maze = (int*) malloc(sizeof(int) * 1000000);
   distance = (int*) malloc(sizeof(int) * 1000000);
   visited = (char*) malloc(sizeof(char) * 1000000);

   scanf("%d", &t);
   while (t-- > 0) {
      scanf("%d%d", &n, &m);
      for (i = 0; i < n; i++) {
         for (j = 0; j < m; j++) {
            index = (i * m) + j;
            scanf("%d", &maze[index]);
            visited[index] = 0;
            distance[index] = INFINITE;
         }
      }
      distance[0] = maze[0];
      heap_size = 1;
      heap_push(heap, distance, 0, 0);
      while (heap_size > 0) {
         index = heap_pop(heap, distance, heap_size);
         --heap_size;
         visited[index] = 1;
         i = index / m;
         j = index % m;

         if (j > 0) {
            next = (i * m) + (j - 1);
            if ((distance[index] + maze[next]) < distance[next] && !visited[next]) {
               distance[next] = distance[index] + maze[next];
               heap_push(heap, distance, next, heap_size);
               ++heap_size;
            }
         }

         if ((j + 1) < m) {
            next = (i * m) + (j + 1);
            if ((distance[index] + maze[next]) < distance[next] && !visited[next]) {
               distance[next] = distance[index] + maze[next];
               heap_push(heap, distance, next, heap_size);
               ++heap_size;
            }
         }

         if (i > 0) {
            next = ((i - 1) * m) + j;
            if ((distance[index] + maze[next]) < distance[next] && !visited[next]) {
               distance[next] = distance[index] + maze[next];
               heap_push(heap, distance, next, heap_size);
               ++heap_size;
            }
         }

         if ((i + 1) < n) {
            next = ((i + 1) * m) + j;
            if ((distance[index] + maze[next]) < distance[next] && !visited[next]) {
               distance[next] = distance[index] + maze[next];
               heap_push(heap, distance, next, heap_size);
               ++heap_size;
            }
         }
      }
      printf("%d\n", distance[(n * m) - 1]);
   }

   return 0;
}

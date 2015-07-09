#include <stdio.h>
#include <memory.h>

#define NODES    1001
#define INFINITE 1000001

int path[NODES][NODES];
int route[NODES];

int dfs(int src, int n)
{
   int i;

   if (route[src] == 0) {
      for (i = 1; i <= n; i++) {
         if (path[src][i] != INFINITE && path[2][i] < path[2][src]) {
            route[src] += dfs(i, n);
         }
      }
   }
   return route[src];
}

void shortest_path(int src, int n)
{
   int dest, i, k, d;
   char selected[NODES];

   for (i = 1; i <= n; i++) {
      selected[i] = (i == src) ? 1 : 0;
   }

   for (i = 1; i <= n; i++) {
      k = 0;
      d = INFINITE;
      for (dest = 1; dest <= n; dest++) {
         if (path[src][dest] < d && !selected[dest]) {
            d = path[src][dest];
            k = dest;
         }
      }
      selected[k] = 1;
      for (dest = 1; dest <= n; dest++) {
         d = path[src][k] + path[k][dest];
         if (d < path[src][dest]) {
            path[src][dest] = d;
         }
      }
   }
}

int main(int argc, char* argv[])
{
   int n, m, i, j, k;

   for (i = 0; i < NODES; i++) {
      path[0][i] = path[i][0] = INFINITE;
   }

   while (scanf("%d%d", &n, &m) == 2) {
      for (i = 1; i <= n; i++) {
         for (j = 1; j <= n; j++) {
            path[i][j] = (i == j) ? 0 : INFINITE;
         }
      }
      while (m-- > 0) {
         scanf("%d%d%d", &i, &j, &k);
         path[j][i] = path[i][j] = k;
      }
      shortest_path(2, n);
      memset(route, 0, sizeof(int) * (n + 1));
      route[2] = 1;
      printf("%d\n", dfs(1, n));
   }

   return 0;
}

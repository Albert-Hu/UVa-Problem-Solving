#include <stdio.h>
#include <memory.h>

#define INF 1000

int main(int argc, char* argv[])
{
	int i, j, k, n, m, index, test_case = 1;
	unsigned int sum;
	unsigned int distance[22][22];
	char name[22][16];

	while (scanf("%d%d", &n, &m) == 2 && n != 0) {
		for (i = 0; i < n; ++i) {
			for (j = 0; j < n; ++j) {
				distance[i][j] = (i == j) ? 0 : INF;
			}
		}
		for (i = 0; i < n; ++i) {
			scanf("%s", name[i]);
		}
		while (m-- > 0) {
			scanf("%d%d%d", &i, &j, &k);
			--i;
			--j;
			distance[i][j] = distance[j][i] = k;
		}
		for (k = 0; k < n; ++k) {
			for (i = 0; i < n; ++i) {
				for (j = 0; j < n; ++j) {
					if (distance[i][j] > (distance[i][k] + distance[k][j]))
						distance[i][j] = distance[i][k] + distance[k][j];
				}
			}
		}

		k = INF * n;
		index = 0;
		for (i = 0; i < n; ++i) {
			sum = 0;
			for (j = 0; j < n; ++j) {
				sum += distance[i][j];
			}
			if (sum < k) {
				k = sum;
				index = i;
			}
		}
		printf("Case #%d : %s\n", test_case, name[index]);
		++test_case;
	}
	return 0;
}

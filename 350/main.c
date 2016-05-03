#include <stdio.h>

int next_random(int z, int i, int m, int l)
{
	return (z * l + i) % m;
}

int main(int argc, char* argv[])
{
	int z, i, m, l, slow, fast, length, test_case = 1;

	while (scanf("%d%d%d%d", &z, &i, &m, &l) == 4) {
		if (z == 0 && i == 0 && m == 0 && l == 0)
			break;
		slow = next_random(z, i, m, l);
		fast = next_random(z, i, m, slow);
		while (slow != fast) {
			slow = next_random(z, i, m, slow);
			fast = next_random(z, i, m, next_random(z, i, m, fast));
		}
		length = 1;
		fast = next_random(z, i, m, slow);
		while (slow != fast) {
			fast = next_random(z, i, m, fast);
			++length;
		}
		printf("Case %d: %d\n", test_case, length);
		++test_case;
	}

	return 0;
}

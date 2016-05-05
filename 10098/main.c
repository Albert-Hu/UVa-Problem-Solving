#include <stdio.h>
#include <stdlib.h>
#include <string.h>

void generate(char* string, int str_len, char* stack, int stack_len, char* used)
{
	int i;

	if (str_len == stack_len) {
		puts(stack);
		return;
	}

	for (i = 0; i < str_len; ++i) {
		if (used[i])
			continue;
		if (i < (str_len - 1)) {
			if (string[i] == string[i + 1] && used[i + 1])
				continue;
		}
		used[i] = 1;
		stack[stack_len] = string[i];
		generate(string, str_len, stack, stack_len + 1, used);
		used[i] = 0;
	}
}

int compare(const void* a, const void* b)
{
	return *(char*)a > *(char*)b;
}

int main(int argc, char* argv[])
{
	int n, len;
	char string[16];
	char stack[16];
	char used[16];

	scanf("%d", &n);
	while (n-- > 0) {
		memset(string, 0, 16);
		memset(stack, 0, 16);
		memset(used, 0, 16);
		scanf("%s", string);
		len = strlen(string);
		qsort(string, len, sizeof(char), &compare);
		generate(string, len, stack, 0, used);
		puts("");
	}
	return 0;
}

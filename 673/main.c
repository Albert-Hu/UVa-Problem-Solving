#include <stdio.h>
#include <stdlib.h>

int main(int argc, char* argv[])
{
	int n, i, s;
	char input[132];
	char stack[128];

	gets(input);
	n = atoi(input);
	while (n-- > 0) {
		gets(input);
		for (i = 0, s = -1; input[i] != '\0'; ++i) {
			if (input[i] == '[' || input[i] == '(') {
				++s;
				stack[s] = input[i];
			} else {
				if ((input[i] == ']' && stack[s] != '[') || (input[i] == ')' && stack[s] != '(')) {
					break;
				}
				--s;
			}
		}
		puts((s == -1 && input[i] == '\0') ? "Yes" : "No");
	}

	return 0;
}

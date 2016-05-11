#include <stdio.h>
#include <math.h>

int main(int argc, char* argv[])
{
	int sq, c, step;

	while (scanf("%d", &step) == 1 && step > 0) {
		sq = (int) sqrt((double) step);
		if ((sq * sq) != step)
			++sq;
		c = (sq * sq) - (sq - 1);
		if ((sq % 2) == 0) {
			if (step > c) {
				printf("%d %d\n", sq, sq - (step - c));
			} else {
				printf("%d %d\n", sq - (c - step), sq);
			}
		} else {
			if (step > c) {
				printf("%d %d\n", sq - (step - c), sq);
			} else {
				printf("%d %d\n", sq, sq - (c - step));
			}
		}
	}

	return 0;
}

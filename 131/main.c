#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int priority(char** cards)
{
	int i;
	char is_ordered = 0;
	char same_color[6] = {0, 0, 0, 0, 0, 0};
	char same_number[5] = {0, 0, 0, 0, 0};
	char color_count[4] = {0, 0, 0, 0};
	char number_count[13] = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};

	for (i = 0; i < 5; ++i) {
		same_number[i] = 0;
	}

	for (i = 0; i < 6; ++i) {
		same_color[i] = 0;
	}

	for (i = 0; i < 5; ++i) {
		switch (cards[i][0]) {
			case 'A': number_count[0]++; break;
			case '2': number_count[1]++; break;
			case '3': number_count[2]++; break;
			case '4': number_count[3]++; break;
			case '5': number_count[4]++; break;
			case '6': number_count[5]++; break;
			case '7': number_count[6]++; break;
			case '8': number_count[7]++; break;
			case '9': number_count[8]++; break;
			case 'T': number_count[9]++; break;
			case 'J': number_count[10]++; break;
			case 'Q': number_count[11]++; break;
			case 'K': number_count[12]++; break;
		}
		switch (cards[i][1]) {
			case 'H': color_count[0]++; break;
			case 'C': color_count[1]++; break;
			case 'D': color_count[2]++; break;
			case 'S': color_count[3]++; break;
		}
	}

	for (i = 0; i < 13; ++i) {
		same_number[number_count[i]]++;
	}

	for (i = 0; i < 5; ++i) {
		same_color[color_count[i]]++;
	}

	for (i = 0; i < 9 && !is_ordered; ++i) {
		is_ordered =  (number_count[i] == 1);
		is_ordered &=  (number_count[i + 1] == 1);
		is_ordered &=  (number_count[i + 2] == 1);
		is_ordered &=  (number_count[i + 3] == 1);
		is_ordered &=  (number_count[i + 4] == 1);
	}
	if (!is_ordered) {
		is_ordered =  (number_count[0] == 1);
		is_ordered &=  (number_count[9] == 1);
		is_ordered &=  (number_count[10] == 1);
		is_ordered &=  (number_count[11] == 1);
		is_ordered &=  (number_count[12] == 1);
	}

	if (is_ordered && same_color[5])
		return 0;
	if (same_number[4])
		return 1;
	if (same_number[3] && same_number[2])
		return 2;
	if (same_color[5])
		return 3;
	if (is_ordered)
		return 4;
	if (same_number[3])
		return 5;
	if (same_number[2])
		return (same_number[2] == 2) ? 6 : 7;
	return 8;
}

int select_best_hand(char** card, int num_card, char** hand, int num_hand)
{
	int i, m, min = 8;

	if ((num_card + num_hand) < 5)
		return 8;

	if (num_card == 5) {
		return priority(card);
	}

	for (i = 0; i < num_hand && min > 0; ++i) {
		card[num_card] = hand[i];
		m = select_best_hand(card, (num_card + 1), &hand[i + 1], (num_hand - i - 1));
		if (m < min) {
			min = m;
		}
	}
	return min;
}

int main(int argc, char* argv[])
{
	int i, h, d, min;
	int stack[5];
	char* tok;
	char* card[10];
	char* deck[5];
	char line[32];

	while (gets(line)) {
		i = 0;
		tok = strtok(line, " ");
		while (tok) {
			card[i++] = tok;
			tok = strtok(NULL, " ");
		}
		printf("Hand: %s %s %s %s %s Deck: %s %s %s %s %s Best hand: ",
				 card[0], card[1], card[2], card[3], card[4],
				 card[5], card[6], card[7], card[8], card[9]);
		h = priority(&card[0]);
		d = priority(&card[5]);
		min = (h < d) ? h : d;
		for (d = 0; d < 5 && min > 0; ++d) {
			deck[d] = card[d + 5];
			i = select_best_hand(deck, (d + 1), &card[0], 5);
			if (i < min)
				min = i;
		}
		switch (min) {
			case 0: puts("straight-flush"); break;
			case 1: puts("four-of-a-kind"); break;
			case 2: puts("full-house"); break;
			case 3: puts("flush"); break;
			case 4: puts("straight"); break;
			case 5: puts("three-of-a-kind"); break;
			case 6: puts("two-pairs"); break;
			case 7: puts("one-pair"); break;
			default: puts("highest-card");
		}
	}

	return 0;
}

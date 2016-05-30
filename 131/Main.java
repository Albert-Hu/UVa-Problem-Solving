import java.io.*;
import java.util.*;

public class Main {
	public static void main(String args[]) throws IOException {
		String line;
		StringBuilder answer = new StringBuilder();
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		while ((line = in.readLine()) != null) {
			int bestPriority;
			String[] cards = line.split(" ");
			String[] hand = Arrays.copyOfRange(cards, 0, 5);
			String[] deck = Arrays.copyOfRange(cards, 5, 10);
			answer.append("Hand: ");
			for (String str: hand)
				answer.append(str + " ");
			answer.append("Deck: ");
			for (String str: deck)
				answer.append(str + " ");
			answer.append("Best hand: ");
			bestPriority = getPriority(hand);
			for (int i = 0; i < deck.length && bestPriority != 0; ++i) {
				int p;
				ArrayList<String> d = new ArrayList<String>();
				for (int j = 0; j <= i; ++j) {
					d.add(deck[j]);
				}
				p = getBestPriority(d, hand);
				if (p < bestPriority)
					bestPriority = p;
			}
			switch (bestPriority) {
				case 0: answer.append("straight-flush\n"); break;
				case 1: answer.append("four-of-a-kind\n"); break;
				case 2: answer.append("full-house\n"); break;
				case 3: answer.append("flush\n"); break;
				case 4: answer.append("straight\n"); break;
				case 5: answer.append("three-of-a-kind\n"); break;
				case 6: answer.append("two-pairs\n"); break;
				case 7: answer.append("one-pair\n"); break;
				case 8: answer.append("highest-card\n"); break;
			}
		}
		System.out.print(answer);
	}

	public static int getBestPriority(ArrayList<String> deck, String[] hand) {
		int bestPriority = 8;
		if ((deck.size() + hand.length) < 5)
			return 8;
		if (deck.size() == 5) {
			String[] cards = (String[]) deck.toArray(new String[5]);
			return getPriority(cards);
		}
		for (int i = 0; i < hand.length && bestPriority != 0; ++i) {
			int p;
			deck.add(hand[i]);
			p = getBestPriority(deck, Arrays.copyOfRange(hand, i + 1, hand.length));
			deck.remove(deck.size() - 1);
			if (p < bestPriority)
				bestPriority = p;
		}
		return bestPriority;
	}

	public static int getPriority(String[] cards) {
		boolean isOrdered = false;
		int[] sameColorSet = new int[6];
		int[] sameNumberSet = new int[5];
		int[] colors = new int[4];
		int[] numbers = new int[13];

		for (String card: cards) {
			switch (card.charAt(0)) {
				case 'A': numbers[0]++; break;
				case '2': numbers[1]++; break;
				case '3': numbers[2]++; break;
				case '4': numbers[3]++; break;
				case '5': numbers[4]++; break;
				case '6': numbers[5]++; break;
				case '7': numbers[6]++; break;
				case '8': numbers[7]++; break;
				case '9': numbers[8]++; break;
				case 'T': numbers[9]++; break;
				case 'J': numbers[10]++; break;
				case 'Q': numbers[11]++; break;
				case 'K': numbers[12]++; break;
			}
			switch (card.charAt(1)) {
				case 'H': colors[0]++; break;
				case 'C': colors[1]++; break;
				case 'D': colors[2]++; break;
				case 'S': colors[3]++; break;
			}
		}

		for (int set: numbers) {
			sameNumberSet[set]++;
		}

		for (int set: colors) {
			sameColorSet[set]++;
		}

		for (int i = 0; i < 10 && !isOrdered; ++i) {
			isOrdered = (numbers[i] == 1);
			isOrdered &= (numbers[(i + 1) % 13] == 1);
			isOrdered &= (numbers[(i + 2) % 13] == 1);
			isOrdered &= (numbers[(i + 3) % 13] == 1);
			isOrdered &= (numbers[(i + 4) % 13] == 1);
		}

		if (isOrdered && sameColorSet[5] == 1)
			return 0;
		if (sameNumberSet[4] == 1)
			return 1;
		if (sameNumberSet[3] == 1 && sameNumberSet[2] == 1)
			return 2;
		if (sameColorSet[5] == 1)
			return 3;
		if (isOrdered)
			return 4;
		if (sameNumberSet[3] == 1)
			return 5;
		if (sameNumberSet[2] == 2)
			return 6;
		if (sameNumberSet[2] == 1)
			return 7;
		return 8;
	}
}

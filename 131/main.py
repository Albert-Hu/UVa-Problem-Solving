import sys
import functools
import itertools

straights = [[1,2,3,4,5],[2,3,4,5,6],[3,4,5,6,7],[4,5,6,7,8],[5,6,7,8,9],[6,7,8,9,10],[7,8,9,10,11],[8,9,10,11,12],[9,10,11,12,13],[1,10,11,12,13]]
numbers = {"A":1,"2":2,"3":3,"4":4,"5":5,"6":6,"7":7,"8":8,"9":9,"T":10,"J":11,"Q":12,"K":13}
output = ["straight-flush","four-of-a-kind","full-house","flush","straight","three-of-a-kind","two-pairs","one-pair","highest-card"]

def duplicate(nums, n):
	nums[n] += 1
	return nums

def priority(cards):
	nums = [n for n in map(lambda card: numbers[card[0]], cards)]
	nums.sort()
	is_straight = nums in straights
	is_flush = len([card for card in cards if card[1] == cards[0][1]]) == 5
	nums = functools.reduce(duplicate, nums, [0] * 14)
	if is_flush and is_straight:
		return 0
	if nums.count(4):
		return 1
	if nums.count(3) == 1 and nums.count(2) == 1:
		return 2
	if is_flush:
		return 3
	if is_straight:
		return 4
	if nums.count(3):
		return 5
	if nums.count(2) == 2:
		return 6
	if nums.count(2) == 1:
		return 7
	return 8

def process(line):
	cards = line.split()
	hand = cards[:5]
	deck = cards[5:]
	h = priority(hand)
	d = priority(deck)
	print("Hand: %s %s %s %s %s Deck: %s %s %s %s %s Best hand: " % tuple(cards), end = '')
	minimum = h if h < d else d
	for n in range(1, 5):
		if minimum == 0:
			break
		deck_select = deck[:n]
		for hand_select in itertools.combinations(hand, (5 - n)):
			m = priority(deck_select + list(hand_select))
			if m < minimum:
				minimum = m
				break
	print(output[minimum])

def main():
	for line in sys.stdin:
		process(line)

if __name__ == '__main__':
	main()

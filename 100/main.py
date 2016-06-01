import sys

cycle_length = {}

def get_cycle_length(n):
	length = 1
	numbers = {}
	while n != 1:
		if n in cycle_length:
			length = length + cycle_length[n] - 1
			break
		numbers[n] = length
		n = (n / 2) if (n % 2) == 0 else (3 * n + 1)
		length += 1
	for i in numbers:
		cycle_length[i] = length + 1 - numbers[i]
	return length

def process(line):
	a, b = [int(n) for n in line.split()]
	start, end = (a, b + 1) if a < b else (b, a + 1)
	print(a, b, max([get_cycle_length(n) for n in range(start, end)]))

def main():
	for line in sys.stdin:
		process(line)

if __name__ == '__main__':
	main()

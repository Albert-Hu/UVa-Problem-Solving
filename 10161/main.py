import sys
import math

def main():
	for step in sys.stdin:
		step = int(step)
		if step == 0:
			break
		sqrt = int(math.sqrt(step))
		if (sqrt ** 2) != step:
			sqrt += 1
		m = (sqrt ** 2) - (sqrt - 1)
		if (sqrt % 2) == 0:
			if step > m:
				print(str(sqrt), str(sqrt - (step - m)))
			else:
				print(str(sqrt - (m - step)), str(sqrt))
		else:
			if step > m:
				print(str(sqrt - (step - m)), str(sqrt))
			else:
				print(str(sqrt), str(sqrt - (m - step)))

if __name__ == '__main__':
	main()


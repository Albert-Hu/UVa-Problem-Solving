from itertools import permutations

def main():
	n = int(input())
	for x in range(0, n):
		string = input()
		for p in sorted(set(permutations(string))):
			print ("".join(p))
		print()

if __name__ == "__main__":
	main()
from sys import stdin

def main():
	case = 1
	while True:
		n, m = map(lambda x: int(x), stdin.readline().split())
		if n == 0:
			break
		names = []
		distance = [[1000 for j in range(n)] for i in range(n)]
		for x in range(n):
			distance[x][x] = 0
		for x in range(n):
			names.append(stdin.readline().strip())
		for x in range(m):
			i, j, k = map(lambda x: int(x), stdin.readline().split())
			i -= 1
			j -= 1
			distance[i][j] = distance[j][i] = k
		for k in range(n):
			for i in range(n):
				for j in range(n):
					if distance[i][j] > (distance[i][k] + distance[k][j]):
						distance[i][j] = distance[i][k] + distance[k][j]
		min = 100000
		name = names[0]
		for i in range(n):
			s = sum(distance[i])
			if s < min:
				min = s
				name = names[i]
		print("Case #%d : %s" % (case, name))
		case += 1

if __name__ == '__main__':
	main()

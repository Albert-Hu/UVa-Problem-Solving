def LCS(seq1, seq2, equal):
   s1 = range(0, len(seq1)+1)
   s2 = range(0, len(seq2)+1)
   score = [[0 for s in s2] for s in s1]
   prev = [[0 for s in s2] for s in s1]
   for i in s1[:-1]:
      for j in s2[:-1]:
         if equal(seq1[i], seq2[j]):
            score[i+1][j+1] = score[i][j] + 1
         else:
            if score[i][j+1] > score[i+1][j]:
               score[i+1][j+1] = score[i][j+1]
               prev[i+1][j+1] = 1
            else:
               score[i+1][j+1] = score[i+1][j]
               prev[i+1][j+1] = -1
   seq = [None for s in range(0, score[-1][-1])]
   i = len(seq1)
   j = len(seq2)
   while i != 0 and j != 0:
      if prev[i][j] == 0:
         seq[score[i][j]-1] = seq1[i-1]
         i -= 1
         j -= 1
      elif prev[i][j] == 1:
         i -= 1
      else:
         j -= 1

   return seq

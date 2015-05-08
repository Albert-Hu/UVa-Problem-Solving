#!/usr/bin/python
from lcs import LCS

a = [3, 1, 2, 4, 9, 5, 10, 6, 8, 7]
b = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
c = [4, 7, 2, 3, 10, 6, 9, 1, 5, 8]
d = [3, 1, 2, 4, 9, 5, 10, 6, 8, 7]
e = [2, 10, 1, 3, 8, 4, 9, 5, 7, 6]

print LCS(a, b, lambda x, y: x == y)
print LCS(a, c, lambda x, y: x == y)
print LCS(a, d, lambda x, y: x == y)
print LCS(a, e, lambda x, y: x == y)

str1 = """
die einkommen der landwirte
sind fuer die abgeordneten ein buch mit sieben siegeln
um dem abzuhelfen
muessen dringend alle subventionsgesetze verbessert werden
"""

str2 = """
die steuern auf vermoegen und einkommen
sollten nach meinung der abgeordneten
nachdruecklich erhoben werden
dazu muessen die kontrollbefugnisse der finanzbehoerden
dringend verbessert werden
"""

print LCS(str1.split(), str2.split(), lambda s1, s2: s1 == s2)

point1 = [{'x':0,'y':0},{'x':1,'y':1},{'x':2,'y':2},{'x':3,'y':3},{'x':4,'y':4}]
point2 = [{'x':3,'y':3},{'x':2,'y':2},{'x':6,'y':3},{'x':4,'y':4}]

print LCS(point1, point2, lambda a, b: a['x'] == b['x'] and a['y'] == b['y'])

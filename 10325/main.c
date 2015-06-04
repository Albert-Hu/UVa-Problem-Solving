#include <stdio.h>

long long int least_common_multiple(int a, int b)
{
   int max, min, tmp;
   if (a < b) {
      max = b;
      min = a;
   } else {
      max = a;
      min = b;
   }
   while ((max % min) != 0) {
      tmp = min;
      min = max % min;
      max = tmp;
   }
   return ((long long int)a * b) / min;
}

int lottery_count(int n, int lcm, int* m, int len, char reduce)
{
   int i, count = 0;
   long long int tmp;

   for (i = 0; i < len; i++) {
      tmp = least_common_multiple(lcm, m[i]);

      if (tmp > n) continue;

      count += (reduce == 1) ? -(n / tmp) : (n / tmp);
      if ((len - 1 - i) > 0)
         count += lottery_count(n, tmp, &m[i+1], (len-1-i), !reduce);
   }

   return  count;
}

int main(int argc, char* argv[])
{
   int n, m, i;
   int num, m_length;
   int number[15];

   while (scanf("%d%d", &n, &m) == 2) {
      m_length = 0;
      while (m-- > 0) {
         scanf("%d", &num);
         for (i = 0; i < m_length; i++) {
            if (num % number[i] == 0) {
               break;
            }
            if (number[i] % num == 0) {
               number[i] = num;
               break;
            }
         }
         if (i == m_length) {
            number[m_length] = num;
            ++m_length;
         }
      }
      printf("%d\n", n - lottery_count(n, 1, number, m_length, 0));
   }

   return 0;
}

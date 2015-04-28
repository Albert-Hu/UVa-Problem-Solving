#include <stdio.h>
#include <stdlib.h>

#include "lcs.h"

struct POINT {
   int x;
   int y;
};

int struct_compare(void* a, void* b)
{
   struct POINT* p1 = (struct POINT*) a;
   struct POINT* p2 = (struct POINT*) b;

   return ((p1->x == p2->x) && (p1->y == p2->y)) ? 0 : -1;
}

void test3()
{
   int i, len;
   int array_len1 = 6;
   int array_len2 = 9;
   struct POINT* ptr;
   struct POINT array1[6] = {
      {2, 5}, {1, 0}, {3, 3},
      {5, 2}, {10, 20}, {0, 0}};
   struct POINT array2[9] = {
      {2, 5}, {3, 3}, {1, 0},
      {3, 0}, {7, 6}, {7, 7},
      {0, 0}, {2, 4}, {10, 20}};
   struct SEQUENCE* seq1;
   struct SEQUENCE* seq2;
   struct LCS* lcs;

   seq1 = sequence_new(array1, sizeof(struct POINT), array_len1);
   seq2 = sequence_new(array2, sizeof(struct POINT), array_len2);

   lcs = lcs_find(seq1, seq2, struct_compare);

   len = lcs_length(lcs);
   printf("length: %d\n", len);
   for (i = 0; i < len; i++) {
      ptr = (struct POINT*) lcs_element_at(lcs, i);
      printf("%s(%d,%d)", (i > 0)?", ":"", ptr->x, ptr->y);
   }
   printf("\n\n");

   lcs_destroy(lcs);
   sequence_destroy(seq1);
   sequence_destroy(seq2);
}

int int_compare(void* a, void* b)
{
   return (*((int*) a) == *((int*) b)) ? 0 : -1;
}

void test2()
{
   int* ptr;
   int i, len;
   int array_len1 = 7;
   int array_len2 = 10;
   int array1[7] = {
      1, 3, 2, 5, 6,
      9, 2};
   int array2[10] = {
      1, 2, 3, 4, 5,
      6, 7, 8, 9, 0};
   struct SEQUENCE* seq1;
   struct SEQUENCE* seq2;
   struct LCS* lcs;

   seq1 = sequence_new(array1, sizeof(int), array_len1);
   seq2 = sequence_new(array2, sizeof(int), array_len2);

   lcs = lcs_find(seq1, seq2, int_compare);

   len = lcs_length(lcs);
   printf("length: %d\n", len);
   for (i = 0; i < len; i++) {
      ptr = (int*) lcs_element_at(lcs, i);
      printf("%s%d", (i > 0)?", ":"", *ptr);
   }
   printf("\n\n");

   lcs_destroy(lcs);
   sequence_destroy(seq1);
   sequence_destroy(seq2);
}

int char_compare(void* a, void* b)
{
   return (*((char*) a) == *((char*) b)) ? 0 : -1;
}

void test1()
{
   int i, len;
   int array_len1 = 10;
   int array_len2 = 6;
   char* ptr;
   char array1[10] = {
      'a','b','c','d','e',
      '1','2','3','4','5'};
   char array2[6] = {
      'a','1','2','b','c',
      'e'};
   struct SEQUENCE* seq1;
   struct SEQUENCE* seq2;
   struct LCS* lcs;

   seq1 = sequence_new(array1, sizeof(char), array_len1);
   seq2 = sequence_new(array2, sizeof(char), array_len2);

   lcs = lcs_find(seq1, seq2, char_compare);

   len = lcs_length(lcs);
   printf("length: %d\n", len);
   for (i = 0; i < len; i++) {
      ptr = (char*) lcs_element_at(lcs, i);
      printf("%s'%c'", (i > 0)?", ":"", *ptr);
   }
   printf("\n\n");

   lcs_destroy(lcs);
   sequence_destroy(seq1);
   sequence_destroy(seq2);
}

int main(int argc, char* argv[])
{
   test1();
   test2();
   test3();
   return 0;
}
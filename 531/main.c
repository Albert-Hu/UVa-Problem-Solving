#include <stdio.h>
#include <memory.h>

struct LCS_UINT {
   int length;
   char* word;
   struct LCS_UINT* previous;
};

int word_split(char* text, char** word_array)
{
   int total = 0;
   int next_word = 1;

   while (*text != '\0') {
      if (next_word) {
         *(word_array + total) = text;
         next_word = 0;
         ++total;
      }
      if (*text == ' ') {
         *text = '\0';
         if (*(text + 1) != ' ')
            next_word = 1;
      }
      ++text;
   }

   *(word_array + total) = NULL;

   return total;
}

int text_read(char* text)
{
   char c;
   int length = 0;

   while ((c = getchar()) != '#') {
      if (c == EOF) return -1;

      if (c == '\n') {
         c = ' ';
      }

      *(text + length) = c;
      ++length;
   }
   getchar();
   *(text + length) = '\0';

   return length;
}

void lcs_uint_print(struct LCS_UINT* unit)
{
   if (unit == NULL)
      return;

   lcs_uint_print(unit->previous);

   if (unit->word) {
      printf("%s%s", (unit->length == 1) ? "" : " " ,unit->word);
   }
}

int main(int argc, char* argv[])
{
   int i, j;
   char texts[2][3101];
   char* words[2][100];
   struct LCS_UINT table[101][101];

   memset(table, 0, sizeof(table));

   while (text_read(texts[0]) >= 0) {
      text_read(texts[1]);
      word_split(texts[0], words[0]);
      word_split(texts[1], words[1]);

      i = 0;
      while (words[0][i] != NULL) {
         j = 0;
         while (words[1][j] != NULL) {
            if (strcmp(words[0][i], words[1][j]) == 0) {
               table[i+1][j+1].length = table[i][j].length + 1;
               table[i+1][j+1].previous = &table[i][j];
               table[i+1][j+1].word = words[0][i];
            } else {
               if (table[i][j+1].length > table[i+1][j].length) {
                  table[i+1][j+1].length = table[i][j+1].length;
                  table[i+1][j+1].previous = &table[i][j+1];
               } else {
                  table[i+1][j+1].length = table[i+1][j].length;
                  table[i+1][j+1].previous = &table[i+1][j];
               }
               table[i+1][j+1].word = NULL;
            }
            ++j;
         }
         ++i;
      }

      lcs_uint_print(&table[i][j]);
      printf("\n");
   }

   return 0;
}

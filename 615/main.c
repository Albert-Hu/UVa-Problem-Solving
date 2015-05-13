#include <stdio.h>
#include <stdlib.h>
#include <memory.h>

struct NODE {
   int value;
   struct NODE* parent;
   struct NODE* next;
};

void node_insert(struct NODE** list, struct NODE* node)
{
   while (*list != NULL) {
      list = &((*list)->next);
   }
   *list = node;
}

struct NODE* node_find(struct NODE* list, int value)
{
   while (list != NULL) {
      if (list->value == value)
         return list;
      list = list->next;
   }
   return NULL;
}

struct NODE* node_new(int value)
{
   struct NODE* node = (struct NODE*) malloc(sizeof(struct NODE));
   node->next = node->parent = NULL;
   node->value = value;
   return node;
}

void node_clean(struct NODE* list)
{
   struct NODE* node;

   while (list != NULL) {
      node = list;
      list = list->next;
      free(node);
   }
}

int node_in_loop(struct NODE* parent, struct NODE* child)
{
   while (parent != NULL) {
      if (child == parent)
         return 1;
      parent = parent->parent;
   }
   return 0;
}

int node_root_number(struct NODE* list)
{
   int count = 0;
   while (list != NULL) {
      if (list->parent == NULL)
         ++count;
      list = list->next;
   }
   return count;
}

int main(int argc, char* argv[])
{
   int root, leaf, tree;
   int is_tree = 1;
   int test_case = 1;
   struct NODE* list = NULL;
   struct NODE* parent = NULL;
   struct NODE* child = NULL;;

   while (scanf("%d %d", &root, &leaf) == 2) {
      if (root > 0 && leaf > 0) {
         if (!is_tree) continue;

         parent = node_find(list, root);
         if (parent == NULL) {
            parent = node_new(root);
            node_insert(&list, parent);
         }
         child = node_find(list, leaf);
         if (child == NULL) {
            child = node_new(leaf);
            node_insert(&list, child);
         }
         if (node_in_loop(parent, child) || child->parent != NULL) {
            is_tree = 0;
         } else {
            child->parent = parent;
         }
      } else if (root == 0 && leaf == 0) {
         tree = node_root_number(list);
         printf("Case %d is%sa tree.\n",
            test_case,
            (is_tree == 1 && tree < 2) ? " " : " not ");
         ++test_case;
         node_clean(list);
         list = NULL;
         is_tree = 1;
      }
   }

   return 0;
}

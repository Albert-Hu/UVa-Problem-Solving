#ifndef _LCS_H_
#define _LCS_H_

struct LCS;
struct SEQUENCE;

typedef int (*fn_compare)(void* a, void* b);

struct SEQUENCE* sequence_new(void* array, int size, int length);

void sequence_destroy(struct SEQUENCE* seq);

struct LCS* lcs_find(struct SEQUENCE* a, struct SEQUENCE* b, fn_compare compare);

void* lcs_element_at(struct LCS* lcs, int index);

int lcs_length(struct LCS* lcs);

void lcs_destroy(struct LCS* lcs);

#endif /* _LCS_H_ */

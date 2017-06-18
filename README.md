# FitchAlgorithm

Inputs:

1. Hash table: that will map species name with its corresponding
sequence (species name as the key)

2. Substring of the species tree in that stage. e.g.:
((((((((KM034557v1,KC242796v1),FJ217162v1),KC545394v1),EU338380v1),JX477
165v1),NC_004161v1),NC_024781v1),NC_001608v3)

Output:

Stack of ancestral sequence
(This can be changed to root node of ancestral tree, but I thought this is more user friendly because a stack of ancestral sequence will remove the concern of the tree structure for the end-users. Just use the stack to get the ancestral sequences in-order)

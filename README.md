# 1. Top-n email domains

HashMap "Big O" notation
1. Insertion O(1)
2. Sorting domains is O(n log n) 

TreeMap "Big O" notation
1. Insertion O(log n)
2. We don't need to sort

# 2. Auto parts compatibility

Model:

1. Single-table data storage (tree-like structure):
- partId: ID
- name: Name of the part
- serialNumber: Serial number
- manufacturer: Manufacturer
- weight: Weight
- compatiblePartId refers to the partId

2. Different tables:

Table 'Parts':
- partId: ID
- name: Name of the part
- serialNumber: Serial number
- manufacturer: Manufacturer
- weight: Weight

Table 'Compatibilities' (many-to-many):
- partId
- compatiblePartId

Managing Scale:
 Sharding
 Vertically scaling
 Indexing key fields like partId, compatiblePartId
 Caching

Frequent Additions/Deletions:
Many-to-many relationship plus sharding should support high write throughput, also millions of records.


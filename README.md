# Binary_Compression
A Java program which compresses a given stream of binary data (string of 1s and  0s) and decompresses the stream that was compressed using this compression technique.  

Unique Limitaion:

1. This technique is effective when the data stream is mainly composed of zeros as it replaces the run of zeros with the number of 
existing zeros. 

2. The program must also follow the restriction such as the following: no more than 
two consecutive 1’s in a string, leading 0’s in a given string of 1’s and 0’s, and an encoding limit 
to a value less than 15.

Background Knowledge: 

Compression is a technique used to reduce the size of the original data for the amount of data 
that needs to be stored or transmitted. There are two types of compression according to Khan 
Academy. Lossless compression algorithms reduce the size of files without losing any 
information in the file, which means that we can reconstruct the original data from the 
compressed file. Further, lossy compression algorithms reduce the size of files by discarding the 
less important information in a file, which can significantly reduce file size but also affect file 
quality. Each compression consists of different methods

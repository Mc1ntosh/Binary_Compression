# Binary_Compression
A Java program which compresses a given stream of binary data (string of 1s and  0s) and decompresses the stream that was compressed using this compression technique. This technique is effective when the data stream is mainly composed of zeros as it replaces the run of zeros with the number of existing zeros. 

**Unique Limitaion:

The program must also follow the restriction such as the following: no more than 
two consecutive 1’s in a string, leading 0’s in a given string of 1’s and 0’s, and an encoding limit 
to a value less than 15.

**Background Knowledge: 

Compression is a technique used to reduce the size of the original data for the amount of data 
that needs to be stored or transmitted. There are two types of compression according to Khan 
Academy. Lossless compression algorithms reduce the size of files without losing any 
information in the file, which means that we can reconstruct the original data from the 
compressed file. Further, lossy compression algorithms reduce the size of files by discarding the 
less important information in a file, which can significantly reduce file size but also affect file 
quality. Each compression consists of different methods


**TEST THE DATA BY USING THE FOLLOWING INPUT: 

Compressing functionality
a)	Input => 1110001010110
Expected output => The string needs to begin with a 0
b)	Input => 00110111000
Expected Output => There should not be an instance of more than 2 consecutive 1's
c)	Input => 001100000000000000001100
Expected Output => There should not be an instance of more than 15 consecutive 0's
d)	Input => 00110000000000000001100
Expected Output => 
The entered line is: 
00110000000000000001100
Compressed line: 
00100000111100000010

Decompressing functionality
e)	Input => 
1100000010101101000010010000110000000111

Expected output =>
Compressed string: 
1100000010101101000010010000110000000111

Decompressed initial string: 
000000000000110000000000100000000000001100000000011000000000000110000000


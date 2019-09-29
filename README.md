Basic Chess Game

Author: Denali Webber

Date Completed: 5/2/2019

Description: This program reads an input .txt file, in this case, input.txt. Places specified chess piece on 8x8 board in the defined location. If the line begins with keyword 'move', the program tries to move the piece in that spot to the new given location. The program will either move the piece, or throw 1 of 3 possible errors: coordinates given are not on the board, that move is illegal for the piece in the original location, or there is a piece in the way. After all the input has been read, the program prints out the final chess board.

How to compile: javac ChessGame.java

How to run: java ChessGame

Running with input.txt, expected output:

PAWN: (7, 0) (7, 2)
Moved! (7, 0) (7, 2)
BISHOP: (2, 5) (5, 2)
Moved! (2, 5) (5, 2)
ROOK: (2, 6) (7, 6)
Moved! (2, 6) (7, 6)
KNIGHT: (0, 0) (2, 1)
Moved! (0, 0) (2, 1)
BISHOP: (7, 3) (3, 7)
That is an illegal chess move for that piece!
KNIGHT: (2, 1) (1, 3)
Moved! (2, 1) (1, 3)
KNIGHT: (1, 3) (2, 5)
Moved! (1, 3) (2, 5)
KNIGHT: (2, 5) (3, 4)
That is an illegal chess move for that piece!
ROOK: (7, 6) (8, 8)
Coordinates are not on the board!
=7= --- --- --- --- --- --- --- ---
=6= --- --- --- --- --- --- --- -r-
=5= --- --- -h- --- --- -p- --- ---
=4= --- --- --- --- --- --- --- ---
=3= --- --- --- --- --- --- --- -b-
=2= --- --- --- --- --- -b- --- -p-
=1= --- --- --- --- --- --- --- ---
=0= --- --- --- --- --- --- --- ---
=== =0= =1= =2= =3= =4= =5= =6= =7=

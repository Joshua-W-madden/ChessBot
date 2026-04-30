import numpy as np
import constants as c


class Board:  

    def __init__(self):
        self.position = np.array([0]*64, dtype='int')
        self.position = self.position.reshape(8,8)

        self.pos_translater("rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR")
    
    def avail_moves(self):
        # movement rules
        """
        king moves one square; in any direction 
            - when king and rook has not moved, no squares attacked or blocked in between 
             & not in check or put into check. can castle
                - king y +-2 towards rook 
                
    
        Queen moves like king; length till capturable piece or blocking piece
        Rook move y =1 or x=1; length till capturable piece or blocking piece
            - Castling: 
                - left rook pos(3,7)
                - right rook pos(5,7)
        Bishop move x = y, -x = y, x=-y, -x=-y;length till capturable piece or blocking piece
        Khignt move x+-2 y+-1, y+-2 x+-1; only empty and capturable positions allowed
        Pawn first move x+2 or x+1, all other movement x+1, captures x+1 y+-1; 
            - when reaches end of board upgrade to a different piece
        """

    def get_position(self):
        return self.position

    def pos_translater(self, positions):
        positions = positions.split('/')
        cols = 0
        for i in positions:
            rows = 0
            for char in i:
                if char.isdigit():
                    rows += int(char)
                elif char.isupper():
                    self.position[cols][rows] = c.format[char.lower()]+ c.White
                else:
                    self.position[cols][rows] = c.format[char]+ c.Black
                rows +=1
            cols +=1
            



    

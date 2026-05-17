import numpy as np
from constants import *
import moves as move


class Board:  

    def __init__(self):
        self.position = np.array([0]*64, dtype='int')
        self.position = self.position.reshape(8,8)
        self.selected = None
        self.legal_moves= []

        self.pos_translater("rnbqkbnr/pppppppp/3P4/8/8/8/PPP1PPPP/RNBQKBNR")
    
    def avail_moves(self,row,col):
        piece = self.position[row][col]

        piece_type = piece & 0b111

        match piece_type:
            case PAWN:
                return self.pawn_move(row, col)

        # movement rules
        """
        king moves one square; in any direction 
            - when king and rook has not moved, no squares attacked or blocked in between 
             & not in check or put into check. can castle
                - king y +-2 towards rook 
                
        """
        """
        Queen moves like king; length till capturable piece or blocking piece
        Rook move y =1 or x=1; length till capturable piece or blocking piece
            - Castling: 
                - left rook pos(3,7)
                - right rook pos(5,7)
        Bishop move x = y, -x = y, x=-y, -x=-y;length till capturable piece or blocking piece
        knignt move x+-2 y+-1, y+-2 x+-1; only empty and capturable positions allowed
        Pawn first move x+2 or x+1, all other movement x+1, captures x+1 y+-1; 
            - when reaches end of board upgrade to a different piece
        """    
    def pawn_move(self, row, col):
        moves = []
        piece = self.position[row][col]
        direction = -1 if piece & WHITE else 1
        if self.position[row + direction][col] == EMPTY:
            moves.append((row + direction, col))
        if (row == 6 and piece & WHITE) or (row == 1 and piece & WHITE):
            moves.append((row + (direction*2), col))
        
        for square in (-1,1):
            if self.position[row + direction][col + square] != EMPTY:
                if piece & 0b11000 != self.position[row + direction][col + square] & 0b11000:
                    moves.append((row + direction, col + square))

        return moves
        
    def get_position(self):
        return self.position

    def peiceChecker(self,x, y):
        return self.position[x][y]

    def pos_translater(self, positions):
        positions = positions.split('/')
        cols = 0
        for i in positions:
            rows = 0
            for char in i:
                if char.isdigit():
                    rows += int(char)
                elif char.isupper():
                    self.position[cols][rows] = PIECE_MAP[char.lower()]|WHITE
                    rows +=1
                else:
                    self.position[cols][rows] = PIECE_MAP[char]|BLACK
                    rows +=1
            cols +=1
            

    

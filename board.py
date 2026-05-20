import numpy as np
from constants import *



class Board:  

    def __init__(self):
        self.position = np.array([0]*64, dtype='int')
        self.position = self.position.reshape(8,8)
        self.selected = None

        self.pos_translater("rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR")
    
    def avail_moves(self,row,col):
        piece = self.position[row][col]

        piece_type = piece & 0b111
        if piece_type == PAWN:
            return self.pawn_move(row, col, piece, [])
        elif piece_type == ROOK:
            return self.rook_move(row, col, piece, [])
        else:
            return []
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
        Pawn 
            ✓ first move x+2 or x+1, all other movement x+1, captures x+1 y+-1; 
            - en pasent
            - when reaches end of board upgrade to a different piece
        """    
    def pawn_move(self, row, col, piece, moves):
        
        direction = -1 if piece & WHITE else 1

        if self.position[row + direction][col] == EMPTY:
            moves.append((row + direction, col))
        
        if (row == 6 and piece & WHITE) or (row == 1 and piece & BLACK):
            if self.position[row + direction][col] == EMPTY and self.position[row + (direction*2)][col] == EMPTY:
                moves.append((row + (direction*2), col))
        
        
        for square in (-1,1):
            eat_col = col + square
            eat_row = row + direction
            if 0 <= eat_row < 8 and 0<= eat_col < 8:
                enemy = self.position[eat_row][eat_col]
                if enemy != EMPTY:
                    if (piece & 0b11000) != (enemy & 0b11000):
                        moves.append((eat_row, eat_col))
            
        
        return moves
    
    def rook_move(self, row, col, piece, moves):
        directions = [(-1, 0), (1, 0), (0, -1), (0, 1)]

        for dr, dc in directions:
            r, c = row + dr, col + dc

            while 0 <= r < 8 and 0 <= c < 8:
                target = self.position[r][c]

                if target == EMPTY:
                    moves.append((r, c))

                else:
                    # Enemy piece -> capture allowed
                    if (target & 0b11000) != (piece & 0b11000):
                        moves.append((r, c))
                    break

                r += dr
                c += dc
        return moves
            

        
    def get_position(self):
        return self.position
    
    def updatePos(self,x,y):
        selected_col = self.selected[0] 
        selected_row = self.selected[1]
        self.position[x][y] = self.position[selected_col][selected_row]
        self.position[selected_col][selected_row] = EMPTY

    def pieceChecker(self,x, y):
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
            

    

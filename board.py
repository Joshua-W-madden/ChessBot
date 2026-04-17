import numpy as np
import constants as c


class Board: 

     
    def __init__(self):
        self.position = np.array([0]*64, dtype='int')
        self.position = self.position.reshape(8,8)
        self.position[0][0] = c.Rook + c.Black
        self.position[0][1] = c.Knight + c.Black
        self.position[0][2] = c.Bishop + c.Black
        self.position[0][3] = c.Queen + c.Black
        self.position[0][4] = c.King + c.Black
        self.position[0][5] = c.Bishop + c.Black
        self.position[0][6] = c.Knight + c.Black
        self.position[0][7] = c.Rook + c.Black

        for x in range(8):
            self.position[1][x] = c.Pawn + c.Black
        
        self.position[7][0] = c.Rook + c.White
        self.position[7][1] = c.Knight + c.White
        self.position[7][2] = c.Bishop + c.White
        self.position[7][3] = c.Queen + c.White
        self.position[7][4] = c.King + c.White
        self.position[7][5] = c.Bishop + c.White
        self.position[7][6] = c.Knight + c.White
        self.position[7][7] = c.Rook + c.White
        for x in range(8):
            self.position[6][x] = c.Pawn + c.White

    def get_position(self):
        return self.position

import numpy as np
import constants as c


class Board:  

    def __init__(self):
        self.position = np.array([0]*64, dtype='int')
        self.position = self.position.reshape(8,8)

        self.pos_translater("rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR")
        

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
            



    

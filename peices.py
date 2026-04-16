import pygame
import numpy as np

class peices:
    alive = True
    isBlack : bool
    
    empty = 0
    King = 1
    Pawn = 2
    Knight = 3
    Bishop = 4
    Rook = 5
    Queen = 6

    Black = 8
    White = 9
    def __init__(self):
        pass

class King(peices):
    def __init__(self, isBlack, position[x][y]):
        self.position[x][y] = 
        if isBlack:
            bKing = pygame.image.load("imgs\Peices\b_king_png_128px.png")
        else:
            wKing = pygame.image.load("imgs\Peices\w_king_png_128px.png")
        

class queen(peices):
    
       def __init__(self, isBlack):
        if isBlack:
            bKing = pygame.image.load("imgs\Peices\b_queen_png_128px.png")
        else:
            wKing = pygame.image.load("imgs\Peices\w_queen_png_128px.png")
class knight(peices):
    
    def __init__(self, isBlack):
        pass
class bishop(peices):
    
    def __init__(self, isBlack):
        pass

class pawn(peices):
    
    def __init__(self, isBlack):
        pass
class Rook(peices):
    
    def __init__(self, isBlack):
        pass

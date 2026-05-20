import pygame
import numpy as np
from constants import *

class pieces:
 

    def __init__(self,board, screen):
        self.screen = screen  
        self.board = board   

        self.images = {
        WHITE | KING: self.load_piece(r"imgs\Peices\w_king_png_128px.png"),
        WHITE | QUEEN: self.load_piece(r"imgs\Peices\w_queen_png_128px.png"),
        WHITE | ROOK: self.load_piece(r"imgs\Peices\w_rook_png_128px.png"),
        WHITE | BISHOP: self.load_piece(r"imgs\Peices\w_bishop_png_128px.png"),
        WHITE | KNIGHT: self.load_piece(r"imgs\Peices\w_knight_png_128px.png"),
        WHITE | PAWN: self.load_piece(r"imgs\Peices\w_pawn_png_128px.png"),

        BLACK | KING: self.load_piece(r"imgs\Peices\b_king_png_128px.png"),
        BLACK | QUEEN: self.load_piece(r"imgs\Peices\b_queen_png_128px.png"),
        BLACK | ROOK: self.load_piece(r"imgs\Peices\b_rook_png_128px.png"),
        BLACK | BISHOP: self.load_piece(r"imgs\Peices\b_bishop_png_128px.png"),
        BLACK | KNIGHT: self.load_piece(r"imgs\Peices\b_knight_png_128px.png"),
        BLACK | PAWN: self.load_piece(r"imgs\Peices\b_pawn_png_128px.png"),
        }
    
    def draw(self):
        positions = self.board.get_position()
        for x in range (8):
            for y in range (8):
                piece = positions[x][y]
                if piece != EMPTY:
                    self.screen.blit(self.images[piece],(y * 90 + 5, x * 90 + 5))

    def load_piece(self,path):
        return pygame.transform.scale(
            pygame.image.load(path).convert_alpha(),
            (80, 80)
        )
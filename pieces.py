import pygame
import numpy as np
import constants as c

class pieces:
 

    def __init__(self,board, screen):
        self.screen = screen  
        self.board = board    

        self.Bking = pygame.image.load(r"imgs\Peices\b_king_png_128px.png").convert_alpha()
        self.Wking = pygame.image.load(r"imgs\Peices\w_king_png_128px.png").convert_alpha()
        
        self.Bqueen = pygame.image.load(r"imgs\Peices\b_queen_png_128px.png").convert_alpha()
        self.Wqueen = pygame.image.load(r"imgs\Peices\w_queen_png_128px.png").convert_alpha()

        self.Bbishop = pygame.image.load(r"imgs\Peices\b_bishop_png_128px.png").convert_alpha()
        self.Wbishop = pygame.image.load(r"imgs\Peices\w_bishop_png_128px.png").convert_alpha()

        self.Bkhight = pygame.image.load(r"imgs\Peices\b_knight_png_128px.png").convert_alpha()
        self.Wkhight = pygame.image.load(r"imgs\Peices\w_knight_png_128px.png").convert_alpha()

        self.Brook = pygame.image.load(r"imgs\Peices\b_rook_png_128px.png").convert_alpha()
        self.Wrook = pygame.image.load(r"imgs\Peices\w_rook_png_128px.png").convert_alpha()

        self.Bpawn = pygame.image.load(r"imgs\Peices\b_pawn_png_128px.png").convert_alpha()
        self.Wpawn = pygame.image.load(r"imgs\Peices\w_pawn_png_128px.png").convert_alpha()
    
    def draw(self):
        positions = self.board.get_position()
        for x in range (8):
            for y in range (8):
                if positions[x][y] == 0:
                    pass
                else:
                    piece = positions[x][y] %10
                    color = c.Black if positions[x][y] // 10 == 1 else c.White

                    match piece: #based on costants piece value
                        case 1:
                            self.king(color,x,y)
                        case 2:
                            self.pawn(color,x,y)
                        case 3:
                            self.knight(color,x,y)
                        case 4:
                            self.bishop(color,x,y)
                        case 5:
                            self.rook(color,x,y)
                        case 6:
                            self.queen(color,x,y)
    
    def king(self, color, x,y):
        if color == c.Black:
            scaled = pygame.transform.scale(self.Bking, (80, 80))
            self.screen.blit(scaled, (y * 91, ((x * 90)+5)+5))
        else:
            scaled = pygame.transform.scale(self.Wking, (80, 80))
            self.screen.blit(scaled, (y * 91, (x * 90)+5)) 
    
    def queen(self, color, x,y):
        if color == c.Black:
            scaled = pygame.transform.scale(self.Bqueen, (80, 80))
            self.screen.blit(scaled, (y * 91, (x * 90)+5))
        else:
            scaled = pygame.transform.scale(self.Wqueen, (80, 80))
            self.screen.blit(scaled, (y * 91, (x * 90)+5)) 
    
    def rook(self, color, x,y):
        if color == c.Black:
            scaled = pygame.transform.scale(self.Brook, (80, 80))
            self.screen.blit(scaled, (y * 91, (x * 90)+5))
        else:
            scaled = pygame.transform.scale(self.Wrook, (80, 80))
            self.screen.blit(scaled, (y * 91, (x * 90)+5)) 
    
    def bishop(self, color, x,y):
        if color == c.Black:
            scaled = pygame.transform.scale(self.Bbishop, (80, 80))
            self.screen.blit(scaled, (y * 91, (x * 90)+5))
        else:
            scaled = pygame.transform.scale(self.Wbishop, (80, 80))
            self.screen.blit(scaled, (y * 91, (x * 90)+5)) 
    
    def pawn(self, color, x,y):
        if color == c.Black:
            scaled = pygame.transform.scale(self.Bpawn, (80, 80))
            self.screen.blit(scaled, (y * 91, (x * 90)+5))
        else:
            scaled = pygame.transform.scale(self.Wpawn, (80, 80))
            self.screen.blit(scaled, (y * 91, (x * 90)+5)) 
    
    def knight(self, color, x,y):
        if color == c.Black:
            scaled = pygame.transform.scale(self.Bkhight, (80, 80))
            self.screen.blit(scaled, (y * 91, (x * 90)+5))
        else:
            scaled = pygame.transform.scale(self.Wkhight, (80, 80))
            self.screen.blit(scaled, (y * 91, (x * 90)+5)) 
      
      
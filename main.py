import pygame
from pygame.locals import *
import boardGraphics as bg
import pieces as p
import board as b 
from constants import BLACK,WHITE

pygame.init()
tile = 90
screen = pygame.display.set_mode((tile * 10, tile * 8))
clock = pygame.time.Clock()
running = True
boardGraphics = bg.board(screen)
boardGraphics.draw()
boardData = b.Board()
pieces = p.pieces(boardData,screen)
clickLoc = 0
side = WHITE

def selectPiece(pos):
    y = pos[0]//tile
    x = pos[1]//tile
    if x <= 7 and y <= 7:
        print("Position:", x, " ,", y)
        if boardData.peiceChecker(x,y) != 0:
            print(boardData.avail_moves(x,y))
            
             
    else:    
        pass
            
def moved():
    global side
    side = BLACK if side == WHITE else WHITE
while running:
    for event in pygame.event.get():
        if event.type == pygame.QUIT:
            running = False
        elif event.type == MOUSEBUTTONDOWN:
            if event.button == 1:
                clickLoc = event.pos
                selectPiece(clickLoc)

    
    boardGraphics.draw()
    pieces.draw()
    pygame.display.flip()
    clock.tick(60)

pygame.quit()
 


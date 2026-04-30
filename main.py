import pygame
from pygame.locals import *
import boardGraphics as bg
import pieces as p
import board as b 

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

def movePiece(pos):
    x = pos[0]
    y = pos[1]
    if x <= tile*8 and y <= tile*8:
        print("Position: ", x//tile, " , ", y//tile)
    else:    
        pass
            

while running:
    for event in pygame.event.get():
        if event.type == pygame.QUIT:
            running = False
        elif event.type == MOUSEBUTTONDOWN:
            if event.button == 1:
                clickLoc = event.pos
                movePiece(clickLoc)

    
    boardGraphics.draw()
    pieces.draw()
    pygame.display.flip()
    clock.tick(60)

pygame.quit()
 


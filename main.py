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
    for i in pos:
        if i <= tile*8:
            pass
        else:
            print("hi")
    """
    if x <= tile*8 | y<= tile*8:
        pass
    else:
        if boardData.position[(x//tile)][y//tile] == 0:
            pass
        else:
            print(boardData.position)
            """

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


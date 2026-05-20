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
boardGraphics = bg.boardGraphics(screen)
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
        if (x,y) in boardGraphics.moveList:
            movePiece(x,y)
        elif boardData.pieceChecker(x,y) != 0:
            moves = boardData.avail_moves(x,y)
            print(moves)
            boardGraphics.moveList = moves
            boardData.selected = [x,y]
        else:
            boardGraphics.moveList = []
            
            
def movePiece(x,y):
    print("moving piece to: ", x,y)
    boardData.updatePos(x,y)
    boardGraphics.moveList = []
    print(boardData.selected)
    print(boardData.position)
    
            
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
    boardGraphics.avail_moves_Draw()
    pygame.display.flip()
    clock.tick(60)

pygame.quit()
 


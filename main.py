import pygame
import boardGraphics as bg
import pieces as p
import board as b 

pygame.init()
screen = pygame.display.set_mode((90 * 10, 90 * 8))
clock = pygame.time.Clock()
running = True
boardGraphics = bg.board(screen)
boardGraphics.draw()
boardData = b.Board()
pieces = p.pieces(boardData,screen)

while running:
    for event in pygame.event.get():
        if event.type == pygame.QUIT:
            running = False
    
    boardGraphics.draw()
    pieces.draw()
    pygame.display.flip()
    clock.tick(60)

pygame.quit()
import pygame
import boardGraphics as bg
import peices as p
import numpy as np

pygame.init()

screen = pygame.display.set_mode((90 * 10, 90 * 8))
clock = pygame.time.Clock()
running = True
board = bg.board(screen)
board.draw()
piece = p.peices()
pieces = []
while running:
    for event in pygame.event.get():
        if event.type == pygame.QUIT:
            running = False
    
      
    pygame.display.flip()
    clock.tick(60)

pygame.quit()
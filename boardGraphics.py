import pygame

class board:
    def __init__(self, screen): 
        self.screen = screen
        self.grave = pygame.image.load(r"imgs\tile\grave.png").convert()
        self.dark_tile = pygame.image.load(r"imgs\tile\square_dark_png_128px.png").convert()
        self.light_tile = pygame.image.load(r"imgs\tile\square_light_png_128px.png").convert()
        self.draw()
        self.graveDraw()

    def draw(self):
        tile_size = 90
        for col in range(8):
            for row in range(8):
                isLightSquare = (col + row) % 2 == 0
                tile = self.light_tile if isLightSquare else self.dark_tile
                scaled = pygame.transform.scale(tile, (tile_size, tile_size))
                self.screen.blit(scaled, (col * tile_size, row * tile_size))

    def graveDraw(self):
        tile_size = 90
        scaled = pygame.transform.scale(self.grave, (tile_size * 2, tile_size * 8))
        self.screen.blit(scaled, (tile_size * 8, 0))

    
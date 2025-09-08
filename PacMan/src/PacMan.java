import java.awt.*;
import java.util.HashSet;
import javax.swing.*; 


public class PacMan extends JPanel {

    class Block {
        int x; 
        int y; 
        int width; 
        int height; 
        Image image; 

        int startX; 
        int startY; 

        Block(Image image, int x, int y, int width, int height) {
            this.image = image; 
            this.x = x; 
            this.y = y; 
            this.width = width; 
            this.height = height; 

            this.startX = x; 
            this.startY = y; 
        }

    }

    private final int rowCount = 21; 
    private final int columnCount = 19;
    private final int tileSize = 32; 
    private final int boardWidth = columnCount * tileSize;
    private final int boardHeight = rowCount * tileSize;

    // create memory variables to store the images.
    private Image wallImage;
    private Image blueGhostImage; 
    private Image orangeGhostImage; 
    private Image pinkGhostImage; 
    private Image redGhostImage; 

    //pacman set up images
    private Image pacmanUpImage; 
    private Image pacmanDownImage; 
    private Image pacmanLeftImage; 
    private Image pacmanRightImage; 

    //X = wall, O = skip, P = pac man, ' ' = food
    //Ghosts: b = blue, o = orange, p = pink, r = red
    private String[] tileMap = {
        "XXXXXXXXXXXXXXXXXXX",
        "X        X        X",
        "X XX XXX X XXX XX X",
        "X                 X",
        "X XX X XXXXX X XX X",
        "X    X       X    X",
        "XXXX XXXX XXXX XXXX",
        "OOOX X       X XOOO",
        "XXXX X XXrXX X XXXX",
        "O       bpo       O",
        "XXXX X XXXXX X XXXX",
        "OOOX X       X XOOO",
        "XXXX X XXXXX X XXXX",
        "X        X        X",
        "X XX XXX X XXX XX X",
        "X  X     P     X  X",
        "XX X X XXXXX X X XX",
        "X    X   X   X    X",
        "X XXXXXX X XXXXXX X",
        "X                 X",
        "XXXXXXXXXXXXXXXXXXX" 
    };

    HashSet <Block> walls; 
    HashSet <Block> foods; 
    HashSet <Block> ghosts;

    Block pacman; 

    PacMan() {
        setPreferredSize(new Dimension(boardWidth, boardHeight));
        setBackground(Color.black);

        //load images
        wallImage = new ImageIcon(getClass().getResource("./imgs/wall.png")).getImage();
        blueGhostImage = new ImageIcon(getClass().getResource("./imgs/blueGhost.png")).getImage();
        orangeGhostImage = new ImageIcon(getClass().getResource("./imgs/orangeGhost.png")).getImage();
        pinkGhostImage = new ImageIcon(getClass().getResource("./imgs/pinkGhost.png")).getImage();
        redGhostImage = new ImageIcon(getClass().getResource("./imgs/redGhost.png")).getImage();

        pacmanUpImage = new ImageIcon(getClass().getResource("./imgs/pacmanUp.png")).getImage();
        pacmanDownImage = new ImageIcon(getClass().getResource("./imgs/pacmanDown.png")).getImage();
        pacmanLeftImage = new ImageIcon(getClass().getResource("./imgs/pacmanLeft.png")).getImage();
        pacmanRightImage = new ImageIcon(getClass().getResource("./imgs/pacmanRight.png")).getImage();

        loadMap();
        System.out.println(walls.size());
        System.out.println(foods.size());
        System.out.println(ghosts.size());
    }

    public void loadMap() {
        walls = new HashSet<Block>();
        foods = new HashSet<Block>(); 
        ghosts = new HashSet<Block>();

        for(int r = 0; r < rowCount; r++) {
            for(int c = 0; c < columnCount; c++) {
                String row = tileMap[r];
                char tileMapChar = row.charAt(c); 

                int x = c * tileSize; //how many tiles from the left
                int y = r * tileSize; //how many tiles from the top

                if (tileMapChar == 'X') {
                    Block wall = new Block (wallImage, x, y, tileSize, tileSize);
                    walls.add(wall);
                }

                else if (tileMapChar == 'b') { //blue ghost
                    Block ghost = new Block(blueGhostImage, x, y, tileSize, tileSize);
                    ghosts.add(ghost);
                }
                else if (tileMapChar == 'o') { //orange ghost
                    Block ghost = new Block(orangeGhostImage, x, y, tileSize, tileSize);
                    ghosts.add(ghost);
                }
                else if (tileMapChar == 'p') { //pink ghost
                    Block ghost = new Block(pinkGhostImage, x, y, tileSize, tileSize);
                    ghosts.add(ghost);
                }
                else if (tileMapChar == 'r') { //red ghost
                    Block ghost = new Block(redGhostImage, x, y, tileSize, tileSize);
                    ghosts.add(ghost);
                }
                else if (tileMapChar == 'P') {
                    pacman = new Block(pacmanRightImage, x, y, tileSize, tileSize); 
                }
                else if (tileMapChar == ' ') {
                    Block food = new Block(null, x + 14, y + 14, 4, 4); 
                    foods.add(food);
                }
            }
        }
    }

}

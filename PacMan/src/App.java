import javax.swing.JFrame; 

public class App {
    public static void main(String[] args) throws Exception {
        int rowCount = 21; 
        int columnCount = 19;
        int tileSize = 32; 
        int boardWidth = columnCount * tileSize;
        int boardHeight = rowCount * tileSize;

        JFrame frame = new JFrame("Pacman Game");
        // frame.setVisible(true);
        frame.setLocationRelativeTo(null);

        //SET FRAME SIZE
        frame.setSize(boardWidth, boardHeight);
        //disable player from resizing the window
        frame.setResizable(false); 
        //terminate if x pressed 
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 

        PacMan game = new PacMan();
        frame.add(game); 
        frame.pack(); 
        frame.setVisible(true);
    }
}

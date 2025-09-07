

public class App {
    public static void main(String[] args) throws Exception {
        int rowCount = 21; 
        int columnCount = 19;
        int tileSize = 32; 
        int boardWidth = columnCount * tileSize;
        int boardHeight = rowCount * tileSize;

        JFrame frame = new JFrame("Pacman Game");
        frame.setvisible(true);
        frame.setLocationRelateiveTo(null);
        //disable player from resizing the window
        frame.setResizable(false); 
        
    }
}

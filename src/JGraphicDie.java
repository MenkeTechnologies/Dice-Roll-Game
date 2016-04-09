import javax.swing.*;
import java.awt.*;

/**
 * Created by jacobmenke on 4/8/16.
 */
public class JGraphicDie extends JPanel{

    GraphicDie newDie = new GraphicDie();

    public void paintComponent(Graphics g) {
        int width = getWidth();
        int height = getHeight();

       newDie.drawDie(g,0,height/2);

    }
}

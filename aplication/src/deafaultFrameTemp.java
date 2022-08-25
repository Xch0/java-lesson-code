import java.awt.*;
import javax.swing.*;

public class deafaultFrameTemp extends JFrame{
	public deafaultFrameTemp() {
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension screenSize = kit.getScreenSize();
		int screenH = screenSize.height;
		int screenW = screenSize.width;
		
		setLocation((screenW - 420)/2, (screenH - 420)/2);	
		Image img = new ImageIcon("./src/tags.png").getImage();
		setIconImage(img);
	}
}
package mod1;
import java.awt.EventQueue;
import mod2.GUI;

public class Driver {

	public static void main(String[] args) {
		
		//Creates Window
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI window = new GUI();
					window.getFrame().setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}

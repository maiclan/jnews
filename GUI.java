import javax.swing.*;

public class GUI extends JFrame {

	private JPanel pane = new JPanel();
	private JButton btnRefresh = new JButton("Refresh");
	
	public void init() {
		this.setTitle("JNews app");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(400, 500);
		this.setVisible(true);
		 
		pane.add(btnRefresh);
		this.setContentPane(pane);
		
	}
}


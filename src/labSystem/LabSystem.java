package labSystem;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

import component.Util;

public class LabSystem extends JFrame implements KeyListener, ActionListener {
	
	private static final long serialVersionUID = 1L;
	
	protected Menu menu;
	protected Login login;
	
	public static void main(String args[]) {
		new LabSystem();
	}
	
	public LabSystem() {
		
		menu = new Menu();
		login = new Login();
		
		setTitle("LabSystem");
		setSize(Util.DEFAULT_SCREEN_WIDTH, Util.DEFAULT_SCREEN_HEIGHT);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);
		
		add(login);
		
		login.jbOpen.addActionListener(this);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == login.jbOpen) {
			login.setVisible(false);
			this.add(this.menu);
			menu.requestFocus();
		}
		
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	
}

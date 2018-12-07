package term;

import java.awt.Graphics;
import java.awt.Image;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import object.ConnectionFactory;
import object.Util;

public class UpdateTerm extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ImageIcon background;
	private boolean back = false;
	private JComboBox<String> jc;
	private JButton jbSearch;
	private JButton jbConfirm;
	private JButton sitYes;
	private JButton sitNot;
	private JButton enYes;
	private JButton enNot;
	private JLabel enBall;
	private JLabel sitBall;
	private int tNumber; 
	private int sNumber;
	private int fCreated;
	private String situetion;
	private int fAss;
	private Date dtFim;
	private Date dtAss;
	
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public UpdateTerm() {
		
		background = new ImageIcon("res\\termo\\ModeloAtualizar.png");
		jc = Util.getComboBoxBlue(369, 223, this);
		jbSearch = Util.setButton(jbSearch, 686, 305, 80, 25, this);
		sitYes = Util.setButton(sitYes, 568, 214, 60, 20, this);
		sitNot = Util.setButton(sitNot, 676, 214, 60, 20, this);
		enNot = Util.setButton(enNot, 676, 250, 60, 20, this);
		enYes = Util.setButton(enYes, 568, 250, 60, 20, this);
		jbConfirm = Util.setButton(jbConfirm, 660, 305, 120, 25, this);
				
		jbConfirm.setVisible(false);
		sitYes.setVisible(false);
		sitNot.setVisible(false);
		enNot.setVisible(false);
		enYes.setVisible(false);
		
		Connection connection = new ConnectionFactory().getConnection();
		TermDAO terDAO = new TermDAO();
		
		jc.setModel(new DefaultComboBoxModel(new Vector(terDAO.getList())));
		
		Util.createButtonEmployee(this);
		Util.newMenu(this);
		
		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void search() {
		
		ArrayList<Integer> keys = new ArrayList<Integer>();
		keys = (ArrayList<Integer>) Util.getListKey("numero", "TermoResponsabilidade");
		
		Connection connection = new ConnectionFactory().getConnection();
		TermDAO terDAO = new TermDAO();
		
		tNumber = keys.get(jc.getSelectedIndex());
		
		terDAO.getUpdate(this, keys.get(jc.getSelectedIndex()));
		
		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		jbSearch.setVisible(false);
		sitYes.setVisible(true);
		sitNot.setVisible(true);
		enNot.setVisible(true);
		enYes.setVisible(true);
		jbConfirm.setVisible(true);
		
		back = true;
		this.repaint();
	}
	
	@SuppressWarnings("null")
	public void ball(int action) {
		
		
		switch (action) {
		case 1:
			sitBall.setBounds( 572, 213, 25, 25);
			setDtAss(Util.getDate());
			setfAss(Util.matriculation);
			setSituetion("A");
			break;
		
		case 2:
			sitBall.setBounds( 680, 213, 25, 25);
			setDtAss(null);
			setfAss(' ');
			setSituetion("D");
			break;
			
		case 3:
			enBall.setBounds( 572, 248, 25, 25);
			setDtFim(Util.getDate());
			break;
			
		case 4:
			enBall.setBounds( 680, 248, 25, 25);
			setDtFim(null);
			break;
		}
		
		this.repaint();
	}
	
	public void update() {
		
		Connection connection = new ConnectionFactory().getConnection();
		TermDAO terDAO = new TermDAO();
		
		terDAO.update(this);
		
		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public JButton getJbConfirm() {
		return jbConfirm;
	}

	public void setJbConfirm(JButton jbConfirm) {
		this.jbConfirm = jbConfirm;
	}

	public int gettNumber() {
		return tNumber;
	}

	public void settNumber(int tNumber) {
		this.tNumber = tNumber;
	}

	public int getsNumber() {
		return sNumber;
	}

	public void setsNumber(int sNumber) {
		this.sNumber = sNumber;
	}

	public int getfCreated() {
		return fCreated;
	}

	public void setfCreated(int fCreated) {
		this.fCreated = fCreated;
	}

	public String getSituetion() {
		return situetion;
	}

	public void setSituetion(String situetion) {
		this.situetion = situetion;
	}

	public int getfAss() {
		return fAss;
	}

	public void setfAss(int fAss) {
		this.fAss = fAss;
	}

	public Date getDtFim() {
		return dtFim;
	}

	public void setDtFim(Date dtFim) {
		this.dtFim = dtFim;
	}

	public Date getDtAss() {
		return dtAss;
	}

	public void setDtAss(Date dtAss) {
		this.dtAss = dtAss;
	}

	public boolean isBack() {
		return back;
	}

	public void setBack(boolean back) {
		this.back = back;
	}

	public JButton getSitYes() {
		return sitYes;
	}

	public void setSitYes(JButton sitYes) {
		this.sitYes = sitYes;
	}

	public JButton getSitNot() {
		return sitNot;
	}

	public void setSitNot(JButton sitNot) {
		this.sitNot = sitNot;
	}

	public JButton getEnYes() {
		return enYes;
	}

	public void setEnYes(JButton enYes) {
		this.enYes = enYes;
	}

	public JButton getEnNot() {
		return enNot;
	}

	public void setEnNot(JButton enNot) {
		this.enNot = enNot;
	}

	public JLabel getEnBall() {
		return enBall;
	}

	public void setEnBall(JLabel enBall) {
		this.enBall = enBall;
	}

	public JLabel getSitBall() {
		return sitBall;
	}

	public void setSitBall(JLabel sitBall) {
		this.sitBall = sitBall;
	}

	public JButton getJbSearch() {
		return jbSearch;
	}



	public void setJbSearch(JButton jbSearch) {
		this.jbSearch = jbSearch;
	}



	public static long getSerialversionuid() {
		return serialVersionUID;
	}



	protected void paintComponent(Graphics g) {

		Image img;
		
		if(!back) {
			img = background.getImage();
			g.drawImage(img, 0, 0, img.getWidth(this), img.getHeight(this), this);
		}else {
			
			jc.setVisible(false);
			background = new ImageIcon("res\\termo\\ModeloAtualizar2.png");
			img = background.getImage();
			g.drawImage(img, 0, 0, img.getWidth(this), img.getHeight(this), this);
		}
	}

}

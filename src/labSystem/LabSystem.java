package labSystem;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import component.Consult;
import component.Delete;
import component.Register;
import component.Update;
import component.Util;

//banco de dados
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class LabSystem extends JFrame implements KeyListener, ActionListener, MouseListener {

	private static final long serialVersionUID = 1L;

	protected Register register;
	protected Login login;
	protected Loading loading;
	protected AddEmployee employee;
	protected Consult consult;
	protected Update update;
	protected Delete delete;

	protected boolean openEmployee = false;

	public static void main(String args[]) {
		new LabSystem();
	}

	/*
	 * construtor
	 */
	public LabSystem() {

		register = new Register();
		login = new Login();
		employee = new AddEmployee();

		setIconImage(Toolkit.getDefaultToolkit().getImage("res\\logo\\computador.png"));
		setTitle("LabSystem");
		setSize(Util.DEFAULT_SCREEN_WIDTH, Util.DEFAULT_SCREEN_HEIGHT);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);

		add(login);

		listener();
	}

	/*
	 * instacia a ultima tela ao clicar esc
	 */
	public void newInstanceScreen(JPanel screen) {

		

		if (screen == login)
			login = new Login();
		Util.lastScreen = login;

		if (screen == employee)
			employee = new AddEmployee();
	}

	/*
	 * metodo para trocar de tela
	 */
	public void anotherScreen(JPanel remove, JPanel newScreen) {

		Util.thisScreen = newScreen;
		Util.lastScreen = new Login();

		remove.setVisible(false);
		this.add(newScreen);
		newScreen.requestFocus();

		listener();
	}

	/*
	 * leitura de todas as ações
	 */
	public void listener() {

		// Botão
		login.jbOpen.addActionListener(this);
		login.jtLogin.addActionListener(this);
		login.jbAddEmployee.addActionListener(this);

		employee.jbSave.addActionListener(this);

		// Mouse
		login.jtLogin.addMouseListener(this);
		login.jPassword.addMouseListener(this);
		login.jbHelp.addMouseListener(this);
		login.jbAddEmployee.addMouseListener(this);
		login.jbOpen.addMouseListener(this);

		employee.jtName.addMouseListener(this);
		employee.jtRegistration.addMouseListener(this);
		employee.jbSave.addMouseListener(this);
		employee.jbCancel.addMouseListener(this);

		Util.jbRegister.addMouseListener(this);
		Util.jbUpdate.addMouseListener(this);
		Util.jbConsult.addMouseListener(this);
		Util.jbDelete.addMouseListener(this);

		Util.jbConsult.addActionListener(this);
		Util.jbRegister.addActionListener(this);
		Util.jbUpdate.addActionListener(this);
		Util.jbDelete.addActionListener(this);
		
		// teclado
		this.addKeyListener(this);
		this.requestFocus();
	}

	/*
	 * eventos dos botões
	 */
	@Override
	public void actionPerformed(ActionEvent e) {

		// entrar
		if (e.getSource() == login.jbOpen) {
			if (login.jtLogin.getText().length() > 0 && login.jPassword.getPassword().length > 0)
				anotherScreen(this.login, this.register = new Register());
			else
				Util.isWrong = true;
			login.repaint();
		}

		// adicionar funcionário
		if (e.getSource() == login.jbAddEmployee)
			anotherScreen(login, employee);

		if (e.getSource() == employee.jbSave && employee.save == false) {
			employee.insertEmployee(employee.jtName, employee.jtRegistration, employee.jpPassword,
					employee.jpConfirmPassword);
			employee.save = true;
		}
		
		/*
		 * Leitura dos botões do menu de cada tela
		 */

		if (e.getSource() == Util.jbConsult)
			anotherScreen(Util.thisScreen, consult = new Consult());
		
		if(e.getSource() == Util.jbRegister)
			anotherScreen(Util.thisScreen, register = new Register());
		
		if(e.getSource() == Util.jbUpdate)
			anotherScreen(Util.thisScreen, update = new Update());
		
		if(e.getSource() == Util.jbDelete)
			anotherScreen(Util.thisScreen, delete = new Delete());
	}

	

	/*
	 * eventos do teclado
	 */
	@Override
	public void keyPressed(KeyEvent e) {
		// ESC
		if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
			newInstanceScreen(Util.thisScreen);
			anotherScreen(Util.thisScreen, Util.lastScreen);
			newInstanceScreen(Util.lastScreen);
		}

		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			// login.jtLogin.
		}
	}

	@Override
	public void keyReleased(KeyEvent arg0) {

	}

	@Override
	public void keyTyped(KeyEvent arg0) {

	}

	/*
	 * Eventos do mouse
	 */

	// Quando mouse clicar em alguma coisa
	@Override
	public void mouseClicked(MouseEvent e) {

		// Tira o erro ao clicar em login ou senha
		if (e.getSource() == login.jtLogin || e.getSource() == login.jPassword)
			Util.isWrong = false;
		login.repaint();

		if (e.getSource() == employee.jtName)
			employee.jtName.setText(null);

		if (e.getSource() == employee.jtRegistration)
			employee.jtRegistration.setText(null);

		if (e.getSource() == login.jtLogin)
			login.jtLogin.setBorder(BorderFactory.createEtchedBorder(Util.jPressedColor, Util.jPressedColor));

		if (e.getSource() == login.jPassword)
			login.jPassword.setBorder(BorderFactory.createEtchedBorder(Util.jPressedColor, Util.jPressedColor));

	}

	// Quando clicar em outro evento
	@Override
	public void mouseReleased(MouseEvent e) {

	}

	// Quando o mouse passar por cima
	@Override
	public void mouseEntered(MouseEvent e) {

		// login / entrar
		if (e.getSource() == login.jbOpen)
			login.jbOpen.setIcon(login.imgOpen);

		// Lampada de ajuda
		if (e.getSource() == login.jbHelp)
			login.jbHelp.setIcon(login.imgHelpPress);

		// Adicionar funcionário
		if (e.getSource() == login.jbAddEmployee)
			login.jbAddEmployee.setIcon(login.imgEmployeePress);

		// add funcionario / salvar
		if (e.getSource() == employee.jbSave)
			employee.jbSave.setIcon(employee.imgSave);

		// add funciona / cancelar
		if (e.getSource() == employee.jbCancel)
			employee.jbCancel.setIcon(employee.imgCancel);

		// menu / consultar
		if (e.getSource() == Util.jbConsult)
			Util.jbConsult.setIcon(Util.imgConsult);

		if (e.getSource() == Util.jbRegister)
			Util.jbRegister.setIcon(Util.imgRegister);

		if (e.getSource() == Util.jbUpdate)
			Util.jbUpdate.setIcon(Util.imgUpdate);

		if (e.getSource() == Util.jbDelete)
			Util.jbDelete.setIcon(Util.imgDelete);

	}

	// Quando o mouse sair de cima
	@Override
	public void mouseExited(MouseEvent e) {

		// login / entrar
		login.jbOpen.setIcon(null);

		// lampada de ajuda
		login.jbHelp.setIcon(login.imgHelp);

		// adicionar funcionário
		login.jbAddEmployee.setIcon(login.imgEmployee);

		// add funcionário / salvar
		employee.jbSave.setIcon(employee.imgSaveTransparent);

		// add Funcionario / cancelar
		employee.jbCancel.setIcon(employee.imgCancelTransparent);

		if (e.getSource() == Util.jbRegister)
			Util.jbRegister.setIcon(null);

		if (e.getSource() == Util.jbConsult)
			Util.jbConsult.setIcon(null);

		if (e.getSource() == Util.jbUpdate)
			Util.jbUpdate.setIcon(null);

		if (e.getSource() == Util.jbDelete)
			Util.jbDelete.setIcon(null);

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	/*
	 * banco de dados
	 */
	public void selectEmployee(JTextField registration, JPasswordField jpassword) {

		String driver = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/systemlab";
		String user = "root";
		String password = "1234";
		Connection conn;
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, password);

			String sql = "selected matricula from cadastro where matrica = " + registration.getText() + "";
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(sql);

			while (rs.next()) {
				if (rs.getCharacterStream(2).equals(registration)) {
					openEmployee = true;
					break;
				}
			}

			rs.close();
			st.close();
			conn.close();
		} catch (SQLException | ClassNotFoundException ex) {
			ex.printStackTrace();
		}

	}
}

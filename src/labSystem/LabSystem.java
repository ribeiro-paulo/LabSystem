package labSystem;

import java.awt.KeyboardFocusManager;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.KeyStroke;

import category.CategoryDAO;
import category.ConsultCategory;
import category.DeleteCategory;
import category.RegisterCategory;
import category.UpdateCategory;
import employee.RegisterEmployee;
import login.Login;
import login.RegisterAdm;
import object.ConnectionFactory;
import object.Consult;
import object.Delete;
import object.Register;
import object.Update;
import object.Util;
import sector.ConsultSector;
import sector.DeleteSector;
import sector.RegisterSector;
import sector.UpdateSector;
import term.ConsultTerm;
import term.DeleteTerm;
import term.RegisterTerm;
import term.UpdateTerm;

//banco de dados
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashSet;

public class LabSystem extends JFrame implements KeyListener, ActionListener, MouseListener, ItemListener {

	private static final long serialVersionUID = 1L;
	
	protected Start start;
	protected RegisterAdm rAdm;
	
	public Register register;
	protected Login login;
	protected Consult consult;
	protected Update update;
	protected Delete delete;
	
	public RegisterEmployee rEmployee;
	
	protected RegisterSector rSector;
	protected ConsultSector cSector;
	protected UpdateSector uSector;
	protected DeleteSector dSector;
	
	protected RegisterCategory rCategory;
	protected ConsultCategory cCategory; 
	protected UpdateCategory uCategory;
	protected DeleteCategory dCategory;
	
	protected RegisterTerm rTerm;
	protected ConsultTerm cTerm;
	protected UpdateTerm uTerm;
	protected DeleteTerm dTerm;
	
	protected boolean a = true;

	protected boolean openEmployee = false;

	public static void main(String args[]) {
		new LabSystem();
	}

	/*
	 * construtor
	 */
	public LabSystem() {
		
		rAdm = new RegisterAdm();
		
		dCategory = new DeleteCategory();
		rCategory = new RegisterCategory();
		uCategory = new UpdateCategory();
		
		rSector = new RegisterSector();
		cSector = new ConsultSector();
		uSector = new UpdateSector();
		dSector = new DeleteSector();
		
		delete = new Delete();
		consult = new Consult();
		update = new Update();
		register = new Register();
		
		start = new Start();
		login = new Login();
		
		rEmployee = new RegisterEmployee();
		
		uTerm = new UpdateTerm();
		cTerm = new ConsultTerm();
		dTerm = new DeleteTerm();
		rTerm = new RegisterTerm();
		

		setIconImage(Toolkit.getDefaultToolkit().getImage("res\\logo\\computador.png"));
		setTitle("LabSystem");
		setSize(login.getBackgorund().getIconWidth(), login.getBackgorund().getIconHeight());
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);

		Util.thisScreen = start;
		add(start);

		listener();
	} 

	/*
	 * instacia a ultima tela ao clicar esc
	 */
	public void newInstanceScreen(JPanel screen) {

		if (screen == login)
			login = new Login();
		Util.lastScreen = login;

	}

	/*
	 * metodo para trocar de tela
	 */
	public void anotherScreen(JPanel remove, JPanel newScreen) {
		
		Util.thisScreen = newScreen;
		Util.lastScreen = remove;
		
		remove.setVisible(false);
		this.add(newScreen);
		newScreen.requestFocus();

		listener();
	}

	/*
	 * leitura de todas as ações
	 */
	@SuppressWarnings("unchecked")
	public void listener() {

		// Configura em cada JPanel o enter
		@SuppressWarnings("rawtypes")
		HashSet conj = new HashSet(Util.thisScreen.getFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS));
		conj.add(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0));
		Util.thisScreen.setFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, conj);
	
		/* ActionListener */
		rAdm.getJbNext().addActionListener(this);
		start.getJbStart().addActionListener(this);
		
		login.getJbLogin().addActionListener(this);
		login.getJbEye().addActionListener(this);
		login.getJbBefore().addActionListener(this);
	
		register.jbSave.addActionListener(this);

		update.jbSearch.addActionListener(this);
		update.jbSave.addActionListener(this);

		delete.jbSearch.addActionListener(this);
		delete.jbDelete.addActionListener(this);
		
		rEmployee.getJbNot().addActionListener(this);
		rEmployee.getJbYes().addActionListener(this);
		rEmployee.getJbSave().addActionListener(this);
		
		rCategory.getJbSave().addActionListener(this);
		uCategory.getJbSearch().addActionListener(this);
		uCategory.getJbSave().addActionListener(this);
		dCategory.getJbDelete().addActionListener(this);
		
		rSector.getJbSave().addActionListener(this);
		uSector.getJbSearch().addActionListener(this);
		uSector.getJbSave().addActionListener(this);
		dSector.getJbDelete().addActionListener(this);
		
		rTerm.getJbYes().addActionListener(this);
		rTerm.getJbNot().addActionListener(this);
		rTerm.getJbSave().addActionListener(this);
		cTerm.getJbSearch().addActionListener(this);
		uTerm.getJbSearch().addActionListener(this);
		uTerm.getSitNot().addActionListener(this);
		uTerm.getSitYes().addActionListener(this);
		uTerm.getEnYes().addActionListener(this);
		uTerm.getEnNot().addActionListener(this);
		uTerm.getJbConfirm().addActionListener(this);
		dTerm.getJbSearch().addActionListener(this);
		dTerm.getJbYes().addActionListener(this);
		dTerm.getJbNot().addActionListener(this);
		
		Util.jbConsult.addActionListener(this);
		Util.jbRegister.addActionListener(this);
		Util.jbUpdate.addActionListener(this);
		Util.jbDelete.addActionListener(this);
		
		Util.jbSector.addActionListener(this);
		Util.jbCategory.addActionListener(this);
		Util.jbEmployee.addActionListener(this);
		
		Util.jbComponent.addActionListener(this);
		Util.jbTerm.addActionListener(this);
		
		/* MouseListener */

		Util.jbConsult.addMouseListener(this);
		Util.jbRegister.addMouseListener(this);
		Util.jbUpdate.addMouseListener(this);
		Util.jbDelete.addMouseListener(this);

		this.requestFocus();
		this.addKeyListener(this);

		/* ItemListener */
		register.jcCategory.addItemListener(this);
	}
	
	private void haveAdm() {
		
		if(Util.getListKey("matricula", "funcionario").size() == 0)
			anotherScreen(Util.thisScreen, rAdm = new RegisterAdm());
		else
			anotherScreen(Util.thisScreen, login = new Login());
	}

	/*
	 * eventos dos botões
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		
		/*
		 *  ------------------------LOGIN------------------------- 
		 */
		
		if(e.getSource() == start.getJbStart())
			haveAdm();	
		
		if(e.getSource() == login.getJbEye())
			login.Eye();
		
		if(e.getSource() == login.getJbLogin())
			login.login(this);
		
		if(e.getSource() == login.getJbBefore())
			anotherScreen(Util.thisScreen, start = new Start());
		
		if(e.getSource() == rAdm.getJbNext()) {
			rAdm.register();
			anotherScreen(Util.thisScreen, login = new Login());
		}
		
		/*
		 *  ----------------------Administrador----------------------- 
		 */
		
		// barra inf
		if(e.getSource() == Util.jbEmployee)
			anotherScreen(Util.thisScreen, rEmployee = new RegisterEmployee());
		
		if(e.getSource() == Util.jbSector)
			anotherScreen(Util.thisScreen, rSector = new RegisterSector());
		
		if(e.getSource() == Util.jbCategory)
			anotherScreen(Util.thisScreen, rCategory = new RegisterCategory());
		
		// barra lateral
		if (e.getSource() == Util.jbConsult)
			this.controller("consultar");

		if (e.getSource() == Util.jbRegister)
			this.controller("adicionar");

		if (e.getSource() == Util.jbUpdate)
			this.controller("atualizar");

		if (e.getSource() == Util.jbDelete)
			this.controller("excluir");
		
		// barra inf
		if(e.getSource() == Util.jbComponent)
			anotherScreen(Util.thisScreen, register = new Register());
		
		if(e.getSource() == Util.jbTerm)
			anotherScreen(Util.thisScreen, rTerm = new RegisterTerm()); 
		
		/*
		 *  -------------------------Funcionário----------------------- 
		 */
		
		if(e.getSource() == rEmployee.getJbNot())
			rEmployee.ball(false);
			
		if(e.getSource() == rEmployee.getJbYes())
			rEmployee.ball(true);
		
		if(e.getSource() == rEmployee.getJbSave())
			rEmployee.register();
		/*
		 * ---------------------------Categoria ------------------------
		 */
		
		// adiconar categoria / salver
		if(e.getSource() == rCategory.getJbSave()) {
			
			if(Util.notNull(rCategory.getJtName().getText())) {
				
				Connection connection = new ConnectionFactory().getConnection();
				CategoryDAO catDAO = new CategoryDAO();
				try {
					catDAO.adicionar(rCategory);
				} catch (SQLException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				try {
					connection.close();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				Util.setSaved(rCategory);
				rCategory.getJtName().setText("");
			}else {
				Util.setNotNull(rCategory);
			}
		}
		
		if(e.getSource() == uCategory.getJbSearch()) {		
			
			if(Util.notNull(uCategory.getJtName().getText()))
				
				uCategory.modeUpdate();
			else
				Util.setNotNull(uCategory);
		
		}
				
		if(e.getSource() == uCategory.getJbSave()) {
			if(Util.notNull(uCategory.getJtName().getText())) {
				
				uCategory.update();
				anotherScreen(Util.thisScreen, uCategory = new UpdateCategory());
				Util.setSaved(uCategory);
			}else {
				Util.setNotNull(uCategory);
			}
		}
		
		if(e.getSource() == dCategory.getJbDelete()) {
			
			dCategory.delete();
			anotherScreen(Util.thisScreen, dCategory = new DeleteCategory());
			Util.setDeleted(dCategory);
		}
		
		/*
		 * ---------------------------Setor ---------------------------
		 */
		
		if(e.getSource() == rSector.getJbSave()) {
			
			if(Util.notNull(rSector.getJtName().getText()) && Util.notNull(rSector.getJtLimit().getText())) {
				rSector.register();
				Util.setSaved(rSector);
				rSector.getJtLimit().setText("");
				rSector.getJtName().setText("");
			}else {
				Util.setNotNull(rSector);
			}
		}
		// não esquecer a senha da minha namorada 071303nsr
		if(e.getSource() == uSector.getJbSearch()) {
			if(Util.notNull(uSector.getJtName().getText())) 
				uSector.modeUpdate();
			else
				Util.setNotNull(uSector);
		}
		
		if(e.getSource() == uSector.getJbSave()) {
			if(Util.notNull(uSector.getJtName().getText()) && Util.notNull(uSector.getJtLimit().getText())) {
				uSector.update();
				anotherScreen(Util.thisScreen, uSector = new UpdateSector());
				Util.setSaved(uSector);
			}else {
				Util.setNotNull(uSector);
			}
		}
		
		if(e.getSource() == dSector.getJbDelete()) {
			dSector.delete();
			Util.setDeleted(dSector);
		}
		
		/*
		 * -------------------TERMO DE REPONSABILIDADE ------------------
		 */
		
		if(e.getSource() == rTerm.getJbYes())
			rTerm.ball(true);
		
		if(e.getSource() == rTerm.getJbNot())
			rTerm.ball(false);
		
		// ta duplicando
		if(e.getSource() == rTerm.getJbSave()) {
			
			if(Util.notNull(rTerm.getJtDescrip().getText())) {
				
				rTerm.register();
				anotherScreen(Util.thisScreen, rTerm = new RegisterTerm());
				Util.setSaved(rTerm);
			}else {
				Util.setNotNull(rTerm);
			}
	
		}
		
		if(e.getSource() == cTerm.getJbSearch())
			cTerm.search();
		
		if(e.getSource() == uTerm.getJbSearch())
			uTerm.search();
		
		if(e.getSource() == uTerm.getSitYes())
			uTerm.ball(1);
		
		if(e.getSource() == uTerm.getSitNot())
			uTerm.ball(2);
		
		if(e.getSource() == uTerm.getEnYes())
			uTerm.ball(3);
		
		if(e.getSource() == uTerm.getEnNot())
			uTerm.ball(4);
		
		if(e.getSource() == uTerm.getJbConfirm()) {
			uTerm.update();
			anotherScreen(Util.thisScreen, uTerm = new UpdateTerm());
			Util.setSaved(uTerm);
		}
		
		if(e.getSource() == dTerm.getJbSearch())
			dTerm.search();
		
		if(e.getSource() == dTerm.getJbYes())
			dTerm.detele();
		
		if(e.getSource() == dTerm.getJbNot())
			anotherScreen(Util.thisScreen, dTerm = new DeleteTerm());
		/*
		 * ---------------------------Objeto ---------------------------
		 */

		// Cadastro Componentes / salvar
		if (e.getSource() == register.jbSave) {
			
			if ( Util.notNull(register.jtName.getText()) && Util.notNull(register.jtDescription.getText()) && Util.notNull(register.jtAmount.getText()) && Util.notNull(register.jcCategory.getSelectedItem().toString())) {		
				
				register.save();
				anotherScreen(Util.thisScreen, register = new Register());
				register.paintSaved();
			}else{
				
				register.paintAllField(register);
			}

		}
		// Atualizar / buscar
		if (e.getSource() == update.jbSearch) {

			JTextField text = update.jtName;
			
			if(!Util.getValue("codigo", "objeto", "nome", text.getText()).equals("not")) {
				update.repaint();
				update.update = true;
				update.searchName(text);
			}else
				Util.setFoundMenu(update);
		}

		// Atualizar / salvar
		if (e.getSource() == update.jbSave) {
			update.updateItens();
			anotherScreen(Util.thisScreen, update = new Update());
			Util.setSaved(update);
		}

		// Excluir / buscar
		if (e.getSource() == delete.jbSearch) {
			Util.name = delete.getJc().getSelectedItem().toString();
			delete.a = true;
			delete.repaint();
			delete.showObject();
		}

		// Excluir / apagar
		if (e.getSource() == delete.jbDelete) {
			delete.delete();
			anotherScreen(Util.thisScreen, delete = new Delete());
			Util.setDeleted(delete);
		}
	}

	/*
	 * eventos do teclado
	 */
	@Override
	public void keyPressed(KeyEvent e) {
		// ESC
		if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
			//newInstanceScreen(Util.thisScreen);
			anotherScreen(Util.thisScreen, login = new Login());
			login.getJtMatriculetion().requestFocus();
			//newInstanceScreen(Util.lastScreen);
		}

		/*
		 * if (e.getKeyCode() == KeyEvent.VK_ENTER) {
		 * if(login.jPassword.getText().equals("")) login.jPassword.requestFocus(); else
		 * this.anotherScreen(this.login, this.register = new Register()); }
		 * 
		 */
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
		
		if (e.getSource() == register.jcCategory)
			register.jcCategory.setBounds(400, 400, 300, 30);
	}

	// Quando clicar em outro evento
	@Override
	public void mouseReleased(MouseEvent e) {

	}

	// Quando o mouse passar por cima
	@Override
	public void mouseEntered(MouseEvent e) {
		
		/*
		 * menu
		 */
		if (e.getSource() == Util.jbConsult)
			Util.jbConsult.setIcon(Util.imgConsult);

		if (e.getSource() == Util.jbRegister)
			Util.jbRegister.setIcon(Util.imgRegister);

		if (e.getSource() == Util.jbUpdate)
			Util.jbUpdate.setIcon(Util.imgUpdate);

		if (e.getSource() == Util.jbDelete)
			Util.jbDelete.setIcon(Util.imgDelete);

		// Adicionar / limpar tudo
		if (e.getSource() == register.jbClear)
			register.jbClear.setIcon(register.imgClear);

		//

	}

	// Quando o mouse sair de cima
	@Override
	public void mouseExited(MouseEvent e) {

		register.jbClear.setIcon(null);

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
	 * controla as telas
	 */
	private void controller(String button) {
		/*
		 * 1 - Adicionar
		 * 2 - Consultar 
		 * 3 - Atualizar 
		 * 4 - Excluir
		 */
		switch(button) {
		case "adicionar":
			
			switch(Util.screen) {
			case "objeto":
				anotherScreen(Util.thisScreen, register = new Register());
			break;
			
			case "funcionario":
				anotherScreen(Util.thisScreen, rEmployee = new RegisterEmployee());
			break;
			
			case "categoria":
				anotherScreen(Util.thisScreen, rCategory = new RegisterCategory());
			break;
			
			case "setor":
				anotherScreen(Util.thisScreen, rSector = new RegisterSector());
			break;
			
			case "termo":
				anotherScreen(Util.thisScreen, rTerm = new RegisterTerm());
			break;
			}
			
		break; 
		
		// -------
		
		case "consultar":
			
			switch(Util.screen) {
			case "objeto":
				anotherScreen(Util.thisScreen, consult = new Consult());
			break;
			
			case "funcionario":
				//anotherScreen(Util.thisScreen, rEmployee = new RegisterEmployee());
			break;
			
			case "categoria":
				anotherScreen(Util.thisScreen, cCategory = new ConsultCategory());
			break;
			
			case "setor":
				anotherScreen(Util.thisScreen, cSector = new ConsultSector());
			break;
			
			case "termo":
				anotherScreen(Util.thisScreen, cTerm = new ConsultTerm());
			break;
			}
			
		break;
		
		// -------
		
		case "atualizar":
			
			switch(Util.screen) {
			case "objeto":
				anotherScreen(Util.thisScreen, update = new Update());
			break;
			
			case "funcionario":
				//anotherScreen(Util.thisScreen, rEmployee = new RegisterEmployee());
			break;
			
			case "categoria":
				anotherScreen(Util.thisScreen, uCategory = new UpdateCategory());
			break;
			
			case "setor":
				anotherScreen(Util.thisScreen, uSector = new UpdateSector());
			break;
			
			case "termo":
				anotherScreen(Util.thisScreen, uTerm = new UpdateTerm());
			break;
			}
			
		break;
		
		// -------
		
		case "excluir":
			
			switch(Util.screen) {
			case "objeto":
				anotherScreen(Util.thisScreen, delete = new Delete());
			break;
			
			case "funcionario":
				//anotherScreen(Util.thisScreen, rEmployee = new RegisterEmployee());
			break;
			
			case "categoria":
				anotherScreen(Util.thisScreen, dCategory = new DeleteCategory());
			break;
			
			case "setor":
				anotherScreen(Util.thisScreen, dSector = new DeleteSector());
			break;
			
			case "termo":
				anotherScreen(Util.thisScreen, dTerm = new DeleteTerm());
			break;
			}
			
		break;
		}
	}

	/* Evento dos itens */
	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub

	}

}

package igu;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;

import Logica.Conversor;
import Logica.Longitud;
import Logica.Moneda;
import Logica.Temperatura;
import Logica.Tiempo;
import Logica.Velocidad;


public class ConversorAlura extends JFrame implements ItemListener,ActionListener {

	private JPanel contentPane,contenidoPanel,contentConversor;
	private JLabel lblFondo;
	private JComboBox<String> cboSelectorConversor;
	private JComboBox<String> cboListaConversor1;
	private JComboBox<String> cboListaConversor2;
	private JTextField txtCuadroDato1= new JTextField(20);
	private JLabel lblResultado;
	private JTextField txtCuadroDato2= new JTextField(20);
	private JLabel lblIndicacionesTipoConversor;
	private JLabel lblLogoAlura;
	private JLabel lblIndicacionesTipoDato1;
	private JLabel lblIndicacionesTipoDato2;
	private int conversorTipo;
	private String conversorTipoText;
	private String datoBase,datoAConvertir,indexTexto; 
	private JLabel lblTipoConversor;
	private JTextField textResultado;
	private int index,newIndex,aleatorio;
	private Random random = new Random();
	private double dato1,dato2;
	private Conversor conversor;
	private boolean isProcessingSelection = false;
	private ImageIcon logo;
	private ButtonGroup grupoTema;
	private ButtonGroup grupoIdioma;
	private JLabel lblTituloConversor;
	private JMenu mnInicio;
	private JMenuItem mntmConversorAlura;
	private JMenu mnInterfaz;
	private JMenu mnInformacion;
	private JMenuItem mntmAcercaDe;
	private JMenu mnTema;
	private JMenu mnIdiomas;
	private JRadioButtonMenuItem rdbtnmntmEspañol;
	private JRadioButtonMenuItem rdbtnmntmIngles;
	 
	
	public ConversorAlura() {
      initComponents();
      
       
        
    }
	
	private void initComponents() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 642, 536);
		setIconImage(new ImageIcon(getClass().getResource("/imgs/LogoConversor.png")).getImage());
		setTitle("Conversor-Alura");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		contentConversor = new JPanel();
        contentConversor.setBounds(0, 22, 626, 482);
        contentPane.add(contentConversor);
		contentConversor.setLayout(null);
		
		contenidoPanel = new JPanel();
		contenidoPanel.setBounds(0, 0, 626, 480);
		contentConversor.add(contenidoPanel);
		contenidoPanel.setLayout(null);
		
		textResultado = new JTextField();
		textResultado.setEditable(false);
		textResultado.setForeground(new Color(0, 9, 36));
		textResultado.setFont(new Font("Century Gothic", Font.BOLD, 24));
		textResultado.setColumns(10);
		textResultado.setBorder(null);
		textResultado.setBackground(new Color(171, 255, 209));
		textResultado.setBounds(232, 418, 306, 31);
		contenidoPanel.add(textResultado);
		
		
		cboSelectorConversor = new JComboBox();
		cboSelectorConversor.addItemListener(this);
		cboSelectorConversor.setFont(new Font("Century Gothic", Font.BOLD, 16));
		cboSelectorConversor.setForeground(new Color(0, 9, 36));
		cboSelectorConversor.setMaximumRowCount(3);
		cboSelectorConversor.setModel(new DefaultComboBoxModel(new String[] {"--","Moneda","Temperatura", "Velocidad", "Tiempo", "Longitud"}));
		cboSelectorConversor.setBackground(new Color(70, 207, 179));
		cboSelectorConversor.setBounds(111, 94, 406, 25);
		cboSelectorConversor.setUI(PropiedadesPrincipalOscura.createUI(rootPane));
		cboSelectorConversor.setRenderer(new ColorSelectedPriOscuro());
		contenidoPanel.add(cboSelectorConversor);
		
		
		lblTituloConversor = new JLabel("CONVERSOR - ALURA");
		lblTituloConversor.setFont(new Font("Century Gothic", Font.BOLD, 29));
		lblTituloConversor.setForeground(new Color(255, 255, 255));
		lblTituloConversor.setBounds(111, 34, 295, 37);
		contenidoPanel.add(lblTituloConversor);
		
		cboListaConversor1 = new JComboBox<String>();
		cboListaConversor1.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				realizarOperacion();
			}
		});
		cboListaConversor1.setForeground(new Color(0, 9, 36));
		cboListaConversor1.setFont(new Font("Century Gothic", Font.BOLD, 14));
		cboListaConversor1.setMaximumRowCount(4);
		cboListaConversor1.addActionListener(this);
		cboListaConversor1.setModel(new DefaultComboBoxModel(new String[] {"--"}));
		cboListaConversor1.setBackground(new Color(49, 176, 176));
		cboListaConversor1.setBounds(97, 293, 208, 25);
		cboListaConversor1.setUI(PropiedadesSecundariasOscura.createUI(rootPane));
		cboListaConversor1.setRenderer(new ColorSelectedSecuOcura());
		contenidoPanel.add(cboListaConversor1);
		
		cboListaConversor2 = new JComboBox<String>();
		cboListaConversor2.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				realizarOperacion();
			}
		});
		cboListaConversor2.setForeground(new Color(0, 9, 36));
		cboListaConversor2.setFont(new Font("Century Gothic", Font.BOLD, 14));
		cboListaConversor2.setMaximumRowCount(4);
		cboListaConversor2.addActionListener(this);
		cboListaConversor2.setModel(new DefaultComboBoxModel(new String[] {"--"}));
		cboListaConversor2.setBackground(new Color(49, 176, 176));
		cboListaConversor2.setBounds(349, 293, 208, 25);
		cboListaConversor2.setUI(PropiedadesSecundariasOscura.createUI(rootPane));
		cboListaConversor2.setRenderer(new ColorSelectedSecuOcura());
		contenidoPanel.add(cboListaConversor2);
		
		txtCuadroDato1 = new JTextField("0.0");
		txtCuadroDato1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c= e.getKeyChar();
				if((c<'0'||c>'9')&&(c != KeyEvent.VK_BACK_SPACE)&&(c!='.'||txtCuadroDato1.getText().contains("."))) e.consume();
			}
		});
		txtCuadroDato1.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				 if(txtCuadroDato1.getText().equals("0.0")) {
				 txtCuadroDato1.setText("");
				 }
				 if(txtCuadroDato2.getText().isEmpty()) {
					 txtCuadroDato2.setText("0.0");	 
				 }
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				realizarOperacion(); 
			}
		});
		
		dato1=Double.parseDouble(txtCuadroDato1.getText());
		txtCuadroDato1.setFont(new Font("Century Gothic", Font.BOLD, 14));
		txtCuadroDato1.setText("0.0");
		txtCuadroDato1.setForeground(new Color(0, 9, 36));
		txtCuadroDato1.setBorder(null);
		txtCuadroDato1.setBackground(new Color(49, 176, 176));
		txtCuadroDato1.setBounds(97, 263, 208, 19);
		txtCuadroDato1.setColumns(10);
		contenidoPanel.add(txtCuadroDato1);
		
		
		txtCuadroDato2 = new JTextField("0.0");
		txtCuadroDato2.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c= e.getKeyChar();
				if((c<'0'||c>'9')&&(c != KeyEvent.VK_BACK_SPACE)&&(c!='.'||txtCuadroDato2.getText().contains("."))) e.consume();
			}
		});
		txtCuadroDato2.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				
				if(txtCuadroDato2.getText().equals("0.0")) {
					 txtCuadroDato2.setText("");
					 }
					 if(txtCuadroDato1.getText().isEmpty()) {
						 txtCuadroDato1.setText("0.0");	 
					 }
			}
		});
		dato2=Double.parseDouble(txtCuadroDato2.getText());
		txtCuadroDato2.setFont(new Font("Century Gothic", Font.BOLD, 14));
		txtCuadroDato2.setForeground(new Color(0, 9, 36));
		txtCuadroDato2.setText("0.0");
		txtCuadroDato2.setColumns(10);
		txtCuadroDato2.setBorder(null);
		txtCuadroDato2.setBackground(new Color(49, 176, 176));
		txtCuadroDato2.setBounds(358, 263, 199, 19);
		contenidoPanel.add(txtCuadroDato2);
		
		lblTipoConversor = new JLabel("Tienes que elegir primero");
		lblTipoConversor.setForeground(Color.WHITE);
		lblTipoConversor.setFont(new Font("Century Gothic", Font.BOLD, 29));
		lblTipoConversor.setBounds(87, 198, 489, 37);
		contenidoPanel.add(lblTipoConversor);
		
		lblResultado = new JLabel("RESULTADO:");
		lblResultado.setForeground(new Color(4, 27, 56));
		lblResultado.setFont(new Font("Century Gothic", Font.BOLD, 24));
		lblResultado.setBounds(89, 418, 136, 31);
		contenidoPanel.add(lblResultado);
		
		lblIndicacionesTipoConversor = new JLabel("Elija el tipo de conversor que va a usar.");
		lblIndicacionesTipoConversor.setFont(new Font("Century Gothic", Font.BOLD, 14));
		lblIndicacionesTipoConversor.setForeground(new Color(255, 255, 255));
		lblIndicacionesTipoConversor.setBounds(121, 130, 278, 16);
		contenidoPanel.add(lblIndicacionesTipoConversor);
		
		logo= new ImageIcon(getClass().getResource("/imgs/logo_aluraline.png"));
		lblLogoAlura = new JLabel("");
		lblLogoAlura.setBounds(35, 34, 46, 41);
		lblLogoAlura.setIcon(new ImageIcon(logo.getImage().getScaledInstance(46,41,Image.SCALE_SMOOTH)));
		contenidoPanel.add(lblLogoAlura);
		
		lblIndicacionesTipoDato1 = new JLabel("");
		lblIndicacionesTipoDato1.setForeground(Color.WHITE);
		lblIndicacionesTipoDato1.setFont(new Font("Century Gothic", Font.BOLD, 14));
		lblIndicacionesTipoDato1.setBounds(110, 329, 165, 16);
		contenidoPanel.add(lblIndicacionesTipoDato1);
		
		lblIndicacionesTipoDato2 = new JLabel("");
		lblIndicacionesTipoDato2.setForeground(Color.WHITE);
		lblIndicacionesTipoDato2.setFont(new Font("Century Gothic", Font.BOLD, 14));
		lblIndicacionesTipoDato2.setBounds(368, 329, 208, 16);
		contenidoPanel.add(lblIndicacionesTipoDato2);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 626, 22);
		contentPane.add(menuBar);
		
		logo= new ImageIcon(getClass().getResource("/imgs/home.png"));
		mnInicio = new JMenu("Inicio");
		mnInicio.setFont(new Font("Century Gothic", Font.BOLD, 12));
		mnInicio.setIcon(new ImageIcon(logo.getImage().getScaledInstance(20,20,Image.SCALE_SMOOTH)));
		menuBar.add(mnInicio);
	
		logo= new ImageIcon(getClass().getResource("/imgs/Alura.png"));
		mntmConversorAlura = new JMenuItem("Conversor");
		mntmConversorAlura.setIcon(new ImageIcon(logo.getImage().getScaledInstance(20,20,Image.SCALE_SMOOTH)));
		mntmConversorAlura.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				contenidoPanel.setSize(626,511);
				contenidoPanel.setLocation(0,0);
				
				contentConversor.removeAll();
				contentConversor.add(contenidoPanel,BorderLayout.CENTER);
				contentConversor.revalidate();
				contentConversor.repaint();
				
			}
		});
		mnInicio.add(mntmConversorAlura);
		
		
		logo= new ImageIcon(getClass().getResource("/imgs/configuracion.png"));
		mnInterfaz = new JMenu("Interfaz");
		mnInterfaz.setFont(new Font("Century Gothic", Font.BOLD, 12));
		mnInterfaz.setIcon(new ImageIcon(logo.getImage().getScaledInstance(20,20,Image.SCALE_SMOOTH)));
		menuBar.add(mnInterfaz);
		
		mnTema = new JMenu("Tema");
		mnTema.setFont(new Font("Century Gothic", Font.BOLD, 12));
		mnInterfaz.add(mnTema);
		
		logo= new ImageIcon(getClass().getResource("/imgs/oscuro.png"));
		JRadioButtonMenuItem rdbtnmntmTemaOscuro = new JRadioButtonMenuItem("Oscuro");
		rdbtnmntmTemaOscuro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblFondo.setIcon(new ImageIcon(getClass().getResource("/imgs/interfazLong.png")));
				textResultado.setBackground(new Color(171, 255, 209));
				
				txtCuadroDato1.setBackground(new Color(49, 176, 176));
				txtCuadroDato1.setForeground(new Color(0, 9, 36));
				txtCuadroDato2.setBackground(new Color(49, 176, 176));
				txtCuadroDato2.setForeground(new Color(0, 9, 36));
				
				cboSelectorConversor.setForeground(new Color(0, 9, 36));
				cboSelectorConversor.setBackground(new Color(70, 207, 179));
				cboSelectorConversor.setUI(PropiedadesPrincipalOscura.createUI(rootPane));
				cboSelectorConversor.setRenderer(new ColorSelectedPriOscuro());
				
				cboListaConversor1.setForeground(new Color(0, 9, 36));
				cboListaConversor1.setBackground(new Color(49, 176, 176));
				cboListaConversor1.setUI(PropiedadesSecundariasOscura.createUI(rootPane));
				cboListaConversor1.setRenderer(new ColorSelectedSecuOcura());
				
				cboListaConversor2.setForeground(new Color(0, 9, 36));
				cboListaConversor2.setBackground(new Color(49, 176, 176));
				cboListaConversor2.setUI(PropiedadesSecundariasOscura.createUI(rootPane));
				cboListaConversor2.setRenderer(new ColorSelectedSecuOcura());
				
				
				lblIndicacionesTipoConversor.setForeground(new Color(255, 255, 255));
				lblIndicacionesTipoDato1.setForeground(new Color(255, 255, 255));
				lblIndicacionesTipoDato2.setForeground(new Color(255, 255, 255));
			}
		});
		rdbtnmntmTemaOscuro.setFont(new Font("Century Gothic", Font.BOLD, 12));
		rdbtnmntmTemaOscuro.setSelected(true);
		rdbtnmntmTemaOscuro.setIcon(new ImageIcon(logo.getImage().getScaledInstance(20,20,Image.SCALE_SMOOTH)));
		mnTema.add(rdbtnmntmTemaOscuro);
		
		logo= new ImageIcon(getClass().getResource("/imgs/claro.png"));
		JRadioButtonMenuItem rdbtnmntmTemaClaro = new JRadioButtonMenuItem("Claro");
		rdbtnmntmTemaClaro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblFondo.setIcon(new ImageIcon(getClass().getResource("/imgs/interfazClara.png")));
				
				textResultado.setBackground(new Color(128, 128, 164));
				txtCuadroDato1.setBackground(new Color(51, 51, 70));
				txtCuadroDato1.setForeground(new Color(255, 255, 255));
				txtCuadroDato2.setBackground(new Color(51, 51, 70));
				txtCuadroDato2.setForeground(new Color(255, 255, 255));
				
				
				cboSelectorConversor.setForeground(new Color(255,255,255));
				cboSelectorConversor.setBackground(new Color(83, 83, 115));
				cboSelectorConversor.setUI(PropiedadPrincipalClara.createUI(rootPane));
				cboSelectorConversor.setRenderer(new ColorSelectedPriClaro());
				
				cboListaConversor1.setForeground(new Color(255,255,255));
				cboListaConversor1.setBackground(new Color(50, 50, 56));
				cboListaConversor1.setUI(PropiedadesSecundariasClara.createUI(rootPane));
				cboListaConversor1.setRenderer(new ColorSelectedSecuClara());
				
				cboListaConversor2.setForeground(new Color(255,255,255));
				cboListaConversor2.setBackground(new Color(50, 50, 56));
				cboListaConversor2.setUI(PropiedadesSecundariasClara.createUI(rootPane));
				cboListaConversor2.setRenderer(new ColorSelectedSecuClara());
				
				
				lblIndicacionesTipoConversor.setForeground(new Color(0, 9, 36));
				lblIndicacionesTipoDato1.setForeground(new Color(0, 9, 36));
				lblIndicacionesTipoDato2.setForeground(new Color(0, 9, 36));
			}
		});
		rdbtnmntmTemaClaro.setFont(new Font("Century Gothic", Font.BOLD, 12));
		rdbtnmntmTemaClaro.setIcon(new ImageIcon(logo.getImage().getScaledInstance(20,20,Image.SCALE_SMOOTH)));
		mnTema.add(rdbtnmntmTemaClaro);
		
		grupoTema= new ButtonGroup();
		grupoTema.add(rdbtnmntmTemaOscuro);
		grupoTema.add(rdbtnmntmTemaClaro);
		
		mnIdiomas = new JMenu("Idioma");
		mnIdiomas.setFont(new Font("Century Gothic", Font.BOLD, 12));
		mnInterfaz.add(mnIdiomas);
		
		rdbtnmntmEspañol = new JRadioButtonMenuItem("Español");
		rdbtnmntmEspañol.setFont(new Font("Century Gothic", Font.BOLD, 12));
		rdbtnmntmEspañol.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cboSelectorConversor.setModel(new DefaultComboBoxModel(new String[] { "--","Moneda","Temperatura", "Velocidad", "Tiempo", "Longitud"}));
				itemStateChanged(null);

				lblTituloConversor.setText("CONVERSOR - ALURA");
				lblResultado.setText("RESULTADO:");
				lblTipoConversor.setText("Tienes que elegir primero");
				lblIndicacionesTipoConversor.setText("Elija el tipo de conversor que va a usar.");
				textResultado.setBounds(215, 418, 306, 31);
				mnInterfaz.setText("Interfaz");
				mnIdiomas.setText("Idiomas");
				mnTema.setText("Temas");
				mnInicio.setText("Inicio");
				
				mntmConversorAlura.setText("Conversor");
				rdbtnmntmEspañol.setText("Español");
				rdbtnmntmIngles.setText("Ingles");
				rdbtnmntmTemaClaro.setText("Claro");
				rdbtnmntmTemaOscuro.setText("Oscuro");
				mnInformacion.setText("Información");
				mntmAcercaDe.setText("Acerca de");
				
			}
		});
		rdbtnmntmEspañol.setSelected(true);
		mnIdiomas.add(rdbtnmntmEspañol);
	
		
		rdbtnmntmIngles = new JRadioButtonMenuItem("Ingles");
		rdbtnmntmIngles.setFont(new Font("Century Gothic", Font.BOLD, 12));
		rdbtnmntmIngles.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				cboSelectorConversor.setModel(new DefaultComboBoxModel(new String[] {"--", "Currency","Temperature", "Velocity", "Time", "Length"}));
				itemStateChanged(null);
				lblTituloConversor.setText("CONVERTOR - ALURA");
				lblIndicacionesTipoConversor.setText("Choose the type of converter to use.");
				lblTipoConversor.setText("You must first choose");
				lblResultado.setText("RESULT:");
				lblResultado.setBounds(76, 418, 136, 31);
				textResultado.setBounds(160, 418, 390, 31);
				mnInterfaz.setText("Interface");
				mnIdiomas.setText("Languages");
				mnTema.setText("Themes");
				mnInicio.setText("Home");
				
				mntmConversorAlura.setText("Convertor");
				rdbtnmntmEspañol.setText("Espanish");
				rdbtnmntmIngles.setText("English");
				rdbtnmntmTemaClaro.setText("Light");
				rdbtnmntmTemaOscuro.setText("Dark");
				mnInformacion.setText("Information");
				mntmAcercaDe.setText("About");
				
			}
		});
		mnIdiomas.add(rdbtnmntmIngles);
		
		grupoIdioma= new ButtonGroup();
		grupoIdioma.add(rdbtnmntmEspañol);
		grupoIdioma.add(rdbtnmntmIngles);
		
		logo= new ImageIcon(getClass().getResource("/imgs/informacion.png"));
		mnInformacion = new JMenu("Información");
		mnInformacion.setFont(new Font("Century Gothic", Font.BOLD, 12));
		mnInformacion.setIcon(new ImageIcon(logo.getImage().getScaledInstance(20,20,Image.SCALE_SMOOTH)));
		menuBar.add(mnInformacion);
		
		mntmAcercaDe = new JMenuItem("Acerca de");
		mntmAcercaDe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Interfaz interfaz = new Interfaz();
				interfaz.setSize(626,511);
				interfaz.setLocation(0,0);
				
				contentConversor.removeAll();
				contentConversor.add(interfaz,BorderLayout.CENTER);
				contentConversor.revalidate();
				contentConversor.repaint();
				
			}
		});
		mntmAcercaDe.setFont(new Font("Century Gothic", Font.BOLD, 12));
		mnInformacion.add(mntmAcercaDe);
		

		lblFondo = new JLabel("");
		lblFondo.setForeground(new Color(4, 27, 56));
		lblFondo.setIcon(new ImageIcon(getClass().getResource("/imgs/interfazLong.png")));
		lblFondo.setBounds(0, 0, 626, 480);
		contenidoPanel.add(lblFondo);
		
		
        cboSelectorConversor.setSelectedIndex(0); 
        
        index = cboSelectorConversor.getSelectedIndex();
        datoBase = (String) cboListaConversor1.getSelectedItem();
        datoAConvertir = (String) cboListaConversor2.getSelectedItem();
        
        
        
        txtCuadroDato1.addActionListener(this);
        txtCuadroDato1.addFocusListener(new CustomFocusListener());

        txtCuadroDato2.addActionListener(this);
        txtCuadroDato2.addFocusListener(new CustomFocusListener());
        
        txtCuadroDato1.addKeyListener(new CustomKeyListener());
        txtCuadroDato2.addKeyListener(new CustomKeyListener());
	}


	// Clase interna para el FocusListener
    private class CustomFocusListener implements FocusListener {
        @Override
        public void focusGained(FocusEvent e) {
            // Al ganar el foco, seleccionar todo el contenido del JTextField
            JTextField textField = (JTextField) e.getComponent();
            SwingUtilities.invokeLater(textField::selectAll);
        }

        @Override
        public void focusLost(FocusEvent e) {
            realizarOperacion();
            if(txtCuadroDato1.getText().isEmpty()) {
				 txtCuadroDato1.setText("0.0");	 
			 }
        }
    }

   
    private class CustomKeyListener extends KeyAdapter {
        @Override
        public void keyReleased(KeyEvent e) {      
            realizarOperacion();
        }
    }

    private void inicializarConversor() {
    	
        conversorTipo = cboSelectorConversor.getSelectedIndex();
        
        switch (conversorTipo) {
        	
            case 1:
                conversor = new Moneda();
                break;
            case 2:
        		conversor = new Temperatura();
            break;
            case 3:
                conversor = new Velocidad();
                break;
            case 4:
                conversor = new Tiempo();
                break;
            case 5:
                conversor = new Longitud();
                break;
            default:
                conversor = null;
                break;
        }
    }

    
    private void realizarOperacion() {
        String datoBase = (String) cboListaConversor1.getSelectedItem();
        String datoAConvertir = (String) cboListaConversor2.getSelectedItem();
        String textoCuadroDato1 = txtCuadroDato1.getText();
        

        if (conversor == null || datoBase == null || datoAConvertir == null) {
            return;
        }

        try {
            double numero1 = Double.parseDouble(textoCuadroDato1);
            double resultado = conversor.convertir(datoBase, datoAConvertir, numero1);
            txtCuadroDato2.setText(String.valueOf(resultado));
            textResultado.setText(String.valueOf(resultado));
        } catch (NumberFormatException ex) {
            txtCuadroDato2.setText("0.0");
            textResultado.setText("0.0");
        }
    }
  

	public void itemStateChanged(ItemEvent e) {
		if (isProcessingSelection) {
            return; // Evitar procesar eventos múltiples mientras estamos en el proceso de selección aleatoria
        }
		
		conversorTipo=cboSelectorConversor.getSelectedIndex();
		conversorTipoText=cboSelectorConversor.getSelectedItem().toString();
		if (conversorTipoText=="--") {
			lblTipoConversor.setText("Tienes que elegir primero");
			lblIndicacionesTipoDato1.setText("");
			lblIndicacionesTipoDato2.setText("");
			txtCuadroDato1.setText("0.0");
			txtCuadroDato2.setText("0.0");
            textResultado.setText("0.0");
			cboListaConversor1.removeAllItems();
			cboListaConversor1.setModel(new DefaultComboBoxModel(new String[] {"--"}));
			cboListaConversor2.removeAllItems();
			cboListaConversor2.setModel(new DefaultComboBoxModel(new String[] {"--"}));
			
			}else if (conversorTipoText=="Temperatura") {
			lblTipoConversor.setText("TEMPERATURA");
			lblIndicacionesTipoDato1.setText("Elija tipo de grado. ");
			lblIndicacionesTipoDato2.setText("Grado a convertir. ");
			cboListaConversor1.removeAllItems();
			cboListaConversor1.setModel(new DefaultComboBoxModel(new String[] {"°Fahrenheit", "°Celsius", "°Kelvin"}));
			cboListaConversor2.removeAllItems();
			cboListaConversor2.setModel(new DefaultComboBoxModel(new String[] {"°Celsius", "°Fahrenheit", "°Kelvin"}));
			
			}else if (conversorTipoText=="Moneda") {
			lblTipoConversor.setText("MONEDA");
			lblIndicacionesTipoDato1.setText("Elija divisa. ");
			lblIndicacionesTipoDato2.setText("Divisa a convertir. ");
			cboListaConversor1.removeAllItems();
			cboListaConversor1.setModel(new DefaultComboBoxModel(new String[] {"Peso Colombiano","Dolar Estadounidense", "Euro", "Yen Japones","Won-Sur Coreano","Libra Esterlina"}));
			cboListaConversor2.removeAllItems();
			cboListaConversor2.setModel(new DefaultComboBoxModel(new String[] {"Dolar Estadounidense","Euro" , "Peso Colombiano", "Yen Japones","Won-Sur Coreano","Libra Esterlina"}));
			
			} else if (conversorTipoText=="Velocidad") {
			lblTipoConversor.setText("VELOCIDAD");
			lblIndicacionesTipoDato1.setText("Elija velocidad. ");
			lblIndicacionesTipoDato2.setText("Velocidad a convertir. ");
			cboListaConversor1.removeAllItems();
			cboListaConversor1.setModel(new DefaultComboBoxModel(new String[] {"Pie por segundo", "Milla por hora", "Metro por segundo", "Kilometros por hora","Nudo"}));
			cboListaConversor2.removeAllItems();
			cboListaConversor2.setModel(new DefaultComboBoxModel(new String[] {"Milla por hora", "Pie por segundo", "Metro por segundo", "Kilometros por hora","Nudo"}));
			}else if (conversorTipoText=="Tiempo") {
			lblTipoConversor.setText("TIEMPO");
			lblIndicacionesTipoDato1.setText("Elija tiempo. ");
			lblIndicacionesTipoDato2.setText("Tiempo a convertir. ");
			cboListaConversor1.removeAllItems();
			cboListaConversor1.setModel(new DefaultComboBoxModel(new String[] {"Segundo","Milisegundo", "Minuto", "Hora","Dia"}));
			cboListaConversor2.removeAllItems();
			cboListaConversor2.setModel(new DefaultComboBoxModel(new String[] {"Milisegundo", "Segundo", "Minuto", "Hora","Dia"}));
			}else if (conversorTipoText=="Longitud") {
			lblTipoConversor.setText("LONGITUD");
			lblIndicacionesTipoDato1.setText("Elija medida. ");
			lblIndicacionesTipoDato2.setText("Medida a convertir. ");
			cboListaConversor1.removeAllItems();
			cboListaConversor1.setModel(new DefaultComboBoxModel(new String[] {"Centimetro", "Milimetro", "Metro", "Kilometro"}));
			cboListaConversor2.removeAllItems();
			cboListaConversor2.setModel(new DefaultComboBoxModel(new String[] {"Milimetro", "Centimetro", "Metro", "Kilometro"}));
			}
		if (conversorTipoText=="Temperature") {
			lblTipoConversor.setText("TEMPERATURE");
			lblIndicacionesTipoDato1.setText("Choose grade type. ");
			lblIndicacionesTipoDato2.setText("Degree to converted. ");
			cboListaConversor1.removeAllItems();
			cboListaConversor1.setModel(new DefaultComboBoxModel(new String[] {"°Fahrenheit", "°Celsius", "°Kelvin"}));
			cboListaConversor2.removeAllItems();
			cboListaConversor2.setModel(new DefaultComboBoxModel(new String[] {"°Celsius", "°Fahrenheit", "°Kelvin"}));
			}else if (conversorTipoText=="Currency") {
			lblTipoConversor.setText("CURRENCY");
			lblIndicacionesTipoDato1.setText("Choose your currency. ");
			lblIndicacionesTipoDato2.setText("Currency to convert. ");
			cboListaConversor1.removeAllItems();
			cboListaConversor1.setModel(new DefaultComboBoxModel(new String[] {"Colombian peso","U.S. dollar", "Euro", "Japanese Yen","Won-South Korean","Pound Sterling"}));
			cboListaConversor2.removeAllItems();
			cboListaConversor2.setModel(new DefaultComboBoxModel(new String[] {"U.S. dollar","Euro" , "Colombian peso", "Japanese Yen","Won-South Korean","Pound Sterling"}));
			
			}  else if (conversorTipoText=="Velocity") {
			lblTipoConversor.setText("VELOCITY");
			lblIndicacionesTipoDato1.setText("Choose velocity. ");
			lblIndicacionesTipoDato2.setText("Velocity to converted.");
			cboListaConversor1.removeAllItems();
			cboListaConversor1.setModel(new DefaultComboBoxModel(new String[] {"Foot per second", "Miles per hour", "Meters per second", "Kilometers per hour","Knot"}));
			cboListaConversor2.removeAllItems();
			cboListaConversor2.setModel(new DefaultComboBoxModel(new String[] {"Miles per hour", "Foot per second", "Meters per second", "Kilometers per hour","Knot"}));
			}else if (conversorTipoText=="Time") {
			lblTipoConversor.setText("TIME");
			lblIndicacionesTipoDato1.setText("Choose time. ");
			lblIndicacionesTipoDato2.setText("Time to convert. ");
			cboListaConversor1.removeAllItems();
			cboListaConversor1.setModel(new DefaultComboBoxModel(new String[] {"Second","Millisecond", "Minute", "Hour","Day"}));
			cboListaConversor2.removeAllItems();
			cboListaConversor2.setModel(new DefaultComboBoxModel(new String[] {"Millisecond", "Second", "Minute", "Hour","Day"}));
			}else if (conversorTipoText=="Length") {
			lblTipoConversor.setText("LENGTH");
			lblIndicacionesTipoDato1.setText("Choose measurement. ");
			lblIndicacionesTipoDato2.setText("Measurement to converted.");
			cboListaConversor1.removeAllItems();
			cboListaConversor1.setModel(new DefaultComboBoxModel(new String[] {"Centimeter", "Milimeter", "Meter", "Kilometer"}));
			cboListaConversor2.removeAllItems();
			cboListaConversor2.setModel(new DefaultComboBoxModel(new String[] {"Milimeter", "Centimeter", "Meter", "Kilometer"}));
			}
		
		if (conversorTipoText != indexTexto) {
	        indexTexto = conversorTipoText;
	        inicializarConversor();
	        realizarOperacion();
	    }
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
	
		 	datoBase = (String) cboListaConversor1.getSelectedItem();
	        datoAConvertir = (String) cboListaConversor2.getSelectedItem();

	        if (datoBase != null && datoAConvertir != null && datoBase.equals(datoAConvertir)) {
	            isProcessingSelection = true;
	            
	            int aleatorio1 = random.nextInt(cboListaConversor1.getItemCount()-1); 
	            int index1 = cboListaConversor1.getSelectedIndex();
	            int newIndex1 = (index1 +aleatorio1) % cboListaConversor1.getItemCount();
	            

	            int aleatorio2 = random.nextInt(cboListaConversor2.getItemCount()+1);
	            int index2 = cboListaConversor2.getSelectedIndex();
	            int newIndex2 = (index2 + aleatorio2) % cboListaConversor2.getItemCount();
	            cboListaConversor1.setSelectedIndex(newIndex1);
	            cboListaConversor2.setSelectedIndex(newIndex2);


	            isProcessingSelection = false;
	            
	            if(datoBase!=datoAConvertir) {
	            	realizarOperacion();
	            	inicializarConversor();
	            }
	        }
	        
	        

	       
	    }
	}


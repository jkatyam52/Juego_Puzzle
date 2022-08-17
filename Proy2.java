import javax.swing.*;

public class Proy2 
{
	JFrame ventanaPrincipal;
	private JLabel lbl_presentacion;
	private JButton[] btn_botones;
	private JButton btn_iniciar;
	private JLabel lbl_movimientos, lbl_tiempo;
	private JTextField tf_movimientos, tf_tiempo;

	public static void main(String[] args) 
	{
		new Proy2();
	}

	Proy2()
	{	
		//CREACION DE LA VENTANA PRINCIPAL
		ventanaPrincipal = new JFrame("JUEGO DE ROMPECABEZA");
		ventanaPrincipal.setBounds(100,100,1000,715);
		ventanaPrincipal.setLayout(null);
		ventanaPrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//CREACION DE LA PRESENTACION
		lbl_presentacion = new JLabel("Universidad Tecnologica de Panama");
		lbl_presentacion.setBounds(200,160,300,20);
		ventanaPrincipal.add(lbl_presentacion);

		lbl_presentacion = new JLabel("Licenciatura Desarrollo de Software");
		lbl_presentacion.setBounds(200,180,300,20);
		ventanaPrincipal.add(lbl_presentacion);

		lbl_presentacion = new JLabel("Desarrollo de Software III");
		lbl_presentacion.setBounds(230,200,300,20);
		ventanaPrincipal.add(lbl_presentacion);

		lbl_presentacion = new JLabel("Proyecto 2 - Puzzle");
		lbl_presentacion.setBounds(235,230,300,20);
		ventanaPrincipal.add(lbl_presentacion);

		lbl_presentacion = new JLabel("Joseph Miranda");
		lbl_presentacion.setBounds(260,270,300,20);
		ventanaPrincipal.add(lbl_presentacion);

		lbl_presentacion = new JLabel("8-916-2401");
		lbl_presentacion.setBounds(265,290,300,20);
		ventanaPrincipal.add(lbl_presentacion);

		lbl_presentacion = new JLabel("1LS-221");
		lbl_presentacion.setBounds(272,320,300,20);
		ventanaPrincipal.add(lbl_presentacion);

		lbl_presentacion = new JLabel("03/04/2022");
		lbl_presentacion.setBounds(266,350,300,20);
		ventanaPrincipal.add(lbl_presentacion);
		
		//CREACION DE TEXTFIELD  MOVIMIENTOS
		tf_movimientos = new JTextField("0");
		tf_movimientos.setBounds(590,475,80,35);
		ventanaPrincipal.add(tf_movimientos);

		//CREACION DE TEXTFIELD TEMPORIZADOR
		tf_tiempo = new JTextField("0");
		tf_tiempo.setBounds(500,475,80,35);
		ventanaPrincipal.add(tf_tiempo);

		Puzzle obj = new Puzzle(tf_movimientos, tf_tiempo);

		//CREACION DE MATRIZ PARA EL ROMPECABEZA
		btn_botones = new JButton[16];

		for (int i=0; i<16; i++)
		{	
			btn_botones[i] = new JButton(String.valueOf(i+1));
			btn_botones[i].setBounds(500+65*(i%4),150+65*(i/4),60,60);
			btn_botones[i].addActionListener(obj);
			ventanaPrincipal.add(btn_botones[i]);
		}
		//btn_botones[15].setVisible(false);

		//CREACION DE BOTON INICIAR
		btn_iniciar = new JButton("Iniciar");
		btn_iniciar.setBounds(585,415,85,25);
		btn_iniciar.addActionListener(obj);
		ventanaPrincipal.add(btn_iniciar);

		obj.setBtn_botones(btn_botones, btn_iniciar);
		
		//CREACION DE LABEL MOVIMIENTOS
		lbl_movimientos = new JLabel("Movimientos");
		lbl_movimientos.setBounds(590,445,90,35);
		ventanaPrincipal.add(lbl_movimientos);

		//CREACION DE LABEL TEMPORIZADOR
		lbl_tiempo = new JLabel("Tiempo");
		lbl_tiempo.setBounds(500,445,60,35);
		ventanaPrincipal.add(lbl_tiempo);

		ventanaPrincipal.setVisible(true);
	}

}
import javax.swing.*;
import java.awt.event.*;
import java.util.Random;

public class Puzzle implements ActionListener {

    private JButton btn_iniciar, btn_temporal;
	private Random rnd;
    private int movimiento, tiempo, p=0;
    private JButton[] btn_botones;
    private JTextField tf_movimientos, tf_tiempo;
    
    Puzzle(JTextField tf_movimientos, JTextField tf_tiempo){
        this.tf_movimientos= tf_movimientos;
        this.tf_tiempo=tf_tiempo;
    }

    public void setBtn_botones(JButton[] btn_botones, JButton btn_iniciar) {
		this.btn_botones = btn_botones;
        this.btn_iniciar = btn_iniciar;
	}

	Timer timer1 = new Timer(500, new ActionListener()
	{
		public void actionPerformed(ActionEvent e)
		{
			tiempo = Integer.parseInt(tf_tiempo.getText());
			tf_tiempo.setText(String.valueOf(tiempo+1));
		}
	});

    Timer timer2 = new Timer(50, new ActionListener()
	{
		public void actionPerformed(ActionEvent e)
		{
			int x=0, y=0, dir=0;

			x= btn_temporal.getLocation().x;
			y= btn_temporal.getLocation().y;
			System.out.println("X="+x+" Y="+y);

			if (x == btn_botones[15].getLocation().x && y == btn_botones[15].getLocation().y)
			{	System.out.println("X="+btn_botones[15].getLocation().x+" Y="+btn_botones[15].getLocation().y+" Estoy aquí ");
				
				switch (p){
					case 1:
					btn_botones[15].setLocation(x-65,y);
					break;
					case 2:
					btn_botones[15].setLocation(x,y-65);
					break;
					case 3:
					btn_botones[15].setLocation(x+65,y);
					break;
					case 4:
					btn_botones[15].setLocation(x,y+65);
					break;
				}
				timer2.stop();

			}else if (x+dir <= btn_botones[15].getLocation().x && y+dir == btn_botones[15].getLocation().y ) 
			{	dir+=5;
				btn_temporal.setLocation(x+dir,y);
				p=1;
			}else if (y+dir <= btn_botones[15].getLocation().y && x+dir == btn_botones[15].getLocation().x)
			{	dir+=5;
				btn_temporal.setLocation(x,y+dir);
				p=2;
			}else if (x+dir >= btn_botones[15].getLocation().x && y+dir == btn_botones[15].getLocation().y ) 
			{	dir-=5;
				btn_temporal.setLocation(x+dir,y);
				p=3;
			}else if (y+dir >= btn_botones[15].getLocation().y && x+dir == btn_botones[15].getLocation().x)
			{	dir-=5;
				btn_temporal.setLocation(x,y+dir);
				p=4;
			}

		}
	});

	public void btn_comprobar(){
		
	}
	
    public void actionPerformed(ActionEvent e)
	{
		int x=0, y=0, z=0, nr=0;
		
		if (e.getSource() == btn_iniciar)
		{
			System.out.println("Iniciar");
            rnd = new Random();

			for (int i=0; i<15; i++)
			{
				z = rnd.nextInt(15);
				x = btn_botones[i].getLocation().x;
				y = btn_botones[i].getLocation().y;

				btn_botones[i].setLocation(btn_botones[z].getLocation().x,btn_botones[z].getLocation().y);
				btn_botones[z].setLocation(x,y);
			}
			
			timer1.start();

		}
		else if (e.getSource() != btn_iniciar && tiempo != 0)
		{
			btn_temporal = (JButton)e.getSource();
			nr=(btn_temporal.getLocation().x+btn_temporal.getLocation().y)-(btn_botones[15].getLocation().x+btn_botones[15].getLocation().y);
			System.out.println("NR= "+nr+" X="+btn_botones[15].getLocation().x+" Y="+btn_botones[15].getLocation().y+" Hola");

			if(nr==-65 || nr==65){				
				tf_movimientos.setText(String.valueOf(movimiento++));
				timer2.start();
			}else{
				timer2.stop();
			}

		}
	}
}
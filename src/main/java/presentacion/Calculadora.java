
package presentacion;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import logica.Calculos;

/**
 *
 * @author Estudiante
 */
public class Calculadora extends JFrame implements ActionListener{
    Calculos calculos;
    private boolean operador;
    private JLabel pantalla;
    private JButton JTeclado[][] = new JButton[4][4];
    private String disposicion[][] ={ 
        {"7","8","9","AC"},    
        {"4","5","6","-"},
        {"1","2","3","+"},
        {"x","0","=","/"}
    };

    public Calculadora(){
        this.calculos = new Calculos();
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("Calculadora POO");
        this.setSize(500,600);
        this.setLayout(new BorderLayout());
        this.pantalla = new JLabel("0",SwingConstants.RIGHT);
        this.pantalla.setFont(new Font("Arial",Font.BOLD,100));
        this.add(this.pantalla,BorderLayout.NORTH);
        JPanel pTeclado = new JPanel();
        pTeclado.setLayout(new GridLayout(4,4,10,10));
        this.add(pTeclado, BorderLayout.CENTER);
        
        for(int i=0; i<4; i++){
            for(int j=0; j<4;j++){
                this.JTeclado[i][j] = new JButton(this.disposicion[i][j]);
                pTeclado.add(this.JTeclado[i][j]);
                this.JTeclado[i][j].addActionListener(this);
            }
        }
        this.setVisible(true);
    }
    
    public static void main(String[] args) {
        new Calculadora();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton Oprimir = (JButton)e.getSource();		
		if(Oprimir.getText().equals(calculos.IGU)) {
			this.pantalla.setText(String.valueOf(this.calculos.operaciones()));
		}else if(Oprimir.getText().equals(Calculos.DEL)) {
			this.calculos.setNum1(0);
			this.calculos.setNum2(0);
			this.calculos.setOperacion("");
			this.pantalla.setText("0");
		}else if(Oprimir.getText().equals(Calculos.SUM) ||
				Oprimir.getText().equals(Calculos.RES) ||
				Oprimir.getText().equals(Calculos.MUL) ||
				Oprimir.getText().equals(Calculos.DIV) ) {
			this.calculos.setOperacion(Oprimir.getText());
			this.operador = true;
		}else {
			if(this.operador) {
				this.pantalla.setText("0");
				this.operador = false;
			}
			this.pantalla.setText(String.valueOf(Integer.parseInt(this.pantalla.getText())*10 + Integer.parseInt(Oprimir.getText())));
			if(this.calculos.getOperacion()== "") {
				this.calculos.setNum1(Integer.parseInt(this.pantalla.getText()));	
			}else {
				this.calculos.setNum2(Integer.parseInt(this.pantalla.getText()));
			}
			
		}

    }
    
 
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}

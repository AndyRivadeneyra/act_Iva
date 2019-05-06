import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class IvaCalcular extends JFrame implements ActionListener{
	private JLabel mensaje;
	private JLabel mensaje2;
	private JLabel mensaje3;
	private JButton boton;
	private JTextField caja;
	//private JTextField caja2;
	private JComboBox listaIva;
	public String selectIva;
	
	public IvaCalcular(){
		super();
		configurarVentana();
		crearComponente();
	}
	
	private void configurarVentana(){
		this.setTitle("Calculadora de IVA");
		this.setSize(350,250);
		this.setLocationRelativeTo(null);
		this.setLayout(null);
		this.setResizable(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	private void crearComponente(){
		mensaje = new JLabel();
		mensaje.setText("A CONTINUACION LE CALCULAREMOS SU IVA");
		mensaje.setBounds(35,0,300,50);
		mensaje.setForeground(Color.RED);
		this.add(mensaje);
		
		mensaje2 = new JLabel();
		mensaje2.setText("VALOR:");
		mensaje2.setBounds(140,35,150,30);
		mensaje2.setForeground(Color.BLACK);
		this.add(mensaje2);
		
		mensaje3 = new JLabel();
		mensaje3.setText("IVA:");
		mensaje3.setBounds(140,90,150,30);
		mensaje3.setForeground(Color.BLACK);
		this.add(mensaje3);
		
		caja = new JTextField();
		caja.setBounds(140,60,50,30);
		this.add(caja);
		
		/*caja2 = new JTextField();
		caja2.setBounds(140,120,50,30);
		this.add(caja2);*/
		
		String[] ivaList = new String[] {"Seleccione el IVA","16","8"}; 
		JComboBox<String> listaIva = new JComboBox<>(ivaList);
		listaIva.setBounds(100,120,150,30);
		listaIva.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				selectIva = listaIva.getItemAt(listaIva.getSelectedIndex());
			}
		});
		this.add(listaIva);
		
		boton = new JButton();
		boton.setText("CALCULAR");
		boton.setBounds(120,160,100,30);
		boton.addActionListener(this);
		this.add(boton);
	}
	
	@Override
	public void actionPerformed(ActionEvent e){
		double r1=Double.parseDouble(caja.getText());
		double r2=Double.parseDouble(selectIva);
		double calcularIva= (r1*r2)/100;
		double total = r1 + calcularIva;
		JOptionPane.showMessageDialog(this,"SU TOTAL CON IVA INCLUIDO: "+total);
	}
	
	public static void main(String[] args){
		IvaCalcular holi = new IvaCalcular();
		holi.setVisible(true);
	}
}

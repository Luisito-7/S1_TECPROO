package GB;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.awt.event.ActionEvent;
import java.util.List;      
import java.util.ArrayList;
import java.util.Map;

public class V1 extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JTextField txtCP;
	private JButton btnAP;
	private JScrollPane scrollPane;
	private JTextArea txtA;
	
	private List<ProdB> boletas = new ArrayList<>();
    private int numB = 10000001;
    private Map<String, Boleta> bl = new HashMap<>();
    private JLabel lblIngreseCantidadDe;
    private JTextField txtCant;
    private JButton btnGB;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					V1 frame = new V1();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public V1() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblNewLabel = new JLabel("Ingrese Codigo de Producto:");
		lblNewLabel.setFont(new Font("Yu Gothic", Font.BOLD, 10));
		lblNewLabel.setBounds(10, 14, 201, 13);
		contentPane.add(lblNewLabel);
		
		txtCP = new JTextField();
		txtCP.setBounds(157, 8, 96, 19);
		contentPane.add(txtCP);
		txtCP.setColumns(10);
		
		btnAP = new JButton("Agregar Producto");
		btnAP.addActionListener(this);
		btnAP.setBounds(282, 16, 113, 21);
		contentPane.add(btnAP);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 89, 416, 164);
		contentPane.add(scrollPane);
		
		txtA = new JTextArea();
		scrollPane.setViewportView(txtA);
		
		lblIngreseCantidadDe = new JLabel("Ingrese Cantidad de Producto:");
		lblIngreseCantidadDe.setFont(new Font("Yu Gothic", Font.BOLD, 10));
		lblIngreseCantidadDe.setBounds(10, 37, 201, 13);
		contentPane.add(lblIngreseCantidadDe);
		
		txtCant = new JTextField();
		txtCant.setBounds(157, 31, 96, 19);
		contentPane.add(txtCant);
		txtCant.setColumns(10);
		
		btnGB = new JButton("Generar Boleta");
		btnGB.addActionListener(this);
		btnGB.setBounds(282, 47, 113, 21);
		contentPane.add(btnGB);
		
		bl.put("001", new Boleta(001,"COCACOLA",3.5));
		bl.put("002", new Boleta(002,"INCAKOLA",3.5));
		bl.put("003", new Boleta(003,"OREO",1));
		bl.put("004", new Boleta(004,"KG DE FIDEOS",2));
		bl.put("005", new Boleta(005,"LATA DE ATÚN",4.5));
		bl.put("006", new Boleta(006,"PASTA DE TOMATE",1.5));

	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnGB) {
			do_btnGB_actionPerformed(e);
		}
		if (e.getSource() == btnAP) {
			do_btnAP_actionPerformed(e);
		}
	}
	protected void do_btnAP_actionPerformed(ActionEvent e) {
		String cod= txtCP.getText();
		double cant= Double.parseDouble(txtCant.getText());
		AP(cod,cant);
		txtA.setText("");
		
	}
	 private void AP(String cod, double cant) {
	        Boleta prod = bl.get(cod); 
	        if (prod != null) {
	        	ProdB pdb= new ProdB(prod,cant);
	            boletas.add(pdb);
	        } else {
	
	            txtA.append("Producto con el codigo " +cod+ " no existe\n");
	        }
	 }
	 private void listar() {
		 double total = 0;
		 txtA.append("==================================================================\n");
		 txtA.append("Numero de Boleta: "+numB+"\n");
		 txtA.append("==================================================================\n");
		 for (ProdB prb : boletas) {
			    txtA.append("Código: " + prb.getBl().getCod() + " | Producto: " + prb.getBl().getProd()+
	                    " | Cantidad: " + prb.getCant() + " | Precio: $" + prb.getBl().getPrecio() +
	                    " | Subtotal: $" + prb.total() + "\n"); 
			    total += prb.total();
			}
			txtA.append("Total: " + total + "\n");
			numB++;
	        boletas.clear();
		 
	 }

	protected void do_btnGB_actionPerformed(ActionEvent e) {
        listar();

	}
}

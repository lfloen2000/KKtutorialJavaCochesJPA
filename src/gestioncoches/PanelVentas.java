package gestioncoches;

import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import model.entities.Venta;
import model.entities.controllers.ControladorVentas;

public class PanelVentas extends JPanel {
	
Venta actual = new Venta();
	
	private JTextField jtfId;
	private JTextField jtfIdCliente;
	private JTextField jtfIdConcesionario;
	private JTextField jtfIdCoche;
	private JTextField jtfFecha;
	private JTextField jtfPrecioVenta;
	
public PanelVentas() {
		
//		try {
//			Class.forName("com.mysql.cj.jdbc.Driver");
//			conn = (Connection) DriverManager.getConnection ("jdbc:mysql://localhost/tutorialjavacoches?serverTimezone=UTC","java", "1234");
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}		
		
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lblNewLabel = new JLabel("Id:");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		add(lblNewLabel, gbc_lblNewLabel);
		
		jtfId = new JTextField();
		GridBagConstraints gbc_jtfId = new GridBagConstraints();
		gbc_jtfId.insets = new Insets(0, 0, 5, 0);
		gbc_jtfId.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfId.gridx = 1;
		gbc_jtfId.gridy = 0;
		add(jtfId, gbc_jtfId);
		jtfId.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("IdCliente:");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.fill = GridBagConstraints.VERTICAL;
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 1;
		add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		jtfIdCliente = new JTextField();
		GridBagConstraints gbc_jtfIdCliente = new GridBagConstraints();
		gbc_jtfIdCliente.insets = new Insets(0, 0, 5, 0);
		gbc_jtfIdCliente.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfIdCliente.gridx = 1;
		gbc_jtfIdCliente .gridy = 1;
		add(jtfIdCliente, gbc_jtfIdCliente);
		jtfIdCliente.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("IdConcesionario:");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 2;
		add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		jtfIdConcesionario = new JTextField();
		GridBagConstraints gbc_jtfIdConcesionario = new GridBagConstraints();
		gbc_jtfIdConcesionario.insets = new Insets(0, 0, 5, 0);
		gbc_jtfIdConcesionario.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfIdConcesionario.gridx = 1;
		gbc_jtfIdConcesionario.gridy = 2;
		add(jtfIdConcesionario, gbc_jtfIdConcesionario);
		jtfIdConcesionario.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("IdCoche:");
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.gridx = 0;
		gbc_lblNewLabel_3.gridy = 3;
		add(lblNewLabel_3, gbc_lblNewLabel_3);
		
		jtfIdCoche = new JTextField();
		GridBagConstraints gbc_jtfIdCoche = new GridBagConstraints();
		gbc_jtfIdCoche.insets = new Insets(0, 0, 5, 0);
		gbc_jtfIdCoche.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfIdCoche.gridx = 1;
		gbc_jtfIdCoche.gridy = 3;
		add(jtfIdCoche, gbc_jtfIdCoche);
		jtfIdCoche.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("fecha:");
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_4.gridx = 0;
		gbc_lblNewLabel_4.gridy = 4;
		add(lblNewLabel_4, gbc_lblNewLabel_4);
		
		jtfFecha = new JTextField();
		GridBagConstraints gbc_jtfFecha = new GridBagConstraints();
		gbc_jtfFecha.insets = new Insets(0, 0, 5, 0);
		gbc_jtfFecha.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfFecha.gridx = 1;
		gbc_jtfFecha.gridy = 4;
		add(jtfFecha, gbc_jtfFecha);
		jtfFecha.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("precioVenta:");
		GridBagConstraints gbc_lblNewLabel_5 = new GridBagConstraints();
		gbc_lblNewLabel_5.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_5.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_5.gridx = 0;
		gbc_lblNewLabel_5.gridy = 5;
		add(lblNewLabel_5, gbc_lblNewLabel_5);
		
		jtfPrecioVenta = new JTextField();
		GridBagConstraints gbc_jtfPrecioVenta = new GridBagConstraints();
		gbc_jtfPrecioVenta.insets = new Insets(0, 0, 5, 0);
		gbc_jtfPrecioVenta.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfPrecioVenta.gridx = 1;
		gbc_jtfPrecioVenta.gridy = 5;
		add(jtfPrecioVenta, gbc_jtfPrecioVenta);
		jtfPrecioVenta.setColumns(10);
		
		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.gridwidth = 2;
		gbc_panel.insets = new Insets(0, 0, 0, 5);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 7;
		add(panel, gbc_panel);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton btnPrimero = new JButton("<<");
		btnPrimero.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actual = ControladorVentas.getInstance().findPrimero();
				cargarActualEnPantalla();
			}
		});
		panel.add(btnPrimero);
		
		JButton btnAnterior = new JButton("<");
		btnAnterior.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actual = ControladorVentas.getInstance().findAnterior(actual.getId());
				cargarActualEnPantalla();
			}
		});
		panel.add(btnAnterior);
		
		JButton btnSiguiente = new JButton(">");
		btnSiguiente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actual = ControladorVentas.getInstance().findSiguiente(actual.getId());
				cargarActualEnPantalla();
			}
		});
		panel.add(btnSiguiente);
		
		JButton btnUltimo = new JButton(">>");
		btnUltimo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actual = ControladorVentas.getInstance().findUltimo();
				cargarActualEnPantalla();
			}
		});
		panel.add(btnUltimo);
		
		JButton btnGuardar = new JButton("Guardar");
		panel.add(btnGuardar);
		
		JButton btnNuevo = new JButton("Nuevo");
		panel.add(btnNuevo);
		
		JButton btnEliminar = new JButton("Eliminar");
		panel.add(btnEliminar);

		
		this.actual = ControladorVentas.getInstance().findPrimero();
		cargarActualEnPantalla();

	}
	
	
	/**
	 * 
	 */
	private void cargarActualEnPantalla() {
		if (this.actual != null) {
			this.jtfId.setText("" + this.actual.getId());
			this.jtfIdCliente.setText("" + this.actual.getId());
			this.jtfIdConcesionario.setText("" + this.actual.getId());
			this.jtfIdCoche.setText("" + this.actual.getId());
			this.jtfFecha.setText("" + this.actual.getFecha());
			this.jtfPrecioVenta.setText("" + this.actual.getPrecioVenta());
			
		}
	}

}

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

import model.entities.Concesionario;
import model.entities.controllers.ControladorConcesionario;

public class PanelConcesionarios extends JPanel{

Concesionario actual = new Concesionario();
	
	private JTextField jtfId;
	private JTextField jtfCif;
	private JTextField jtfNombre;
	private JTextField jtfLocalidad;
	
public PanelConcesionarios() {
		
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
		
		JLabel lblNewLabel_1 = new JLabel("cif:");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.fill = GridBagConstraints.VERTICAL;
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 1;
		add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		jtfCif = new JTextField();
		GridBagConstraints gbc_jtfCif = new GridBagConstraints();
		gbc_jtfCif.insets = new Insets(0, 0, 5, 0);
		gbc_jtfCif.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfCif.gridx = 1;
		gbc_jtfCif.gridy = 1;
		add(jtfCif, gbc_jtfCif);
		jtfCif.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Nombre:");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 2;
		add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		jtfNombre = new JTextField();
		GridBagConstraints gbc_jtfNombre = new GridBagConstraints();
		gbc_jtfNombre.insets = new Insets(0, 0, 5, 0);
		gbc_jtfNombre.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfNombre.gridx = 1;
		gbc_jtfNombre.gridy = 2;
		add(jtfNombre, gbc_jtfNombre);
		jtfCif.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Localidad:");
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.gridx = 0;
		gbc_lblNewLabel_3.gridy = 3;
		add(lblNewLabel_3, gbc_lblNewLabel_3);
		
		jtfLocalidad = new JTextField();
		GridBagConstraints gbc_jtfLocalidad = new GridBagConstraints();
		gbc_jtfLocalidad.insets = new Insets(0, 0, 5, 0);
		gbc_jtfLocalidad.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfLocalidad.gridx = 1;
		gbc_jtfLocalidad.gridy = 3;
		add(jtfLocalidad, gbc_jtfLocalidad);
		jtfLocalidad.setColumns(10);
		
		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.gridwidth = 2;
		gbc_panel.insets = new Insets(0, 0, 0, 5);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 4;
		add(panel, gbc_panel);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton btnPrimero = new JButton("<<");
		btnPrimero.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actual = ControladorConcesionario.getInstance().findPrimero();
				cargarActualEnPantalla();
			}
		});
		panel.add(btnPrimero);
		
		JButton btnAnterior = new JButton("<");
		btnAnterior.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actual = ControladorConcesionario.getInstance().findAnterior(actual.getId());
				cargarActualEnPantalla();
			}
		});
		panel.add(btnAnterior);
		
		JButton btnSiguiente = new JButton(">");
		btnSiguiente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actual = ControladorConcesionario.getInstance().findSiguiente(actual.getId());
				cargarActualEnPantalla();
			}
		});
		panel.add(btnSiguiente);
		
		JButton btnUltimo = new JButton(">>");
		btnUltimo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actual = ControladorConcesionario.getInstance().findUltimo();
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

		
		this.actual = ControladorConcesionario.getInstance().findPrimero();
		cargarActualEnPantalla();

	}
	
	
	/**
	 * 
	 */
	private void cargarActualEnPantalla() {
		if (this.actual != null) {
			this.jtfId.setText("" + this.actual.getId());
			this.jtfCif.setText(this.actual.getCif());
			this.jtfNombre.setText(this.actual.getNombre());
			this.jtfLocalidad.setText(this.actual.getLocalidad());
			
			
		}
	}
	
}

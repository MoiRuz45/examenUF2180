package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

import controlador.Controlador;
import modelo.Centro;
import modelo.Departamento;
import net.miginfocom.swing.MigLayout;

public class DialogoAnadirDepartamento extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtCod_departamento;
	private JTextField txtCod_centro;
	private JTextField txtTipo_dir;
	private JTextField txtPresupuesto;
	private JTextField txtNombre;
	private Controlador controlador;


	/**
	 * Create the dialog.
	 */
	public DialogoAnadirDepartamento() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new MigLayout("", "[grow]", "[grow]"));
		{
			JPanel panel = new JPanel();
			panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Detalles del centro", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
			((TitledBorder)  panel.getBorder()).setTitleFont(new Font("Tahoma", Font.PLAIN, 14));
			contentPanel.add(panel, "cell 0 0,grow");
			panel.setLayout(new MigLayout("", "[][][grow]", "[][][][][]"));
			{
				JLabel lblNewLabel_3 = new JLabel("");
				lblNewLabel_3.setIcon(new ImageIcon(DialogoAnadirCentro.class.getResource("/images/editar32.png")));
				panel.add(lblNewLabel_3, "cell 0 0 1 5");
			}
			{
				JLabel lblNewLabel = new JLabel("C\u00F3digo:");
				panel.add(lblNewLabel, "cell 1 0,alignx trailing");
				lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
			}
			{
				txtCod_departamento = new JTextField();
				panel.add(txtCod_centro, "cell 2 0,growx");
				txtCod_departamento.setFont(new Font("Tahoma", Font.PLAIN, 14));
				txtCod_departamento.setColumns(10);
			}
			{
				JLabel lblNewLabel_1 = new JLabel("Nombre:");
				panel.add(lblNewLabel_1, "cell 1 2,alignx trailing");
				lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
			}
			{
				txtCod_centro = new JTextField();
				panel.add(txtNombre, "cell 2 2,growx");
				txtCod_centro.setFont(new Font("Tahoma", Font.PLAIN, 14));
				txtCod_centro.setColumns(10);
			}
			{
				JLabel lblNewLabel_2 = new JLabel("Direcci\u00F3n:");
				panel.add(lblNewLabel_2, "cell 1 4,alignx trailing");
				lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
			}
			{
				txtTipo_dir = new JTextField();
				panel.add(txtTipo_dir, "cell 2 4,growx");
				txtTipo_dir.setFont(new Font("Tahoma", Font.PLAIN, 14));
				txtTipo_dir.setColumns(10);
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						recogerDatos();
					}
				});
				okButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);}
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						setVisible(false);
					}
				});
				cancelButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
				cancelButton.setActionCommand("Cancel");
				
			}
		}
	protected void recogerDatos() {
		int cod_departamento = Integer.parseInt(txtCod_departamento.getText());
		int cod_centro = Integer.parseInt(txtCod_centro.getText());
		String tipo_dir = txtTipo_dir.getText();
		int presupuesto = Integer.parseInt(txtPresupuesto.getText());
		String nombre = txtNombre.getText();
		Departamento departamento = new Departamento(cod_departamento,cod_centro, tipo_dir, presupuesto, nombre);
		controlador.insertarDepartamento(departamento);
		
	}
	public void setControlador(Controlador controlador) {
		this.controlador=controlador;
	}
}
/**
 * 
 */
package controlador;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import dao.CentroDAO;
import dao.DepartamentoDao;
import modelo.Centro;
import modelo.Departamento;
import vista.DialogoAnadirCentro;
import vista.DialogoAnadirDepartamento;
import vista.VentanaMostrarCentros;
import vista.VentanaMostrarDepartamentos;
import vista.VentanaPpal;

/**
 * @author David
 *
 */
public class Controlador {

	// Ventanas del sistema
	private VentanaPpal ventanaPpal;
	private VentanaMostrarCentros ventanaMostrarCentros;
	private DialogoAnadirCentro dialogoAnadirCentro;
	private DialogoAnadirDepartamento dialogoAnadirDepartamento;
	private VentanaMostrarDepartamentos ventanaMostrarDepartamento;
	
	// Objetos DAO o CRUD de la base de datos
	private CentroDAO centroDAO;
	private DepartamentoDao departamentoDao;
	private Controlador controlador;
	
	
	public Controlador() {
		// Creamos las ventanas de la aplicaci�n
		ventanaPpal = new VentanaPpal();
		ventanaMostrarCentros = new VentanaMostrarCentros();
		dialogoAnadirCentro = new DialogoAnadirCentro();
		ventanaMostrarDepartamento = new VentanaMostrarDepartamentos();
		dialogoAnadirDepartamento = new DialogoAnadirDepartamento();
		
		// Dando acceso al controlador desde las vistas
		ventanaPpal.setControlador(this);
		ventanaMostrarCentros.setControlador(this);
		dialogoAnadirCentro.setControlador(this);

		
		// Creamos los objetos DAO
		centroDAO = new CentroDAO();
		departamentoDao = new DepartamentoDao();
	}
	
	
	/**
	 * M�todo que arranca el programa principal
	 */
	public void inciarPrograma() {
		ventanaPpal.setVisible(true);
	}
	
	public void mostrarListarCentros() {
		ArrayList<Centro> lista = centroDAO.obtenerCentros();
		ventanaMostrarCentros.setListaCentros(lista);
		ventanaMostrarCentros.setVisible(true);
	}
	public void mostrarListarDepartamento() {
		ArrayList<Departamento> lista = departamentoDao.obtenerDepartamento();
		VentanaMostrarDepartamentos.setListaDepartamentos(lista);
		ventanaMostrarCentros.setVisible(true);
	}
	public void mostrarInsertarCentros() {
		dialogoAnadirCentro.setVisible(true);
	}
	public void mostrarInsertarDepartamento() {
		DialogoAnadirDepartamento dialogoAnadirDepartamento = new DialogoAnadirDepartamento();
		dialogoAnadirDepartamento.setVisible(true);
	}


	/** 
	 * M�todo del controlador que a�ade un nuevo centro a la tabla de centros
	 * @param centro
	 */
	public void insertaCentro(Centro centro) {
		// Invocando a centroDAO
		int resultado = centroDAO.insertarCentro(centro);
		if (resultado ==0) {
			JOptionPane.showMessageDialog(dialogoAnadirCentro, "Error. no se ha podido insertar.");
		} else {
			JOptionPane.showMessageDialog(dialogoAnadirCentro, "Insercion del centro correcta");
			dialogoAnadirCentro.setVisible(false);
		}
	}

	public void insertarDepartamento(Departamento departamento) {
		int resultado = departamentoDao.insertarDepartamento(departamento);
		if (resultado ==0) {
			JOptionPane.showMessageDialog(dialogoAnadirDepartamento, "Error. no se ha podido insertar el departamento.");
		} else {
			JOptionPane.showMessageDialog(dialogoAnadirDepartamento, "Insercion del departamento correcta");
			dialogoAnadirDepartamento.setVisible(false);
		}
	}
}

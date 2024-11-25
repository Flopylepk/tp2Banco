import java.util.LinkedList;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class Usuario {
	protected String nombre;
	protected String dni;
	protected String contrasena;
	private static LinkedList<Usuario> usuarios=new LinkedList<Usuario>();
	private static LinkedList<Cliente> clientes=new LinkedList<Cliente>();
	private static LinkedList<Admin> administradores=new LinkedList<Admin>();

	public Usuario(String nombre, String dni, String contrasena) {
		super();
		this.nombre = nombre;
		this.dni = dni;
		this.contrasena = contrasena;
	}

	public Usuario() {
		
	}
	public Usuario(String nombre,   String contrasena) {
		super();
		this.nombre = nombre;
		this.contrasena = contrasena;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDni() { 
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	public static LinkedList<Usuario> getUsuarios() {
		return usuarios;
	}

	public static void setUsuarios(LinkedList<Usuario> usuarios) {
		Usuario.usuarios = usuarios;
	}

	public static LinkedList<Cliente> getClientes() {
		return clientes;
	}

	public static void setClientes(LinkedList<Cliente> clientes) {
		Usuario.clientes = clientes;
	}

	public static LinkedList<Admin> getAdministradores() {
		return administradores;
	}

	public static void setAdministradores(LinkedList<Admin> administradores) {
		Usuario.administradores = administradores;
	}
	
	public boolean login(boolean a) {
	
		return true;
	}
	
	
	public static int validarNumeros(String mensaje) {
		boolean flag;
		String num = "";
		do {
			flag = true;
			num = JOptionPane.showInputDialog(mensaje);
			while (num.isEmpty()) {
				num = JOptionPane.showInputDialog(mensaje);
			}
			for (int i = 0; i < num.length(); i++) {
				if (!Character.isDigit(num.charAt(i))) {
					flag = false;
					break;
				}
			}
		} while (!flag);

		return Integer.parseInt(num);
	}

	public static String validarCaracteres(String mensaeje) {
		String palabra = "";
		while (palabra.equals("")) {
			palabra = JOptionPane.showInputDialog(mensaeje);
		}
		return palabra;
	}
	public static String validarDni(String mensaeje) {
		String palabra = "";
		boolean flag;
		do {
			flag=true;
			palabra = JOptionPane.showInputDialog(mensaeje);
			while (palabra.equals("")) {
			palabra = JOptionPane.showInputDialog("Error: "+mensaeje);
			}
			
			for (int i = 0; i < palabra.length(); i++) {
				if (!Character.isDigit(palabra.charAt(i))) {
					flag=false;
				}
					break;
				}
			if (palabra.length()<6) {
				JOptionPane.showMessageDialog(null, "El DNI debe ser de más de 6 digitos", "Error",
						JOptionPane.DEFAULT_OPTION,
						new ImageIcon(Gerente.class.getResource("/img/xd.png")));
				flag=false;
			}
		} while (!flag);
		
		return palabra;
	}

	@Override
	public String toString() {
		return "Usuario [nombre=" + nombre + ", dni=" + dni + ", contrasena=" + contrasena + "]";
	}

	
}

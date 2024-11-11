import java.util.LinkedList;

public class Usuario {
	private String nombre;
	private String dni;
	private String contrasena;
	private static LinkedList<Usuario> usuarios;
	private static LinkedList<Cliente> clientes;
	private static LinkedList<Admin> administradores;

	public Usuario(String nombre, String dni, String contrasena) {
		super();
		this.nombre = nombre;
		this.dni = dni;
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

	@Override
	public String toString() {
		return "Usuario [nombre=" + nombre + ", dni=" + dni + ", contrasena=" + contrasena + "]";
	}

}

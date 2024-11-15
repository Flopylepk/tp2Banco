import javax.swing.ImageIcon;
import javax.swing.JOptionPane;


public class Gerente extends Usuario {
	private Banco banco;

	public Gerente(String nombre, String dni, String contrasena, Banco banco) {
		super(nombre, dni, contrasena);
		this.banco = banco;
	}

	public Banco getBanco() {
		return banco;
	}

	public void setBanco(Banco banco) {
		this.banco = banco;
	}

	@Override
	public String toString() {
		return "Gerente [banco=" + banco + ", toString()=" + super.toString() + "] \n";
	}

	public void Registrarse() {
		Banco banco = new Banco("Santender");
		String nombre = validarCaracteres("Ingrese su nombre");
		String dni = validarDni("Ingrese su DNI");
		String contrasena = validarCaracteres("Ingrese su contraseña");
		this.nombre=nombre;
		this.dni=dni;
		this.contrasena=contrasena;
		Gerente gerente = new Gerente(nombre, dni, contrasena, banco);

		Usuario.getUsuarios().add(gerente);
	}

	public void RegistrarAdmin() {
		String nombre = validarCaracteres("Ingrese el nombre del administrador");
		String dni = validarDni("Ingrese el DNI del administrador");
		String contrasena = validarCaracteres("Ingrese la contraseña del administrador");
		int numero = (int) (Math.random() * 100);

		Admin admin = new Admin(nombre, dni, contrasena, numero);

		for (Usuario item : Usuario.getUsuarios()) {
			if (item.getNombre().equals(admin.getNombre()) && item.getDni().equals(admin.getDni())
					&& item.getContrasena().equals(admin.getContrasena())) {

				JOptionPane.showMessageDialog(null, "Ya existe ese usuario llamado: "+nombre, "Error",
						JOptionPane.DEFAULT_OPTION,
						new ImageIcon(Gerente.class.getResource("/img/xd.png")));
				return;
			}
		}
		for (Usuario item : Usuario.getAdministradores()) {
			if (item.getNombre().equals(admin.getNombre()) && item.getDni().equals(admin.getDni())
					&& item.getContrasena().equals(admin.getContrasena())) {

				JOptionPane.showMessageDialog(null, "Ya existe ese Admin llamado: "+nombre, "Error",
						JOptionPane.DEFAULT_OPTION,
						new ImageIcon(Gerente.class.getResource("/img/xd.png")));
				return;
			}
		}

		Usuario.getUsuarios().add(admin);
		Usuario.getAdministradores().add(admin);
	}
}

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
		return "Gerente [banco=" + banco + ", toString()=" + super.toString() + "]";
	}

	public void Registrarse() {
		Banco banco = new Banco("Santender");
		nombre = validarCaracteres("ingrese su nombre");
		dni = validarCaracteres("ingrese su dni");
		contrasena = validarCaracteres("ingrese su contraseña");

		Gerente gerente = new Gerente(nombre, dni, contrasena, banco);

		Usuario.getUsuarios().add(gerente);
	}

	public void RegistrarAdmin() {
		String nombre = validarCaracteres("ingrese el nombre del administrador");
		String dni = validarCaracteres("ingrese el dni del administrador");
		String contrasena = validarCaracteres("ingrese la contraseña del administrador");
		int numero = (int) (Math.random() * 100);

		Admin admin = new Admin(nombre, dni, contrasena, numero);

		for (Usuario item : Usuario.getUsuarios()) {
			if (item.getNombre().equals(admin.getNombre()) && item.getDni().equals(admin.getDni())
					&& item.getContrasena().equals(admin.getContrasena())) {

				JOptionPane.showMessageDialog(null, "Ya existe ese usuario");
				return;
			}
		}
		for (Usuario item : Usuario.getAdministradores()) {
			if (item.getNombre().equals(admin.getNombre()) && item.getDni().equals(admin.getDni())
					&& item.getContrasena().equals(admin.getContrasena())) {

				JOptionPane.showMessageDialog(null, "Ya existe ese Admin");
				return;
			}
		}

		Usuario.getUsuarios().add(admin);
		Usuario.getAdministradores().add(admin);
	}
}

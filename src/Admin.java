import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class Admin extends Usuario {
	private int NroAdmin;

	public Admin(String nombre, String dni, String contrasena, int nroAdmin) {
		super(nombre, dni, contrasena);
		NroAdmin = nroAdmin;
	}

	public Admin(String nombre, String contrasena, int nroAdmin) {
		super(nombre, contrasena);
		NroAdmin = nroAdmin;
	}
	public Admin() {
		super();
	
	}

	public int getNroAdmin() {
		return NroAdmin;
	}

	public void setNroAdmin(int nroAdmin) {
		NroAdmin = nroAdmin;

	}
	
	

	@Override
	public boolean login(boolean a) {
		String nombre = validarCaracteres("Ingrese el nombre del administrador:");
		String contrasena = validarCaracteres("Ingrese la contraseña:");
		int nroAdmin = validarNumeros("Ingrese el número de administrador:");

		Admin admin = new Admin(nombre, contrasena, nroAdmin);

		for (Admin adminExistente : Usuario.getAdministradores()) {
			if (adminExistente.getNombre().equalsIgnoreCase(admin.getNombre())
					&& adminExistente.getContrasena().equals(admin.getContrasena())
					&& adminExistente.getNroAdmin() == admin.getNroAdmin()) {
				JOptionPane.showMessageDialog(null, "Bienvenido " + admin.getNombre() + " su inicio de seción fue exitoso", "Correcto",
						JOptionPane.DEFAULT_OPTION,
						new ImageIcon(Admin.class.getResource("/img/log.png")));
				
				a = true;
				return a;
			}

		}
		JOptionPane.showMessageDialog(null, "Algo se ingreso incorrectamente", "Error",
				JOptionPane.DEFAULT_OPTION,
				new ImageIcon(Admin.class.getResource("/img/xd.png")));
		a = false;
		return a;
	}

	public void registrarCliente() {
		String nombre = validarCaracteres("Ingrese el nombre del cliente");
		String dni = validarDni("Ingrese el DNI del cliente");
		String contrasena = validarCaracteres("Ingrese la contraseña del cliente");
		String tipo = validarCaracteres("ingrese el tipo de cliente");
		int nrocuenta = (int) (Math.random() * 200);
		int saldo = validarNumeros("ingrese el saldo del cliente");
		String tarjeta = validarCaracteres("Ingrese la tarjeta del cliente");

		Cuenta cuenta = new Cuenta(nrocuenta, saldo, tarjeta);

		Cliente cliente = new Cliente(nombre, dni, contrasena, tipo, cuenta);

		for (Cliente clienteExistente : Usuario.getClientes()) {
			if (clienteExistente.getNombre().equalsIgnoreCase(cliente.getNombre())
					&& clienteExistente.getDni().equals(cliente.getDni())
					&& clienteExistente.getCuenta().getTarjeta().equals(cliente.getCuenta().getTarjeta())) {
				JOptionPane.showMessageDialog(null, "El cliente  " + cliente.getNombre() + " ya está registrado.", "Error",
						JOptionPane.DEFAULT_OPTION,
						new ImageIcon(Admin.class.getResource("/img/xd.png")));
				return;
			}
		}

		Usuario.getClientes().add(cliente);
		JOptionPane.showMessageDialog(null, "Cliente registrado exitosamente: " + cliente.getNombre(), "Correcto",
				JOptionPane.DEFAULT_OPTION,
				new ImageIcon(Admin.class.getResource("/img/ok.png")));

	}
	
	public void buscar() {
		String criterio=validarCaracteres("ingrese el nombre de la cuenta");
		for (Cliente elemento : Usuario.getClientes()) {
			 if (elemento.getNombre().equals(criterio)) {
					JOptionPane.showMessageDialog(null, elemento);
					return;
				}
			}
		JOptionPane.showMessageDialog(null, "Ese cliente no esta registrado", "Error",
				JOptionPane.DEFAULT_OPTION,
				new ImageIcon(Main.class.getResource("/img/xd.png")));
		return;
	}

	@Override
	public String toString() {
		return "Admin [NroAdmin=" + NroAdmin + ", toString()=" + super.toString() + "] \n";
	}

}

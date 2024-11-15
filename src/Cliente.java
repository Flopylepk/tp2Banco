
import java.time.LocalDateTime;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class Cliente extends Usuario {
	private String tipo;
	private Cuenta cuenta;

	public Cliente(String nombre, String dni, String contrasena, String tipo, Cuenta cuenta) {
		super(nombre, dni, contrasena);
		this.tipo = tipo;
		this.cuenta = cuenta;
	}
	public Cliente(String nombre, String contrasena) {
		super(nombre,contrasena);
	}
	public Cliente() {
		super();
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Cuenta getCuenta() {
		return cuenta;
	}

	public void setCuenta(Cuenta cuenta) {
		this.cuenta = cuenta;
	}

	@Override
	public String toString() {
		return "Cliente [tipo=" + tipo + ", cuenta=" + cuenta + ", toString()=" + super.toString() + "] \n";
	}
	
	@Override
	public boolean login(boolean a) {
		String nombre = validarCaracteres("Ingrese el nombre del administrador:");
		String contrasena = validarCaracteres("Ingrese la contraseña:");

		Cliente cliente = new Cliente(nombre, contrasena);

		for (Cliente clienteExistente : Usuario.getClientes()) {
			if (clienteExistente.getNombre().equalsIgnoreCase(cliente.getNombre())
					&& clienteExistente.getContrasena().equals(cliente.getContrasena())){
				this.nombre=nombre;
				this.contrasena=contrasena;
				JOptionPane.showMessageDialog(null, "Bienvenido " + cliente.getNombre() + " su inicio de secion fue exitoso", "Correcto",
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

	public void Transferir(){
		String detalles="";
		for (Cliente item : Usuario.getClientes()) {
			if (item.getNombre().equals(this.getNombre())
					&& item.getContrasena().equals(this.getContrasena())) {
				String nombre=validarCaracteres("ingrese el nombre del usuario");
				for (Cliente item2 : Usuario.getClientes()) {
					if (item.getNombre().equals(nombre)) {
						JOptionPane.showMessageDialog(null, "la transaccion es correcta", "Correcto",
								JOptionPane.DEFAULT_OPTION,
								new ImageIcon(Admin.class.getResource("/img/ok.png")));
						double monto=validarNumeros("ingrese el monto que quiere transferir");
						item.cuenta.setSaldo(item.cuenta.getSaldo()-monto);
						LocalDateTime hora=LocalDateTime.now();
						detalles= "Banco: Santender \n "
								+ "Monto: "+ monto+"\n "
								+"Operacion: Transferencia"
								+"Cuenta a transferir: "+item2.cuenta;
						Movimintos movimientos1= new Movimintos(hora,item,detalles);
						item.cuenta.getMovimientos().add(movimientos1);
						
						//cuenta2
						item2.cuenta.setSaldo(this.cuenta.getSaldo()-monto);
						LocalDateTime hora2=LocalDateTime.now();
						detalles= "Banco: Santender \n "
								+ "Monto: "+ monto+"\n "
								+"Operacion: Transferencia"
								+"Cuenta que transfirio: "+item.cuenta;
						Movimintos movimientos2= new Movimintos(hora2,item2,detalles);
						item2.cuenta.getMovimientos().add(movimientos2);
						
					}else {
						JOptionPane.showMessageDialog(null, "Ese cliente no fue registrado por el administrador", "Error",
								JOptionPane.DEFAULT_OPTION,
								new ImageIcon(Admin.class.getResource("/img/xd.png")));
					}
				}
			}
		}
	}
	
	public void Depositar(){
		String detalles="";
		
		for (Cliente item : Usuario.getClientes()) {
			if (item.getNombre().equals(this.getNombre())
					&& item.getContrasena().equals(this.getContrasena())) {
				
				double monto=validarNumeros("ingrese el monto que quiere retirar");
					JOptionPane.showMessageDialog(null, "la transaccion es correcta");
					item.cuenta.setSaldo(item.cuenta.getSaldo()+monto);
					LocalDateTime hora=LocalDateTime.now();
					detalles= "Banco: Santender \n "
							+ "Monto: "+ monto+"\n "
							+"Operacion: Deposito";
					Movimintos movimientos= new Movimintos(hora,item,detalles);
					item.cuenta.getMovimientos().add(movimientos);
			}
		}
	}
	public  void Retirar() {
		String detalles="";
		
		for (Cliente item : Usuario.getClientes()) {
			if (item.getNombre().equals(this.getNombre())
					&& item.getContrasena().equals(this.getContrasena())) {
				double monto=validarNumeros("ingrese el monto que quiere retirar");
				if (monto<item.cuenta.getSaldo()) {
					JOptionPane.showMessageDialog(null, "la transaccion es correcta");
					item.cuenta.setSaldo(item.cuenta.getSaldo()-monto);
					LocalDateTime hora=LocalDateTime.now();
					detalles= "Banco: Santender \n "
							+ "Monto: "+ monto+"\n "
							+"Operacion: Retiro";
					Movimintos movimientos= new Movimintos(hora,item,detalles);
					item.cuenta.getMovimientos().add(movimientos);
				} else {
					JOptionPane.showMessageDialog(null, "Usted no tiene el saldo suficiente", "Error",
							JOptionPane.DEFAULT_OPTION,
							new ImageIcon(Admin.class.getResource("/img/xd.png")));
				}
			}
		}	
	}
	
	public void Mostrar() {
		for (Cliente item : Usuario.getClientes()) {
			if (item.getNombre().equals(this.getNombre())
					&& item.getContrasena().equals(this.getContrasena())) {
				if (item.cuenta.getMovimientos().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Usted no tiene nada en los movimientos", "Error",
							JOptionPane.DEFAULT_OPTION,
							new ImageIcon(Admin.class.getResource("/img/xd.png")));
				} else {
					JOptionPane.showMessageDialog(null, item.cuenta.getMovimientos());
				}
			
			}
		}	
	}
}

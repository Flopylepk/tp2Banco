import javax.swing.JOptionPane;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Banco banco = new Banco("");
		Gerente gerente = new Gerente("", "", "", banco);
		Admin admin = new Admin();
		
		String[] menu = { "Gerente", "Admin", "Cliente", "Salir" };
		String[] opciones = { "Admin", "Cliente", "Completa" };
		String[] menug = { "Registrarse", "Registrar admin", "Ver usuarios", "Salir" };
		String[] menua = { "Loguearse", "Registrar Cliente","Ver Cliente" ,"Salir" };
		String[] menuc = { "Operaciones", "Ver Registro", "Ver operaciones", "Salir" };
		
		int opcion = 0;
		int opciong = 0;
		int opcionc = 0;
		int opciona = 0;
		int opcions = 0;
		
		boolean ad=false;

		do {
			opcion = JOptionPane.showOptionDialog(null, "¿Elija una opción?", null, 0, 0, null, menu, menu[0]);
			switch (opcion) {
			case 0:
				do {
					opciong = JOptionPane.showOptionDialog(null, "¿Elija una opción?", null, 0, 0, null, menug,
							menug[0]);
					switch (opciong) {
					case 0:
						if (gerente.getNombre().isEmpty()) {
							gerente.Registrarse();
						} else {
							JOptionPane.showMessageDialog(null, "Usted ya se registró");
						}
						break;
					case 1:
						if (gerente.getNombre().isEmpty()) {
							JOptionPane.showMessageDialog(null, "Usted no se registró");
						} else {
							gerente.RegistrarAdmin();
						}
						break;
					case 2:
						if (gerente.getNombre().isEmpty()) {
							JOptionPane.showMessageDialog(null, "Usted no se registró");
						} else {
							opcions = JOptionPane.showOptionDialog(null, "¿Qué le gustaría ver?", null, 0, 0, null, opciones,
									opciones);
							switch (opcions) {
							case 0:
								if (Usuario.getAdministradores().isEmpty()) {
									JOptionPane.showMessageDialog(null, "No hay administradores");
								} else {
									JOptionPane.showMessageDialog(null, Usuario.getAdministradores());
								}
								break;
							case 1:
								if (Usuario.getClientes().isEmpty()) {
									JOptionPane.showMessageDialog(null, "No hay clientes");
								} else {
									JOptionPane.showMessageDialog(null, Usuario.getClientes());
								}
								break;
							case 2:
								if (Usuario.getUsuarios().isEmpty()) {
									JOptionPane.showMessageDialog(null, "No hay usuarios");
								} else {
									JOptionPane.showMessageDialog(null, Usuario.getUsuarios());
								}
								break;

							}
						}
						break;

					case 3:
						JOptionPane.showMessageDialog(null, "Nos vemos la proxima");
						break;
						
					}
				} while (opciong!=3);
				break;

			case 1:
				do {
					opciona = JOptionPane.showOptionDialog(null, "¿Elija una opción?", null, 0, 0, null, menua,
							menua[0]);
					switch (opciona) {
					case 0:
						if (ad==false) {
							ad=admin.login(ad);
						}else {
							JOptionPane.showMessageDialog(null, "Ya te logueaste");
						}
						
						break;
					case 1:
						if (ad==false) {
							JOptionPane.showMessageDialog(null, "Usted debe loguerse primero");
						} else {
							admin.registrarCliente();
						}
						break;
					case 2:
						if (ad==false) {
							JOptionPane.showMessageDialog(null, "Usted debe loguerse primero");
						} else {
							if (Usuario.getClientes().isEmpty()) {
								JOptionPane.showMessageDialog(null, "No hay clientes registrados");
							} else {
								JOptionPane.showMessageDialog(null, Usuario.getClientes());
							}
						}
						break;
					case 3:
						JOptionPane.showMessageDialog(null, "Nos vemos la proxima");
						break;
						
					
					}
				} while (opciona!=3);
				break;
			case 2:
				JOptionPane.showMessageDialog(null, "Cliente");
				break;
			case 3:
				JOptionPane.showMessageDialog(null, "Nos vemos pronto");
				break;

			
			}
		} while (opcion != 3);
				
		
	}
}

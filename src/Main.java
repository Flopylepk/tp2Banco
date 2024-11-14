import javax.swing.JOptionPane;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Banco banco = new Banco("");
		Gerente gerente = new Gerente("", "", "", banco);
		String[] menu = { "Gerente", "Admin", "Cliente", "Salir" };
		String[] opciones = { "Admin", "Cliente", "Completa" };
		String[] menug = { "Registrarse", "Registrar admin", "Ver usuarios", "Salir" };
		String[] menuc = { "Operaciones", "Ver Registro", "Ver operaciones", "Salir" };
		String[] menua = { "Registrar Cliente", "Ver registro", "Salir" };
		
		int opcion = 0;
		int opciong = 0;
		int opcionc = 0;
		int opciona = 0;
		int opcions = 0;

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
							JOptionPane.showMessageDialog(null, "usted ya se registro");
						}
						break;
					case 1:
						if (gerente.getNombre().isEmpty()) {
							JOptionPane.showMessageDialog(null, "usted no se registro");
						} else {
							gerente.RegistrarAdmin();
						}
						break;
					case 2:
						if (gerente.getNombre().isEmpty()) {
							JOptionPane.showMessageDialog(null, "usted no se registro");
						} else {
							opcions = JOptionPane.showOptionDialog(null, "¿Qué qioere ver?", null, 0, 0, null, opciones,
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
									JOptionPane.showMessageDialog(null, "No hay Clientes");
								} else {
									JOptionPane.showMessageDialog(null, Usuario.getClientes());
								}
								break;
							case 2:
								if (Usuario.getUsuarios().isEmpty()) {
									JOptionPane.showMessageDialog(null, "No hay Usuarios");
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
				JOptionPane.showMessageDialog(null, "Admin");
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

import javax.swing.JOptionPane;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Banco banco = new Banco("");
		Gerente gerente = new Gerente("", "", "", banco);
		String[] menu = { "Gerente", "Admin", "Cliente", "Salir" };
		String[] opciones = {"Admin", "Cliente", "Completa" };
		String[] menug = { "Registrarse", "Registrar admin", "ver usuarios", "Salir" };
		String[] menuc = { "Operaciones", "Ver Registro", "Ver operaciones", "Salir" };
		String[] menua = { "Registrar Cliente", "Ver registro", "Salir" };
		int opcion = 0;
		int opciong = 0;
		int opcionc = 0;
		int opciona = 0;

		do {
			opcion = JOptionPane.showOptionDialog(null, "¿Elija una opción?", null, 0, 0, null, menu, menu[0]);

			switch (opcion) {
			case 0:
				opciong = JOptionPane.showOptionDialog(null, "¿Elija una opción?", null, 0, 0, null, menug, menug[0]);
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
						
					}
					break;

				case 3:
					JOptionPane.showMessageDialog(null, "Nos vemos la proxima");
					break;
				}
				break;
			case 1:

				break;
			case 2:

				break;
			case 3:
				JOptionPane.showMessageDialog(null, "Nos vemos pronto");
				break;

			}

		} while (opcion != 3);

	}

}

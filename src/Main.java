import javax.swing.JOptionPane;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Admin admin=new Admin("","","",0);
		String[] menu = { "Gerente", "Admin", "Cliente", "Salir" };
		String[] menuc = { "Operaciones", "Ver Registro", "Ver operaciones", "Salir" };
		String[] menua = { "Loguearse", "Registrar Cliente","Ver clientes" ,"Salir" };

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
							JOptionPane.showMessageDialog(null, Usuario.getClientes());
						}
						break;

					case 3:
						JOptionPane.showMessageDialog(null, "Nos vemos la proxima");
						break;

					}
				} while (opciong != 3);
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

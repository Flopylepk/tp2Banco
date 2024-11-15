import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Banco banco = new Banco("");
		Gerente gerente = new Gerente("", "", "", banco);
		Admin admin = new Admin();
		Cliente cliente = new Cliente();

		String[] menu = { "Gerente", "Admin", "Cliente", "Salir" };
		String[] opciones = { "Admin", "Cliente", "Completa" };
		String[] menug = { "Registrarse", "Registrar admin", "Ver usuarios", "Salir" };
		String[] menua = { "Registrar Cliente", "Ver Cliente", "Salir" };
		String[] menuc = { "Operaciones", "Ver operaciones", "Salir" };

		int opcion = 0;
		int opciong = 0;
		int opcionc = 0;
		int opciona = 0;
		int opcions = 0;
		int opciono = 0;

		boolean ad = false;
		boolean cl = false;

		do {
			opcion = JOptionPane.showOptionDialog(null, "¿Elija una opción?", "Menú", JOptionPane.DEFAULT_OPTION, 0,
					new ImageIcon(Main.class.getResource("/img/santan.png")), menu, menu[0]);
			switch (opcion) {
			case 0:
				do {
					opciong = JOptionPane.showOptionDialog(null, "¿Elija una opción?", "Menú gerente",
							JOptionPane.DEFAULT_OPTION, 0, new ImageIcon(Main.class.getResource("/img/gere.png")),
							menug, menug[0]);
					switch (opciong) {
					case 0:
						if (gerente.getNombre().isEmpty()) {
							gerente.Registrarse();
						} else {
							JOptionPane.showMessageDialog(null, "Usted ya se registró", "Error",
									JOptionPane.DEFAULT_OPTION, new ImageIcon(Main.class.getResource("/img/xd.png")));
						}
						break;
					case 1:
						if (gerente.getNombre().isEmpty()) {
							JOptionPane.showMessageDialog(null, "Usted no se registró", "Error",
									JOptionPane.DEFAULT_OPTION, new ImageIcon(Main.class.getResource("/img/xd.png")));
						} else {
							gerente.RegistrarAdmin();
						}
						break;
					case 2:
						if (gerente.getNombre().isEmpty()) {
							JOptionPane.showMessageDialog(null, "Usted no se registró", "Error",
									JOptionPane.DEFAULT_OPTION, new ImageIcon(Main.class.getResource("/img/xd.png")));
						} else {
							opcions = JOptionPane.showOptionDialog(null, "¿Qué le gustaría ver?", "Menú gerente",
									JOptionPane.DEFAULT_OPTION, 0,
									new ImageIcon(Main.class.getResource("/img/gere.png")), opciones, opciones);
							switch (opcions) {
							case 0:
								if (Usuario.getAdministradores().isEmpty()) {
									JOptionPane.showMessageDialog(null, "No hay administradores", "Error",
											JOptionPane.DEFAULT_OPTION,
											new ImageIcon(Main.class.getResource("/img/xd.png")));
								} else {
									JOptionPane.showMessageDialog(null, Usuario.getAdministradores());
								}
								break;
							case 1:
								if (Usuario.getClientes().isEmpty()) {
									JOptionPane.showMessageDialog(null, "No hay clientes", "Error",
											JOptionPane.DEFAULT_OPTION,
											new ImageIcon(Main.class.getResource("/img/xd.png")));
								} else {
									JOptionPane.showMessageDialog(null, Usuario.getClientes());
								}
								break;
							case 2:
								if (Usuario.getUsuarios().isEmpty()) {
									JOptionPane.showMessageDialog(null, "No hay usuarios", "Error",
											JOptionPane.DEFAULT_OPTION,
											new ImageIcon(Main.class.getResource("/img/xd.png")));
								} else {
									JOptionPane.showMessageDialog(null, Usuario.getUsuarios());
								}
								break;

							}
						}
						break;

					case 3:
						JOptionPane.showMessageDialog(null, "Nos vemos la proxima", "Salida",
								JOptionPane.DEFAULT_OPTION, new ImageIcon(Admin.class.getResource("/img/chau.png")));
						break;

					}
				} while (opciong != 3);
				break;

			case 1:
				ad = admin.login(ad);
				if (ad == false) {
					JOptionPane.showMessageDialog(null, "el logueo fue erroneo", "Error", JOptionPane.DEFAULT_OPTION,
							new ImageIcon(Main.class.getResource("/img/xd.png")));
				} else {
					do {
						opciona = JOptionPane.showOptionDialog(null, "¿Elija una opción?", "Menú administrador",
								JOptionPane.DEFAULT_OPTION, 0, new ImageIcon(Main.class.getResource("/img/adm.png")),
								menua, menua[0]);
						switch (opciona) {
						case 0:
							if (ad == false) {
								JOptionPane.showMessageDialog(null, "Usted debe loguerse primero", "Error",
										JOptionPane.DEFAULT_OPTION,
										new ImageIcon(Main.class.getResource("/img/xd.png")));
							} else {
								admin.registrarCliente();
							}
							break;
						case 1:
							if (ad == false) {
								JOptionPane.showMessageDialog(null, "Usted debe loguerse primero", "Error",
										JOptionPane.DEFAULT_OPTION,
										new ImageIcon(Main.class.getResource("/img/xd.png")));
							} else {
								if (Usuario.getClientes().isEmpty()) {
									JOptionPane.showMessageDialog(null, "No hay clientes registrados", "Error",
											JOptionPane.DEFAULT_OPTION,
											new ImageIcon(Main.class.getResource("/img/xd.png")));
								} else {
									JOptionPane.showMessageDialog(null, Usuario.getClientes());
								}
							}
							break;
						case 2:
							JOptionPane.showMessageDialog(null, "Nos vemos la proxima", "Salida",
									JOptionPane.DEFAULT_OPTION, new ImageIcon(Admin.class.getResource("/img/chau.png")));
							break;

						}
					} while (opciona != 2);
				}

				break;
			case 2:
				cl = cliente.login(cl);
				if (cl == false) {
					JOptionPane.showMessageDialog(null, "el logueo fue erroneo", "Error", JOptionPane.DEFAULT_OPTION,
							new ImageIcon(Main.class.getResource("/img/xd.png")));
				} else {
					do {
						
					
					opcionc = JOptionPane.showOptionDialog(null, "Elija la opcion que quiere realizar", "Menú cliente",
							JOptionPane.DEFAULT_OPTION, 0, new ImageIcon(Main.class.getResource("/img/clie.png")),
							menuc, menuc[0]);
					switch (opcionc) {
					case 0:
						opciono = JOptionPane.showOptionDialog(null, "Elija que operacion quiere hacer", "Operaciones",
								JOptionPane.DEFAULT_OPTION, 0, new ImageIcon(Main.class.getResource("/img/opera.png")),
								Opciones.values(), Opciones.values());
						switch (opciono) {
						case 0:
							cliente.Transferir();
							break;
						case 1:
							cliente.Depositar();
							break;
						case 2:
							cliente.Retirar();
							break;

						}
						break;
					case 1:
						cliente.Mostrar();
						break;
					case 2:

						JOptionPane.showMessageDialog(null, "Nos vemos la proxima", "Salida",
								JOptionPane.DEFAULT_OPTION, new ImageIcon(Admin.class.getResource("/img/chau.png")));
						break;

					}
					} while (opcionc!=2);
				}
				break;
			case 3:
				JOptionPane.showMessageDialog(null, "Nos vemos la proxima", "Salida",
						JOptionPane.DEFAULT_OPTION, new ImageIcon(Admin.class.getResource("/img/chau.png")));

			}
		} while (opcion != 3);

	}
}

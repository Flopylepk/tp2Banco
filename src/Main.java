import javax.swing.JOptionPane;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Banco banco=new Banco("");
		Gerente gerente=new Gerente("","","",banco);
		String[] menu= {"Gerente","Admin","Cliente","Salir"};
		String[] menug= {"Registrarse","ver registro","Registrar admin","Salir"};
		String[] menuc= {"Operaciones","Ver Registro","Ver operaciones","Salir"};
		String[] menua= {"Registrar Cliente","Ver registro","Salir"};
		int opcion=0;
		
		do {
			opcion=JOptionPane.showOptionDialog(null, "¿Elija una opción?", null, 0, 0, null, menu, menu[0]);
			
			switch (opcion) {
			case 0:
				
				break;
			case 1:
				
				break;
			case 2:
				
				break;
			case 3:
				JOptionPane.showMessageDialog(null, "Nos vemos pronto");
				break;
			
			}
			
		} while (opcion!=3);
		
		
	}

}

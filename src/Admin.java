import javax.swing.JOptionPane;

public class Admin extends Usuario {
	private int NroAdmin;

	public Admin(String nombre, String dni, String contrasena, int nroAdmin) {
		super(nombre, dni, contrasena);
		NroAdmin = nroAdmin;
	}

	public int getNroAdmin() {
		return NroAdmin;
	}

	public void setNroAdmin(int nroAdmin) {
		NroAdmin = nroAdmin;
	}
	public static Admin login() {
        String nombre = JOptionPane.showInputDialog("Ingrese el nombre del administrador:");
        String dni = JOptionPane.showInputDialog("Ingrese el DNI del administrador:");
        String contrasena = JOptionPane.showInputDialog("Ingrese la contraseña del administrador:");
        int nroAdmin = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el número de administrador:"));
        
        Admin admin = new Admin(nombre, dni, contrasena, nroAdmin);     
        return admin;
        
	}
        
	
	
	
	
	

	@Override
	public String toString() {
		return "Admin [NroAdmin=" + NroAdmin + ", toString()=" + super.toString() + "]";
	}

}

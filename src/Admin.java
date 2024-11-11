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
        String nombre =  validarCaracteres(JOptionPane.showInputDialog("Ingrese el nombre del administrador:"));
        String dni =  validarCaracteres(JOptionPane.showInputDialog("Ingrese el DNI:"));
        String contrasena = validarCaracteres(JOptionPane.showInputDialog("Ingrese la contraseña:")) ;
        int nroAdmin = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el número de administrador:")) ;
        
        Admin admin = new Admin(nombre, dni, contrasena, nroAdmin);  
        Usuario.getAdministradores().add(admin);
        
        return admin;
        
	}
	
        
	
	
	
	
	

	@Override
	public String toString() {
		return "Admin [NroAdmin=" + NroAdmin + ", toString()=" + super.toString() + "]";
	}

}

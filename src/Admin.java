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
        int nroAdmin = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el número de administrador:"));
        
        Admin admin = new Admin(nombre, dni, contrasena, nroAdmin);  
        Usuario.getAdministradores().add(admin);
        
        return admin;
        
	}
	  public void registrarCliente() {
	        String nombre =validarCaracteres(JOptionPane.showInputDialog("Ingrese el nombre del cliente:")) ;
	        String dni = validarCaracteres(JOptionPane.showInputDialog("Ingrese el DNI del cliente:"));
	        String contrasena = validarCaracteres(JOptionPane.showInputDialog("Ingrese la contraseña del cliente:"));
	        String tipo = validarCaracteres(JOptionPane.showInputDialog("ingrese el tipo de cliente"));


	        Cliente cliente = new Cliente(nombre, dni, contrasena, tipo, null);


	        for (Cliente clienteExistente : Usuario.getClientes()) {
	            if (clienteExistente.getNombre().equalsIgnoreCase(cliente.getNombre()) && clienteExistente.getDni().equals(cliente.getDni())) {
	                JOptionPane.showMessageDialog(null, "El cliente  " + cliente.getNombre() + " ya está registrado.");
	                return;
	            }
	        } 
				
	        Usuario.getClientes().add(cliente);
	        JOptionPane.showMessageDialog(null, "Cliente registrado exitosamente: " + cliente.getNombre());
			


	    }
	
	
        
	
	
	
	
	

	@Override
	public String toString() {
		return "Admin [NroAdmin=" + NroAdmin + ", toString()=" + super.toString() + "]";
	}

}

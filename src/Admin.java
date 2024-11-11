
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

	@Override
	public String toString() {
		return "Admin [NroAdmin=" + NroAdmin + ", toString()=" + super.toString() + "]";
	}

}

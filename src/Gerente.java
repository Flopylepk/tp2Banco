
public class Gerente extends Usuario{
	private Banco banco;

	public Gerente(String nombre, String dni, String contrasena, Banco banco) {
		super(nombre, dni, contrasena);
		this.banco = banco;
	}

	public Banco getBanco() {
		return banco;
	}

	public void setBanco(Banco banco) {
		this.banco = banco;
	}

	@Override
	public String toString() {
		return "Gerente [banco=" + banco + ", toString()=" + super.toString() + "]";
	}

	
}

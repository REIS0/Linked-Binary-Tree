package aor;

public class Position {
	
	protected int elemento;
	protected Position pai;
	protected Position filho_esquerdo;
	protected Position filho_direito;
	
	public Position(int elemento) {
		this.elemento = elemento;
	}
	
}

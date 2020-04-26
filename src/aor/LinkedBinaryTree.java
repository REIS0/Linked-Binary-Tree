package aor;

import java.util.List;
import java.util.ArrayList;

public class LinkedBinaryTree {

	private Position raiz;
	private int tamanho;

	public LinkedBinaryTree() {
		tamanho = 0;
	}

	public Position getRaiz() {
		return raiz;
	}

	public int getTamanho() {
		return tamanho;
	}

	public void addRoot(int i) {
		Position position = new Position(i);
		this.raiz = position;
		tamanho = 1;
	}

	public void insertRight(Position v, int i) {
		Position novo = new Position(i);
		if (v.filho_direito == null) {
			v.filho_direito = novo;
			novo.pai = v;
			tamanho++;
		} else {
			System.out.println("Esse no ja tem um filho direito.");
		}
	}

	public void insertLeft(Position v, int i) {
		Position novo = new Position(i);
		if (v.filho_esquerdo == null) {
			v.filho_esquerdo = novo;
			novo.pai = v;
			tamanho++;
		} else {
			System.out.println("Esse no ja tem um filho esquerdo");
		}
	}

	public boolean isEmpty() {
		return (raiz == null ? true : false);
	}

	public boolean isInternal(Position v) {
		if (v.filho_direito != null || v.filho_esquerdo != null) {
			return true;
		} else {
			return false;
		}
	}

	public boolean isExternal(Position v) {
		if (v.filho_direito == null || v.filho_esquerdo == null) {
			return true;
		} else {
			return false;
		}
	}

	public boolean isRoot(Position v) {
		if (v.pai == null) {
			return true;
		} else {
			return false;
		}
	}

	public boolean hasLeft(Position v) {
		if (v.filho_esquerdo != null) {
			return true;
		} else {
			return false;
		}
	}

	public boolean hasRight(Position v) {
		if (v.filho_direito != null) {
			return true;
		} else {
			return false;
		}
	}

	public Position left(Position v) {
		if (hasLeft(v)) {
			return v.filho_esquerdo;
		} else {
			System.out.println("Nao tem filho esquerdo.");
			return null;
		}
	}

	public Position right(Position v) {
		if (hasRight(v)) {
			return v.filho_direito;
		} else {
			System.out.println("Nao tem filho direito.");
			return null;
		}
	}

	public Position parent(Position v) {
		if (!isRoot(v)) {
			return v.pai;
		} else {
			System.out.println("Esse e o no raiz.");
			return null;
		}
	}

	public List<Position> children(Position v) {
		if (hasLeft(v) && hasRight(v)) {
			List<Position> lista = new ArrayList<Position>();
			lista.add(v.filho_esquerdo);
			lista.add(v.filho_direito);
			return lista;
		} else {
			System.out.println("Esse no nao tem filhos");
			return null;
		}
	}

	public String toStringPreOrder() {
		return preOrder(raiz);
	}

	private String preOrder(Position v) {
		String retorno = "";
		retorno = retorno + v.elemento;
		if (hasLeft(v)) {
			retorno = retorno + " -> " + preOrder(left(v));			
		}
		if (hasRight(v)) {
			retorno = retorno + " -> " + preOrder(right(v));
		}
		return retorno;
	}

	public String toStringPosOrdem() {
		return posOrdem(raiz);
	}

	private String posOrdem(Position v) {
		String retorno = "";
		if (hasLeft(v)) {
			retorno = retorno + posOrdem(left(v)) + " -> ";
		}
		if (hasRight(v)) {
			retorno = retorno + posOrdem(right(v)) + " -> ";
		}
		retorno = retorno + v.elemento;
		return retorno;
	}

	public int depth(Position v) {
		int depth = 0;
		if (!isRoot(v)) {
			return depth + depth(v.pai);
		} else {
			return depth;
		}
	}
}
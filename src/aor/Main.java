package aor;

public class Main {

	public static void main(String[] args) {

		LinkedBinaryTree tree = new LinkedBinaryTree();
		
		tree.addRoot(4);
		
		Position no = tree.getRaiz();
		
		tree.insertLeft(no, 7);
		tree.insertRight(no, 17);
		
		// Troca para inserir mais
		no = tree.left(no);
		
		tree.insertLeft(no, 1);
		tree.insertRight(no, 9);
		
		tree.insertLeft(tree.left(no), 3);
		
		// adicionar no lado direito
		no = tree.right(tree.getRaiz());
		
		tree.insertLeft(no, 15);
		tree.insertRight(no, 13);
		
		tree.insertLeft(tree.left(no), 18);
		tree.insertRight(tree.left(no), 23);
		
		tree.insertRight(tree.right(no), 16);
		
		// operacoes
		
		no = tree.getRaiz();
		
		System.out.println("Vazio: " + tree.isEmpty());
		System.out.println("No " + no.elemento + " e raiz? " + tree.isRoot(no));
		
		System.out.print("Filhos de " + no.elemento + ": ");
		for (Position c : tree.children(no)) {
			System.out.print(c.elemento);
			System.out.print(" ");
		}
		System.out.println();
		
		no = tree.left(no);
		
		System.out.println("No " + no.elemento + " tem filho esquerdo? " + tree.hasLeft(no));
		System.out.println("No " + no.elemento + " tem filho direito? " + tree.hasRight(no));
		
		System.out.println("No " + tree.left(no).elemento + " tem filho direito? " + tree.hasRight(tree.left(no)));
		
		System.out.println("Tamanho: " + tree.getTamanho());
		
		System.out.println("Pre ordem:");
		System.out.println(tree.toStringPreOrder());
		System.out.println();
		
		System.out.println("Pos ordem:");
		System.out.println(tree.toStringPosOrdem());
	}

}

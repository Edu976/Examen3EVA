package examen_3EVA_Ejercicio3;

import node_simpleLinkedList.Node;
import node_simpleLinkedList.SimpleLinkedList;

/**
 * pre:---
 * post: en este metodo implementaremos a la simple Linked List un método para eliminar el nodo
 * 		cuyo contenido sea mayor que el resto
 *
 */

public class Main {
	public static void main(String[] args) {
		SimpleLinkedList l = new SimpleLinkedList();
		Node n1 = new Node(20, null);
		Node n2 = new Node(40, null);
		Node n3 = new Node(30, null);
		Node n4 = new Node(470, null);
		Node n5 = new Node(5, null);
		l.add(n1);
		l.add(n2);
		l.add(n3);
		l.add(n4);
		l.add(n5);
		l.show();
		System.out.println("------------------------------");

	}
}

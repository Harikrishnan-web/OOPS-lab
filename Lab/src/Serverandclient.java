//Server code
import java.util.*;

class Node<T> {
    T data;
    Node<T> left, right;
    Node(T d) { data = d; }
}

class BinaryTree<T extends Comparable<T>> {
    Node<T> root;

    void insert(T val) { root = insertRec(root, val); }
    Node<T> insertRec(Node<T> n, T v) {
        if(n == null) return new Node<>(v);
        if(v.compareTo(n.data) < 0) n.left = insertRec(n.left, v);
        else n.right = insertRec(n.right, v);
        return n;
    }

    void inorder(Node<T> n) {
        if(n == null) return;
        inorder(n.left);
        System.out.print(n.data + " ");
        inorder(n.right);
    }

    void preorder(Node<T> n) {
        if(n == null) return;
        System.out.print(n.data + " ");
        preorder(n.left);
        preorder(n.right);
    }

    void postorder(Node<T> n) {
        if(n == null) return;
        postorder(n.left);
        postorder(n.right);
        System.out.print(n.data + " ");
    }

    void levelorder() {
        Queue<Node<T>> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()) {
            Node<T> n = q.poll();
            System.out.print(n.data + " ");
            if(n.left != null) q.add(n.left);
            if(n.right != null) q.add(n.right);
        }
    }
}

public class Tree {
    public static void main(String[] args) {
        BinaryTree<Integer> t = new BinaryTree<>();
        t.insert(10);
        t.insert(5);
        t.insert(20);

        t.levelorder();   System.out.println();
        t.inorder(t.root);System.out.println();
        t.preorder(t.root);System.out.println();
        t.postorder(t.root);
    }
}

//Client.java
import java.io.*;
import java.net.*;

public class Client {
    public static void main(String[] args) throws Exception {
        Socket s = new Socket("localhost", 5000);
        BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
        PrintWriter out = new PrintWriter(s.getOutputStream(), true);
        out.println("Hello Server");
        System.out.println("Server: " + in.readLine());
        s.close();
    }
}

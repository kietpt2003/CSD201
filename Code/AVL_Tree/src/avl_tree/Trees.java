/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package avl_tree;

import java.util.ArrayList;

/**
 *
 * @author ACER
 */
public class Trees {

    ArrayList<Student_info> fileList;
    /**
     * @param args the command line arguments
     */
    Node root;

    public Trees() {
        root = null;
    }

    public Trees(ArrayList<Student_info> arrayList) {
        fileList = arrayList;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public void clear() {
        root = null;
    }

    public void visit(Node p) {
        if (p == null) {
            return;
        }
        System.out.print(p.info + "\n");
    }

    //return a Node which has key = given key in the tree p
    public Node search(Node p, int stCode) {
        if (p == null) {
            return null;
        }
        if (p.info.getStudent_code() == stCode) {
            return p;
        } else if (p.info.getStudent_code() > stCode) { //Nếu key cần tìm nhỏ hơn thì đệ quy tìm bên trái nguược lại thì đệ quy bên phải
            return search(p.left, stCode); //đệ quy bên trái
        } else {
            return search(p.right, stCode); //đệ quy bên phải
        }
    }
    
    public int max(int hLeft, int hRight) {
        if (hLeft <= hRight)
            return hRight;
        return hLeft;
    }

    public void insert(Student_info x) {
        this.root = insert(this.root, x);
    }
    //insert a key x to the tree
    public Node insert(Node node, Student_info x) {
        if (node == null) {
            return new Node(x);
        }
        
        if (node.equal(x)) {
            return node;
        }
        
        if (node.lessThan(x)) {
            node.right = insert(node.right, x);
        } else {
            node.left = insert(node.left, x);
        }
        
        //bắt đầu cân bằng
        node.height = max(height(node.left), height(node.right)) + 1; //Tính chiều cao thằng mới thêm
        int balance = balanceFactor(node);
        if (balance > 1) {
            // => right
            if (node.left.lessThan(x)) {
                // left rotation
                node.left = rotateLeft(node.left);
            }
            // right rotation
            return rotateRight(node);
        } else if (balance < -1) {
            // => left
            if (node.right.greaterThan(x)) {
                // right rotation
                node.right = rotateRight(node.right);
            }
            // left rotation
            return rotateLeft(node);
        }
        return node;
    }

    //preorder a tree
    public void preOrder(Node p) { //NLR
        if (p == null) {
            return;
        }
        visit(p);
        preOrder(p.left);
        preOrder(p.right);
    }

    //postorder a tree
    public void postOrder(Node p) { //LRN
        if (p == null) {
            return;
        }
        postOrder(p.left);
        postOrder(p.right);
        visit(p);
    }

    //inorder a tree
    public void inOrder(Node p) { //LNR
        if (p == null) {
            return;
        }
        inOrder(p.left);
        visit(p);
        inOrder(p.right);
    }

    //bft
    public void BFT(Node p) { //vô hết cha rồi mới vô con và cứ thế
        if (p == null) {
            return;
        }
        MyQueue m = new MyQueue();
        m.enqueue(p);
        while (!m.isEmpty()) {
            Node q = (Node) m.dequeue();
            visit(q);
            if (q.left != null) {
                m.enqueue(q.left);
            }
            if (q.right != null) {
                m.enqueue(q.right);
            }
        }
    }

    //height of tree
    int height(Node p) {
        if (p == null) {
            return 0;
        } else {
            int lDepth = height(p.left);//compute the depth of each subtree
            int rDepth = height(p.right);
            if (lDepth > rDepth) {
                return (lDepth + 1);//use the larger one
            } else {
                return (rDepth + 1);
            }
        }
    }

    public int balanceFactor(Node node) {
        if (node == null) {
            return 0;
        }
        return height(node.left) - height(node.right);
    }

    //delete a node on BST
    public void deleteByCopy(int code) {
        Node p = search(root, code); //Node cần xóa
        if (p == null) {
            System.out.println("Key " + code + " does not exists, deletion failed");
            return;
        }
        //find f is father of p (sau khi chạy xong f = node father của p, q là node xóa
        Node f = null, q = root;
        while (q != p) {
            f = q;
            if (q.info.getStudent_code() > p.info.getStudent_code()) {
                q = q.left;
            } else {
                q = q.right;
            }
        }
        //1.p has no child
        if (p.left == null && p.right == null) { //nếu node cần xóa trái phải null hết
            if (f == null) { //nếu father = null chứng tỏ node câ xóa ko tồn tại => root = null
                root = null;
            } else if (f.left == p) { //Nếu father left = node cần xóa
                f.left = null; //thì cho node father.left = null => xóa xong
            } else {
                f.right = null; //tương tự bên phải
            }
        } //2.p has left child only
        else if (p.left != null && p.right == null) {
            if (f == null) {
                root = p.left;
            } else if (f.left == p) {
                f.left = p.left;
            } else {
                f.right = p.left;
            }
        } //3.p has right child only
        else if (p.left == null && p.right != null) {
            if (f == null) {
                root = p.right;
            } else if (f.left == p) {
                f.left = p.right;
            } else {
                f.right = p.right;
            }
        } //4.p has both child
        else if (p.left != null && p.right != null) {
            //tim q la node lon nhat ben con trai cua p -> q la con phai nhat
            //cua con trai cua p
            q = p.left;
            f = null;
            while (q.right != null) {
                f = q;
                q = q.right;
            }
            p.info = q.info;
            //delete q
            if (f == null) {
                p.left = q.left;
            } else {
                f.right = q.left;
            }
        }
    }

    public void deleteByMerging(int code) {
        Node p = search(root, code);
        if (p == null) {
            System.out.println("Key " + code + " does not exists, deletion failed");
            return;
        }
        //find f is father of p
        Node f = null, q = root;
        while (q != p) {
            f = q;
            if (q.info.getStudent_code() > p.info.getStudent_code()) {
                q = q.left;
            } else {
                q = q.right;
            }
        }
        //1.p has no child
        if (p.left == null && p.right == null) {
            if (f == null) {
                root = null;
            } else if (f.left == p) {
                f.left = null;
            } else {
                f.right = null;
            }
        } //2.p has left child only
        else if (p.left != null && p.right == null) {
            if (f == null) {
                root = p.left;
            } else if (f.left == p) {
                f.left = p.left;
            } else {
                f.right = p.left;
            }
        } //3.p has right child only
        else if (p.left == null && p.right != null) {
            if (f == null) {
                root = p.right;
            } else if (f.left == p) {
                f.left = p.right;
            } else {
                f.right = p.right;
            }
        } //4.p has both child
        else if (p.left != null && p.right != null) {
            //tim q la node lon nhat ben con trai cua p -> q la con phai nhat
            //cua con trai cua p
            q = p.left;
            Node t = null;
            while (q.right != null) {
                t = q;
                q = q.right;
            }
            Node rp = p.right;
            q.right = rp;
            if (f == null) {
                root = p.left;
            } else if (f.left == p) {
                f.left = p.left;
            } else {
                f.right = p.left;
            }
        }
    }

    public Node rotateLeft(Node node) {
        if (node == null) {
            return null;
        }
        Node rightChild = node.right;
        node.right = rightChild.left;
        rightChild.left = node;
        
        node.height = max(height(node.left), height(node.right)) + 1;
        rightChild.height = max(height(rightChild.left), height(rightChild.right)) + 1;
        return rightChild;
    }

    public Node rotateRight(Node node) {
        if (node == null) {
            return null;
        }
        Node leftChild = node.left;
        node.left = leftChild.right;
        leftChild.right = node;
        
        node.height = max(height(node.left), height(node.right)) + 1;
        leftChild.height = max(height(leftChild.left), height(leftChild.right)) + 1;
        return leftChild;
    }
}

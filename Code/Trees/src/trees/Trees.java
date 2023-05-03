/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package trees;

import java.util.ArrayList;

/**
 *
 * @author ACER
 */
public class Trees {

    /**
     * @param args the command line arguments
     */
    Node root;

    public Trees() {
        root = null;
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
        System.out.print(p.info + "  ");
    }

    //return a Node which has key = given key in the tree p
    public Node search(Node p, int key) {
        if (p == null) {
            return null;
        }
        if (p.info == key) {
            return p;
        } else if (p.info > key) { //Nếu key cần tìm nhỏ hơn thì đệ quy tìm bên trái nguược lại thì đệ quy bên phải
            return search(p.left, key); //đệ quy bên trái
        } else {
            return search(p.right, key); //đệ quy bên phải
        }
    }

    //insert a key x to the tree
    public void insert(int x) {
        Node p = new Node(x);
        Node f = null, q = root;
        while (q != null) { //Vòng while này để đổi đến các nhánh con(Nếu không có là chỉ thêm dc ngay root chính thôi)
            if (q.info == x) { //check duplicate
                System.out.println("Key cannot be duplicated...");
                return;
            }
            
            //if else này để chặn điều kiện cho while
            if (q.info < x) { //x lớn hơn thì qua phải
                f = q; //f giữ lại root
                q = q.right; //xong root qua phải (giống head.next)
            } else { //x bé hơn thì qua trái
                f = q; //f giữ lại root
                q = q.left; //xong root qua trái (giống head.next)
            }
        }
        if (f == null) { //nếu f = null nghĩa là root = null
            root = p; //suy ra root = node cần thêm (node p)
        } else if (p.info > f.info) { //Nếu node cần thêm lớn hơn root(f) thì bên phải = p
            f.right = p;
        } else { //Nếu node cần thêm bé hơn root(f) thì bên trái = p
            f.left = p;
        }
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

    /*Part 2___________________________________________________________________*/
    //delete a node on BST
    public void deleteByCopy(int x) {
        Node p = search(root, x); //Node cần xóa
        if (p == null) {
            System.out.println("Key " + x + " does not exists, deletion failed");
            return;
        }
        //find f is father of p (sau khi chạy xong f = node father của p, q là node xóa
        Node f = null, q = root;
        while (q != p) {
            f = q;
            if (q.info > p.info) {
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

    public void deleteByMerging(int x) {
        Node p = search(root, x);
        if (p == null) {
            System.out.println("Key " + x + " does not exists, deletion failed");
            return;
        }
        //find f is father of p
        Node f = null, q = root;
        while (q != p) {
            f = q;
            if (q.info > p.info) {
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

    //balancing a BST
    //inorder a BST and save all items to an array
    public void buildArray(ArrayList a, Node p) {
        if (p == null) {
            return;
        }
        buildArray(a, p.left);
        a.add(p);
        buildArray(a, p.right);
    }

    //insert all items from an array to a new BST
    public void balance(ArrayList a, int f, int l) {
        if (f > l) {
            return;
        }
        int m = (f + l) / 2;
        Node p = (Node) a.get(m);
        insert(p.info);
        balance(a, f, m - 1);
        balance(a, m + 1, l);
    }

    public void balance(Node p) {
        ArrayList a = new ArrayList();
        buildArray(a, p);
        int l = a.size(), f = 0;
        //create a new tree and insert all items from a to the BST
        Trees t = new Trees();
        t.balance(a, f, l - 1);
        root = t.root;
    }

    /*Part 3___________________________________________________________________*/
    public Node rotateLeft(Node p) {
        if (p.right == null) {
            return p;
        }
        Node p1 = p.right;
        p.right = p1.left;
        p1.left = p;
        return p1;
    }

    public Node rotateRight(Node p) {
        if (p.left == null) {
            return p;
        }
        Node p1 = p.left;
        p.left = p1.right;
        p1.right = p;
        return p1;
    }

    public static void main(String[] args) {
//        int[] x = {60, 90, 80, 100, 50, 55, 40};
//        Trees tree = new Trees();
//        for (int i = 0; i < x.length; i++) {
//            tree.insert(x[i]);
//        }
//        tree.preOrder(tree.root);//60 50 40 55 90 80 100
//        System.out.println("");
//        tree.inOrder(tree.root);//40 50 55 60 80 90 100
//        System.out.println("");
//        tree.BFT(tree.root);//60 50 90 40 55 80 100
//        System.out.println("");
        /*Part 2___________________________________________________________________*/
        int[] x = {44, 17, 78, 32, 50, 88, 48, 62, 54};
        Trees tree = new Trees();
        for (int i = 0; i < x.length; i++) {
            tree.insert(x[i]);
        }
        tree.BFT(tree.root); //44  17  78  32  50  88  48  62  54
        System.out.println("");
        tree.balance(tree.root);
        tree.BFT(tree.root); //50  32  62  17  44  54  78  48  88
        System.out.println("");
        /*Part 3___________________________________________________________________*/
//        int[] x = {5, 3, 4, 1, 7};
//        Trees tree = new Trees();
//        for (int i = 0; i < x.length; i++) {
//            tree.insert(x[i]);
//        }
//        tree.preOrder(tree.root);//NLR 5  3  1  4  7
//        System.out.println("");
//        tree.inOrder(tree.root);//LNR 1  3  4  5  7
//        System.out.println("");
//        tree.postOrder(tree.root); //LRN 1  4  3  7  5
//        System.out.println("");
//        tree.BFT(tree.root); //vô hết cha rồi mới vô con và cứ thế 5  3  7  1  4
//        System.out.println("");
    }

}

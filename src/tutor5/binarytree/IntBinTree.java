package tutor5.binarytree;

import java.util.Scanner;

//lop mo ta cay nhi phan so nguyen
public class IntBinTree {
    final int LEFT = 0;
    final int RIGHT = 1;
    IntBinTreeNode root;
    public static Scanner sc = new Scanner(System.in);

    public IntBinTree() {
        root = null;
    }
    //Tham 1 nut p tren cay
    protected void visit (IntBinTreeNode p){
        System.out.println(p.key + " ");
    }
    //Chu y: Dung ky thuat de quy thuong phai viet 2 method
    //Duyet inoder node p - LNR
    public void inorder (IntBinTreeNode p){
        if(p != null){
            inorder(p.left); //duyet nut con trai - LEFT
            visit(p);
            inorder(p.right); //duyet nut con phai - RIGHT
        }
    }
    public void inorder(){
        inorder(root);
    }

    //Duyet tim mot key tren cay con goc p inorder nut p - NLR
    public IntBinTreeNode searchInOrder (int key, IntBinTreeNode p){
        IntBinTreeNode result = p;
        if(p == null){
            return null;
        }else if(p.key == key){
            return p;
        }else {
            result  = searchInOrder(key, p.left);
            if(result == null){
                result = searchInOrder(key, p.right);
            }
        }
        return result;
    }
    //Duyet cay LNR
    public IntBinTreeNode searchInOrder(int key){
        return searchInOrder(key, root);
    }
    //Nhap cay so nguyen tu ban phim
    protected IntBinTreeNode input (IntBinTreeNode p){
        int x; //gia tri nhap
        System.out.println("Enter an integer for a node, 0 for quit");
        x = Integer.parseInt(sc.nextLine());
        if(x != 0 && p == null){ //chi dua vao gia tri khac 0
            p = new IntBinTreeNode(x); //NODE
            System.out.println("Left of " + x + ": "); // Nhap cay con trai
            p.left = input(p.left); //LEFT
            System.out.println("Right of " + x + ": "); // Nhap cay con phai
            p.right = input(p.right); //LEFT
        }
        return p;
    }

    public void input(){
        root = null; //Huy cay cu (neu co)
        root = input(root);
    }

    //BF traversal - duyet theo hang ngang
    public void breadthFirst(){
        if(root == null){
            System.out.println("Empty tree!");
            return; //Cay rong thi dung lun
        }
        IntBinTreeNode p = root;
        MyQueue queue = new MyQueue();
        queue.enqueue(p); //Khoi tao queue la nut goc de bat dau duyet
        while (!queue.isEmpty()){ //khi chua duyet xong
            p = (IntBinTreeNode) queue.dequeue(); //Lay 1 nut ra khoi hang
            visit(p); //tham nut nay
            //bo 2 nut con vao queue
            if( p.left != null) queue.enqueue(p.left);
            if( p.right != null) queue.enqueue(p.right);
        }
    }
    //Duyet nut p o muc L voi muc biet truoc can duyet level
    protected void inorder_level (IntBinTreeNode p, int L, int level){
        if(p != null){
            if( L == level) {
                visit(p);
            }else if(L < level){
                inorder_level(p.left, L+1, level);
                inorder_level(p.right, L+1, level);
            }
        }
    }

    public void inorder_level (int level){
        inorder_level(root, 0, level); //nut goc co muc 0
    }

    //Duyet tim chieu cao cua cay
    protected int height (IntBinTreeNode p){
        if((p == null) || (p.left == null && p.right == null)){
            return 0;
        }
        int hL = 1 + height(p.left);
        int hR = 1 + height(p.right);
        return hL > hR ? hL : hR;
    }
    //tim chieu cao cua cay
    public int height(){
        return height(root);
    }

    public static void main(String[] args) {
        IntBinTree tree = new IntBinTree();
        System.out.println("Input a tree: ");
        tree.input();
        System.out.println("Inorder - LNR - Recuisive traverval: ");
        tree.inorder();
        System.out.println();
        System.out.println("Breadth first traversal: ");
        tree.breadthFirst();
        System.out.println();
        int h = tree.height();
        System.out.println("Height: " + h);
        int x; // tri can tim
        System.out.println("Input a search value: ");
        x = Integer.parseInt(sc.nextLine());
        IntBinTreeNode p = tree.searchInOrder(x);
        if(p == null){
            System.out.println("The value: " + x + " does not exist!");
        } else {
            System.out.println("The value: " + x + " exist!");
        }
        int level;
        System.out.println("Input a level: ");
        level = Integer.parseInt(sc.nextLine());
        if(level > h){
            System.out.println("This level does not exist!");
        } else {
            tree.inorder_level(level);
        }
    }

}

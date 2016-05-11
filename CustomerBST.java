/*Nick Buly
Program Four
Implement a binary search tree class using linked CustomerNodes
Due: 03/30/2016*/
import java.io.*;


public class CustomerBST implements java.io.Serializable{
	private CustomerNode t;
	private int n;
	private CustomerNode root;

	public CustomerBST(){
		root = null;
	}
//isEmpty method for BST: this tells the user if the BST is empty
	public Boolean isEmptyTree(){
		return root == null;
	}
//findSuccessor method for BST: this is used to find the successor of a specific CustomerNode
	public CustomerNode findSuccessor(CustomerNode temp){
		CustomerNode parent = temp.getRight();
		temp = parent;
		while(temp.getLeft()!=null){
			parent = temp;
			temp = temp.getLeft();
		}
		if (parent!=temp){
			parent.setLeft(temp.getRight());
		}
		return temp;
	}
//getParent method for BST: this is used to get the parent of a specific CustomerNode
	public CustomerNode getParent(CustomerNode temp){
        CustomerNode parent=root;
        while(parent.getRight()!=temp && parent.getLeft() != temp){
                if (temp.getcc()>parent.getcc()){
                        parent = parent.getRight();
                }
                else{
                        parent = parent.getLeft();
                }
        }
        return parent;
    }

//deleteRoot method for BST: this is used to delete the root 
    public void deleteRoot(){
    	if (root.getLeft() == null && root.getRight() == null){
    		root = null;
    	}
    	else if(root.getLeft() == null || root.getRight() ==null){
    		if (root.getRight() == null){
    			root = root.getLeft();
    		}
    		else{
    			root = root.getRight();
    		}
    	}
    	else{
    		CustomerNode successor = findSuccessor(root);
    		CustomerNode temp = root;
    		root = successor;
    		root.setLeft(temp.getLeft());
    		root.setRight(temp.getRight());
    	}
    }
//deleteNoKids method for BST: this is used when the CustomerNode we're deleting has zero kids
    public void deleteNoKids(CustomerNode current, CustomerNode parent){

    	if (current.getcc() < parent.getcc()){
    		parent.setLeft(null);
    	}
    	else{
    		parent.setRight(null);
    	}
    }
//deleteOneKid method for BST: this is used when the CustomerNode we're deleting has one kid
    public void deleteOneKid(CustomerNode temp){
    	CustomerNode p = getParent(temp);
    	if(temp.getcc() < p.getcc()){
    		if(temp.getLeft() == null){
    			p.setRight(temp.getRight());
    		}
    		else{
    			p.setLeft(temp.getLeft());
    		}    	
    	}
    	else{
    		if (temp.getLeft() == null){
    			p.setRight(temp.getRight());
    		}
    		else{
    			p.setLeft(temp.getLeft());
    		}
    	}
    }
//deleteTwoKids method for BST: this is used when the CustomerNode we're deleting has two kids
    public void deleteTwoKids(CustomerNode temp){
    	CustomerNode p = getParent(temp);
    	CustomerNode successor = findSuccessor(temp);
    	if(temp == p.getLeft()){
    		p.setLeft(successor);
    	}
    	else{
    		p.setRight(successor);
    	}
    	successor.setLeft(temp.getLeft());
    	if(successor!=temp.getRight()){
    		successor.setRight(temp.getRight());
    	}
    }
//delete method for BST: this is used to delete a specific CustomerNode
	public void delete(CustomerNode current){
		if (current == root){
			deleteRoot();
		}
		else if(current.getRight() == null && current.getLeft() == null){
			CustomerNode parent = getParent(current);
			deleteNoKids(current,parent);
		}
		else if(current.getLeft() == null || current.getRight() == null){
			deleteOneKid(current);
		}
		else if(current.getLeft() != null && current.getRight() != null){
			deleteTwoKids(current);
		}	
	}
//search2 method for BST: this is used to search for a specific CustomerNode
	public CustomerNode search2(CustomerNode temp, int cc){
		if (temp == null){
			return null;
		}
		else if(cc == temp.getcc()){
			return temp;
		}
		else if(cc < temp.getcc() && temp.getLeft() != null){
			return search2(temp.getLeft(),cc);
		}
		else if(cc > temp.getcc() && temp.getRight() != null){
			return search2(temp.getRight(),cc);
		}
		else
			return null;
	}
//search method for BST: this is used to search for a specific CustomerNode
	public CustomerNode search(int cc){
		if(root==null){
			return null;
		}
		else if(cc == root.getcc()){
			return root;
		}
		else if(cc < root.getcc()){
			return search2(root.getLeft(),cc);
		}
		else{
			return search2(root.getRight(),cc);
		}
	}
//insert method for BST: this is used to insert a new CustomerNode 'p' into the BST
	public void insert(CustomerNode p){
		if (root == null){
			root = p;
		}
		else{
			insert2(root,p);
		}
	}
//insert2 method for BST: this is used in correlation with search to insert a new CustomerNode 'p' into BST
	public void insert2(CustomerNode t,CustomerNode p){
		if (p.getcc() < t.getcc()){
			if (t.getLeft() == null){
				t.setLeft(p);
			}
			else{
				insert2(t.getLeft(),p);
			}
		}
		else{
			if (t.getRight() == null){
				t.setRight(p);
			}
			else{
				insert2(t.getRight(),p);
			}
		}
	}
//traverse2 method for BST: this helps traverse print out the tree
	public void traverse2(CustomerNode temp){
		if (temp != null){
			traverse2(temp.getLeft());
			System.out.print(temp.getcc()+" ");
			traverse2(temp.getRight());
		}
	}
//traverse method for BST: this is used to print out the BST
	public void traverse(){
		if (root != null){
			traverse2(root.getLeft());
			System.out.print(root.getcc()+" ");
			traverse2(root.getRight());
		}
		System.out.println();
	}
//print methods for BST
    public void printTree() {
	printTree2(root);
	System.out.println();
    }
    private void printTree2(CustomerNode tree) {
	if (tree != null) {
	    System.out.print(tree.getcc() + " ");
            if (tree.getLeft() != null)
	        System.out.print("Left: " + tree.getLeft().getcc() + " ");
            else
                System.out.print("Left: null ");
            if (tree.getRight() != null)
	        System.out.println("Right: " + tree.getRight().getcc() + " ");
            else
                System.out.println("Right: null ");
	    printTree2(tree.getLeft());
	    printTree2(tree.getRight());
	}
    }
}
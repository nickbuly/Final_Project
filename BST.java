/*Nick Buly
Program Four
Implement a binary search tree class using linked MovieNodes
Due: 03/30/2016*/

public class BST{
	private MovieNode t;
	private int n;
	private MovieNode root;

	public BST(){
		root = null;
	}
//isEmpty method for BST: this tells the user if the BST is empty
	public Boolean isEmptyTree(){
		return root == null;
	}
//findSuccessor method for BST: this is used to find the successor of a specific MovieNode
	public MovieNode findSuccessor(MovieNode temp){
		MovieNode parent = temp.getRight();
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
//getParent method for BST: this is used to get the parent of a specific MovieNode
	public MovieNode getParent(MovieNode temp){
        MovieNode parent=root;
        while(parent.getRight()!=temp && parent.getLeft() != temp){
                if (temp.getDate()>parent.getDate()){
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
    		MovieNode successor = findSuccessor(root);
    		MovieNode temp = root;
    		root = successor;
    		root.setLeft(temp.getLeft());
    		root.setRight(temp.getRight());
    	}
    }
//deleteNoKids method for BST: this is used when the MovieNode we're deleting has zero kids
    public void deleteNoKids(MovieNode current, MovieNode parent){

    	if (current.getDate() < parent.getDate()){
    		parent.setLeft(null);
    	}
    	else{
    		parent.setRight(null);
    	}
    }
//deleteOneKid method for BST: this is used when the MovieNode we're deleting has one kid
    public void deleteOneKid(MovieNode temp){
    	MovieNode p = getParent(temp);
    	if(temp.getDate() < p.getDate()){
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
//deleteTwoKids method for BST: this is used when the MovieNode we're deleting has two kids
    public void deleteTwoKids(MovieNode temp){
    	MovieNode p = getParent(temp);
    	MovieNode successor = findSuccessor(temp);
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
//delete method for BST: this is used to delete a specific MovieNode
	public void delete(MovieNode current){
		if (current == root){
			deleteRoot();
		}
		else if(current.getRight() == null && current.getLeft() == null){
			MovieNode parent = getParent(current);
			deleteNoKids(current,parent);
		}
		else if(current.getLeft() == null || current.getRight() == null){
			deleteOneKid(current);
		}
		else if(current.getLeft() != null && current.getRight() != null){
			deleteTwoKids(current);
		}	
	}
//search2 method for BST: this is used to search for a specific MovieNode
	public MovieNode search2(MovieNode temp, int date){
		if (temp == null){
			return null;
		}
		else if(date == temp.getDate()){
			return temp;
		}
		else if(date < temp.getDate() && temp.getLeft() != null){
			return search2(temp.getLeft(),date);
		}
		else if(date > temp.getDate() && temp.getRight() != null){
			return search2(temp.getRight(),date);
		}
		else
			return null;
	}
//search method for BST: this is used to search for a specific MovieNode
	public MovieNode search(int date){
		if(root==null){
			return null;
		}
		else if(date == root.getDate()){
			return root;
		}
		else if(date < root.getDate()){
			return search2(root.getLeft(),date);
		}
		else{
			return search2(root.getRight(),date);
		}
	}
//insert method for BST: this is used to insert a new MovieNode 'p' into the BST
	public void insert(MovieNode p){
		if (root == null){
			root = p;
		}
		else{
			insert2(root,p);
		}
	}
//insert2 method for BST: this is used in correlation with search to insert a new MovieNode 'p' into BST
	public void insert2(MovieNode t,MovieNode p){
		if (p.getDate() < t.getDate()){
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
	public void traverse2(MovieNode temp){
		if (temp != null){
			traverse2(temp.getLeft());
			System.out.print(temp.getDate()+" ");
			traverse2(temp.getRight());
		}
	}
//traverse method for BST: this is used to print out the BST
	public void traverse(){
		if (root != null){
			traverse2(root.getLeft());
			System.out.print(root.getDate()+" ");
			traverse2(root.getRight());
		}
		System.out.println();
	}
//print methods for BST
    public void printTree() {
	printTree2(root);
	System.out.println();
    }
    private void printTree2(MovieNode tree) {
	if (tree != null) {
	    System.out.print(tree.getDate() + " ");
            if (tree.getLeft() != null)
	        System.out.print("Left: " + tree.getLeft().getDate() + " ");
            else
                System.out.print("Left: null ");
            if (tree.getRight() != null)
	        System.out.println("Right: " + tree.getRight().getDate() + " ");
            else
                System.out.println("Right: null ");
	    printTree2(tree.getLeft());
	    printTree2(tree.getRight());
	}
    }
}
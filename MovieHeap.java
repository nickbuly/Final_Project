import java.io.*;


public class MovieHeap implements java.io.Serializable{
	private MovieNode [] h = new MovieNode [120];
	private int n;
	private int p;

	public MovieHeap(){
		n = 0;
		p = 0;
	}
//isEmpty method for Heap. This will return True is it's empty, and false if it is not
	public Boolean isEmpty(){
		return n == 0;
	}
//findMind method for Heap. This will return the min value
	public MovieNode findMin(){
		if(isEmpty()){
			return null;
		}
		return h[0];
	}
//deleteMin method for Heap. This will delete a specific number in the heap
	public void deleteMin(){
		if (isEmpty()){
			System.out.println("The Heap is empty");
		}
		else{
			swap(0, (n-1));
			int t = 0;
			int c = getChild(0);
			int w = getParent(c);
			while(t!=n && (h[w].getScore() > h[c].getScore())){
				swap(w,c);
				n--;
			}
		}
	}
//swap method for Heap. This will swap two values in the heap
	public void swap(int a, int b){
		MovieNode temp = h[b];
		h[b] = h[a];
		h[a] = temp;
	}
//insert method for Heap. This will insert a certain number into the heap
	public void insert(MovieNode x){
		int t=0;
		h[n] = x;
		n++;
		int m = getParent(n-1);
		t = n-1;
		while (m >= 0 && h[t].getScore() < h[m].getScore()){
			swap(t,m);
			t = m;
			m = getParent(t);
		}	

	}
//getChild method for Heap: this will return the child int for a specific int
	public int getChild(int c){
		int leftChild = (2*c) + 1;
		int rightChild = (2*c) + 2;
		if(h[leftChild] != null &&  h[rightChild] != null && (h[leftChild].getScore() < h[rightChild].getScore())){
			return leftChild;
		}
		else if(h[leftChild] != null &&  h[rightChild] != null && (h[leftChild].getScore() > h[rightChild].getScore())){
			return rightChild;
		}
		else if(h[leftChild] == null){
			return rightChild;
		}
		else{
			return leftChild;
		}
	}
//getParent method for Heap. This will return the parent of x
	public int getParent(int x){
		return (x-1)/2;
	}
}

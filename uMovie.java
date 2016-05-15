import java.util.Scanner;
import java.io.*;
import java.util.InputMismatchException;

public class uMovie implements java.io.Serializable{

	public static void main(String[] args){
		MovieBST a = new MovieBST(); //Release Date
		MovieHeap b = new MovieHeap(); //Rotten Tomatoes Score
		MovieHash c = new MovieHash(); // Movie ID
		CustomerBST d = new CustomerBST(); // Customer's CC #
		Scanner s = new Scanner(System.in); //creates a scanner
		int i = 0;

		 try{
         FileInputStream fileIn = new FileInputStream("MovieBST.txt");
         ObjectInputStream in = new ObjectInputStream(fileIn);
         a = (MovieBST) in.readObject();
         in.close();
         fileIn.close();
      }catch(IOException io)
      {
         io.printStackTrace();
      }catch(ClassNotFoundException cn)
      {
         System.out.println("MovieBST class not found");
         cn.printStackTrace();
         return;
    }
        	try{
         FileInputStream fileIn = new FileInputStream("MovieHeap.txt");
         ObjectInputStream in = new ObjectInputStream(fileIn);
         b = (MovieHeap) in.readObject();
         in.close();
         fileIn.close();
      }catch(IOException io)
      {
         io.printStackTrace();
      }catch(ClassNotFoundException w)
      {
         System.out.println("Employee class not found");
         w.printStackTrace();
         return;
    }
    	try{
         FileInputStream fileIn = new FileInputStream("MovieHash.txt");
         ObjectInputStream in = new ObjectInputStream(fileIn);
         c = (MovieHash) in.readObject();
         in.close();
         fileIn.close();
      }catch(IOException io)
      {
         io.printStackTrace();
      }catch(ClassNotFoundException cn)
      {
         System.out.println("Employee class not found");
         cn.printStackTrace();
         return;
    }
    	try{
         FileInputStream fileIn = new FileInputStream("CustomerBST.txt");
         ObjectInputStream in = new ObjectInputStream(fileIn);
         d = (CustomerBST) in.readObject();
         in.close();
         fileIn.close();
      }catch(IOException io)
      {
         io.printStackTrace();
      }catch(ClassNotFoundException cn)
      {
         System.out.println("Employee class not found");
         cn.printStackTrace();
         return;
    }
    	System.out.println();

    	boolean program = true;
    	while (program){

    	
		System.out.println("Welcome to uMovie. Enter '1' if you are a customer, or '2' if you are an administrator");
		try{
		int x = s.nextInt();
		
		while (x > 2 || x < 1){
			
			System.out.println("Enter '1' if you are a customer, or '2' if you are an administrator");
			
			x = s.nextInt();
		}

//User is a customer:

		if(x == 1){ 
			boolean running = true;
			while (running){
			System.out.println();
			System.out.println("Welcome to your Home Menu.");
			System.out.println("1.) Search for movie using Release Date");
			System.out.println("2.) Search for movie using ID");
			System.out.println("3.) View all movies in order of Release Date");
			System.out.println("4.) Access your WishList");
			System.out.println("5.) Quit");
			System.out.println("Enter a number from the menu above to enter that section.");
			int z = s.nextInt();
			while (z < 1 || z > 5){
				System.out.println("Please enter a number from the given menu.");
				z = s.nextInt();
			}
			if (z == 1){
				System.out.println("Please enter the release date of the movie you are searching for.");
				int movie = s.nextInt();
				if(a.search(movie) == null){
					System.out.println("Sorry, we do not have a movie in our database with that release date.");
					System.out.println("*Returning you to your Home Menu*");
					System.out.println();
				}
				else{
					MovieNode themovie = a.search(movie);
					System.out.println();
					System.out.println("The movie you are searching for is "+themovie.getTitle()+".");
					System.out.println("We found it! Enjoy the show.");
					System.out.println();
					break;
				}
			}
			if (z == 2){
				System.out.println("Please enter the ID of the movie you are searching for.");
				int movID = s.nextInt();
				if (c.lookUp(movID) == null){
					System.out.println("Sorry, we do not have a movie in our database with that ID.");
					System.out.println("*Returning you to your Home Menu*");
					System.out.println();
				}
				else{
					System.out.println();
					System.out.println("The movie you are searching for is "+c.lookUp(movID)+".");
					System.out.println("We found it! Enjoy the show.");
					System.out.println();
					break;
				}
			}
			if (z == 3){
				a.traverse();
				System.out.println("*Returning you to your Home Menu*");
				System.out.println();
			}
			if (z == 4){
				System.out.println("Enter the last 4 digits of your credit card number to login.");
				int ccnum = s.nextInt();
				while(d.search(ccnum) == null){
					System.out.println("Invalid credit card. Please try again.");
					ccnum = s.nextInt();
				}

				System.out.println("Welcome, "+d.search(ccnum).getName()+", to your WishList.");
				if((d.search(ccnum).getList()) == null){
					System.out.println("There is nothing in your WishList yet!");
					System.out.println();
				}
				else{
					System.out.println("Here is your WishList!");
					d.search(ccnum).getList().printWishList();
				}

				System.out.println("1.) Add to your WishList");
				System.out.println("2.) Watch next up movie");
				System.out.println("3.) Delete a movie from your WishList");
				System.out.println("4.) Go back to your home menu");
				int wl = s.nextInt();
				while (wl < 1 || wl > 4){
					System.out.println("Please enter a number from the given menu.");
					wl = s.nextInt();
				}
				if (wl == 1){
					System.out.println("Here are your choices:");
					a.traverse();
					System.out.println("Please enter the release date of the movie you want to add.");
					int wlrd = s.nextInt();
					System.out.println("Please enter the place of the WishList you want the movie.");
					int wlindex = s.nextInt();
					MovieNode wishMovie = a.search(wlrd);
					System.out.println(wishMovie.getDate());
					CustomerNode customer1 = d.search(ccnum);
					WishList wish = customer1.getList();
					wish.insert(wishMovie);
					System.out.println("The movie has been added to your WishList.");
				}
				if (wl == 2){
					if((d.search(ccnum).getList()) == null){
						System.out.println("There is nothing in your WishList yet!");
						System.out.println();
					}
					else{


					d.search(ccnum).getList().accessMovie();
					System.out.println("Enjoy the show!");
					System.out.println();
					break;
				}
			}
				if (wl == 3){
					System.out.println("Enter movie's index of the WishList you want to delete.");
					int delmovie = s.nextInt();
					d.search(ccnum).getList().delete(delmovie);
					System.out.println("The movie has been deleted from your WishList.");
				}
				if (wl == 4){
				}

			}
			if (z == 5){
				running = false;
				program = false;
			}

}
	}
//User is an administator:
		else if(x == 2){ 
			boolean working = true;
			while (working){
			System.out.println("Welcome Admin.");
			System.out.println("1.) Retrieve Customer Information");
			System.out.println("2.) View Least Rated Movie");
			System.out.println("3.) Add Movie");
			System.out.println("4.) View all movies in order of release date");
			System.out.println("5.) Add new customer");
			System.out.println("6.) Delete Customer");
			System.out.println("7.) Quit");
			System.out.println("Enter a number from the menu above to enter that section.");
			int q = s.nextInt();
			while (q< 1 || q > 7){
				System.out.println("Please enter a number from the given menu");
				q = s.nextInt();
			}
			//retrieve customer information
			if (q==1){
				System.out.println("Please enter the last 4 digits of the customer's credit card.");
				int card = s.nextInt();
				if(d.search(card) == null){
					System.out.println("There is not a customer in our database with that credit card on file.");
					System.out.println("*Returning you to your Home Menu*");
					System.out.println();
			}
				else{
					CustomerNode foundCustomer = d.search(card);
					System.out.println(foundCustomer);
					System.out.println("*Returning you to your Home Menu*");
					System.out.println();

				}
		}
			//view least rated movie
			if (q == 2){
				MovieNode lrmovie = b.findMin();
				if(lrmovie == null){
					System.out.println("Sorry, it looks like there aren't any movies in the database.");
					System.out.println("*Returning you to your Home Menu*");
					System.out.println();
				}
				else{

			System.out.println("The least rated movie in the database is "+lrmovie.getTitle()+" with a Rotten Tomatoes score of "+lrmovie.getScore()+".");
			System.out.println("Would you like to delete it? Enter '1' for yes or '2' for no.");
		}
			int e = s.nextInt();
			while(e< 1 || e > 2){
				System.out.println("Please enter either '1' or '2'");
				e = s.nextInt();
			}
			if (e == 1){
				MovieNode lowestScore = b.findMin();
				System.out.println(lowestScore.getTitle());
				a.delete(lowestScore);
				b.deleteMin();
				c.delete(lowestScore.getID());
				
				System.out.println("The movie has been deleted from the database.");
				System.out.println("*Returning you to your Home Menu*");
				System.out.println();
			}
			if(e == 2){
				System.out.println("Ok, the least rated movie will remain in our database. Let's hope it's rating increases soon!");
				System.out.println("*Returning you to your Home Menu*");
				System.out.println();
			}

		}
			//add movie
			if (q==3){
				System.out.println("Please Enter the ID for the new Movie");
				int id = s.nextInt();
				System.out.println("Enter score");
				int score = s.nextInt();
				s.nextLine();
				System.out.println("Enter Title");
				String title = s.nextLine();
				System.out.println("Enter Date");
				int date = s.nextInt();
				MovieNode m = new MovieNode(id,score,title,date);
				a.insert(m);
				b.insert(m);
				c.insert(m);
				System.out.println("*Returning you to your Home Menu*");
				System.out.println();
			}
			//view all movies
			if (q == 4){
				a.traverse();
				System.out.println("*Returning you to your Home Menu*");
				System.out.println();
			}
			if (q==5){
				s.nextLine();
				System.out.println("Please enter the name of the customer.");
				String name = s.nextLine();
				System.out.println("Please enter the credit card number of the customer");
				int ccnumber = s.nextInt();
				s.nextLine();
				System.out.println("Please enter the email of the customer.");
				String email = s.nextLine();
				CustomerNode newCustomer = new CustomerNode(name, ccnumber, email);
				d.insert(newCustomer);
				System.out.println(name+" has been added to our database.");
				System.out.println("*Returning you to your Home Menu*");
				System.out.println();



			}
			if (q == 6){
				System.out.println("Please enter the last 4 digits of the customer's credit card.");
				int card = s.nextInt();
				if(d.search(card) == null){
					System.out.println("There is not a customer in our database with that credit card on file.");//
			}
				else{
					CustomerNode foundCustomer = d.search(card);
					d.delete(foundCustomer);
					System.out.println("The customer has been removed from our database.");
					System.out.println("*Returning you to your Home Menu*");
					System.out.println();
				}
			}
			if(q==7){
				working = false;
				program = false;
			}
		}
	}

	
	}catch(java.util.InputMismatchException ime){
		System.out.println("Please enter a valid entry.");
		s.nextLine();
		
	}
		}
	

			try{
			FileOutputStream fileOut = 
			new FileOutputStream("MovieBST.txt");
			ObjectOutputStream output = 
			new ObjectOutputStream(fileOut);
			output.writeObject(a);
			output.close();
			fileOut.close();
			System.out.println("Serialized data is saved in MovieBST.txt");
		}
		catch(IOException io){
			io.printStackTrace();

		}

		try{
			FileOutputStream fileOut = 
			new FileOutputStream("MovieHeap.txt");
			ObjectOutputStream output = 
			new ObjectOutputStream(fileOut);
			output.writeObject(b);
			output.close();
			fileOut.close();
			System.out.println("Serialized data is saved in MovieHeap.txt");
		}
		catch(IOException io){
			io.printStackTrace();

		}
		try{
			FileOutputStream fileOut = 
			new FileOutputStream("MovieHash.txt");
			ObjectOutputStream output = 
			new ObjectOutputStream(fileOut);
			output.writeObject(c);
			output.close();
			fileOut.close();
			System.out.println("Serialized data is saved in MovieHash.txt");
		}
		catch(IOException io){
			io.printStackTrace();

		}
		try{
			FileOutputStream fileOut = 
			new FileOutputStream("CustomerBST.txt");
			ObjectOutputStream output = 
			new ObjectOutputStream(fileOut);
			output.writeObject(d);
			output.close();
			fileOut.close();
			System.out.println("Serialized data is saved in CustomerBST.txt");
		}
		catch(IOException io){
			io.printStackTrace();

		}

}
}
/* 
Andrew Eigner

Hash Test
*/
public class MovieHashTest {
    public static void main(String[] args){
	MovieHashTable a = new MovieHashTable();
	System.out.println("isEmptySet = " + a.isEmptySet());
		MovieNode aMovieNode = new MovieNode(01000	, 100, "The Wizard of Oz", 19390420);
		MovieNode bMovieNode = new MovieNode(02000	, 98 , "The Third Man" , 19490618);
		MovieNode cMovieNode = new MovieNode(03000	, 96 , "Citizen Kane" , 19411129);
		MovieNode dMovieNode = new MovieNode(04000	, 94 , "All About Eve" , 19500714);
		MovieNode eMovieNode = new MovieNode(05000	, 92 , "Das Cabinet des Dr. Caligari. (The Cabinet of Dr. Caligari)" , 19200913);
		MovieNode fMovieNode = new MovieNode(06000	, 90 , "Modern Times" , 19361014);
		MovieNode gMovieNode = new MovieNode(07000	, 88 , "The Godfather" , 19720926);
		MovieNode hMovieNode = new MovieNode(8000	, 86 , "E.T. The Extra-Terrestrial" , 19820809);
		MovieNode iMovieNode = new MovieNode(9000	, 84 ,	"Metropolis" , 19270827);
		MovieNode jMovieNode = new MovieNode(10000	, 82 , "Singin’ in the Rain" , 19520317);
		MovieNode kMovieNode = new MovieNode(11000	, 80 , "It Happened One Night" , 19340424);
		MovieNode lMovieNode = new MovieNode(12000	, 78 , "Inside Out" , 20150612);
		MovieNode mMovieNode = new MovieNode(13000	, 76 , "Laura" , 19440529);
		MovieNode nMovieNode = new MovieNode(14000	, 74 , "Snow White and the Seven Dwarfs" , 19370726);
		MovieNode oMovieNode = new MovieNode(15000	, 72 , "A Hard Day's Night" , 19641225);
		MovieNode pMovieNode = new MovieNode(16000	, 70 , "Boyhood" , 20141031);
		MovieNode qMovieNode = new MovieNode(17000	, 68 , "North by Northwest"  , 19590704);
		MovieNode rMovieNode = new MovieNode(18000	, 66 , "Repulsion"  , 19650603);
		MovieNode sMovieNode = new MovieNode(19000	, 64 , "King Kong"  , 19330819);
		MovieNode tMovieNode = new MovieNode(20000	, 62 , "The Adventures of Robin Hood" , 19380604);
		MovieNode uMovieNode = new MovieNode(21000	, 60 , "La Battaglia di Algeri (The Battle of Algiers)" , 19670901);
		MovieNode vMovieNode = new MovieNode(22000	, 58 , "Rear Window" , 19540127);
		MovieNode wMovieNode = new MovieNode(23000	, 56 , "The Maltese Falcon" , 19410605);
		MovieNode xMovieNode = new MovieNode(24000	, 54 , "Rashômon (Rashomon) (In the Woods)" , 19510707);
		MovieNode yMovieNode = new MovieNode(25000	, 52 , "Sunset Boulevard" , 19501231);
		MovieNode zMovieNode = new MovieNode (26000 , 50, "Toy Story 2" ,19990827);
		MovieNode aaMovieNode = new MovieNode (27000, 48, "The Philadelphia Story" , 19400429);
		MovieNode bbMovieNode = new MovieNode (28000, 46, "Toy Story 3", 20100505);
		MovieNode ccMovieNode = new MovieNode (29000, 44, "The Bicycle Thief", 19490929);
		MovieNode ddMovieNode = new MovieNode (30000, 42, "The Bride of Frankenstein", 19351225);
		MovieNode eeMovieNode = new MovieNode (31000, 40, "Zootopia" , 20161119);
		MovieNode ffMovieNode = new MovieNode (32000, 38, "M", 19310624);
		MovieNode ggMovieNode = new MovieNode (33000, 36, "The 400 Blows (Les Quatre cents coups)" ,19591031);
		MovieNode hhMovieNode = new MovieNode (34000, 34, "Selma", 20150315);
		MovieNode iiMovieNode = new MovieNode (35000, 32, "Seven Samurai (Shichinin no Samurai)" , 19561111);
		MovieNode jjMovieNode = new MovieNode (36000, 30, "Up" , 20090915);
		MovieNode kkMovieNode = new MovieNode (37000, 28, "The Treasure of the Sierra Madre", 19480228);
		MovieNode llMovieNode = new MovieNode (38000, 26, "Taxi Driver", 19760226);
		MovieNode mmMovieNode = new MovieNode (39000, 24, "12 Angry Men (Twelve Angry Men)", 19570322);
		MovieNode nnMovieNode = new MovieNode (40000, 22, "A Streetcar Named Desire" , 19510922);
		MovieNode ooMovieNode = new MovieNode (41000, 20, "Rebecca", 19400808);
		MovieNode ppMovieNode = new MovieNode (42000, 18, "The Conformist", 19700619);
		MovieNode qqMovieNode = new MovieNode (43000, 16, "The Night of the Hunter", 19550131);
		MovieNode rrMovieNode = new MovieNode (44000, 14, "Finding Nemo", 20030405);
		MovieNode ssMovieNode = new MovieNode (45000, 12, "Rosemary’s Baby", 19680712);
		MovieNode ttMovieNode = new MovieNode (46000, 10, "Frankenstein", 19310518);
		MovieNode uuMovieNode = new MovieNode (47000, 8, "L.A. Confidential", 19970513);
		MovieNode vvMovieNode = new MovieNode (48000, 6, "The Wrestler", 20081225);
		MovieNode wwMovieNode = new MovieNode (49000, 4, "Dr. Strangelove Or How I Learned to Stop Worrying and Love the Bomb",19641127);
		MovieNode xxMovieNode = new MovieNode (50000, 2, "The Hurt Locker", 20090707);
	a.insert(aMovieNode);
	a.insert(eMovieNode);
	a.insert(pMovieNode);
	a.insert(xMovieNode);
	a.insert(ddMovieNode);
	System.out.println("lookUp");
	System.out.println(a.lookUp(01000));
	System.out.println(a.lookUp(05000));
	System.out.println(a.lookUp(16000));
	System.out.println(a.lookUp(30000));
	System.out.println("delete24000");
	a.delete(xMovieNode.getID());
	System.out.println("delete16000");
	a.delete(pMovieNode.getID());
	System.out.println("insert02000");
	a.insert(bMovieNode);
	System.out.println("insert15000");
	a.insert(oMovieNode);
	System.out.println("delete05000");
	a.delete(eMovieNode.getID());
	System.out.println("isEmptySet = " + a.isEmptySet());
    }

}
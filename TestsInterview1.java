package Tests;

public class TestsInterview {
	
	public static void main(String[] args) {
		System.out.println(checkNewspaperWords("abc, de! fg.","de? fg!"));
	}


//	1. There is a scoundrel who stole a dog from a neighbor.
//	He wants to write a ransom note, cutting out words from a newspaper.
//	The task is to write a function that accepts 2 strings (text of the newspaper, text of the note)
//	and returns true if all the words from the note are in the text of the newspaper or false if there are not enough words
// cover case when words in note more than in newspaper
	
	public static boolean checkNewspaperWords(String newspp, String note) {
		boolean result = false;
		int count = 0;
		String[] newspWords = newspp.split("\\W+");
		String[] noteWords = note.split("\\W+");
		
		 for (String n:newspWords)
	        {
	          for (String t:noteWords)
		        {
	        	  if (n.equals(t)) {
	        		  count++;
	        	  }
		        }
	        }
		 
		 if(count==noteWords.length)
			 result = true;
		 
		return result; 
	}

}

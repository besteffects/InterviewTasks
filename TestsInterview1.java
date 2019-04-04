package Tests;

public class TestsInterview {
	
	public static void main(String[] args) {
		System.out.println(ZapiskaIGazeta("abc, de! fg.","de? fg!")); 
	}
	
	
//	1. Есть негодяй, который украл собаку у соседа.
//	Он хочет написать записку о выкупе, вырезая слова из газеты. 
//	Задание написать функцию, которая принимает 2 стринга (текст газеты, текст записки) 
//	и возвращает true, если все слова из записки есть в тексте газеты или false, 
//	если каких-то слов не хватает
	
	public static boolean ZapiskaIGazeta(String newspp, String note) {
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

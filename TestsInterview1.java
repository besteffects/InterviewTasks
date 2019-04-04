package Tests;

public class TestsInterview {
	
	public static void main(String[] args) {
		System.out.println(ZapiskaIGazeta("abc, de! fg.","de? fg!")); 
	}
	
	
//	1. ���� �������, ������� ����� ������ � ������.
//	�� ����� �������� ������� � ������, ������� ����� �� ������. 
//	������� �������� �������, ������� ��������� 2 ������� (����� ������, ����� �������) 
//	� ���������� true, ���� ��� ����� �� ������� ���� � ������ ������ ��� false, 
//	���� �����-�� ���� �� �������
	
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

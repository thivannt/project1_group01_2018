/*
 Cách lấy danh sách thư mục được tham khảo và chỉnh sửa tại:
 print directory tree
 https://stackoverflow.com/questions/10655085/print-directory-tree
 */

import java.io.File;


public class LISTDIR
{


	private String [] PATH;
	int nPath;
	
	
	 
	 
	public static void main(String[] args) {
		
	}
	
	
	public LISTDIR()
	{
		PATH = new String[100];
		nPath = 0;
		initStringArray();
	}

	public int takenPath()
	{
		return nPath;
	}


	 public static String chuanHoa(String str) {
	        str = str.trim();
	        str = str.replaceAll("\\s+", "");
	        return str;
	    }
	
	


	private void initStringArray()
	{
		for(int i = 0; i<100; i++)
			PATH[i] = ".";
	}

	
	private String cutTail(String justName)
	{
		char [] temp = new char[100];
		temp = justName.toCharArray();
	
		int i = 0;
		while(i<justName.length() && temp[i] != '.')
		{
			i++;
		}
		
		return justName.substring(0, i);
	}

	public String [] takeDirectoryTree(String path, String tail )
	{
		File file[] = new File(path).listFiles();

		for(int i = 0 ; i < file.length ; i++)
		{

			if(tail.trim().equals(""))
			{
				if(file[i].isDirectory())
				{
					String justName =cutTail(file[i].getName());
					
					PATH[nPath] = justName;
					nPath++;
				}
			}
			else
			{
				if(file[i].getName().endsWith(tail))
				{
					String justName =cutTail(file[i].getName());
					PATH[nPath] = justName;
					nPath++;
				}
			}

		}
		return PATH;
	}

}
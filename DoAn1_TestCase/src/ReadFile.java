import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;


public class ReadFile {

	private static String allLine;
	private static int nLine;
	public static void main(String[] args) {
		
	}

	public ReadFile()
	{
		nLine = 0;
	}
	public String readTextFile(String strPATH)
	{
		allLine = "";
		try {
			FileInputStream fis = new FileInputStream(new File(strPATH));
			BufferedReader br = new BufferedReader(new InputStreamReader(fis));
			String line;
			while ((line = br.readLine()) != null) {
				line = line.trim();
						allLine += line;
						allLine += '\n';
			}
			br.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
		return allLine;
	}


	public int takenLine()
	{

		return nLine; 
	}

	private static void initString(String[] kqPATH)
	{
		for(int i =0; i<100; i++)
			kqPATH[i] = "";
	}
	
	public String [] readTextFiletoArray(String strPATH)
	{
	
		String [] kqPATH = new String[100];
		initString(kqPATH);
		
	
		try {
			FileInputStream fis = new FileInputStream(new File(strPATH));
			BufferedReader br = new BufferedReader(new InputStreamReader(fis));
			String line;
			while ((line = br.readLine()) != null)
			{
				//line = line.trim();
				if(line.isEmpty())
				{
					kqPATH[nLine] = kqPATH[nLine].trim();
					nLine++;
				}
				else
				{
					kqPATH[nLine] += line.trim();
					kqPATH[nLine] += '\n';
				}
					
			}
			br.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
		
		nLine++;
		return kqPATH;
	}
	
}
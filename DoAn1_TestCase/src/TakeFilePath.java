/*
 Hướng dẫn lấy địa chỉ của thư mục/file được tham khảo và chỉnh sửa từ:
 https://www.youtube.com/watch?v=XXkq73u9Uqg
 */

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

public class TakeFilePath {

	private String strTitle;

	public TakeFilePath(String title)
	{
		strTitle = title;

	}

	public TakeFilePath()
	{
		strTitle = "Chọn đường dẫn";
	}

	// Lấy địa chỉ của thư mục
	public String takeFolerDerectory()
	{
		JFileChooser chooser = new JFileChooser();
		chooser.setDialogTitle(strTitle);
		chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		
		
		if (chooser.showDialog(null,"Choose") == JFileChooser.APPROVE_OPTION) {
			return chooser.getSelectedFile().toString();
		}
		else
		{
			return "";
		}
	}

	// lấy địa chỉ tuyệt đối của 1 file có chọn filter.
	public String takeFileDerectory(String Filter, String Decription, String CurrentDerectory)
	{
		JFileChooser chooser = new JFileChooser();
		
		// Set derectory là nếu đã click vào một ô nào đó :) 
		if(!CurrentDerectory.trim().equals(""))
			chooser.setCurrentDirectory(new java.io.File(CurrentDerectory));
		
		chooser.setDialogTitle(strTitle);


		chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
		chooser.addChoosableFileFilter(new FileNameExtensionFilter(Decription, Filter));
		chooser.setAcceptAllFileFilterUsed(true);

		if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
			return chooser.getSelectedFile().toString();
		}
		else
		{
			return "";
		}
	}

	//lấy địa chỉ tuyệt đối của 1 file không chọn filter
	public String takeFileDerectory()
	{
		JFileChooser chooser = new JFileChooser();
	
		
		chooser.setCurrentDirectory(new java.io.File("."));
		
		chooser.setDialogTitle(strTitle);


		if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
			return chooser.getSelectedFile().toString();
		}
		else
		{
			return "";
		}
	}	
}

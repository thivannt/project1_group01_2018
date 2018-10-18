import java.io.PrintWriter;

public class ExecuteShellComand {


	


	/*
	 cơ chế chạy lệnh command Runtime.getRuntime().exec
	 			
	 được tham khảo từ:
	 	 http://chillyfacts.com/run-command-prompt-cmd-commands-from-java/
	 	 
	 Được chỉnh sửa bởi NHÓM 1.
	 */
	
	// gọi lệnh trong command promt
	
	
	public void runCommand(String[] strCommand, int numberOfCommand)
	{
		
		String[] command =
			{
					"cmd",

			};
		Process p;
		try {
			p = Runtime.getRuntime().exec(command);
			new Thread(new SyncPipe(p.getErrorStream(), System.err)).start();
			new Thread(new SyncPipe(p.getInputStream(), System.out)).start();
			PrintWriter stdin = new PrintWriter(p.getOutputStream());
			for(int i = 0; i<numberOfCommand; i++)
				{
			stdin.println(strCommand[i]);
				}
			stdin.flush();
			stdin.close();
			p.waitFor();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	
	
	
	
}
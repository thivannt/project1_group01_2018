import java.io.PrintWriter;

public class ExecuteShellComand {

	public static void main(String[] args) {
		
		String [] cmd = new String [5];
		cmd[0] ="C:";
		cmd[1] ="cd C:\\WINDOWS\\Microsoft.NET\\Framework\\v4.0.30319";
		cmd[2] = "csc \"C:\\Users\\Dang Nguyen Hong Kha\\Desktop\\test\\program.cs\"";
		cmd[3] = "Program.exe > out.txt";
		
		
		
		int n=4;
		runCommand_1(cmd,n);
		
	}
	
	


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

	
	public static void runCommand_1(String[] strCommand, int numberOfCommand)
	{
		
		String[] command =
			{
				"cmd",
					"runas /profile /user:Administrator /savecred",
				

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
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JMenuBar;
import javax.swing.JToolBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JMenu;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.Window.Type;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;



public class frmMain implements ActionListener {


	/*
	 
	 */

	public String DotNetPath = "C:\\Windows\\Microsoft.NET\\Framework\\v4.0.30319";
	private JFrame frmTestCase;
	private JPanel nullLayout;
	private JTextPane txtPaneExecuteResult;
	private JButton btnClick;

	private JTextField txtSourcePath;
	private JButton btnBrowse;

	private JTextField txtInputTestCase;
	private JButton btnBrowseInputTestCase;

	private JButton btnBrowseOutputTestCase;
	private JTextField txtOutputTestCase;

	private String [] PATH;

	private JCheckBox chckbxC_1;
	private JCheckBox chckbxC;

	private JPanel pnBrowse;
	private JPanel pnConfig;
	private JCheckBox chkFileSource;
	private JCheckBox chkMoiFileSourceCoThuMucRieng;
	private JPanel pnThuMuc;
	private JTextField txtSourceFileName;
	private JPanel pnTenFile;

	private String [] InputTestCase;
	private String [] OutputTestCase;
	private int nLine;
	private boolean isFirstExcute;
	private String Contents;
	private JLabel lbDiem;
	private String [] ExecuteResult;
	private String [][] ExecuteReport;
	private boolean nonInput;
	private JButton btnXem;
	private JButton btnTrolai;
	// Các biến cờ chứa giá trị
	// cách chấm bài
	private int iCachChamBai;
	private int iCachChamBaiDetail;
	private String TAIL;
	private String strBackupExcecuteResut;
	private int tempScore;
	private JTextField txtXemTenBai;


	private int Compiller;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmMain window = new frmMain();
					window.frmTestCase.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public frmMain() {
		initialize();
		InputTestCase = new String[100];
		OutputTestCase = new String[100];
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		isFirstExcute = true;

		frmTestCase = new JFrame();
		frmTestCase.setTitle("Chấm file cpp và cs");
		frmTestCase.setBounds(100, 100, 829, 759);
		frmTestCase.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// tạo 1 nullLayout để đặt các đối tượng một cách tự do
		nullLayout = new JPanel();
		nullLayout.setLayout(null);
		frmTestCase.getContentPane().add(nullLayout);

		pnBrowse = new JPanel();
		pnBrowse.setBounds(23, 125, 778, 139);
		pnBrowse.setLayout(null);
		nullLayout.add(pnBrowse);

		txtSourcePath = new JTextField();
		txtSourcePath.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtSourcePath.setBounds(212, 0, 554, 35);
		pnBrowse.add(txtSourcePath);
		txtSourcePath.setColumns(10);

		btnBrowse = new JButton("Thư mục chứa source");
		btnBrowse.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnBrowse.setToolTipText("Đường dẫn của thư mục chứa source code");
		btnBrowse.setBackground(Color.ORANGE);
		btnBrowse.setBounds(0, 0, 192, 35);
		pnBrowse.add(btnBrowse);

		btnBrowseInputTestCase = new JButton("Đường dẫn file input");
		btnBrowseInputTestCase.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnBrowseInputTestCase.setToolTipText("Nếu bài toàn không có input thì để trống");
		btnBrowseInputTestCase.setBackground(new Color(0, 255, 255));
		btnBrowseInputTestCase.setBounds(0, 47, 192, 35);
		pnBrowse.add(btnBrowseInputTestCase);

		txtInputTestCase = new JTextField();
		txtInputTestCase.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtInputTestCase.setBounds(212, 47, 554, 35);
		pnBrowse.add(txtInputTestCase);
		txtInputTestCase.setColumns(10);

		btnBrowseOutputTestCase = new JButton("Đường dẫn file output");
		btnBrowseOutputTestCase.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnBrowseOutputTestCase.setToolTipText("Nếu không cần chấm điểm thì để trống");
		btnBrowseOutputTestCase.setBackground(new Color(224, 255, 255));
		btnBrowseOutputTestCase.setBounds(0, 95, 192, 35);
		pnBrowse.add(btnBrowseOutputTestCase);

		txtOutputTestCase = new JTextField();
		txtOutputTestCase.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtOutputTestCase.setBounds(212, 95, 554, 35);
		pnBrowse.add(txtOutputTestCase);
		txtOutputTestCase.setColumns(10);


		btnClick = new JButton("CHẤM BÀI");
		btnClick.setBackground(new Color(0, 250, 154));
		btnClick.setForeground(new Color(0, 0, 139));
		btnClick.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnClick.setBounds(543, 336, 258, 78);
		nullLayout.add(btnClick);

		pnConfig = new JPanel();
		pnConfig.setLayout(null);
		pnConfig.setBounds(23, 37, 310, 70);
		nullLayout.add(pnConfig);

		pnThuMuc = new JPanel();
		pnThuMuc.setBounds(12, 13, 292, 56);
		pnConfig.add(pnThuMuc);
		pnThuMuc.setLayout(null);

		chkFileSource = new JCheckBox("Mỗi sinh viên chỉ có File Source");
		chkFileSource.setBounds(8, 0, 276, 25);
		pnThuMuc.add(chkFileSource);
		chkFileSource.setFont(new Font("Times New Roman", Font.PLAIN, 17));

		chkMoiFileSourceCoThuMucRieng = new JCheckBox("Mỗi sinh viên có thư mục riêng");
		chkMoiFileSourceCoThuMucRieng.setBounds(8, 30, 259, 25);
		pnThuMuc.add(chkMoiFileSourceCoThuMucRieng);
		chkMoiFileSourceCoThuMucRieng.setFont(new Font("Times New Roman", Font.PLAIN, 17));

		pnTenFile = new JPanel();
		pnTenFile.setBounds(23, 266, 467, 40);
		pnTenFile.setLayout(null);
		nullLayout.add(pnTenFile);

		txtSourceFileName = new JTextField();
		txtSourceFileName.setForeground(Color.RED);
		txtSourceFileName.setFont(new Font("Times New Roman", Font.BOLD, 19));
		txtSourceFileName.setBounds(212, 0, 243, 35);
		pnTenFile.add(txtSourceFileName);
		txtSourceFileName.setColumns(10);

		JLabel lblNewLabel = new JLabel("Tên source cần chấm:");
		lblNewLabel.setForeground(new Color(255, 0, 0));
		lblNewLabel.setBounds(32, 1, 182, 35);
		pnTenFile.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));



		TAIL =".cpp";



		//Thêm action cho các button
		btnClick.addActionListener(this);
		btnBrowseOutputTestCase.addActionListener(this);
		btnBrowseInputTestCase.addActionListener(this);
		btnBrowse.addActionListener(this);
		chkFileSource.addActionListener(this);
		chkMoiFileSourceCoThuMucRieng.addActionListener(this);
		

		JLabel lblChnChcNng = new JLabel("CHỌN CHỨC NĂNG:");
		lblChnChcNng.setForeground(new Color(255, 0, 255));
		lblChnChcNng.setFont(new Font("Tahoma", Font.BOLD, 21));
		lblChnChcNng.setBounds(23, 13, 258, 24);
		nullLayout.add(lblChnChcNng);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(23, 336, 508, 365);
		nullLayout.add(scrollPane);
		//	scrollPane.setLayout(null);

		txtPaneExecuteResult = new JTextPane();
		scrollPane.setViewportView(txtPaneExecuteResult);
		txtPaneExecuteResult.setEditable(false);
		txtPaneExecuteResult.setFont(new Font("Tahoma", Font.PLAIN, 20));

		JPanel panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setForeground(Color.LIGHT_GRAY);
		panel.setBounds(543, 431, 258, 268);
		nullLayout.add(panel);
		panel.setLayout(null);

		lbDiem = new JLabel("0/0");
		lbDiem.setBounds(151, 185, 76, 70);
		panel.add(lbDiem);
		lbDiem.setForeground(Color.RED);
		lbDiem.setFont(new Font("Times New Roman", Font.BOLD, 36));

		JLabel lblTLng = new JLabel("Tỉ lệ đúng");
		lblTLng.setBounds(38, 208, 133, 31);
		panel.add(lblTLng);
		lblTLng.setFont(new Font("Times New Roman", Font.PLAIN, 26));

		btnXem = new JButton("Xem");
		btnXem.setBackground(new Color(127, 255, 0));
		btnXem.setBounds(38, 102, 172, 37);
		panel.add(btnXem);

		txtXemTenBai = new JTextField();
		txtXemTenBai.setBounds(38, 58, 172, 31);
		panel.add(txtXemTenBai);
		txtXemTenBai.setColumns(10);

		JLabel lblTnBiCn = new JLabel("Xem kết của của bài ");
		lblTnBiCn.setForeground(Color.BLUE);
		lblTnBiCn.setBounds(38, 13, 191, 31);
		panel.add(lblTnBiCn);
		lblTnBiCn.setFont(new Font("Tahoma", Font.PLAIN, 19));

		btnTrolai = new JButton("Toàn bộ kết quả");
		btnTrolai.setBackground(new Color(224, 255, 255));
		btnTrolai.setBounds(38, 147, 172, 37);
		panel.add(btnTrolai);

		chckbxC = new JCheckBox("C++");
		chckbxC.setFont(new Font("Tahoma", Font.BOLD, 16));
		chckbxC.setBounds(341, 78, 113, 25);
		nullLayout.add(chckbxC);

		chckbxC_1 = new JCheckBox("C#");
		chckbxC_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		chckbxC_1.setBounds(452, 78, 113, 25);
		nullLayout.add(chckbxC_1);

		JLabel lblChnTrnhBin = new JLabel("CHỌN TRÌNH");
		lblChnTrnhBin.setForeground(Color.BLUE);
		lblChnTrnhBin.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblChnTrnhBin.setBounds(333, 37, 136, 32);
		nullLayout.add(lblChnTrnhBin);

		JLabel lblBinDch = new JLabel("BIÊN DỊCH");
		lblBinDch.setForeground(Color.BLUE);
		lblBinDch.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblBinDch.setBounds(470, 33, 119, 40);
		nullLayout.add(lblBinDch);
		btnTrolai.addActionListener(this);
		btnXem.addActionListener(this);
		chckbxC.addActionListener(this);
		chckbxC_1.addActionListener(this);

		//Kiểm tra chwck box của compiller
		chckbxC.setSelected(true);


		iCachChamBai = 2;
		nonInput = true;
		Compiller = 1;

	}

	private void btnBrowseClick()
	{
		TakeFilePath tfp =  new TakeFilePath("Chọn thư mục chứa file");
		String filePATH = tfp.takeFolerDerectory();
		if(!filePATH.trim().equals(""))
		{
			txtSourcePath.setText(filePATH);
		}
		return;
	}

	private void btnBrowseInputTestCaseClick()
	{
		TakeFilePath tfp = new TakeFilePath("Chọn file chứa Test Case input");

		// CurentDectory sẽ là txt của chính nó (Input test case)
		String filePATH = tfp.takeFileDerectory("txt","Text Document",txtInputTestCase.getText());


		if(!filePATH.trim().equals(""))
		{
			txtInputTestCase.setText(filePATH);
		}
		return;
	}

	private void btnBrowseOutputTestCaseClick()
	{
		TakeFilePath tfp = new TakeFilePath("Chọn file chứa Test Case output");

		// CurrentDerectory sẽ là txt của thằng bên trên nó.
		/*
		 Vì theo thói quen của người dùng họ sẽ lấy các file input - output ở cùng 1 địa chỉ
		 */
		String filePATH = tfp.takeFileDerectory("txt","Text Document",txtInputTestCase.getText());
		if(!filePATH.trim().equals(""))
		{
			txtOutputTestCase.setText(filePATH);
		}
		return;
	}

	


	private void chkFileSourceClick()
	{
		if(chkFileSource.isSelected())
		{
			
			JOptionPane.showMessageDialog(null, 
                    "Chọn thư mục chứa các source file cần chấm điểm. Hệ thống sẽ tự nhận diện tên", 
                    "Thông báo", 
                    JOptionPane.WARNING_MESSAGE);
			
			chkMoiFileSourceCoThuMucRieng.setSelected(false);
			//txtSourceFileName.setEnabled(false);
			txtSourceFileName.setText("KHÔNG CẦN NHẬP TÊN");
		}
		else
		{
			JOptionPane.showMessageDialog(null, 
                    "Chọn thư mục chứa các thư mục con chứa source", 
                    "Thông báo", 
                    JOptionPane.WARNING_MESSAGE);
			chkMoiFileSourceCoThuMucRieng.setSelected(true);
			//	txtSourceFileName.setEnabled(true);
			txtSourceFileName.setText("");
		}

	}


	


	private void chkMoiFileSourceCoThuMucRiengClick()
	{
		if(chkMoiFileSourceCoThuMucRieng.isSelected())
		{
			
			JOptionPane.showMessageDialog(null, 
                    "Chọn thư mục chứa các thư mục con chứa source", 
                    "Thông báo", 
                    JOptionPane.WARNING_MESSAGE);
			txtSourceFileName.setText("");
			chkFileSource.setSelected(false);

		}
		else
		{
			JOptionPane.showMessageDialog(null, 
                    "Chọn thư mục chứa các source file cần chấm điểm. Hệ thống sẽ tự nhận diện tên", 
                    "Thông báo", 
                    JOptionPane.WARNING_MESSAGE);
			chkFileSource.setEnabled(true);
			txtSourceFileName.setText("KHÔNG CẦN NHẬP TÊN");
		}
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		//Lấy địa chỉ thư mục chứa file source
		if(e.getSource() == btnBrowse )
		{
			btnBrowseClick();
			return;
		}

		//Lấy địa chỉ của file txt chứa testcase của input
		if(e.getSource() == btnBrowseInputTestCase)
		{
			btnBrowseInputTestCaseClick();
			return;
		}

		//Lấy địa chỉ của file txt chứa testcase của ouput
		if(e.getSource() == btnBrowseOutputTestCase)
		{		
			btnBrowseOutputTestCaseClick();
			return;
		}
		// xử lý checkbox chỉ source file
		if(e.getSource() == chkFileSource)
		{
			iCachChamBaiDetail = 1;
			chkFileSourceClick();
			return;
		}

		if(e.getSource() == chkMoiFileSourceCoThuMucRieng)
		{
			chkMoiFileSourceCoThuMucRiengClick();
			iCachChamBaiDetail = 2;
			return;
		}

		// button chấm bài
		if(e.getSource() == btnClick)
		{
			if(Compiller == 1)
			{
				btnChamBaiClick();
			}
			else
			{
				
				btnChamBaiClick_1();

			}

			return;
		}

		// button xem lại bài
		if(e.getSource() ==  btnXem)
		{
			btnXemClick();
			return;
		}


		// button trở lại (hay là xem tất cả đáp án)
		if(e.getSource() == btnTrolai)
		{
			btnTroiLaiClick();
			return;
		}

		if(e.getSource() == chckbxC)
		{
			chckbxCClick();
			return;
		}

		if(e.getSource() == chckbxC_1)
		{
			chckbxC_1Click();
			return;
		}

	}

	private void chckbxCClick()
	{
		if(chckbxC.isSelected())
		{
			TAIL = ".cpp";
			Compiller = 1;
			chckbxC_1.setSelected(false);
		}
		else
		{
			TAIL = ".cs";
			Compiller = 2;
			chckbxC_1.setSelected(true);
		}
	}

	private void chckbxC_1Click()
	{
		if(chckbxC_1.isSelected())
		{
			
			TAIL = ".cs";
			Compiller = 2;
			JOptionPane.showMessageDialog(null, 
                    "Chạy chương trình với quyền administrator", 
                    "Thông báo", 
                    JOptionPane.WARNING_MESSAGE);
			
			chckbxC.setSelected(false);
		}
		else
		{
			TAIL = ".cpp";
			Compiller = 1;
			chckbxC.setSelected(true);
		}
	}

	private void btnXemClick()
	{

		int i = Integer.valueOf(txtXemTenBai.getText().trim());
		String strNewContents = ExecuteReport[i-1][1];
		txtPaneExecuteResult.setText(strNewContents);
		lbDiem.setText(ExecuteReport[i-1][2] + "/" + String.valueOf(nLine));
	}

	private void btnTroiLaiClick()
	{
		txtXemTenBai.setText("");
		txtPaneExecuteResult.setText(strBackupExcecuteResut);
		lbDiem.setText("0/0");
	}

	private void excuteCommand(String otherCommand, boolean isFirstTime) // chổ này mới execute.
	{

		ExecuteShellComand cmd = new ExecuteShellComand();
		String [] strDirectToFoloder = new String[6];

		strDirectToFoloder[0] = txtSourcePath.getText().substring(0, 2);
		strDirectToFoloder[1] =  "cd " + txtSourcePath.getText();

		// Tối ưu hóa thời gian excute, built rồi thì ko built nữa
		if(isFirstTime)
			strDirectToFoloder[2] =  " g++ " + "\"" +txtSourceFileName.getText() + "\""  +TAIL + " -o " + "\""  +  txtSourceFileName.getText() + "\""  + ".exe";
		else
			strDirectToFoloder[2] ="";

		strDirectToFoloder[3] = "\""  + txtSourceFileName.getText() +  "\""  + ".exe > " + "\""+ txtSourceFileName.getText() + "\"Output.txt";

		strDirectToFoloder[4] =otherCommand; // other command

		cmd.runCommand(strDirectToFoloder, 5);

	}

	private void executeCommandWithDotNet(String otherCommand, boolean isFirstTime)
	{
		ExecuteShellComand cmd = new ExecuteShellComand();
		String [] strDirectToFoloder = new String[6];

		strDirectToFoloder[0] = txtSourcePath.getText().substring(0, 2);
		//Source PATH la duong dan Thu MUC CHUA BAI CAN CHAM
		
		// tro toi thu muc chua .NET
		strDirectToFoloder[1] =  "cd "+DotNetPath;

		// Tối ưu hóa thời gian excute, built rồi thì ko built nữa
		if(isFirstTime)
			strDirectToFoloder[2] =  "csc "+"\""+txtSourcePath.getText()+"\\"+ txtSourceFileName.getText() +"\"" +".cs"; // Cái này là build thành file EXE
		else
			strDirectToFoloder[2] ="";

		strDirectToFoloder[3] = "\""  + txtSourceFileName.getText() +  "\""  + ".exe > " + "\""+ txtSourceFileName.getText() + "Output\".txt"; // cái này là xuất ra file

		strDirectToFoloder[4] =otherCommand; // other command

		cmd.runCommand(strDirectToFoloder, 5);

	}

	private void runChamBai()
	{
		//ĐIỂM TẠM
		tempScore = 0;


		// Contents gốc
		Contents ="";

		// file được xuất ra sẽ có dạng tên + Output.txt
		for(int i = 0; i<nLine; i++)
		{

			// khởi tạo executeResult
			ExecuteResult = new String[100];

			excuteCommand(InputTestCase[i], isFirstExcute);
			isFirstExcute = false;


			//Đoạn này đọc dữ liệu từ file đã được tạo sau mỗi lần excute
			ReadFile rf = new ReadFile();

			// Biến này lấy lên được kết quả của mỗi lần execute
			String tempContents =rf.readTextFile(txtSourcePath.getText()+"\\"+txtSourceFileName.getText()+"Output.txt").trim();
			ExecuteResult[i] = tempContents.trim();

			// Biến này ghi lại tất cả kết quả đã execute theo cách cộng dồn.
			Contents +=tempContents;
			Contents += '\n';

			if(tempContents.trim().toString().equals(OutputTestCase[i].trim().toString()))
			{
				tempScore++;
			}
			else
			{
				System.out.println(tempContents + " && " +OutputTestCase[i]);
			}


		}

		isFirstExcute = true;
		// Sau khi chạy xong chương trình thì dừng luôn

	}



	private void btnChamBaiClick()
	{

		txtPaneExecuteResult.setText("");

		if(!txtInputTestCase.getText().trim().equals(""))
		{
			loadInputTestCase();

		}
		else
		{
			//Khi ko có nhập file input, input = null, nó sẽ bị lỗi
			InputTestCase[0] = " ";
			nLine = 1;
		}

		if(!txtOutputTestCase.getText().trim().equals(""))
		{
			loadOutPutTestCase();
		}
		else
		{
			OutputTestCase[0] =" ";
			nLine = 1;
		}

		if(iCachChamBai == 1)
		{

			runChamBai();
			// hiện ra màn hình
			txtPaneExecuteResult.setText(Contents);
			lbDiem.setText(String.valueOf(tempScore) +"/" + String.valueOf(nLine));
		}
		else
		{

			if(iCachChamBaiDetail == 1)
			{
				txtPaneExecuteResult.setText("");
				// CHẤM NHIỀU NGƯỜI.

				// TH1: Nhiều file nằm chung một thư mục.
				// Đọc Danh sách ra
				// đối tượng sử dụng:

				//ExecuteReport chứa tất cả điểm của tất cả bài.
				// Cấu trúc của executeReport là 1 mảng 2 chiều gồm n dòng và 3 cột.
				// Cột đầu là lưu tên file CPP hoặc CS.
				// Cột 2 là lưu điểm
				// Cột 3 là cột để lưu kết quả.


				//lấy danh sách tên source ra một mảng.
				LISTDIR ld = new LISTDIR();
				String [] DirPath = ld.takeDirectoryTree(txtSourcePath.getText(), TAIL);
				int nDirPath  = ld.takenPath();

				// Chuẩn hóa và đổi tên file.
				// Lý do phải chuẩn hóa tên file là do nếu tên file có khoanrgc ách trình biên dịch sẽ không thể hiểu


				ExecuteReport = new String [100][3];
				// Duyệt toàn bộ danh sách source file
				for(int  k= 0; k<nDirPath; k++)
				{	
					txtSourceFileName.setText(DirPath[k]);

					runChamBai();

					int strSize = txtSourceFileName.getText().length();
					ExecuteReport[k][0] =  txtSourceFileName.getText()  ;
					ExecuteReport[k][1] = Contents;
					ExecuteReport[k][2] = String.valueOf(tempScore);
					txtPaneExecuteResult.setText(  (txtPaneExecuteResult.getText()+ '\n' + "STT "+ String.valueOf(k+1)+ ": " + ExecuteReport[k][0] + " - " +
							ExecuteReport[k][2] ).trim()+"/" + String.valueOf(nLine));


				}

				txtSourceFileName.setText("KHÔNG CẦN NHẬP TÊN");
				strBackupExcecuteResut = txtPaneExecuteResult.getText();

			}
			else
			{
				// MỖI SOURCE FILE ĐỀU CÓ MỘT THƯ MỤC RIÊNG.

				// Backup địa chỉ thư mục lớp
				String backupSourceFolderLink = txtSourcePath.getText();



				//Lấy danh sách tất cả các thư mục chứa thư mục source.

				LISTDIR ldFolder = new LISTDIR();
				String [] DirPath = ldFolder.takeDirectoryTree(txtSourcePath.getText(), "");
				int nFolderDirPath  = ldFolder.takenPath();


				//Sử dụng ExecuteReport lưu lại kết quả.
				// Với cấu trúc: E[0] tên folder - Tên bài E[1] = kết quả E[2] = Điểm
				
				ExecuteReport = new String [100][3];
				// Ứng với mỗi folder. 
				//Sửa lại folderPath bằng cách cộng thêm vào tên folder đã lấy

				for(int  i = 0; i<nFolderDirPath; i++)
				{
					// Set mọi thông số out - in
					// Set đường link mới.
					// Gọi chấm bài
					String newPath = backupSourceFolderLink + "\\" + DirPath[i]; 
					txtSourcePath.setText(newPath);
					runChamBai();

					int strSize = txtSourceFileName.getText().length();
					ExecuteReport[i][0] =  txtSourceFileName.getText() + " - "+ DirPath[i]  ;
					ExecuteReport[i][1] = Contents;
					ExecuteReport[i][2] = String.valueOf(tempScore);

					// In ra màn hình
					txtPaneExecuteResult.setText( (txtPaneExecuteResult.getText()+ '\n' + "STT "+ String.valueOf(i+1) + ": "+  ExecuteReport[i][0] + " - " 
							+ ExecuteReport[i][2] ).trim() +"/" + String.valueOf(nLine));

				}

				txtSourcePath.setText(backupSourceFolderLink);
				strBackupExcecuteResut = txtPaneExecuteResult.getText();




			}

		}


	}

	
	private void btnChamBaiClick_1()
	{

		txtPaneExecuteResult.setText("");

		if(!txtInputTestCase.getText().trim().equals(""))
		{
			loadInputTestCase();

		}
		else
		{
			//Khi ko có nhập file input, input = null, nó sẽ bị lỗi
			InputTestCase[0] = " ";
			nLine = 1;
		}

		if(!txtOutputTestCase.getText().trim().equals(""))
		{
			loadOutPutTestCase();
		}
		else
		{
			OutputTestCase[0] =" ";
			nLine = 1;
		}

		if(iCachChamBai == 1)
		{

			runChamBai_1();
			// hiện ra màn hình
			txtPaneExecuteResult.setText(Contents);
			lbDiem.setText(String.valueOf(tempScore) +"/" + String.valueOf(nLine));
		}
		else
		{

			if(iCachChamBaiDetail == 1)
			{
				txtPaneExecuteResult.setText("");
				// CHẤM NHIỀU NGƯỜI.

				// TH1: Nhiều file nằm chung một thư mục.
				// Đọc Danh sách ra
				// đối tượng sử dụng:

				//ExecuteReport chứa tất cả điểm của tất cả bài.
				// Cấu trúc của executeReport là 1 mảng 2 chiều gồm n dòng và 3 cột.
				// Cột đầu là lưu tên file CPP hoặc CS.
				// Cột 2 là lưu điểm
				// Cột 3 là cột để lưu kết quả.


				//lấy danh sách tên source ra một mảng.
				LISTDIR ld = new LISTDIR();
				String [] DirPath = ld.takeDirectoryTree(txtSourcePath.getText(), TAIL);
				int nDirPath  = ld.takenPath();

				// Chuẩn hóa và đổi tên file.
				// Lý do phải chuẩn hóa tên file là do nếu tên file có khoanrgc ách trình biên dịch sẽ không thể hiểu


				ExecuteReport = new String [100][3];
				// Duyệt toàn bộ danh sách source file
				for(int  k= 0; k<nDirPath; k++)
				{	
					txtSourceFileName.setText(DirPath[k]);

					runChamBai_1();

					int strSize = txtSourceFileName.getText().length();
					ExecuteReport[k][0] =  txtSourceFileName.getText()  ;
					ExecuteReport[k][1] = Contents;
					ExecuteReport[k][2] = String.valueOf(tempScore);
					txtPaneExecuteResult.setText(  (txtPaneExecuteResult.getText()+ '\n' + "STT "+ String.valueOf(k+1)+ ": " + ExecuteReport[k][0] + " - " +
							ExecuteReport[k][2] ).trim()+"/" + String.valueOf(nLine));


				}

				txtSourceFileName.setText("KHÔNG CẦN NHẬP TÊN");
				strBackupExcecuteResut = txtPaneExecuteResult.getText();

			}
			else
			{
				// MỖI SOURCE FILE ĐỀU CÓ MỘT THƯ MỤC RIÊNG.

				// Backup địa chỉ thư mục lớp
				String backupSourceFolderLink = txtSourcePath.getText();



				//Lấy danh sách tất cả các thư mục chứa thư mục source.

				LISTDIR ldFolder = new LISTDIR();
				String [] DirPath = ldFolder.takeDirectoryTree(txtSourcePath.getText(), "");
				int nFolderDirPath  = ldFolder.takenPath();


				//Sử dụng ExecuteReport lưu lại kết quả.
				// Với cấu trúc: E[0] tên folder - Tên bài E[1] = kết quả E[2] = Điểm
				
				ExecuteReport = new String [100][3];
				// Ứng với mỗi folder. 
				//Sửa lại folderPath bằng cách cộng thêm vào tên folder đã lấy

				for(int  i = 0; i<nFolderDirPath; i++)
				{
					// Set mọi thông số out - in
					// Set đường link mới.
					// Gọi chấm bài
					String newPath = backupSourceFolderLink + "\\" + DirPath[i]; 
					txtSourcePath.setText(newPath);
					runChamBai_1();

					int strSize = txtSourceFileName.getText().length();
					ExecuteReport[i][0] =  txtSourceFileName.getText() + " - "+ DirPath[i]  ;
					ExecuteReport[i][1] = Contents;
					ExecuteReport[i][2] = String.valueOf(tempScore);

					// In ra màn hình
					txtPaneExecuteResult.setText( (txtPaneExecuteResult.getText()+ '\n' + "STT "+ String.valueOf(i+1) + ": "+  ExecuteReport[i][0] + " - " 
							+ ExecuteReport[i][2] ).trim() +"/" + String.valueOf(nLine));

				}

				txtSourcePath.setText(backupSourceFolderLink);
				strBackupExcecuteResut = txtPaneExecuteResult.getText();




			}

		}


	}


	private void runChamBai_1()
	{
		//ĐIỂM TẠM
		tempScore = 0;


		// Contents gốc
		Contents ="";

		// file được xuất ra sẽ có dạng tên + Output.txt
		for(int i = 0; i<nLine; i++)
		{

			// khởi tạo executeResult
			ExecuteResult = new String[100];

			executeCommandWithDotNet(InputTestCase[i], isFirstExcute);
			isFirstExcute = false;


			//Đoạn này đọc dữ liệu từ file đã được tạo sau mỗi lần excute
			ReadFile rf = new ReadFile();

			// Biến này lấy lên được kết quả của mỗi lần execute
			// đối với .NET là phải đi vào bên trong thư mục gốc của .NET để lấy file
			String tempContents =rf.readTextFile(DotNetPath+"\\"+txtSourceFileName.getText()+"Output.txt").trim();
			ExecuteResult[i] = tempContents.trim();

			// Biến này ghi lại tất cả kết quả đã execute theo cách cộng dồn.
			Contents +=tempContents;
			Contents += '\n';

			if(tempContents.trim().toString().equals(OutputTestCase[i].trim().toString()))
			{
				tempScore++;
			}
			else
			{
				System.out.println(tempContents + " && " +OutputTestCase[i]);
			}


		}

		isFirstExcute = true;
		// Sau khi chạy xong chương trình thì dừng luôn

	}
	
	
	public String chuanHoa(String str) {
		str = str.trim();
		str = str.replaceAll("\\s+", "");
		return str;
	}


	private void loadInputTestCase()
	{
		ReadFile rf = new ReadFile();
		InputTestCase = rf.readTextFiletoArray(txtInputTestCase.getText());
		nLine = rf.takenLine();
	}

	private void loadOutPutTestCase()
	{
		ReadFile rf = new ReadFile();
		OutputTestCase = rf.readTextFiletoArray(txtOutputTestCase.getText());
		nLine = rf.takenLine();
	}
}

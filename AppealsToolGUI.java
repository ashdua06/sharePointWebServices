package com.jw.sharepoint.examples;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.font.TextAttribute;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Map;
import java.awt.*;
import java.awt.event.*;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;


public class AppealsToolGUI implements ActionListener {
	static Font stdfont = new Font("Times New Roman",Font.BOLD,16);
	 static JFrame frame;
	static JButton ETS,IDRS,EDSS,WAND,CDX,CDB,COC,SCI_IDRS,Searchbtn,Reset,Download,NextPage,PrevPage,DocumentViewer,ICUE ;
	static JMenuItem CEI,MHI,AHI,AHUI_TIN,AHI_TIN_SUFFIX,RHI,ISI,MRI,OII,FCI,PTI,IBAAG,MMI,PPI,ITI,ARI,CMI,PHI,Remark_Code,NDB,IAI,IDI;
	static JTextField CaseIDValue;
	static JMenu TOPS;
	static JPanel jPanel2;
	static String ScreenName="";
	static int totalimages=0;
	static ImageIcon NextPageImg,PrevPageImg;
	public static BufferedImage OptumIcon,OptumPicture;
	
	
	
	public AppealsToolGUI() throws Exception{
	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();	
	frame = new JFrame("Appeal Virtual Solution");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    //Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    //frame.setSize(1950, 1080);
    frame.setSize(screenSize.width, screenSize.height);
   // System.out.println("width is "+screenSize.width+" and height is "+screenSize.height);
   // frame.setSize(frame.getMaximumSize());
    
   frame.getContentPane().setBackground(Color.WHITE);
   OptumIcon=ImageIO.read(new File("Configuration\\OptumIconLogo.png"));
   frame.setIconImage(OptumIcon);
    
    //-----------------------Main Panel-----------------------------------------------------------
    JPanel mainPanel = new JPanel();
    mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
   
   

    
    //-----------First panel displays last login and Nt ID----------------------------------------------------
    JPanel panel1 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
    JLabel loginlabel = new JLabel(" Last Login ");
    JTextField loginvalue = new JTextField(13);
    loginvalue.setEditable(false);
    loginvalue.setFont(stdfont);
    loginvalue.setText(new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(Calendar.getInstance().getTime()));
    loginvalue.setPreferredSize(new java.awt.Dimension(80, 25));
    loginlabel.setFont(stdfont);
    loginlabel.setForeground(Color.black);
    loginlabel.setBorder(BorderFactory.createLineBorder(Color.black, 2));
    JLabel NtIDlabel = new JLabel(" RA NT ID ");
    NtIDlabel.setBorder(BorderFactory.createLineBorder(Color.black, 2));
    JTextField ntIDvalue = new JTextField(7);
    ntIDvalue.setPreferredSize(new java.awt.Dimension(80, 25));
    ntIDvalue.setFont(stdfont);
    ntIDvalue.setEditable(false);
    //Setting ms Id of the user
    String ntIdValue = System.getProperty("user.home").substring(System.getProperty("user.home").lastIndexOf("\\")+1);
    ntIDvalue.setText(ntIdValue);
    
    NtIDlabel.setFont(stdfont);
    NtIDlabel.setForeground(Color.black);
    JLabel label1Space = new JLabel("                           ");
    panel1.add(loginlabel);
    panel1.add(loginvalue);
    panel1.add(NtIDlabel);
    panel1.add(ntIDvalue);
    panel1.add(label1Space);
    panel1.setBackground(Color.ORANGE);
  //-----------First panel Ends----------------------------------------------------
    
    
  //---------------------Blank Panel b/w 1 and 2--------------------------------------------------------
    JPanel blankPanel12 = new JPanel(new FlowLayout(FlowLayout.LEFT));
    //JLabel blankspace12 = new JLabel(" ");
    JLabel blankspace12 = new JLabel(" ");
    blankPanel12.add(blankspace12);
    blankPanel12.setBackground(Color.WHITE);
    //-----------Blank Panel b/w 1 and 2 Ends----------------------------------------------------
    
    
  //-----------Second panel displays Tool Name----------------------------------------------------
    JPanel panel2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
    OptumPicture=ImageIO.read(new File("Configuration\\OptumPic.jpg"));
    JLabel optumpic = new JLabel(new ImageIcon(OptumPicture));
    JLabel ToolHeading = new JLabel(" Appeal Virtual Solution ");
    JLabel Panel2Space1 = new JLabel("      ");
    JLabel Panel2Space2 = new JLabel("                                                      "
    		+ "                                                                                        "
    		+ "                                   ");
    //Set Border
   Border redBorder = BorderFactory.createLineBorder(Color.MAGENTA, 2);
   Border orangeBorder = BorderFactory.createLineBorder(Color.BLUE, 2);
   Border yellowBorder = BorderFactory.createLineBorder(Color.YELLOW, 5);
   Border greenBorder = BorderFactory.createLineBorder(Color.GREEN, 2);
   Border blueBorder = BorderFactory.createLineBorder(Color.ORANGE, 4);
   Border magentaBorder = BorderFactory.createLineBorder(Color.RED, 3);
   Border twoColorBorder = new CompoundBorder(magentaBorder, blueBorder);
   Border threeColorBorder = new CompoundBorder(twoColorBorder, greenBorder);
   Border fourColorBorder = new CompoundBorder(threeColorBorder, yellowBorder);
   Border fiveColorBorder = new CompoundBorder(fourColorBorder, orangeBorder);
   Border sixColorBorder = new CompoundBorder(fiveColorBorder, redBorder);
   ToolHeading.setBorder(sixColorBorder);
    Font headingfont = new Font("Times New Roman",Font.BOLD,36);
    ToolHeading.setFont(headingfont);
    /*Map attributes = headingfont.getAttributes();
    attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);  //Underline Label
    ToolHeading.setFont(headingfont.deriveFont(attributes));*/
    ToolHeading.setForeground(Color.black);
    panel2.add(Panel2Space1);
    panel2.add(optumpic);
    panel2.add(Panel2Space2);
    panel2.add(ToolHeading);
    panel2.setBackground(Color.WHITE);
  //-----------Second panel Ends----------------------------------------------------
   
    
  //---------------------Blank Panel b/w 2 and 3--------------------------------------------------------
    JPanel blankPanel23 = new JPanel(new FlowLayout(FlowLayout.LEFT));
    Reset=new JButton("Reset");
    Reset.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    Reset.setFont(new Font("Times New Roman",Font.BOLD,25));
    Reset.setPreferredSize(new java.awt.Dimension(100, 35));
    Reset.addActionListener(this);
    Reset.setActionCommand(Reset.getText());
    blankPanel23.setBackground(Color.WHITE);
    JLabel Label2Space3 = new JLabel("                                                                   "
    		+ "                                                                                          "
    		+ "                                                                                  "
    		+ "                                                                                   "
    		+ "                                                                                "
    		+ "                                                                          "
    		+ "                                                                         "
    		+ "                     ");
    blankPanel23.add(Label2Space3);
    blankPanel23.add(Reset);
    //-----------Blank Panel b/w 2 and 3 Ends----------------------------------------------------
    
    
  //-----------Third panel displays Case ID and Search----------------------------------------------------
    JPanel panel3 = new JPanel(new FlowLayout(FlowLayout.LEFT));
    JLabel CaseID = new JLabel("Enter Case ID");
    CaseID.setFont(new Font("Times New Roman",Font.BOLD,25));
    NtIDlabel.setForeground(Color.black);
    CaseIDValue = new JTextField(13);
    CaseIDValue.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
    CaseIDValue.setPreferredSize(new java.awt.Dimension(100, 35));
    CaseIDValue.setFont(new Font("Times New Roman",Font.BOLD,25));
    JLabel Panel3Space1 = new JLabel("            ");
    Searchbtn=new JButton("Search");
    Searchbtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    Searchbtn.setFont(new Font("Times New Roman",Font.BOLD,25));
    Searchbtn.addActionListener(this);
    Searchbtn.setActionCommand(Searchbtn.getText());
    JLabel Panel3Space2 = new JLabel("                              ");
    panel3.add(Label2Space3);
    panel3.add(Reset);
   
    panel3.setBackground(Color.WHITE);
    
  //-----------Third panel Ends---------------------------------------------------- 
    
    //---------------------Blank Panel b/w 3 and 4--------------------------------------------------------
    JPanel blankPanel34 = new JPanel();
    JLabel blankspace34 = new JLabel(" ");
    blankPanel34.add(blankspace34);
    blankPanel34.setBackground(Color.WHITE);
    //-----------Blank Panel b/w 3 and 4 Ends----------------------------------------------------
    
    
    
  //-----------Fourth panel displays Application name labels----------------------------------------------------
    JPanel panel4 = new JPanel(new FlowLayout(FlowLayout.LEFT));
    JLabel Panel4Space1 = new JLabel("  ");
    JLabel Panel4Space2 = new JLabel("                                                      "
    		+ "                                                           "
    		+ "                                                           ");
    JLabel Panel4Space3 = new JLabel("                                                                                  ");
    JLabel AppName = new JLabel("User Click option to select Application Name");
    NextPageImg = new ImageIcon("Configuration\\NextPage.jpg");
    PrevPageImg = new ImageIcon("Configuration\\PreviousPage.png");

    NextPage = new JButton(NextPageImg);
    PrevPage= new JButton(PrevPageImg);
    
    NextPage.setPreferredSize(new java.awt.Dimension(60, 60));
    PrevPage.setPreferredSize(new java.awt.Dimension(60, 60));
	
    NextPage.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
    PrevPage.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
    NextPage.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    PrevPage.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    NextPage.addActionListener(this);
    PrevPage.addActionListener(this);
    NextPage.setActionCommand("NextPage");
    PrevPage.setActionCommand("PrevPage");
    NextPage.setEnabled(false);
    PrevPage.setEnabled(false);
    
    AppName.setFont(new Font("Times New Roman",Font.ITALIC,17));
    AppName.setForeground(Color.black);
    panel4.add(Panel4Space1);
    panel4.add(AppName);
    panel4.add(Panel4Space2);
    panel4.add(PrevPage);
    panel4.add(NextPage);
    //Move Panel 3 to 4
    panel4.add(Panel4Space3);
    panel4.add(CaseID);
    panel4.add(CaseIDValue);
    panel4.add(Panel3Space1);
    panel4.add(Searchbtn);
    panel4.add(Panel3Space2);
    
    panel4.setBackground(Color.WHITE);
    
  //-----------fourth panel Ends---------------------------------------------------- 
    
    
    
    
  //----------Left series of button pannel---------------------------------------------------
   
    JPanel jPanel1 = new JPanel();
    jPanel1.setLayout(null);

    JPanel ButtonsPanel = new JPanel();
    FlowLayout ButtonsPanelLayout = new FlowLayout();
    jPanel1.add(ButtonsPanel);
    ButtonsPanel.setLayout(ButtonsPanelLayout);
    ButtonsPanel.setBounds(12, 23, 180, screenSize.height-370);
    
    ButtonsPanel.setBorder(BorderFactory.createEtchedBorder(BevelBorder.LOWERED));

    //ETS APP BUTTON
    ETS = new JButton();
    ButtonsPanel.add(ETS);
    ETS.setText("ETS");
    setButtonsAttribute(ETS);
    
   /*ETS.addActionListener(new ActionListener(){
	    @Override
	    public void actionPerformed(ActionEvent e){
	    	
	    	try {
				ImageMain("http://app40-07.uhg.com/sites/BP/CA/ORS/Appeal RPA  Detail/Test/testdua.jpeg");
			} catch (Exception e1) {
				ErrorMessgFrame();
			}
	    }
	});*/
    
   

    //TOPS Menu Bar----------------------------------------------------------------------------
    JMenuBar menuBar = new JMenuBar();
    menuBar.setPreferredSize(new java.awt.Dimension(140, 45));
    TOPS = new JMenu("           TOPS");
    TOPS.setEnabled(false);
    TOPS.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    TOPS.setFont(stdfont);
    TOPS.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
   TOPS.setPreferredSize(new java.awt.Dimension(140, 45));
 //   menuBar.setBackground(Color.cyan);
    
    menuBar.add(TOPS);
    
    //CEI menu item in TOPS
    CEI = new JMenuItem("CEI");
    setMenuItemAttribute(CEI);
    //MHI menu item in TOPS
    MHI = new JMenuItem("MHI");
    setMenuItemAttribute(MHI);
    //AHI menu item in TOPS
    AHI = new JMenuItem("AHI");
    setMenuItemAttribute(AHI);
    //AHUI+TIN menu item in TOPS
    AHUI_TIN = new JMenuItem("AHUI+TIN");
    setMenuItemAttribute(AHUI_TIN);
    //AHI_TIN+SUFFIX menu item in TOPS
    AHI_TIN_SUFFIX = new JMenuItem("AHI_TIN+SUFFIX");
    setMenuItemAttribute(AHI_TIN_SUFFIX);
    //RHI menu item in TOPS
    RHI = new JMenuItem("RHI");
    setMenuItemAttribute(RHI);
    //ISI menu item in TOPS
    ISI = new JMenuItem("ISI");
    setMenuItemAttribute(ISI);
    //MRI menu item in TOPS
    MRI = new JMenuItem("MRI");
    setMenuItemAttribute(MRI);
    //OII menu item in TOPS
    OII = new JMenuItem("OII");
    setMenuItemAttribute(OII);
    //FCI menu item in TOPS
    FCI = new JMenuItem("FCI");
    setMenuItemAttribute(FCI);
    //PTI menu item in TOPS
    PTI = new JMenuItem("PTI");
    setMenuItemAttribute(PTI);
    //IBAAG menu item in TOPS
    IBAAG = new JMenuItem("IBAAG");
    setMenuItemAttribute(IBAAG);
    //MMI menu item in TOPS
    MMI = new JMenuItem("MMI");
    setMenuItemAttribute(MMI);
    //PPI menu item in TOPS
    PPI = new JMenuItem("PPI");
    setMenuItemAttribute(PPI);
    //ITI menu item in TOPS
    ITI = new JMenuItem("ITI");
    setMenuItemAttribute(ITI);
    //ARI menu item in TOPS
    ARI = new JMenuItem("ARI");
    setMenuItemAttribute(ARI);
    //CMI menu item in TOPS
    CMI = new JMenuItem("CMI");
    setMenuItemAttribute(CMI);
    //PHI menu item in TOPS
    PHI = new JMenuItem("PHI");
    setMenuItemAttribute(PHI);
    //Remark Code menu item in TOPS
    Remark_Code = new JMenuItem("RemarkCode");
    setMenuItemAttribute(Remark_Code);
    //NDB menu item in TOPS
    NDB = new JMenuItem("NDB");
    setMenuItemAttribute(NDB);
    //IDI menu item in TOPS
    IDI = new JMenuItem("IDI");
    setMenuItemAttribute(IDI);
    //IAI menu item in TOPS
    IAI = new JMenuItem("IAI");
    setMenuItemAttribute(IAI);
    
    //Add menuitems in menu
    TOPS.add(CEI);
    TOPS.addSeparator();
    TOPS.add(MHI);
    TOPS.addSeparator();
    TOPS.add(AHI);
    TOPS.addSeparator();
    TOPS.add(AHUI_TIN);
    TOPS.addSeparator();
    TOPS.add(AHI_TIN_SUFFIX);
    TOPS.addSeparator();
    TOPS.add(RHI);
    TOPS.addSeparator();
    TOPS.add(ISI);
    TOPS.addSeparator();
    TOPS.add(MRI);
    TOPS.addSeparator();
    TOPS.add(OII);
    TOPS.addSeparator();
    TOPS.add(FCI);
    TOPS.addSeparator();
    TOPS.add(PTI);
    TOPS.addSeparator();
    TOPS.add(IBAAG);
    TOPS.addSeparator();
    TOPS.add(MMI);
    TOPS.addSeparator();
    TOPS.add(PPI);
    TOPS.addSeparator();
    TOPS.add(ITI);
    TOPS.addSeparator();
    TOPS.add(ARI);
    TOPS.addSeparator();
    TOPS.add(CMI);
    TOPS.addSeparator();
    TOPS.add(PHI);
    TOPS.addSeparator();
    TOPS.add(Remark_Code);
    TOPS.addSeparator();
    TOPS.add(NDB);
    TOPS.addSeparator();
    TOPS.add(IDI);
    TOPS.addSeparator();
    TOPS.add(IAI);
    TOPS.addSeparator();
    
    ButtonsPanel.add(menuBar);
  
    
    
    //IDRS APP BUTTON---------------------------------------------------------------------------------------
    IDRS = new JButton();
    ButtonsPanel.add(IDRS);
    IDRS.setText("IDRS");
    setButtonsAttribute(IDRS);


    //EDSS APP BUTTON
    EDSS = new JButton();
    ButtonsPanel.add(EDSS);
    EDSS.setText("EDSS");
    setButtonsAttribute(EDSS);


    //WAND APP BUTTON
    WAND = new JButton();
    ButtonsPanel.add(WAND);
    WAND.setText("WAND");
    setButtonsAttribute(WAND);
    
    //CDX APP BUTTON
    CDX = new JButton();
    ButtonsPanel.add(CDX);
    CDX.setText("CDX");
    setButtonsAttribute(CDX);

    
    //CDB APP BUTTON
    CDB = new JButton();
    ButtonsPanel.add(CDB);
    CDB.setText("CDB");
    setButtonsAttribute(CDB);
    
 	//COC APP BUTTON
    COC = new JButton();
    ButtonsPanel.add(COC);
    COC.setText("COC");
    setButtonsAttribute(COC);

    
    //SCI- IDRS APP BUTTON
    SCI_IDRS = new JButton();
    ButtonsPanel.add(SCI_IDRS);
    SCI_IDRS.setText("SCI- IDRS");
    setButtonsAttribute(SCI_IDRS);
    
    
    //DocumentViewer APP BUTTON
    DocumentViewer = new JButton();
    ButtonsPanel.add(DocumentViewer);
    DocumentViewer.setText("DocumentViewer");
    setButtonsAttribute(DocumentViewer);
    
    //ICUE APP BUTTON
    ICUE = new JButton();
    ButtonsPanel.add(ICUE);
    ICUE.setText("ICUE");
    setButtonsAttribute(ICUE);
    
    jPanel2 = new JPanel();
    jPanel1.add(jPanel2);
    jPanel2.setLayout(null);
    //jPanel2.setBounds(122, 23, 1750, 700);
    jPanel2.setBounds(122, 23, screenSize.width-150, screenSize.height-370);
    
    jPanel2.setBorder(BorderFactory.createEtchedBorder(BevelBorder.LOWERED));
    
    
    Download = new JButton();
    setButtonsAttribute(Download);
    
  //-----------END Left series of button pannel---------------------------------------------------- 
    
    
    //-----------Main Panel Add----------------------------------------------------
    mainPanel.add( panel1);
    mainPanel.add( blankPanel12);
    mainPanel.add( panel2);
    //mainPanel.add( blankPanel23);
    mainPanel.add( panel3);
   // mainPanel.add( blankPanel34);
    mainPanel.add( panel4);
    mainPanel.add( jPanel1);
    
    
    frame.getContentPane().add(BorderLayout.NORTH, mainPanel);
    
    frame.getContentPane().add(BorderLayout.CENTER, jPanel1);
    frame.setVisible(true);
    
	}
	
	public void setButtonsAttribute(JButton BtnName){
		BtnName.setPreferredSize(new java.awt.Dimension(140, 45));
		BtnName.setFont(stdfont);
		BtnName.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
		BtnName.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		BtnName.addActionListener(this);
		BtnName.setEnabled(false);
		if(BtnName.getText().equals("SCI- IDRS")){
			BtnName.setActionCommand("SCI");
			return;
		}
		BtnName.setActionCommand(BtnName.getText());
		
	}
	
	public void setMenuItemAttribute(JMenuItem menuItem){
		menuItem.setPreferredSize(new java.awt.Dimension(140, 35));
		menuItem.setFont(stdfont);
		menuItem.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
		menuItem.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		menuItem.setBackground(Color.GREEN);
		menuItem.addActionListener(this);
	 
	}
	

	@Override
	public void actionPerformed(ActionEvent e) { 
            try {
            	if(CaseIDValue.getText().isEmpty() && !e.getSource().equals(Reset)){
            		NoCaseIdDialog();
            		return;
            	}
            		
            	System.out.println(e.getActionCommand()+" Button Pressed");
            	if(e.getActionCommand().equals("Search")){
            		CaseIdSearch();
            		return;
            	}
            	if(e.getActionCommand().equals("Download")){
            		DownloadImg();
            		return;
            	}
            	if(e.getActionCommand().equals("Reset")){
            		ResetCaseID();
            		return;
            	}
            	if(e.getActionCommand().equals("NextPage")){
            		
            		ImageComponent.displaynextimage();
            		return;
            	}
            	if(e.getActionCommand().equals("PrevPage")){
            		
            		ImageComponent.displaypreviousimage();
            		return;
            	}
            	
            	if(e.getActionCommand().equals("DocumentViewer")){
            		ImageComponent.openLinkDirectly("http://app40-07.uhg.com/sites/BP/CA/ORS/Appeal%20RPA%20%20Detail/Test/Case%20"+CaseIDValue.getText()+"/DocumentViewer.pdf");
            		return;
            	}
            	
            	if(e.getActionCommand().equals("IBAAG")){
            		ImageComponent.openLinkDirectly("http://app40-07.uhg.com/sites/BP/CA/ORS/Appeal%20RPA%20%20Detail/Test/Case%20"+CaseIDValue.getText()+"/ibaag.mht");
            		return;
            	}
            	
            	ImageFetch(e.getActionCommand());
			} catch (Exception e1) {
				System.out.println("Images not fetched under main class and exception is "+e1);
        }
		
	}
	
	public static void setWaitCursor(boolean yesno)
	  {
	    Frame.getFrames()[0].setCursor(yesno ? Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR) : Cursor.getDefaultCursor());
	  }
	
	public static void setWaitCursorJbutton(boolean yesno){
		ETS.setCursor(yesno ? Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR) : Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		IDRS.setCursor(yesno ? Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR) : Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		EDSS.setCursor(yesno ? Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR) : Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		WAND.setCursor(yesno ? Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR) : Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		CDX.setCursor(yesno ? Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR) : Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		CDB.setCursor(yesno ? Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR) : Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		COC.setCursor(yesno ? Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR) : Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		SCI_IDRS.setCursor(yesno ? Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR) : Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		Searchbtn.setCursor(yesno ? Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR) : Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		Download.setCursor(yesno ? Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR) : Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		DocumentViewer.setCursor(yesno ? Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR) : Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		ICUE.setCursor(yesno ? Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR) : Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		//ImageComponent.Imframe.setCursor(yesno ? Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR) : Cursor.getDefaultCursor());
	}
	
	public static void ScreenbuttonsEnable(boolean yesno){
		ETS.setEnabled(yesno);
		IDRS.setEnabled(yesno);
		EDSS.setEnabled(yesno);
		WAND.setEnabled(yesno);
		CDX.setEnabled(yesno);
		CDB.setEnabled(yesno);
		COC.setEnabled(yesno);
		SCI_IDRS.setEnabled(yesno);
		TOPS.setEnabled(yesno);
		DocumentViewer.setEnabled(yesno);
		ICUE.setEnabled(yesno);
	}
	
	public static void ImageFetch(String screen) throws Exception{
		ScreenName = screen;
		System.out.println("Screen name is "+ScreenName);
		setWaitCursorJbutton(true);
		setWaitCursor(true);
		ImageComponent.imgFrameDispose();
		ImageComponent AppealImg = new ImageComponent();
		AppealImg.ImageMain(ScreenName,"view","http://app40-07.uhg.com/sites/BP/CA/ORS/Appeal RPA  Detail/Test/Case "+CaseIDValue.getText()+"/"+ScreenName+".jpeg");
		setWaitCursorJbutton(false);
		setWaitCursor(false);
	}
	
	public static void CaseIdSearch() throws Exception{
		setWaitCursorJbutton(true);
		setWaitCursor(true);
		ImageComponent caseID = new ImageComponent();
		caseID.CaseIdSearchMain("http://app40-07.uhg.com/sites/BP/CA/ORS/Appeal RPA  Detail/Test/Case "+CaseIDValue.getText());
		setWaitCursorJbutton(false);
		setWaitCursor(false);
	}
	
	public static void DownloadImg() throws Exception{
		setWaitCursorJbutton(true);
		setWaitCursor(true);
		ImageComponent.ImFrameWaitCursor(true);
		ImageComponent.ImageMain(ScreenName,"Download","http://app40-07.uhg.com/sites/BP/CA/ORS/Appeal RPA  Detail/Test/Case "+CaseIDValue.getText()+"/"+ScreenName+".jpeg");
		setWaitCursorJbutton(false);
		setWaitCursor(false);
		ImageComponent.ImFrameWaitCursor(false);
	}
	
	public static void ResetCaseID() throws Exception{
		ScreenbuttonsEnable(false);
		CaseIDValue.setText("");
		CaseIDValue.setEditable(true);
		ImageComponent.imgFrameDispose();
		ImageComponent.ImframeLi.clear();
		NextPage.setEnabled(false);
		PrevPage.setEnabled(false);
		totalimages=0;
	}
	
	public static void ImageFetchDialog(int imgcount){
		totalimages=imgcount;
		JPanel Dmain = new JPanel();
		Dmain.setLayout(new BoxLayout(Dmain, BoxLayout.Y_AXIS));
		
		JDialog ImgD = new JDialog(frame, "Image Fetch Result");
		JPanel ImgP = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JLabel ImgL = new JLabel("<html>Total Images fetched : "+imgcount+"<br/>Case ID : "+CaseIDValue.getText()+"<br/>Screen : "+ScreenName+"</html>",SwingConstants.CENTER);
		ImgL.setFont(new Font("Times New Roman",Font.BOLD,26));
		ImgD.setLocationRelativeTo(null);
		ImgP.add(ImgL);
		Dmain.add(ImgP);
		ImgD.setSize(500, 300);
		ImgP.setBackground(Color.WHITE);
		if(imgcount==0){
			PrevPage.setEnabled(false);
			NextPage.setEnabled(false);
		}
		
		if(imgcount!=0){
		JPanel DownP = new JPanel(new FlowLayout(FlowLayout.CENTER));
		Download = new JButton();
		DownP.add(Download);
		Download.setText("Download");
		Download.setPreferredSize(new java.awt.Dimension(150, 35));
		Download.setBounds(10,10,40,40);
		Download.setFont(new Font("Times New Roman",Font.BOLD,26));
		Dmain.add(BorderLayout.SOUTH, DownP);
		Download.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
		Download.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		Download.addActionListener(new ActionListener(){
		    @Override
		    public void actionPerformed(ActionEvent e){
		    	try {
		    		ImgD.dispose();
		    		DownloadImg();
				} catch (Exception e1) {
					System.out.println("No Images Downloaded");
				}
		    }
		});
		}
		ImgD.add(Dmain);
		ImgD.getContentPane().setBackground(Color.WHITE);
		ImgD.setVisible(true); 
	}
	
	public static void ImageDownloadDialog(int imgcount){
		
		JDialog Dimg = new JDialog(frame, "Image Download Result");
		JLabel ImgL = new JLabel("<html>Total Images Downloaded : "+imgcount+"<br/>Case ID : "+CaseIDValue.getText()+"<br/>Screen : "+ScreenName+"<br/>Downloaded path : "+ImageComponent.home+"\\Downloads</html>",SwingConstants.CENTER);
		ImgL.setFont(new Font("Times New Roman",Font.BOLD,26));
		Dimg.add(ImgL);
		Dimg.setLocationRelativeTo(null);
		Dimg.setSize(600, 300);
		Dimg.getContentPane().setBackground(Color.WHITE);
		Dimg.setVisible(true);
	}
	
	public static void NoCaseIdDialog(){
		JDialog ErrD = new JDialog(frame, " Case ID Required ");
		JLabel ErrL = new JLabel("Please Enter Case ID",SwingConstants.CENTER);
		
		ErrL.setFont(new Font("Times New Roman",Font.BOLD,26));
		ErrD.setLocationRelativeTo(null);
		ErrD.add(ErrL);
		ErrD.setSize(500, 250);
		ErrD.getContentPane().setBackground(Color.WHITE);
		ErrD.setVisible(true); 
	}
	
	public static void CaseIdSearchDialog(int code){
		JDialog CaseD = new JDialog(frame, " Case ID Search Result");
		JLabel CaseL;
		
		if(code==404){
		CaseL = new JLabel("<html>Screenshots for Case ID : "+CaseIDValue.getText()+"<br/>does not exist in SharePoint</html>",SwingConstants.CENTER);
		CaseL.setFont(new Font("Times New Roman",Font.BOLD,26));
		CaseD.setLocationRelativeTo(null);
		CaseD.add(CaseL);
		CaseD.setSize(600, 350);
		CaseD.getContentPane().setBackground(Color.WHITE);
		CaseD.setVisible(true); 
		}
		else{
		CaseL = new JLabel("Case ID "+CaseIDValue.getText()+" exist in SharePoint",SwingConstants.CENTER);
		ScreenbuttonsEnable(true);
		CaseIDValue.setEditable(false);
		}
		CaseL.setFont(new Font("Times New Roman",Font.BOLD,26));
		CaseD.setLocationRelativeTo(null);
		CaseD.add(CaseL);
		CaseD.setSize(600, 350);
		CaseD.getContentPane().setBackground(Color.WHITE);
		//CaseD.setVisible(true); 
	}
	
	
	public static void main(String[] args) throws Exception{
		AppealsToolGUI ap = new AppealsToolGUI();

    }

	
}



package com.jw.sharepoint.examples;


import java.awt.Component;
import java.awt.Cursor;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.beans.PropertyVetoException;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

/*import org.icepdf.ri.common.SwingController;
import org.icepdf.ri.common.SwingViewBuilder;*/

import com.sun.tools.xjc.reader.xmlschema.bindinfo.BIConversion.User;


public class ImageComponent extends JComponent {
	 public static BufferedImage img;
	 public static BufferedImage imgIcon;
	 static ArrayList<BufferedImage> ImgLi = new ArrayList<BufferedImage>();
	 static ArrayList<JInternalFrame> ImframeLi = new ArrayList<JInternalFrame>();
	 public static int imgcount;
	 public static String home;
	 public static JInternalFrame Imframe;
	 public static int nexpgcounter=0;
	 public static int prevpgcounter=0;
	 public static int im;
	 
	 public ImageComponent(){
		 ImgLi.clear();
		 ImframeLi.clear();
		 System.out.println("Image Array List and Img Frame Array list Cleared Successfully");
	 }
	 public ImageComponent(URL url) throws IOException {
	        img = ImageIO.read(url);
	        setPreferredSize(new Dimension(img.getWidth(), img.getHeight()));
	        imgIcon=ImageIO.read(new File("Configuration\\Imgicon.png"));
	        ImgLi.add(img);
	       repaint();
	        
	    }
	    @Override 
	    protected void paintComponent(Graphics g) {
	        super.paintComponent(g);
	        System.out.println("Total images are "+ImgLi.size());
	        
	       // for(BufferedImage li :ImgLi){
	        	//System.out.println("Image is "+li);
	        //	g.drawImage(ImgLi.get(im), 0, 0, ImgLi.get(im).getWidth(), ImgLi.get(im).getHeight(), this);
	        	g.drawImage(ImgLi.get(im), 0, 0, 1570, 625, this);
	        	System.out.println("Image drawn");
	       // }
	    }
	    
	    //This is the main function   "public static void main(String[] args) throws Exception {"
	    
	    public static void CaseIdSearchMain(String caseidURL) throws Exception{
			System.out.println("Case ID search Url is "+caseidURL);
			if(caseidURL.contains(" ")){
				caseidURL = caseidURL.replaceAll(" ", "%20");
        		System.out.println("New Case ID url is "+caseidURL);
        	}
			URL u = new URL (caseidURL);
			HttpURLConnection huc =  ( HttpURLConnection )u.openConnection(); 
			huc.setRequestMethod ("HEAD");  //OR  huc.setRequestMethod ("HEAD"); 
			huc.connect () ; 
			int code = huc.getResponseCode() ;
			System.out.println(code+" and Case ID URL message is "+huc.getResponseMessage());
			AppealsToolGUI.CaseIdSearchDialog(code);
		}
	    
	    
	    public static void ImageMain(String screen,String dwn,String urlstringOrg) throws Exception {
	    String urlstring =urlstringOrg;
	    imgcount=0;
	    int len = urlstringOrg.length();
	    
	    for(int i=1;i>0;i++){
	    try {
	    	if(urlstring.contains(" ")){
        		urlstring = urlstring.replaceAll(" ", "%20");
        		System.out.println("Image url is "+urlstring);
        	}

	    final URL lenna = new URL(urlstring);
	    urlstring=urlstringOrg.substring(0, len-5)+i+".jpeg";
	    //urlstring= "http://app40-07.uhg.com/sites/BP/CA/ORS/Appeal RPA  Detail/Test/testdua"+i+".jpg";
	    
			
			if(dwn.equals("Download"))
			downloadImage(lenna,i-1,screen);
			else
			viewImage(lenna,i-1,screen);
			
		} 
	    
	    
	    catch (Exception e) {
	    	System.out.println("value of i is "+i);
	    	if(i==1)
	    		continue;
	    	
	    	System.out.println("Total Images fetched : "+imgcount);
			System.out.println("Exception value is "+e.getMessage());
			if(dwn.equals("Download"))
				AppealsToolGUI.ImageDownloadDialog(imgcount);
				else{
				AppealsToolGUI.ImageFetchDialog(imgcount);
				displayImages();
				}
			
			imgcount=0;
			break;
		}

	    }
	    
}
	   
	    public static void openLinkDirectly(String url1){
	    	try {
	            Desktop.getDesktop().browse(new URL(url1).toURI());
	        } catch (Exception e) {
	            System.out.println("URL not found");
	        }
	    }
	    
	    public static void pdfViewer(String url1,String screen) throws Exception{/*
	    	
	    	System.out.println("Loading PDF......");
	    	
	    	
	    	
	    	String filePath = "C:\\Users\\hdua\\Desktop\\Dua's Personnel docs\\Passport-compressed.pdf";

	        // build a component controller
	        SwingController controller = new SwingController();
	        SwingViewBuilder factory = new SwingViewBuilder(controller);
	        System.getProperties().put("Dorg.icepdf.core.imageReference.blurred.dimension", "5");
	        JFrame pdfframe = new JFrame(AppealsToolGUI.CaseIDValue.getText()+"_"+screen);
	        pdfframe = factory.buildViewerFrame();
	        pdfframe.setBounds(100, 23, 1600, 660);
	        
	        JPanel viewerComponentPanel = factory.buildViewerPanel();
	        viewerComponentPanel.setBounds(100, 23, 1600, 660);
	        System.out.println("7th.....");
			  AppealsToolGUI.jPanel2.add(viewerComponentPanel);
			  System.out.println("8th.....");
	    	

	        // add interactive mouse link annotation support via callback
	        controller.getDocumentViewController().setAnnotationCallback(
	                new org.icepdf.ri.common.MyAnnotationCallback(
	                        controller.getDocumentViewController()));

	        // Now that the GUI is all in place, we can try openning a PDF
	        controller.openDocument(filePath);
	        viewerComponentPanel.setEnabled(true);
	      
	    	
	    	
	    	
	    	
	    	
	    	URL url = new URL(url1);
	    	URLConnection urlConn = url.openConnection();
	    	
	    	
	    	System.out.println("PDF loaded successfuly");
	    	
	        
	    */}
	    
	    public static void viewImage(URL url,int no,String screen) throws IOException{
	    	System.out.println("url in view image is "+url);
	    	ImageComponent image = new ImageComponent(url);
	    	//JFrame Imframe = new JFrame();
	    	
	    	
	    	Imframe = new JInternalFrame();
	    	if(no==0)
		    Imframe = new JInternalFrame(AppealsToolGUI.CaseIDValue.getText()+"_"+screen);
	    	else
	    	Imframe = new JInternalFrame(AppealsToolGUI.CaseIDValue.getText()+"_"+screen+no);
	    	
	    	//JScrollPane jsp = new JScrollPane(image);
	    	
	    	//jsp.setBounds(100, 23, 1300, 600);
		   Imframe.add(image);
	
		   //Imframe.setIconImage(imgIcon);
		   
		 //  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		   // Imframe.setBounds(122, 1123, 1600, 600);
		  //  Imframe.setSize(Imframe.getMaximumSize());
		   
		   // Imframe.setVisible(true);
		    Imframe.setBounds(100, 23, 1600, 660);
		   AppealsToolGUI.jPanel2.add(Imframe);
		    imgcount=imgcount+1;
		    ImframeLi.add(Imframe);
		    
	    }
	    
	    public static void downloadImage(URL url,int no,String screen) throws Exception{
	    	 
	         
	             img = ImageIO.read(url);
	            home = System.getProperty("user.home");
	             System.out.println("path is "+home+"\\Downloads\\tempfiledua.jpg");
	             
	             if(no==0)
	             ImageIO.write(img, "jpg", new File(home+"\\Downloads\\"+AppealsToolGUI.CaseIDValue.getText()+"_"+screen+".jpg"));
	             else
	             ImageIO.write(img, "jpg", new File(home+"\\Downloads\\"+AppealsToolGUI.CaseIDValue.getText()+"_"+screen+no+".jpg"));
	             
	             //Other image formats
	             /* ImageIO.write(img, "png", new File("C:\\Users\\hdua\\Desktop\\SharepointScreenshots\\tempfiledua.png"));
	             ImageIO.write(img, "gif", new File("C:\\Users\\hdua\\Desktop\\SharepointScreenshots\\tempfiledua.gif"));
	             ImageIO.write(img, "bmp", new File("C:\\Users\\hdua\\Desktop\\SharepointScreenshots\\tempfiledua.bmp"));*/
	             imgcount=imgcount+1;
	         
	        
	          
	         System.out.println("done");
	    }
	    
	    public static void displayImages(){
	    	if(imgcount!=0){
	    		im=0;
	    		hideAllImgframes();
	    		System.out.println("Total frames in display loop "+ImframeLi.size());
	    		ImframeLi.get(0).setVisible(true);
	    		AppealsToolGUI.jPanel2.add(ImframeLi.get(0)); //Added
	    		if(ImframeLi.size()==1){
	    		AppealsToolGUI.NextPage.setEnabled(false);
    			AppealsToolGUI.PrevPage.setEnabled(false);
	    		}
	    		else
	    		{
	    			AppealsToolGUI.NextPage.setEnabled(true);
	    			AppealsToolGUI.PrevPage.setEnabled(false);
	    			prevpgcounter=0;
	    			nexpgcounter=ImframeLi.size()-1;
	    			
	    		}
	    	}
	    }
	    
	    public static void displaynextimage(){
	    	hideAllImgframes();
	    	im=prevpgcounter+1;
	    	ImframeLi.get(prevpgcounter+1).setVisible(true);
	    	AppealsToolGUI.jPanel2.add(ImframeLi.get(prevpgcounter+1)); //Added
	    	nexpgcounter=nexpgcounter-1;
	    	prevpgcounter=prevpgcounter+1;
	    	if(nexpgcounter==0){
	    		AppealsToolGUI.NextPage.setEnabled(false);
    			AppealsToolGUI.PrevPage.setEnabled(true);
	    	}
	    	else{
	    		AppealsToolGUI.NextPage.setEnabled(true);
    			AppealsToolGUI.PrevPage.setEnabled(true);
	    	}
	    	
	    }
	    
	    public static void displaypreviousimage(){
	    	hideAllImgframes();
	    	im=prevpgcounter-1;
	    	ImframeLi.get(prevpgcounter-1).setVisible(true);
	    	AppealsToolGUI.jPanel2.add(ImframeLi.get(prevpgcounter-1)); //Added
	    	nexpgcounter=nexpgcounter+1;
	    	prevpgcounter=prevpgcounter-1;
	    	if(prevpgcounter==0){
	    		AppealsToolGUI.NextPage.setEnabled(true);
    			AppealsToolGUI.PrevPage.setEnabled(false);
	    	}
	    	else{
	    		AppealsToolGUI.NextPage.setEnabled(true);
    			AppealsToolGUI.PrevPage.setEnabled(true);
	    	}
	    }
	    
	    public static void hideAllImgframes(){
	    	for(int ef=0;ef<ImframeLi.size();ef++){
	    		ImframeLi.get(ef).setVisible(false);
	    	}
	    }
	    
	    public static void imgFrameDispose() throws Exception{
	    	System.out.println("Total frames in Output panel are "+ImframeLi.size());
	    	for(JInternalFrame jf:ImframeLi){
	    		jf.dispose();
	    	}
	    }
	    
	    public static void ImFrameWaitCursor(boolean yesno)
		  {
	    	for(JInternalFrame jfw:ImframeLi){
	    	jfw.setCursor(yesno ? Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR) : Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		  }
		  }
		
	    
	    
	    }

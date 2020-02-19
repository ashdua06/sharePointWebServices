package com.jw.sharepoint.examples;


import java.io.InputStream;
import java.util.Properties;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.microsoft.sharepoint.webservices.*;

public class SharePointUploadDocumentExample extends SharePointBaseExample {

	public static Properties properties = new Properties();
	private static final Log logger = LogFactory.getLog(SharePointUploadDocumentExample.class);
	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// Set root logger level to DEBUG and its only appender to A1.
		
		logger.debug("main...");		
		try {		
			SharePointUploadDocumentExample example = new SharePointUploadDocumentExample();
			example.initialize();
			CopySoap p = example.getCopySoap();
			example.uploadDocument(p, properties.getProperty("copy.sourceFile"));
		} catch (Exception ex) {
			logger.error("Error caught in main: ",ex);
		}
	}

	public Properties getProperties() {
		return properties;
	}

	


	protected void initialize() throws Exception {
		logger.info("initialize()...");
		InputStream in = SharePointUploadDocumentExample.class.getResourceAsStream("/SharePointUploadDocumentExample.properties");
		System.out.print("Stream is "+in);
		properties.load(in);
		super.initialize();		
	}
}

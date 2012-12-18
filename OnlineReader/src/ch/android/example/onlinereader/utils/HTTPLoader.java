package ch.android.example.onlinereader.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class HTTPLoader {
	
	private String url;
	private String result;
	
	public HTTPLoader(){
		
	}
	
	public HTTPLoader(String url){
		this.url = url;
	}
	
	public String getUrl() {
		return url;
	}


	public void setUrl(String url) {
		this.url = url;
	}




	public String getResult() {
		return result;
	}



	public String connect(){
		this.result = "";
		try {
			  URL urlObject = new URL(url);
			  HttpURLConnection con = (HttpURLConnection) urlObject
			    .openConnection();
			  readStream(con.getInputStream());
			  } catch (Exception e) {
			  e.printStackTrace();
			}
		
		return result;
		
	}

	public String connectTo(String url){
		this.url = url;
		return connect();
		
	}
	
	private void readStream(InputStream in) {
		  BufferedReader reader = null;
		  try {
		    reader = new BufferedReader(new InputStreamReader(in));
		    String line = "";
		    while ((line = reader.readLine()) != null) {
		    	result = result + line;
		    }
		  } catch (IOException e) {
		    e.printStackTrace();
		  } finally {
		    if (reader != null) {
		      try {
		        reader.close();
		      } catch (IOException e) {
		        e.printStackTrace();
		        }
		    }
		  }
		} 

}

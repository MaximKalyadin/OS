package oclab4;

import java.util.ArrayList;

public class File {
	private String name;
	private String extension;
	
	private int firstSectorNumber;
	
	public File(String name, String extension) {
		this.name = name;
		this.extension = extension;
	}
	
	public int getfirstSectorNumber() {
		return firstSectorNumber;
	}
	
	public String getName() {
		return new String(name);
	}
	
	public String getExtension() {
		return new String(extension);
	}
	
	public void setName(String name) {
		this.name = name;
	}
}

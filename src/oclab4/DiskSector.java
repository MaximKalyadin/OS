package oclab4;

public class DiskSector {
private final int size;
	
	private int nextSectorNumber;
	private String data;
	
	public DiskSector(int size) {
		this.size = size;
		
		nextSectorNumber = -1;
		data = "";
	}
	
	public void write(String data) {
		this.data = data.substring(0, data.length() <= size ? data.length() : size);
	}
	
	public String read() {
		return new String(data);
	}

	public int getNextSectorNumber() {
		return nextSectorNumber;
	}

	public void setNextSectorNumber(int nextSectorNumber) {
		this.nextSectorNumber = nextSectorNumber;
	}
}

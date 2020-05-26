package oclab4;

public class DiskPart {
private DiskSector[] sectors;

	public DiskPart(int size, int sectorSize) {
		sectors = new DiskSector[size];
		for (int i = 0; i < size; i++) {
			sectors[i] = new DiskSector(sectorSize);
		}
	}

	public void writeDataIntoSector(int index, String data) {
		if (index >= 0 && index < sectors.length) {
			sectors[index].write(data);
		}
	}

	public String readDataFromSector(int index) {
		if (index >= 0 && index < sectors.length) {
			return sectors[index].read();
		} else {
			throw new IndexOutOfBoundsException();
		}
	}

	public int getNextSectorForSector(int index) {
		if (index >= 0 && index < sectors.length) {
			return sectors[index].getNextSectorNumber();
		} else {
			throw new IndexOutOfBoundsException();
		}
	}

	public void setNextSectorForSector(int index, int nextSectorNumber) {
		if (index >= 0 && index < sectors.length) {
			sectors[index].setNextSectorNumber(nextSectorNumber);
		} else {
			throw new IndexOutOfBoundsException();
		}
	}
}

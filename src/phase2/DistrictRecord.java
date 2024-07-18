package phase2;



public class DistrictRecord implements Comparable<DistrictRecord>{ //Class District_Record:

	private String districtName;
	private BSTree<LocationRecord> locations;

	public DistrictRecord(String districtName) {

		this.districtName = districtName;
		this.locations = new BSTree<>();
	}

	public String getDistrictName() {
		return districtName;
	}

	public void setDistrictName(String districtName) {
		this.districtName = districtName;
	}

	public BSTree<LocationRecord> getLocations() {
		return locations;
	}

	public void setLocations(BSTree<LocationRecord> locations) {
		this.locations = locations;
	}

	@Override
	public String toString() {
		return  districtName;
	}

	@Override
	public int compareTo(DistrictRecord o) {

		return this.districtName.toUpperCase().compareTo(o.districtName.toUpperCase());
	}

	public boolean equals(Object o) {

		if (o instanceof DistrictRecord) {

			return this.districtName.equalsIgnoreCase(((DistrictRecord)o).districtName);
		}

		return false;
	}
}

package phase2;



public class LocationRecord implements Comparable<LocationRecord>{ // Class Location_Record:

	private String locationName;
	private BSTree<DateRecord> martyrDate;


	public LocationRecord(String locationName) {

		this.locationName = locationName;
		this.martyrDate = new BSTree<>();
	}

	public String getLocationName() {
		return locationName;
	}

	public void setLocationName(String name) {
		this.locationName = name;
	}

	public BSTree<DateRecord> getMartyrDate() {
		return martyrDate;
	}

	public void setMartyrDate(BSTree<DateRecord> martyrDate) {
		this.martyrDate = martyrDate;
	}

	@Override
	public String toString() {

		return  locationName;
	}

	@Override
	public int compareTo(LocationRecord o) {

		return this.locationName.toUpperCase().compareTo(o.locationName.toUpperCase());
	}

	public boolean equals(Object o) {

		if (o instanceof LocationRecord) {

			return this.locationName.equalsIgnoreCase(((LocationRecord)o).locationName);
		}

		return false;
	}
}

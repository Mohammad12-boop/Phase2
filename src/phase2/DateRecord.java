package phase2;

import java.time.LocalDate;



public class DateRecord implements Comparable<DateRecord>{

	private LocalDate date;
	private SLinkedList<MartyrRecord> martyrs;

	public DateRecord(LocalDate date) {

		this.date = date;
		this.martyrs = new SLinkedList<>();
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public SLinkedList<MartyrRecord> getMartyrs() {
		return martyrs;
	}

	public void setMartyrs(SLinkedList<MartyrRecord> martyrs) {
		this.martyrs = martyrs;
	}

	public String toString() {

		return " "+ date;
	}

	@Override
	public int compareTo(DateRecord o) {

		return this.date.compareTo(o.date);
	}


}

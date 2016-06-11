package barclays.hackathon.starks.model;

public enum AGERANGE {

	AgeRange_17_25(0), AGE_RANGE_25_35(1), AGE_RANGE_35_PLUS(2);

	private int index;

	private AGERANGE(int index) {
		this.index = index;
	}

	public int getIndex() {
		return index;
	}
}

package barclays.hackathon.starks.core;

public enum Offer {
	Arrival5XT(0), Arrival5XR(1), Arrival5XO(2), Arrival5XDE(3), Carnival10XT(4), Carnival10XR(5), Carnival10XO(
			6), Carnival10XDE(7), JetBlue10XT(8), JetBlue2XR(9), JetBlue5XO(10), JetBlue3XDE(11), Apple2XT(
					12), Apple10XR(13), Apple5XO(14), Apple1XDE(15);

	private int index;

	private Offer(int index) {
		this.index = index;
	}

	public int getIndex() {
		return index;
	}

	public static Offer fromOffer(double offerIndex) {
		Offer[] values = Offer.values();
		for (Offer offer : values) {
			if (offer.getIndex() == offerIndex) {
				return offer;
			}
		}
		return null;
	}

}

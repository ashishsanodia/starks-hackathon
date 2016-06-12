package barclays.hackathon.starks.model;

public enum Offer {
	JetBlue5XO(0),Apple5XDE(1),JetBlue5XT(2),Carnival5XR(3),Carnival5XT(4),Carnival5XO(5),Apple5XR(6),Apple5XT(7),
	Apple5XO(8),Arrival5XT(9),Arrival5XR(10),Arrival5XO(11),JetBlue5XDE(12),Carnival5XDE(13),Arrival5XDE(14);



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

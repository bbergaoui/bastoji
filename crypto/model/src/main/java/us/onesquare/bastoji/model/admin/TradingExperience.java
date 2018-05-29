package us.onesquare.bastoji.model.admin;


public enum TradingExperience {
	NEVER_TRADED(1), LESS_THAN_ONE(2), BETWEEN_ONE_THREE(3), MORE_THAN_THREE(3);

	private final int value;

	TradingExperience(int newValue) {
		value = newValue;
	}

	public int toInt() {
		return value;
	}

	public static TradingExperience fromInt(Integer value) {
		if (value == null)
			return TradingExperience.NEVER_TRADED;
		for (TradingExperience s : TradingExperience.values()) {
			if (value == s.toInt())
				return s;
		}
		return TradingExperience.NEVER_TRADED;
	}

}

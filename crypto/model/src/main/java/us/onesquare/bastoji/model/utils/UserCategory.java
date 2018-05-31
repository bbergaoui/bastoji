package us.onesquare.bastoji.model.utils;


public enum UserCategory {
	INDIVIDUAL(1), COMPANY(2);

	private final int value;

	UserCategory(int newValue) {
		value = newValue;
	}

	public int toInt() {
		return value;
	}

	public static UserCategory fromInt(Integer value) {
		if (value == null)
			return UserCategory.INDIVIDUAL;
		for (UserCategory s : UserCategory.values()) {
			if (value == s.toInt())
				return s;
		}
		return UserCategory.INDIVIDUAL;
	}

}

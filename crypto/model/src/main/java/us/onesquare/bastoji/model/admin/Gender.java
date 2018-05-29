package us.onesquare.bastoji.model.admin;

public enum Gender {

	  MALE(1), FEMALE(2);

	    private final int value;

	    Gender(int newValue) {
	        value = newValue;
	    }

	    public int toInt() {
	        return value;
	    }

	    public static Gender fromInt(Integer value) {
	        if (value == null)
	            return Gender.MALE;
	        for (Gender s : Gender.values()) {
	            if (value == s.toInt())
	                return s;
	        }
	        return Gender.MALE;
	    }
}

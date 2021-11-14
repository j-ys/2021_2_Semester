package Items;

public class ItemFactory {
	private enum ItemType{
		ANIMATION, ENTERTAINMENT, MOVIE, ORIGINAL_SERIES, REGULAR_SERIES
	}
	
	public static Item createItem(String type) {
		switch (ItemType.valueOf(type)) {
		case ANIMATION:
			return new Animation();
		case ENTERTAINMENT:
			return new Entertainment();
		case MOVIE:
			return new Movie();
		case ORIGINAL_SERIES:
			return new OriginalSeries();
		case REGULAR_SERIES:
			return new RegularSeries();
		default:
			break;
		}
		return null;
	}
}

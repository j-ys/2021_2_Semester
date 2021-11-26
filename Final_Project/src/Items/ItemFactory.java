package Items;

public class ItemFactory {
	private enum ItemType{
		Animation, Entertainment, Movie, OriginalSeries, RegularSeries
	}
	
	public static Item createItem(String type) {
		switch (ItemType.valueOf(type)) {
		case Animation:
			return new Animation();
		case Entertainment:
			return new Entertainment();
		case Movie:
			return new Movie();
		case OriginalSeries:
			return new OriginalSeries();
		case RegularSeries:
			return new RegularSeries();
		default:
			break;
		}
		return null;
	}
}

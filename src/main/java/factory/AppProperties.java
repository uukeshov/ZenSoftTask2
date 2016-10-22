package factory;

/**
 * Created by Andrew on 17.06.2016.
 */
public class AppProperties {

    public enum ParseMod {
        FirstType(1), SecondType(2), ThirdType(3);
        public final Integer parseMod;

        ParseMod(Integer parseMod) {
            this.parseMod = parseMod;
        }
    }

    public static ParseMod parseMod = ParseMod.SecondType;

    public void alter(ParseMod Integer) {
        this.parseMod = parseMod;
    }
}

package beer.hapibrew.beerxml2proto.parser;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import beer.hapibrew.beerxml2proto.proto.Recipe;
import beer.hapibrew.beerxml2proto.proto.RecipeType;

public class RecipeParser extends BaseParser {

    private StyleParser styleParser = new StyleParser();
    private HopParser hopParser = new HopParser();
    private FermentableParser fermentableParser = new FermentableParser();
    private MiscParser miscParser = new MiscParser();
    private YeastParser yeastParser = new YeastParser();
    private WaterParser waterParser = new WaterParser();
    private MashParser mashParser = new MashParser();
    private FermentationParser fermentationParser = new FermentationParser();
    private EquipmentParser equipmentParser = new EquipmentParser();

    public List<Recipe> readRecipes(XmlPullParser parser) throws XmlPullParserException, IOException {
        ArrayList<Recipe> recipes = new ArrayList<>();

        parser.require(XmlPullParser.START_TAG, ns, "RECIPES");
        while (parser.next() != XmlPullParser.END_TAG) {
            if (parser.getEventType() != XmlPullParser.START_TAG) {
                continue;
            }
            String name = parser.getName();
            if (name.equals("RECIPE")) {
                recipes.add(readRecipe(parser, name));
            } else {
                skip(parser);
            }
        }
        return recipes;
    }

    private Recipe readRecipe(XmlPullParser parser, String tag) throws XmlPullParserException, IOException {
        parser.require(XmlPullParser.START_TAG, ns, tag);
        Recipe.Builder builder = new Recipe.Builder();

        while (parser.next() != XmlPullParser.END_TAG) {
            if (parser.getEventType() != XmlPullParser.START_TAG) {
                continue;
            }
            String name = parser.getName();
            switch (name) {
                case "NAME":
                    builder.name(readText(parser, name));
                    break;
                case "VERSION":
                    builder.version(readInt(parser, name));
                    break;
                case "TYPE":
                    builder.type(readType(parser, name));
                    break;
                case "STYLE":
                    builder.style(styleParser.readStyle(parser, name));
                    break;
                case "HOPS":
                    builder.hops(hopParser.readHops(parser, name));
                    break;
                case "FERMENTABLES":
                    builder.fermentables(fermentableParser.readFermentables(parser, name));
                    break;
                case "MISCS":
                    builder.miscs(miscParser.readMiscs(parser, name));
                    break;
                case "YEASTS":
                    builder.yeasts(yeastParser.readYeasts(parser, name));
                    break;
                case "WATERS":
                    builder.waters(waterParser.readWaters(parser, name));
                    break;
                case "MASH":
                    builder.mash(mashParser.readMash(parser, name));
                    break;
                case "EQUIPMENT":
                    builder.equipment(equipmentParser.readEquipment(parser, name));
                    break;
                case "FERMENTATION_STAGES":
                    fermentationParser.fermentationStages = readInt(parser, name);
                    break;
                case "PRIMARY_AGE":
                    fermentationParser.primary.days(readDouble(parser, name));
                    break;
                case "PRIMARY_TEMP":
                    fermentationParser.primary.temperature(readDouble(parser, name));
                    break;
                case "SECONDARY_AGE":
                    fermentationParser.secondary.days(readDouble(parser, name));
                    break;
                case "SECONDARY_TEMP":
                    fermentationParser.secondary.temperature(readDouble(parser, name));
                    break;
                case "TERTIARY_AGE":
                    fermentationParser.tertiary.days(readDouble(parser, name));
                    break;
                case "TERTIARY_TEMP":
                    fermentationParser.tertiary.temperature(readDouble(parser, name));
                    break;
                case "AGE":
                    fermentationParser.aging.days(readDouble(parser, name));
                    break;
                case "AGE_TEMP":
                    fermentationParser.aging.temperature(readDouble(parser, name));
                    break;
                case "BATCH_SIZE":
                    builder.batch_size(readDouble(parser, name));
                    break;
                case "BOIL_SIZE":
                    builder.boil_size(readDouble(parser, name));
                    break;
                case "BOIL_TIME":
                    builder.boil_time((int) readDouble(parser, name));
                    break;
                case "EFFICIENCY":
                    builder.efficiency(readDouble(parser, name));
                    break;
                case "EST_OG":
                    builder.est_og(readUnit(parser, name, "SG"));
                    break;
                case "EST_FG":
                    builder.est_fg(readUnit(parser, name, "SG"));
                    break;
                case "EST_ABV":
                    builder.est_abv(readUnit(parser, name, "%"));
                    break;
                case "ABV":
                    builder.est_abv(readUnit(parser, name, "%"));
                    break;
                case "EST_COLOR":
                    builder.est_srm(readUnit(parser, name, "SRM"));
                    break;
                case "IBU":
                    builder.est_ibu(readUnit(parser, name, "IBU"));
                    break;
                case "NOTES":
                    builder.notes(readText(parser, name));
                    break;
                case "BREWER":
                    builder.brewer(readText(parser, name));
                    break;
                default:
                    skip(parser);
                    break;
            }
        }

        if (builder.boil_size < builder.batch_size) {
            builder.boil_size(builder.boil_size + builder.batch_size);
        }

        builder.fermentations(fermentationParser.buildFermentation());

        return builder.build();
    }

    private RecipeType readType(XmlPullParser parser, String tag) throws IOException, XmlPullParserException {
        String type = readText(parser, tag).toLowerCase();
        switch (type) {
            case "all grain":
                return RecipeType.ALL_GRAIN;
            case "partial mash":
                return RecipeType.PARTIAL_MASH;
            case "extract":
                return RecipeType.EXTRACT;
            default:
                throw new XmlPullParserException("Unsupported recipe type: " + type);
        }
    }

    private double readUnit(XmlPullParser parser, String tag, String unit) throws IOException, XmlPullParserException {
        String value = readText(parser, tag).toLowerCase();
        int index = value.indexOf(unit.toLowerCase());
        if (index != -1) {
            String n = value.substring(0, index).trim();
            return Float.parseFloat(n);
        } else if (!value.isEmpty()) {
            try {
                return Float.parseFloat(value);
            } catch (NumberFormatException e) {
            }
        }
        return 0.0;
    }
}

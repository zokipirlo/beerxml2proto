package beer.hapibrew.beerxml2proto.parser;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import beer.hapibrew.beerxml2proto.proto.Yeast;
import beer.hapibrew.beerxml2proto.proto.YeastForm;
import beer.hapibrew.beerxml2proto.proto.YeastType;

class YeastParser extends BaseParser {

    List<Yeast> readYeasts(XmlPullParser parser, String tag) throws XmlPullParserException, IOException {
        ArrayList<Yeast> yeasts = new ArrayList<>();

        parser.require(XmlPullParser.START_TAG, ns, tag);
        while (parser.next() != XmlPullParser.END_TAG) {
            if (parser.getEventType() != XmlPullParser.START_TAG) {
                continue;
            }
            String name = parser.getName();
            if (name.equals("YEAST")) {
                yeasts.add(readYeast(parser, name));
            } else {
                skip(parser);
            }
        }
        return yeasts;
    }

    private Yeast readYeast(XmlPullParser parser, String tag) throws XmlPullParserException, IOException {
        parser.require(XmlPullParser.START_TAG, ns, tag);
        Yeast.Builder builder = new Yeast.Builder();
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
                case "LABORATORY":
                    builder.laboratory(readText(parser, name));
                    break;
                case "PRODUCT_ID":
                    builder.product_id(readText(parser, name));
                    break;
                case "TYPE":
                    builder.type(readType(parser, name));
                    break;
                case "FORM":
                    builder.form(readForm(parser, name));
                    break;
                case "AMOUNT":
                    builder.amount(readDouble(parser, name));
                    break;
                case "AMOUNT_IS_WEIGHT":
                    builder.amount_is_weight(readBoolean(parser, name));
                    break;
                case "ATTENUATION":
                    builder.attenuation(readDouble(parser, name));
                    break;
                case "MIN_TEMPERATURE":
                    builder.min_temp(readDouble(parser, name));
                    break;
                case "MAX_TEMPERATURE":
                    builder.max_temp(readDouble(parser, name));
                    break;
                case "NOTES":
                    builder.notes(readText(parser, name));
                    break;
                default:
                    skip(parser);
                    break;
            }
        }
        return builder.build();
    }

    private YeastForm readForm(XmlPullParser parser, String tag) throws IOException, XmlPullParserException {
        String form = readText(parser, tag).toLowerCase();
        switch (form) {
            case "liquid":
                return YeastForm.LIQUID;
            case "dry":
                return YeastForm.DRY;
            case "slant":
                return YeastForm.SLANT;
            case "culture":
                return YeastForm.CULTURE;
            default:
                throw new XmlPullParserException("Unsupported yeast form: " + form);
        }
    }

    private YeastType readType(XmlPullParser parser, String tag) throws IOException, XmlPullParserException {
        String type = readText(parser, tag).toLowerCase();
        switch (type) {
            case "ale":
                return YeastType.ALE;
            case "lager":
                return YeastType.LAGER;
            case "wheat":
                return YeastType.WHEAT;
            case "wine":
                return YeastType.WINE;
            case "champagne":
                return YeastType.CHAMPAGNE;
            default:
                throw new XmlPullParserException("Unsupported yeast type: " + type);
        }
    }
}

package beer.hapibrew.beerxml2proto.parser;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;

import beer.hapibrew.beerxml2proto.proto.Style;
import beer.hapibrew.beerxml2proto.proto.StyleType;

class StyleParser extends BaseParser {

    Style readStyle(XmlPullParser parser, String tag) throws XmlPullParserException, IOException {
        parser.require(XmlPullParser.START_TAG, ns, tag);
        Style.Builder builder = new Style.Builder();
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
                case "CATEGORY":
                    builder.category(readText(parser, name));
                    break;
                case "CATEGORY_NUMBER":
                    builder.category_number(readText(parser, name));
                    break;
                case "STYLE_LETTER":
                    builder.style_letter(readText(parser, name));
                    break;
                case "STYLE_GUIDE":
                    builder.style_guide(readText(parser, name));
                    break;
                case "TYPE":
                    builder.type(readType(parser, name));
                    break;
                case "OG_MIN":
                    builder.og_min(readDouble(parser, name));
                    break;
                case "OG_MAX":
                    builder.og_max(readDouble(parser, name));
                    break;
                case "FG_MIN":
                    builder.fg_min(readDouble(parser, name));
                    break;
                case "FG_MAX":
                    builder.fg_max(readDouble(parser, name));
                    break;
                case "IBU_MIN":
                    builder.ibu_min(readDouble(parser, name));
                    break;
                case "IBU_MAX":
                    builder.ibu_max(readDouble(parser, name));
                    break;
                case "COLOR_MIN":
                    builder.srm_min(readDouble(parser, name));
                    break;
                case "COLOR_MAX":
                    builder.srm_max(readDouble(parser, name));
                    break;
                case "ABV_MIN":
                    builder.abv_min(readDouble(parser, name));
                    break;
                case "ABV_MAX":
                    builder.abv_max(readDouble(parser, name));
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

    private StyleType readType(XmlPullParser parser, String tag) throws IOException, XmlPullParserException {
        String type = readText(parser, tag).toLowerCase();
        switch (type) {
            case "lager":
                return StyleType.LAGER;
            case "ale":
                return StyleType.ALE;
            case "mead":
                return StyleType.MEAD;
            case "wheat":
                return StyleType.WHEAT;
            case "mixed":
                return StyleType.MIXED;
            case "cider":
                return StyleType.CIDER;
            default:
                throw new XmlPullParserException("Unsupported style type: " + type);
        }
    }
}

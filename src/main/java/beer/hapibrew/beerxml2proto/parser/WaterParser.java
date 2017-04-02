package beer.hapibrew.beerxml2proto.parser;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import beer.hapibrew.beerxml2proto.proto.Water;

class WaterParser extends BaseParser {

    List<Water> readWaters(XmlPullParser parser, String tag) throws XmlPullParserException, IOException {
        ArrayList<Water> waters = new ArrayList<>();

        parser.require(XmlPullParser.START_TAG, ns, tag);
        while (parser.next() != XmlPullParser.END_TAG) {
            if (parser.getEventType() != XmlPullParser.START_TAG) {
                continue;
            }
            String name = parser.getName();
            if (name.equals("WATER")) {
                waters.add(readWater(parser, name));
            } else {
                skip(parser);
            }
        }
        return waters;
    }

    private Water readWater(XmlPullParser parser, String tag) throws XmlPullParserException, IOException {
        parser.require(XmlPullParser.START_TAG, ns, tag);
        Water.Builder builder = new Water.Builder();
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
                case "AMOUNT":
                    builder.amount(readDouble(parser, name));
                    break;
                case "CALCIUM":
                    builder.calcium(readDouble(parser, name));
                    break;
                case "BICARBONATE":
                    builder.bicarbonate(readDouble(parser, name));
                    break;
                case "SULFATE":
                    builder.sulfate(readDouble(parser, name));
                    break;
                case "CHLORIDE":
                    builder.chloride(readDouble(parser, name));
                    break;
                case "SODIUM":
                    builder.sodium(readDouble(parser, name));
                    break;
                case "MAGNESIUM":
                    builder.magnesium(readDouble(parser, name));
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
}

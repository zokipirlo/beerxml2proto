package beer.hapibrew.beerxml2proto.parser;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import beer.hapibrew.beerxml2proto.proto.Fermentable;

class FermentableParser extends BaseParser {

    List<Fermentable> readFermentables(XmlPullParser parser, String tag) throws XmlPullParserException, IOException {
        ArrayList<Fermentable> fermentables = new ArrayList<>();

        parser.require(XmlPullParser.START_TAG, ns, tag);
        while (parser.next() != XmlPullParser.END_TAG) {
            if (parser.getEventType() != XmlPullParser.START_TAG) {
                continue;
            }
            String name = parser.getName();
            if (name.equals("FERMENTABLE")) {
                fermentables.add(readFermentable(parser, name));
            } else {
                skip(parser);
            }
        }
        return fermentables;
    }

    private Fermentable readFermentable(XmlPullParser parser, String tag) throws XmlPullParserException, IOException {
        parser.require(XmlPullParser.START_TAG, ns, tag);
        Fermentable.Builder builder = new Fermentable.Builder();
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
                    builder.type(readText(parser, name));
                    break;
                case "AMOUNT":
                    builder.amount(readDouble(parser, name));
                    break;
                case "YIELD":
                    builder.yield(readDouble(parser, name));
                    break;
                case "COLOR":
                    builder.color(readDouble(parser, name));
                    break;
                case "POTENTIAL":
                    builder.potential(readDouble(parser, name));
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

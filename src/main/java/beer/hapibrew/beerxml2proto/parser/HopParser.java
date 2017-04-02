package beer.hapibrew.beerxml2proto.parser;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import beer.hapibrew.beerxml2proto.proto.Hop;
import beer.hapibrew.beerxml2proto.proto.HopForm;
import beer.hapibrew.beerxml2proto.proto.HopType;
import beer.hapibrew.beerxml2proto.proto.HopUse;

class HopParser extends BaseParser {

    List<Hop> readHops(XmlPullParser parser, String tag) throws XmlPullParserException, IOException {
        ArrayList<Hop> hops = new ArrayList<>();

        parser.require(XmlPullParser.START_TAG, ns, tag);
        while (parser.next() != XmlPullParser.END_TAG) {
            if (parser.getEventType() != XmlPullParser.START_TAG) {
                continue;
            }
            String name = parser.getName();
            if (name.equals("HOP")) {
                hops.add(readHop(parser, name));
            } else {
                skip(parser);
            }
        }
        return hops;
    }

    private Hop readHop(XmlPullParser parser, String tag) throws XmlPullParserException, IOException {
        parser.require(XmlPullParser.START_TAG, ns, tag);
        Hop.Builder builder = new Hop.Builder();
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
                case "ALPHA":
                    builder.alpha(readDouble(parser, name));
                    break;
                case "AMOUNT":
                    double value = readDouble(parser, name);
                    if (value >= 5.0)
                        value /= 1000.0;
                    builder.amount(value);
                    break;
                case "USE":
                    builder.use(readUse(parser, name));
                    break;
                case "TIME":
                    builder.time(readDouble(parser, name));
                    break;
                case "TYPE":
                    builder.type(readType(parser, name));
                    break;
                case "FORM":
                    builder.form(readForm(parser, name));
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

    private HopUse readUse(XmlPullParser parser, String tag) throws IOException, XmlPullParserException {
        String use = readText(parser, tag).toLowerCase();
        switch (use) {
            case "boil":
                return HopUse.BOIL;
            case "dry hop":
                return HopUse.DRY_HOP;
            case "mash":
                return HopUse.MASH;
            case "first wort":
                return HopUse.FIRST_WORT;
            case "aroma":
                return HopUse.AROMA;
            default:
                throw new XmlPullParserException("Unsupported hop use: " + use);
        }
    }

    private HopType readType(XmlPullParser parser, String tag) throws IOException, XmlPullParserException {
        String type = readText(parser, tag).toLowerCase();
        switch (type) {
            case "bittering":
                return HopType.BITTERING;
            case "aroma":
                return HopType.AROMA;
            case "both":
                return HopType.BOTH;
            default:
                throw new XmlPullParserException("Unsupported hop type: " + type);
        }
    }

    private HopForm readForm(XmlPullParser parser, String tag) throws IOException, XmlPullParserException {
        String form = readText(parser, tag).toLowerCase();
        switch (form) {
            case "pellet":
                return HopForm.PELLET;
            case "plug":
                return HopForm.PLUG;
            case "leaf":
                return HopForm.LEAF;
            default:
                throw new XmlPullParserException("Unsupported hop form: " + form);
        }
    }
}

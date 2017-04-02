package beer.hapibrew.beerxml2proto.parser;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import beer.hapibrew.beerxml2proto.proto.Misc;
import beer.hapibrew.beerxml2proto.proto.MiscType;
import beer.hapibrew.beerxml2proto.proto.MiscUse;

class MiscParser extends BaseParser {

    List<Misc> readMiscs(XmlPullParser parser, String tag) throws XmlPullParserException, IOException {
        ArrayList<Misc> miscs = new ArrayList<>();

        parser.require(XmlPullParser.START_TAG, ns, tag);
        while (parser.next() != XmlPullParser.END_TAG) {
            if (parser.getEventType() != XmlPullParser.START_TAG) {
                continue;
            }
            String name = parser.getName();
            if (name.equals("MISC")) {
                miscs.add(readMisc(parser, name));
            } else {
                skip(parser);
            }
        }
        return miscs;
    }

    private Misc readMisc(XmlPullParser parser, String tag) throws XmlPullParserException, IOException {
        parser.require(XmlPullParser.START_TAG, ns, tag);
        Misc.Builder builder = new Misc.Builder();
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
                case "USE":
                    builder.use(readUse(parser, name));
                    break;
                case "AMOUNT":
                    builder.amount(readDouble(parser, name));
                    break;
                case "TIME":
                    builder.time(readDouble(parser, name));
                    break;
                case "AMOUNT_IS_WEIGHT":
                    builder.amount_is_weight(readBoolean(parser, name));
                    break;
                case "USE_FOR":
                    builder.use_for(readText(parser, name));
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

    private MiscUse readUse(XmlPullParser parser, String tag) throws IOException, XmlPullParserException {
        String use = readText(parser, tag).toLowerCase();
        switch (use) {
            case "boil":
                return MiscUse.BOIL;
            case "mash":
                return MiscUse.MASH;
            case "primary":
                return MiscUse.PRIMARY;
            case "secondary":
                return MiscUse.SECONDARY;
            case "bottling":
                return MiscUse.BOTTLING;
            default:
                throw new XmlPullParserException("Unsupported misc use: " + use);
        }
    }

    private MiscType readType(XmlPullParser parser, String tag) throws IOException, XmlPullParserException {
        String type = readText(parser, tag).toLowerCase();
        switch (type) {
            case "spice":
                return MiscType.SPICE;
            case "fining":
                return MiscType.FINING;
            case "water agent":
                return MiscType.WATER_AGENT;
            case "herb":
                return MiscType.HERB;
            case "flavor":
                return MiscType.FLAVOR;
            case "other":
                return MiscType.OTHER;
            default:
                throw new XmlPullParserException("Unsupported misc type: " + type);
        }
    }
}

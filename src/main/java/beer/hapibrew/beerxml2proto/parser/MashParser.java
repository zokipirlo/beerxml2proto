package beer.hapibrew.beerxml2proto.parser;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import beer.hapibrew.beerxml2proto.proto.Mash;
import beer.hapibrew.beerxml2proto.proto.MashStep;

class MashParser extends BaseParser {

    Mash readMash(XmlPullParser parser, String tag) throws XmlPullParserException, IOException {
        parser.require(XmlPullParser.START_TAG, ns, tag);
        Mash.Builder builder = new Mash.Builder();
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
                case "SPARGE_TEMP":
                    builder.sparge_temp(readDouble(parser, name));
                    break;
                case "PH":
                    builder.ph(readDouble(parser, name));
                    break;
                case "MASH_STEPS":
                    builder.steps(readMashSteps(parser, name));
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

    private List<MashStep> readMashSteps(XmlPullParser parser, String tag) throws XmlPullParserException, IOException {
        ArrayList<MashStep> mashSteps = new ArrayList<>();

        parser.require(XmlPullParser.START_TAG, ns, tag);
        while (parser.next() != XmlPullParser.END_TAG) {
            if (parser.getEventType() != XmlPullParser.START_TAG) {
                continue;
            }
            String name = parser.getName();
            if (name.equals("MASH_STEP")) {
                mashSteps.add(readMashStep(parser, name));
            } else {
                skip(parser);
            }
        }
        return mashSteps;
    }

    private MashStep readMashStep(XmlPullParser parser, String tag) throws XmlPullParserException, IOException {
        parser.require(XmlPullParser.START_TAG, ns, tag);
        MashStep.Builder builder = new MashStep.Builder();
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
                case "STEP_TEMP":
                    builder.step_temp(readDouble(parser, name));
                    break;
                case "STEP_TIME":
                    builder.step_time(readDouble(parser, name));
                    break;
                default:
                    skip(parser);
                    break;
            }
        }
        return builder.build();
    }
}

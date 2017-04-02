package beer.hapibrew.beerxml2proto.parser;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;

abstract class BaseParser {
    static final String ns = null;

    String readText(XmlPullParser parser, String tag) throws IOException, XmlPullParserException {
        parser.require(XmlPullParser.START_TAG, ns, tag);
        String result = "";
        if (parser.next() == XmlPullParser.TEXT) {
            result = parser.getText();
            parser.nextTag();
        }
        parser.require(XmlPullParser.END_TAG, ns, tag);
        return result;
    }
    int readInt(XmlPullParser parser, String tag) throws IOException, XmlPullParserException {
        return Integer.parseInt(readText(parser, tag));
    }
    double readDouble(XmlPullParser parser, String tag) throws IOException, XmlPullParserException {
        return Double.parseDouble(readText(parser, tag));
    }
    boolean readBoolean(XmlPullParser parser, String tag) throws IOException, XmlPullParserException {
        return Boolean.parseBoolean(readText(parser, tag));
    }

    void skip(XmlPullParser parser) throws XmlPullParserException, IOException {
        if (parser.getEventType() != XmlPullParser.START_TAG) {
            throw new IllegalStateException();
        }
        int depth = 1;
        while (depth != 0) {
            switch (parser.next()) {
                case XmlPullParser.END_TAG:
                    depth--;
                    break;
                case XmlPullParser.START_TAG:
                    depth++;
                    break;
            }
        }
    }
}

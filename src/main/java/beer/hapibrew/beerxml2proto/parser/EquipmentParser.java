package beer.hapibrew.beerxml2proto.parser;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;

import beer.hapibrew.beerxml2proto.proto.Equipment;

class EquipmentParser extends BaseParser {

    Equipment readEquipment(XmlPullParser parser, String tag) throws XmlPullParserException, IOException {
        parser.require(XmlPullParser.START_TAG, ns, tag);
        Equipment.Builder builder = new Equipment.Builder();
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
                case "BOIL_SIZE":
                    builder.boil_size(readDouble(parser, name));
                    break;
                case "BATCH_SIZE":
                    builder.batch_size(readDouble(parser, name));
                    break;
                case "TUN_VOLUME":
                    builder.tun_volume(readDouble(parser, name));
                    break;
                case "TOP_UP_WATER":
                    builder.top_up_water(readDouble(parser, name));
                    break;
                case "TRUB_CHILLER_LOSS":
                    builder.trub_chiller_loss(readDouble(parser, name));
                    break;
                case "EVAP_RATE":
                    builder.evap_rate(readDouble(parser, name));
                    break;
                case "BOIL_TIME":
                    builder.boil_time(readDouble(parser, name));
                    break;
                case "CALC_BOIL_VOLUME":
                    builder.calc_boil_volume(readBoolean(parser, name));
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

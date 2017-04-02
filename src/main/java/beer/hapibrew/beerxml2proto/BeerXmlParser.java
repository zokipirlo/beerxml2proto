package beer.hapibrew.beerxml2proto;

import android.support.annotation.Nullable;
import android.util.Log;
import android.util.Xml;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import beer.hapibrew.beerxml2proto.parser.RecipeParser;
import beer.hapibrew.beerxml2proto.proto.Recipe;

public class BeerXmlParser {

    @Nullable
    public List<Recipe> parse(InputStream in) {
        if (in == null)
            return null;

        try {
            XmlPullParser parser = Xml.newPullParser();
            parser.setFeature(XmlPullParser.FEATURE_PROCESS_NAMESPACES, false);
            parser.setInput(in, null);
            parser.nextTag();
            return new RecipeParser().readRecipes(parser);
        } catch (XmlPullParserException | IOException e) {
            Log.w("BeerXmlParser", e);
        } finally {
            try {
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}

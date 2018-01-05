package com.vlocker.ui.widget.c;

import java.io.InputStream;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.helpers.DefaultHandler;

public class c {
    public d a(InputStream inputStream) {
        SAXParser newSAXParser = SAXParserFactory.newInstance().newSAXParser();
        DefaultHandler eVar = new e();
        newSAXParser.parse(inputStream, eVar);
        inputStream.close();
        return eVar.a();
    }
}

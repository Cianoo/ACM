package day20190507;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

public class DoXml {
    private Map<String ,String> cont = new HashMap<>();

    public static void main(String[] args) {
        DoXml doXml = new DoXml();
        doXml.saveInfo();   //储存信息

        DocumentBuilderFactory documentBuilderFactory =
                DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder documentBuilder =
                    documentBuilderFactory.newDocumentBuilder();

            Document document = documentBuilder.newDocument();
            Element root = document.createElement("OTA_AirLowFareSearchRQ");    //创建根目录

            Element OriginDestinationInformation =
                    document.createElement("OriginDestinationInformation");     //创建父目录

            Element child1 = document.createElement("DepartureDateTime");       //子目录1
            Element child2 = document.createElement("OriginLocation");
            child2.setAttribute("CodeContext","IATA");
            child2.setAttribute("LocationCode","PEK");
            Element child3  = document.createElement("DestinationLocation");
            child3.setAttribute("CodeContext","IATA");
            child3.setAttribute("LocationCode","PEK");

            document.appendChild(root);

            TransformerFactory transformerFactory =
                    TransformerFactory.newInstance();
            Transformer transformer =
                    transformerFactory.newTransformer();

            StringWriter writer = new StringWriter();
            transformer.transform(new DOMSource(document),new StreamResult(writer));
            System.out.println(writer.toString());

            transformer.transform(new DOMSource(document),new StreamResult(new File("TEST.xml")));
        } catch (ParserConfigurationException | TransformerException e) {
            e.printStackTrace();
        }
    }

    public void saveInfo(){
        cont.put("Departure","PEK");
        cont.put( "Arrival","HAK");
        cont.put("JoneryType", "RT");
        cont.put("DepartureDateTime", "2018-12-19T22:00:00");
        cont.put( "ArrivalDateTime","2018-12-21T22:00:00");
        cont.put( "PassgerType","ADT");
        cont.put( "PassgerCount","1");
    }
}


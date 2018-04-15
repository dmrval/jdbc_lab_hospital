package mainPackage;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.StringWriter;
import java.sql.*;

public class ExportToXML {

    public static void ExportToXMLVisits() throws ParserConfigurationException, SQLException, TransformerException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = builder.newDocument();
        Element results = doc.createElement("Results");
        doc.appendChild(results);
        Connection con = Connections.connectTo();
        ResultSet rs = null;
        try {
            rs = con.createStatement().executeQuery("select * from Visits");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        ResultSetMetaData rsmd = rs.getMetaData();
        int colCount = rsmd.getColumnCount();
        while (rs.next()) {
            Element row = doc.createElement("Row");
            results.appendChild(row);
//            for (int i = 1; i <= colCount; i++) {
//                String columnName = rsmd.getColumnName(i);
//                Object value = rs.getObject(i);
//                Element node = doc.createElement(columnName);
//                node.appendChild(doc.createTextNode(value.toString()));
//                row.appendChild(node);
//            }
        }
        DOMSource domSource = new DOMSource(doc);
        TransformerFactory tf = TransformerFactory.newInstance();
        Transformer transformer = tf.newTransformer();
        transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
        transformer.setOutputProperty(OutputKeys.METHOD, "xml");
        transformer.setOutputProperty(OutputKeys.ENCODING, "ISO-8859-1");
        StringWriter sw = new StringWriter();
        StreamResult sr = new StreamResult(sw);
        transformer.transform(domSource, sr);

        System.out.println(sw.toString());

        con.close();
        rs.close();

    }
}

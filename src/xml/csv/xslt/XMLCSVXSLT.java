/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xml.csv.xslt;

import org.w3c.dom.Document;
import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
/**
 *
 * @author Debasis
 */
public class XMLCSVXSLT {

    public static void main(String args[]) throws Exception {
    File stylesheet = new File("XSLT.xsl");
    File xmlSource = new File("input.xml");

    DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
    DocumentBuilder builder = factory.newDocumentBuilder();
    Document document = builder.parse(xmlSource);

    StreamSource stylesource = new StreamSource(stylesheet);
    Transformer transformer = TransformerFactory.newInstance() .newTransformer(stylesource);
    
    Source source = new DOMSource(document);
    Result outputTarget = new StreamResult(new File("output.csv"));
    transformer.transform(source, outputTarget);
    System.out.println("Done.");
  }
    
    
}

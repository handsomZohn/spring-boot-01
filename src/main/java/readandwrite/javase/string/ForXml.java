package readandwrite.javase.string;


import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;
import org.jdom.output.XMLOutputter;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.StringReader;
import java.text.Format;

/**
 * @ClassName ForXml
 * @Description 解析xml
 * @Date 2022/1/24 10:49
 * @Version 1.0
 **/
public class ForXml {
    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException, JDOMException {
        String dataStr = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                "\n" +
                "<user-info>\n" +
                "  <phone></phone>\n" +
                "  <email></email>\n" +
                "  <rspcode>022</rspcode>\n" +
                "  <rspmsg>交易已被取消: timeout</rspmsg>\n" +
                "  <weatherIsNew>false</weatherIsNew>\n" +
                "  <records>1.89000</records>\n" +
                "  <userName>明日晴空</userName>\n" +
                "  <owed>30</owed>\n" +
                "  <weight>70</weight>\n" +
                "  <operationTime>20220101000000</operationTime>\n" +
                "</user-info>";

//         Document document = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(dataStr);
//         Document document = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new ByteArrayInputStream(dataStr.getBytes()));
//        System.out.println(document);

        // 字符串转Document对象
        StringReader stringReader = new StringReader(dataStr);
        InputSource inputSource = new InputSource(stringReader);
        org.jdom.Document doc = (new SAXBuilder()).build(inputSource);
        System.out.println("doc:" + doc);

        Element rootElement = doc.getRootElement();
        System.out.println(rootElement);


        // 一顿操作 比如改某个属性的值
        Element weatherIsNew = rootElement.getChild("weatherIsNew");
        System.out.println(weatherIsNew);
//        String value = weatherIsNew.getValue();
        Element aTrue = weatherIsNew.setText("true");
//        System.out.println(value);

        // 再比如，添加一个节点叫昵称，根据名字而来的昵称 名字 + 大大大人
        String userName = rootElement.getChild("userName").getValue();
        rootElement.addContent(new Element("nickName").setText(userName + "大大大人"));


        // 再转为字符串
        XMLOutputter xmlOutputter = new XMLOutputter();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        xmlOutputter.output(doc, byteArrayOutputStream);
        String string = byteArrayOutputStream.toString();
        System.out.println(string);
    }
}

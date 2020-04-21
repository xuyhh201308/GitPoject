package test;

import javax.xml.bind.annotation.XmlRootElement;

import org.json.XML;
import net.sf.json.JSON;
import net.sf.json.xml.XMLSerializer;


@XmlRootElement
public class Xml2JsonUtil {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       String xml = "<root><aaa>a</aaa><bbb>b</bbb></root>";
		xml2json(xml);
		System.out.println(xml2json2(xml));
//		System.out.println();
		System.out.println();
	}

	
	public static void xml2json(String xml){

			org.json.JSONObject json = null;
			try {
				json = XML.toJSONObject(xml);
				 //��������  
			    String jsonPrettyPrintString = json.toString(4);  
				System.out.println(jsonPrettyPrintString);
			} catch (org.json.JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			

	}
	
	
	
    /**
     * ��xml�ַ���<STRONG>ת��</STRONG>ΪJSON�ַ���
     * 
     * @param xmlString
     *            xml�ַ���
     * @return JSON<STRONG>����</STRONG>
     */
    public static String xml2json2(String xmlString) {
        XMLSerializer xmlSerializer = new XMLSerializer();
        JSON json = xmlSerializer.read(xmlString);
        return json.toString(1);
    }
}

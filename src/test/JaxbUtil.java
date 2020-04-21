package test;

import java.io.StringReader;
import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class JaxbUtil {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		JavaVO vo = new JavaVO();
		ParentVO pvo = new ParentVO();
		pvo.setAge(0);
		pvo.setName("p");
		ChildVO cvo = new ChildVO();
		cvo.setAge(1);
		cvo.setName("c");
		vo.setHeadvo(pvo);
		vo.setChildvo(new ChildVO[] {cvo});
		System.out.println(converTomXml(vo));
		System.out.println("----------------------------");
//		String xml = "<javaVO><age>1</age><code>b</code><name></name></javaVO>";
//		JavaVO vo1 = converyToJavaBean(xml, JavaVO.class);
//		System.out.println(vo1.getAge());
	}

	/**
	 * JavaBean装换成xml 默认编码UTF-8
	 * 
	 * @param obj
	 * @return
	 */
	public static String converTomXml(Object obj) {
		return converToXml(obj, "UTF-8");
	}

	/**
	 * JavaBean装换成xml
	 * 
	 * @param obj
	 * @param encoding
	 * @return
	 */
	private static String converToXml(Object obj, String encoding) {
		String result = null;
		try {
			JAXBContext context = JAXBContext.newInstance(obj.getClass());
			Marshaller marshaller = context.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			marshaller.setProperty(Marshaller.JAXB_ENCODING, encoding);
			StringWriter writer = new StringWriter();
			marshaller.marshal(obj, writer);
			result = writer.toString();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * xml装换成JavaBean
	 * 
	 * @param xml
	 * @param c
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static <T> T converyToJavaBean(String xml, Class<T> c) {
		T t = null;
		try {
			JAXBContext context = JAXBContext.newInstance(c);
			Unmarshaller unmarshaller = context.createUnmarshaller();
			t = (T) unmarshaller.unmarshal(new StringReader(xml));
		} catch (Exception e) {
			e.printStackTrace();
		}

		return t;

	}
}

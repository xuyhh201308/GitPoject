package test;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class JavaVO {

  
	private ParentVO headvo;
	
	private ChildVO[] childvo;

	public ParentVO getHeadvo() {
		return headvo;
	}

	public void setHeadvo(ParentVO headvo) {
		this.headvo = headvo;
	}

	public ChildVO[] getChildvo() {
		return childvo;
	}

	public void setChildvo(ChildVO[] childvo) {
		this.childvo = childvo;
	}
	
	
	
	
	
}

package AllipcVersion;

//public class ROW {

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.sun.xml.internal.txw2.annotation.XmlAttribute;



//					<IPC_CLASS_CODE TYPE="C">07</IPC_CLASS_CODE>
//					<IPC_EDITION_CODE TYPE="C">-</IPC_EDITION_CODE>
//					<IPC_GROUP_CODE TYPE="C">15</IPC_GROUP_CODE>
//					<IPC_NAME TYPE="C">Compounds containing elements of the 8th Group of the Periodic System</IPC_NAME>
//					<IPC_SECTION_CODE TYPE="C">C</IPC_SECTION_CODE>
//					<IPC_SUBCLASS_CODE TYPE="C">F</IPC_SUBCLASS_CODE>
//					<IPC_SUBGROUP_CODE TYPE="C">00</IPC_SUBGROUP_CODE>
//					<ROW_VERSION TYPE="N">1</ROW_VERSION>


@XmlRootElement
public class ROW {
	
	
	//private String  NAME;
	private String ipc_class_code;
	private String ipc_edition_code;
	private String ipc_group_code;
	private String ipc_subgroup_code;
	private String ipc_name;
	private String ipc_section_code;
	private String ipc_subclass_code;
	private String row_version;
	private String xml_designer;
	private String type;
			
	  
	
	  @XmlAttribute
	 
	public void setAttributeType(String type) {
		this.type = type;
	}
	
	
	

	public String getClassCode() {
		return ipc_class_code;
	}
	@XmlElement( name = "IPC_CLASS_CODE" )
	public void setClassCode(String ipc_class_code) {
		this.ipc_class_code = ipc_class_code;
	}

	public String getEditionCode() {
		return ipc_edition_code;
	}
	@XmlElement( name = "IPC_EDITION_CODE" )
	public void setEditionCode(String ipc_edition_code) {
		this.ipc_edition_code = ipc_edition_code;
	}

	public String getGroupCode() {
		return ipc_group_code;
	}
	@XmlElement( name = "IPC_GROUP_CODE" )
	public void setGroupCode(String ipc_group_code) {
		this.ipc_group_code = ipc_group_code;
	}

	public String getSubGroupCode() {
		return ipc_subgroup_code;
	}
	@XmlElement( name = "IPC_SUBGROUP_CODE" )
	public void setSubGroupCode(String ipc_subgroup_code) {
		this.ipc_subgroup_code = ipc_subgroup_code;
	}

	public String getIpcName() {
		return ipc_name;
	}
	@XmlElement( name = "IPC_NAME" )
	public void setIpcName(String ipc_name) {
		this.ipc_name = ipc_name;
	}

	public String getSectionCode() {
		return ipc_section_code;
	}
	@XmlElement( name = "IPC_SECTION_CODE" )
	public void setSectionCode(String ipc_section_code) {
		this.ipc_section_code = ipc_section_code;
	}

	public String getSubClassCode() {
		return ipc_subclass_code;
	}
	@XmlElement( name = "IPC_SUBCLASS_CODE" )
	public void setSubClassCode(String ipc_subclass_code) {
		this.ipc_subclass_code = ipc_subclass_code;
	}

	public String getRowVersion() {
		return row_version;
	}
	@XmlElement( name = "ROW_VERSION" )
	public void setRowVersion(String row_version) {
		this.row_version = row_version;
	}
	
	
	public String getXmlDesigner() {
		return xml_designer;
	}
	@XmlElement( name = "XML_DESIGNER" )
	public void setXmlDesigner(String xml_designer) {
		this.xml_designer = xml_designer;
	}
	

}




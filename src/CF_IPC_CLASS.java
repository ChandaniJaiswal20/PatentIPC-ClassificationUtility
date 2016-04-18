import javax.xml.bind.annotation.XmlRootElement;



//					<IPC_CLASS_CODE TYPE="C">07</IPC_CLASS_CODE>
//					<IPC_EDITION_CODE TYPE="C">-</IPC_EDITION_CODE>
//					<IPC_GROUP_CODE TYPE="C">15</IPC_GROUP_CODE>
//					<IPC_NAME TYPE="C">Compounds containing elements of the 8th Group of the Periodic System</IPC_NAME>
//					<IPC_SECTION_CODE TYPE="C">C</IPC_SECTION_CODE>
//					<IPC_SUBCLASS_CODE TYPE="C">F</IPC_SUBCLASS_CODE>
//					<IPC_SUBGROUP_CODE TYPE="C">00</IPC_SUBGROUP_CODE>
//					<ROW_VERSION TYPE="N">1</ROW_VERSION>


@XmlRootElement
public class CF_IPC_CLASS {
	
	


	private String ipc_class_code;
	private String ipc_edition_code;
	private String ipc_group_code;
	private String ipc_subgroup_code;
	private String ipc_name;
	private String ipc_section_code;
	private String ipc_subclass_code;
	private String row_version;
	private String xml_designer;





	public String getClassCode() {
		return ipc_class_code;
	}

	public void setClassCode(String ipc_class_code) {
		this.ipc_class_code = ipc_class_code;
	}

	public String getEditionCode() {
		return ipc_edition_code;
	}

	public void setEditionCode(String ipc_edition_code) {
		this.ipc_edition_code = ipc_edition_code;
	}

	public String getGroupCode() {
		return ipc_group_code;
	}

	public void setGroupCode(String ipc_group_code) {
		this.ipc_group_code = ipc_group_code;
	}

	public String getSubGroupCode() {
		return ipc_subgroup_code;
	}

	public void setSubGroupCode(String ipc_subgroup_code) {
		this.ipc_subgroup_code = ipc_subgroup_code;
	}

	public String getName() {
		return ipc_name;
	}

	public void setName(String ipc_name) {
		this.ipc_name = ipc_name;
	}

	public String getSectionCode() {
		return ipc_section_code;
	}

	public void setSectionCode(String ipc_section_code) {
		this.ipc_section_code = ipc_section_code;
	}

	public String getSubClassCode() {
		return ipc_subclass_code;
	}

	public void setSubClassCode(String ipc_subclass_code) {
		this.ipc_subclass_code = ipc_subclass_code;
	}

	public String getRowVersion() {
		return row_version;
	}

	public void setRowVersion(String row_version) {
		this.row_version = row_version;
	}
	
	
	public String getXmlDesigner() {
		return xml_designer;
	}

	public void setXmlDesigner(String xml_designer) {
		this.xml_designer = xml_designer;
	}
	

}

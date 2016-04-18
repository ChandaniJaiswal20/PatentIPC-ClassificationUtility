package AllipcVersion;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;



//					<IPC_CLASS_CODE TYPE="C">07</IPC_CLASS_CODE>
//					<IPC_EDITION_CODE TYPE="C">-</IPC_EDITION_CODE>
//					<IPC_GROUP_CODE TYPE="C">15</IPC_GROUP_CODE>
//					<IPC_NAME TYPE="C">Compounds containing elements of the 8th Group of the Periodic System</IPC_NAME>
//					<IPC_SECTION_CODE TYPE="C">C</IPC_SECTION_CODE>
//					<IPC_SUBCLASS_CODE TYPE="C">F</IPC_SUBCLASS_CODE>
//					<IPC_SUBGROUP_CODE TYPE="C">00</IPC_SUBGROUP_CODE>
//					<ROW_VERSION TYPE="N">1</ROW_VERSION>


@XmlRootElement( name = "TABLE" )
public class TABLE {
	 String  NAME= "CF_CLASS_IPC";
	List<ROW> rows = new ArrayList<ROW>();
	

//	@XmlAttribute(name="NAME")
	public void setTableName() {
		this.NAME = "CF_CLASS_IPC";
	}

	public List<ROW> getRows() {
		return rows;
	}

	
	@XmlElement( name = "ROW")
	public void setRows(List<ROW> rows) {
		this.rows = rows;
	}


		public void add(ROW row)
		{
			
			rows.add(row);
			
		}

}


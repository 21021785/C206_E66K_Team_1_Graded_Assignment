/**
 * 
 */

/**
 * @author nicks
 *
 */
public class Subject {
	private String name;
	private String description;
	private String preRequisite;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getPreRequisite() {
		return preRequisite;
	}
	public void setPreRequisite(String preRequisite) {
		this.preRequisite = preRequisite;
	}
	@Override
	public String toString() {
		return "Subject [name=" + name + ", description=" + description + ", preRequisite=" + preRequisite + "]";
	}
	
}

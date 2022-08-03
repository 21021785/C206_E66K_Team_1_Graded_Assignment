public class Tuition {
	private int code; 
	private int title;
	private String grpName;
	private String description;
	private double duration;
	private String preReq;
	private String teacher;
	public Tuition(int code, int title, String grpName, String description, double duration, String preReq,
			String teacher) {
		this.code = code;
		this.title = title;
		this.grpName = grpName;
		this.description = description;
		this.duration = duration;
		this.preReq = preReq;
		this.teacher = teacher;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public int getTitle() {
		return title;
	}
	public void setTitle(int title) {
		this.title = title;
	}
	public String getGrpName() {
		return grpName;
	}
	public void setGrpName(String grpName) {
		this.grpName = grpName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getDuration() {
		return duration;
	}
	public void setDuration(double duration) {
		this.duration = duration;
	}
	public String getPreReq() {
		return preReq;
	}
	public void setPreReq(String preReq) {
		this.preReq = preReq;
	}
	public String getTeacher() {
		return teacher;
	}
	public void setTeacher(String teacher) {
		this.teacher = teacher;
	}
	@Override
	public String toString() {
		return "Tuition [code=" + code + ", title=" + title + ", grpName=" + grpName + ", description=" + description
				+ ", duration=" + duration + ", preReq=" + preReq + ", teacher=" + teacher + "]";
	}
	
}

public class Tuition {
	private String code; 
	private String title;
	private String subject;
	private String description;
	private double duration;
	private String preReq;
	private String teacher;
	private String tuition;
	public Tuition(String code, String title, String subject, String description, double duration, String preReq,
			String teacher, String tuition ) {
		this.code = code;
		this.title = title;
		this.subject = subject;
		this.description = description;
		this.duration = duration;
		this.preReq = preReq;
		this.teacher = teacher;
		this.tuition = tuition;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
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
	public String getTuition() {
		return tuition;
	}
	public void setTuition(String tuition) {
		this.tuition = tuition;
	}
	@Override
	public String toString() {
		return "Tuition [code=" + code + ", title=" + title + ", Subject=" + subject + ", description=" + description
				+ ", duration=" + duration + ", preReq=" + preReq + ", teacher=" + teacher + "]";
	}
	//aj
}

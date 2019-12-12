package hello.model;

public class Model {

	private final long id;
	private final String content;

	public Model(long id, String content) {
		this.id = id;
		this.content = content;
	}

	public long getId() {
		return id;
	}

	public String getContent() {
		return content;
	}
}

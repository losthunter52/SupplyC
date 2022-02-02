package db;

public class Database {

	private String url;
	private String username;
	private String password;
	
	public Database url(String url) {
		this.url = url;
		return this;
	}
	
	public Database username(String username) {
		this.username = username;
		return this;
	}
	
	public Database password(String password) {
		this.password = password;
		return this;
	}
	
	public String getUrl() {
		return url;
	}
	public String getUsername() {
		return username;
	}
	public String getPassword() {
		return password;
	}
	
}

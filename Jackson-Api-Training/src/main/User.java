package main;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;

public class User {
	private String id;
	private String name;

	public User() {
	}

	@JsonCreator
	public User(String user) {
		String[] filds = user.split(",");
		this.id = filds[0];
		this.name = filds[1];
	}

	@JsonCreator
	public User(@JsonProperty("id") String id, @JsonProperty("name") String name) {
		this.id = id;
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null || getClass() != obj.getClass())
			return false;
		User user = (User) obj;
		return id.equals(user.id) && name.equals(user.name);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, name);
	}

	@Override
	@JsonValue
	public String toString() {
		return id + "," + name;
	}
}

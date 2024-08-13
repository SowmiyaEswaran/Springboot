package com.boot.MultipleDataSource.domain.book;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name="books")
public class BookDetails {
			

	@Id
	private int id;
	
	private String topic;
	
	private String description;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTopic() {
		return topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	

	public BookDetails() {
		super();
	}

	public BookDetails(int id, String topic, String description) {
		super();
		this.id = id;
		this.topic = topic;
		this.description = description;
	}
	

}

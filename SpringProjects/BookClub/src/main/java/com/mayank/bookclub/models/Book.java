package com.mayank.bookclub.models;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="books")
public class Book {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // generates an auto incrementing 
	private Long id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	private User postedBy;
	
	@NotBlank
	@Size(min=2, max=255, message="book title needs to be between 2 and 255 characters")
	private String bookName;
	
	@NotBlank
	@Size(min=2, max=255, message="book title needs to be between 2 and 255 characters")
	private String author;
	
	@NotBlank
	@Size(min=2, max=255, message="book title needs to be between 2 and 255 characters")
	private String myThoughts;
	
	
	@Column(updatable = false)
	private Date createdAt;

	private Date updatedAt;

	public Book() {
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getBookName() {
		return bookName;
	}


	public void setBookName(String bookName) {
		this.bookName = bookName;
	}



	public User getPostedBy() {
		return postedBy;
	}



	public void setPostedBy(User postedBy) {
		this.postedBy = postedBy;
	}



	public String getAuthor() {
		return author;
	}



	public void setAuthor(String author) {
		this.author = author;
	}



	public String getMyThoughts() {
		return myThoughts;
	}



	public void setMyThoughts(String myThoughts) {
		this.myThoughts = myThoughts;
	}



	public Date getCreatedAt() {
		return createdAt;
	}


	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}


	public Date getUpdatedAt() {
		return updatedAt;
	}


	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}


	@PrePersist // adds the created at date and time to sql on creation 
	protected void onCreate() {
		this.createdAt = new Date();
	}

	@PreUpdate // add the updated at date and time when being updated
	protected void onUpdate() {
		this.updatedAt = new Date();
	}

}

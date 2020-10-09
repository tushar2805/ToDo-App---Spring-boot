package com.github.todo.domain;

import java.time.LocalDateTime;
import java.util.UUID;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.GenericGenerator;


@Entity
public class ToDo {
	
	@NotNull
	@Id
	@GeneratedValue (generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	private String id;
	@NotNull
	@NotBlank
	private String description;
	
	@Column(insertable = true, updatable = false)
	private LocalDateTime created;
    private LocalDateTime modified;
    private boolean completed;
    
    public ToDo(){
    }
        
    public ToDo(String description) {
    	this.description = description;
    }
    
    @PrePersist
    void onCreate() {
	   this.setCreated(LocalDateTime.now());
	   this.setModified(LocalDateTime.now());
    }
    @PreUpdate
	void onUpdate() {
	   this.setModified(LocalDateTime.now());
    }

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDateTime getCreated() {
		return created;
	}

	public void setCreated(LocalDateTime created) {
		this.created = created;
	}

	public LocalDateTime getModified() {
		return modified;
	}

	public void setModified(LocalDateTime modified) {
		this.modified = modified;
	}

	public boolean isCompleted() {
		return completed;
	}

	public void setCompleted(boolean completed) {
		this.completed = completed;
	}
    
    
}

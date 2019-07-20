package com.FirstMavenProject.FirstRest;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Actor {
	private int actorID;
	private String firstName;
	private String lastName;

	public int getActorID() {
		return actorID;
	}
	
	public void setActorID(int actorID) {
		this.actorID = actorID;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	@Override
	public String toString() {
		return "actor [actorID=" + actorID + ", firstName=" + firstName + ", lastName=" + lastName + "]";
	}
	
	

}

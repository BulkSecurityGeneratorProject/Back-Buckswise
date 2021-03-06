package com.valuequo.buckswise.service.dto;


import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import java.util.Objects;

/**
 * A DTO for the Familyprofile entity.
 */
public class FamilyprofileDTO implements Serializable {

    private Long id;
    
    private Long uid;

	private String relationship;

    private String firstname;

    private String middlename;

    private String lastname;

    private Date dateOfBirth;

    private String earncheck;

	private String email;

    private String phonenumber;

    private Long childuid; 

    //added by ranjan...............
    private String accesstype;
    private String familyaccess;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUid() {
		return uid;
	}

	public void setUid(Long uid) {
		this.uid = uid;
	}

    public String getRelationship() {
        return relationship;
    }

    public void setRelationship(String relationship) {
        this.relationship = relationship;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getMiddlename() {
        return middlename;
    }

    public void setMiddlename(String middlename) {
        this.middlename = middlename;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
    public String getEarncheck() {
		return earncheck;
	}

	public void setEarncheck(String earncheck) {
		this.earncheck = earncheck;
	}

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    //added by ranjan..........start.....

    public String getAccesstype() {
        return accesstype;
    }

    public void setAccesstype(String accesstype) {
        this.accesstype = accesstype;
    }

     public String getFamilyaccess() {
        return  familyaccess;
    }

    public void setFamilyaccess(String  familyaccess) {
        this. familyaccess =  familyaccess;
    }

    public Long getChilduid() {
        return childuid;
    }

    public void setChilduid(Long childuid) {
        this.childuid = childuid;
    }
    

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        FamilyprofileDTO familyprofileDTO = (FamilyprofileDTO) o;
        if(familyprofileDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), familyprofileDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "FamilyprofileDTO{" +
            "id=" + getId() +
            ", uid= "+getUid()+ ", relationship='" + getRelationship() + "'" +
            ", firstname='" + getFirstname() + "'" +
            ", middlename='" + getMiddlename() + "'" +
            ", lastname='" + getLastname() + "'" +
            ", dateOfBirth='" + getDateOfBirth() + "'" +
            ", isEarning='" + getEarncheck() + "'" +
            ", email='" + getEmail() + "'" +
            ", phonenumber='" + getPhonenumber() + "'" +
            ", accesstype='" + getAccesstype() + "'" +
            ", familyaccess='" + getFamilyaccess() + "'" +

            "}";
    }
}

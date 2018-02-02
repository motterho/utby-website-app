package com.utby.springboot.web.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table(name = "notes_tab")
public class Todo implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = -8760528476040711762L;

    @GenericGenerator(name = "usersSequenceGenerator", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator", parameters = {
            @Parameter(name = "sequence_name", value = "usersSequence"), @Parameter(name = "initial_value", value = "1"),
            @Parameter(name = "increment_size", value = "1") })
    
    @Id
    @GeneratedValue(generator = "usersSequenceGenerator")
    private int id;

    @Column(name = "username")
    private String user;

    @Column(name = "note")
    private String note;

    @Column(name = "targetdate")
    private Date targetDate;

    @Column(name = "isdone")
    private boolean isDone;

    public Todo() {
        super();
        // TODO Auto-generated constructor stub
    }

    public Todo(int id, String user, String note, Date targetDate, boolean isDone) {
        super();
        this.id = id;
        this.user = user;
        this.note = note;
        this.targetDate = targetDate;
        this.isDone = isDone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Date getTargetDate() {
        return targetDate;
    }

    public void setTargetDate(Date targetDate) {
        this.targetDate = targetDate;
    }

    public boolean isDone() {
        return isDone;
    }

    public void setDone(boolean isDone) {
        this.isDone = isDone;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + id;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Todo other = (Todo) obj;
        if (id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return String.format("Todo [id=%s, user=%s, note=%s, targetDate=%s, isDone=%s]", id, user, note, targetDate, isDone);
    }

}
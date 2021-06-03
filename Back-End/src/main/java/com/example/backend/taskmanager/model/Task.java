package com.example.backend.taskmanager.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import java.io.Serializable;

@Entity
public class Task implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private Long id;

    private String text;
    private String day;
    private Boolean reminder;

    public Task() {

    }

    public Task(String text, String day, Boolean reminder) {
        this.text = text;
        this.day = day;
        this.reminder = reminder;
    }

    public Task(Long id, String text, String day, Boolean reminder) {
        this.id = id;
        this.text = text;
        this.day = day;
        this.reminder = reminder;
    }

    public Long getId() {
        return this.id;
    }

    public String getText() {
        return this.text;
    }

    public String getDay() {
        return this.day;
    }

    public Boolean getReminder() {
        return this.reminder;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public void setReminder(Boolean reminder) {
        this.reminder = reminder;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", text='" + text + '\'' +
                ", day='" + day + '\'' +
                ", reminder=" + reminder +
                '}';
    }


}

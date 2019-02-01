package com.hendisantika.springbootintegrationtest.model;

import javax.persistence.*;

/**
 * Created by IntelliJ IDEA.
 * Project : springboot-integrationtest
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 2019-02-01
 * Time: 08:05
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name = "students")
public class Student {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Integer id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description", nullable = false)
    private String description;

    public Student() {

    }

    public Student(String name, String description) {
        super();
        this.name = name;
        this.description = description;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return String.format(
                "Student [id=%s, name=%s, description=%s]", id, name, description);
    }
}
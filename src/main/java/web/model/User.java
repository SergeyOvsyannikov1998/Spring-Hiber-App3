package web.model;

import javax.persistence.*;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String name;
    @Column
    private String lastName;
    @Column
    private Byte age;
    public User(){}
    public User(String name, String lastName, Byte age){
        this.name=name;
        this.lastName=lastName;
        this.age=age;
    }
    public void setAge(Byte age) {
        this.age = age;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public Long getId() {
        return id;
    }

    public Byte getAge() {
        return age;
    }

    public String getLastName() {
        return lastName;
    }

    public String getName() {
        return name;
    }
}

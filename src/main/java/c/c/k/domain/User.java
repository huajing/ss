package c.c.k.domain;


import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Data //不用加get/set
@Table(name = "my_user")
public class User implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String mobile;

    public User(){}

    public User(String name) {
        this.name = name;
    }
}

package c.c.k.domain;


import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Data //不用加get/set
@Table(name = "my_stock")
public class Stock implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String code;

    private Integer city;

}

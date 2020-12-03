package c.c.k.domain;


import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;


@Entity
@Data //不用加get/set
@Table(name = "my_history")
public class History implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private LocalDate createTime;

    private Date updateTime;

    private Date dataTime;

    private Long stockId;

    private Long startPrice;

    private Long endPrice;


}

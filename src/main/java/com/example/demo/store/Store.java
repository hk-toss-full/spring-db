package com.example.demo.store;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity // 이 obj table 임
@Table(name = "stores")
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Store {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="store_id")
    private Long id;
    @Column(name="store_name", nullable = false)
    private String name;
    @Column(name="store_address")
    private String address;
    // getter 생성자 (lombok)
//  all argument 생성자
//    public Store(Long id, String name, String address) {
//        this.id = id;
//        this.name = name;
//        this.address = address;
//    }
// no argument 생성자
//    public Store() {
//    }
}

/*
create table store(
    store_id bigint primary key auto increment,
    store_name varchar(255)
)
 */
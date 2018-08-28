package app.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "items")

public class Item {
    @Id
    private Long id;
    @Column
    private String name;
    @Column
    private String description;
    @Column
    private BigDecimal cost;
    @Column
    private boolean status;
    @Column (name="id_user")
    private Long idUser;

    public boolean getStatus(){
        return status;
    }
}

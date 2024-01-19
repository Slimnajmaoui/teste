package tn.slim.msarticle.entities;



import entities.BaseEntity;
import entities.StockDto;
import lombok.*;

import javax.persistence.Entity;
import java.time.LocalDate;


@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Article extends BaseEntity {



    private Long idStock;
    private String name;
    private int qte;
}

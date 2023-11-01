package springboot.ecomerce.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Entity
@Data
public class LogPesanan implements Serializable {

    @Id
    private String id;
    @JoinColumn
    @ManyToOne
    private Pesanan pesanan;
    @JoinColumn
    @ManyToOne
    private Pengguna pengguna;
    private Integer LogType;
    private String LogMessage;
    @Temporal(TemporalType.TIMESTAMP)
    private Date waktu;
}

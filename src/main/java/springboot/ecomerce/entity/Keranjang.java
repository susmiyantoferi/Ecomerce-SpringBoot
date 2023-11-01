package springboot.ecomerce.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Data
public class Keranjang implements Serializable {

    @Id
    private String id;
    @JoinColumn
    @ManyToOne
    private Produk produk;
    @JoinColumn
    @ManyToOne
    private Pengguna pengguna;
    private Double kuantitas;
    private BigDecimal jumlah;
    private BigDecimal harga;
    @Temporal(TemporalType.TIMESTAMP)
    private Date waktu;
}

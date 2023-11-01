package springboot.ecomerce.entity;

import jakarta.persistence.*;
import lombok.Data;
import springboot.ecomerce.model.StatusPesanan;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Data
public class Pesanan implements Serializable {

    @Id
    private String id;
    private String nomor_pesanan;
    @Temporal(TemporalType.DATE)
    private Date tanggal;
    @JoinColumn
    @ManyToOne
    private Pengguna pengguna;
    private String alamatKirim;
    private BigDecimal jumlah;
    private BigDecimal ongkir;
    private BigDecimal total;
    @Enumerated(EnumType.STRING)
    private StatusPesanan statusPesanan;
    @Temporal(TemporalType.TIMESTAMP)
    private Date waktuPesan;

}

package springboot.ecomerce.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.text.DecimalFormat;

@Entity
@Data
public class Produk implements Serializable {

    @Id
    private String id;
    @JoinColumn
    @ManyToOne
    private Kategori kategori;
    private String nama;
    private String deskripsi;
    private String gambar;
    private BigDecimal harga;
    private Double stok;

}

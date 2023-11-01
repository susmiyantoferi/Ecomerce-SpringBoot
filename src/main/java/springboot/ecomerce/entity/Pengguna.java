package springboot.ecomerce.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

import java.io.Serializable;
@Entity
@Data
public class Pengguna implements Serializable {

    @Id
    private String id;
    private String email;
    private String password;
    private String nama;
    private String alamat;
    private String hp;
    private String role;
    private Boolean isAktif;
}

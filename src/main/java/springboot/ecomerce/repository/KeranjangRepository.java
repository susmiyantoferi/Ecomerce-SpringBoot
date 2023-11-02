package springboot.ecomerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import springboot.ecomerce.entity.Keranjang;

public interface KeranjangRepository extends JpaRepository<Keranjang, String> {
}

package springboot.ecomerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import springboot.ecomerce.entity.Produk;

public interface ProdukRepository extends JpaRepository<Produk, String> {
}

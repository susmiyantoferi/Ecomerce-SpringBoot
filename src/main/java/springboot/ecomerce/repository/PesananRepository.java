package springboot.ecomerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import springboot.ecomerce.entity.Pesanan;

public interface PesananRepository extends JpaRepository<Pesanan, String> {
}

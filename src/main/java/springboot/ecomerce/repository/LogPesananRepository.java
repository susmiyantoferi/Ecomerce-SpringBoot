package springboot.ecomerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import springboot.ecomerce.entity.LogPesanan;

public interface LogPesananRepository extends JpaRepository<LogPesanan, String> {
}

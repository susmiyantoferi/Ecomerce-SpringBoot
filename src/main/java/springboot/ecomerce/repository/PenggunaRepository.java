package springboot.ecomerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import springboot.ecomerce.entity.Pengguna;

public interface PenggunaRepository extends JpaRepository<Pengguna, String> {
    Boolean existsByEmail(String email);
}

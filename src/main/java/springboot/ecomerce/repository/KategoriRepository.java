package springboot.ecomerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import springboot.ecomerce.entity.Kategori;

public interface KategoriRepository extends JpaRepository<Kategori, String> {
}

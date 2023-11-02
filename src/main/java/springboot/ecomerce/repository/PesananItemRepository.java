package springboot.ecomerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import springboot.ecomerce.entity.PesananItem;

public interface PesananItemRepository extends JpaRepository<PesananItem, String> {
}

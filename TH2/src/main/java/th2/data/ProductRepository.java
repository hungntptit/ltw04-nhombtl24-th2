package th2.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import th2.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, String> {

}

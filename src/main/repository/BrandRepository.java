package main.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import main.model.Brand;

/**
 * 廠牌 Repository
 * @author aries
 */
@Repository
public interface BrandRepository extends JpaRepository<Brand, Long>{

	public Brand findByBrandDescription(String name);
}

package br.com.ufc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.ufc.model.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long>{

}

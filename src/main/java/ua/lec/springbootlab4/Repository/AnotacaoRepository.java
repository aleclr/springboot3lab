package ua.lec.springbootlab4.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ua.lec.springbootlab4.Entity.Anotacao;

public interface AnotacaoRepository extends JpaRepository<Anotacao, Long>{
    
}

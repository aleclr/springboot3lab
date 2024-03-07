package ua.lec.springbootlab4.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ua.lec.springbootlab4.Entity.Autorizacao;

public interface AutorizacaoRepository extends JpaRepository<Autorizacao, Long>{
    
}

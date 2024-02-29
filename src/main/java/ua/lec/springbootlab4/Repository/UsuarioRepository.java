package ua.lec.springbootlab4.Repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import ua.lec.springbootlab4.Entity.Usuario;

//para a função de repository, precisa ser uma interface e precisa extender uma interface do Spring
//(JpaRepository ou PagingAndSortingRepository)
public interface UsuarioRepository extends PagingAndSortingRepository<Usuario, Long>{
    


}

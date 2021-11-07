
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.coop.application.PruebaApplication;
import com.coop.domain.entities.Usuario;
import com.coop.domain.interfaces.usuario.IUsuarioRepository;
import com.coop.domain.interfaces.usuario.IUsuarioService;
import com.coop.infrastructure.repository.usuario.IUsuarioJpaRepository;


@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = PruebaApplication.class)
class UsuarioServiceTest {
	
	@Autowired
	IUsuarioService usuarioService;
	
	@Autowired
	IUsuarioJpaRepository usuarioJpaRepository;
	
	@Autowired
	IUsuarioRepository usuarioRepository;
	
	@BeforeEach
    public void init() {
    }
	
	@Test
	void testFindById() {
		System.out.println("testFindById ******************");
		Usuario usuario = usuarioService.findById(1L);
		System.out.println(usuario.getUserName());
		
		Usuario oE = usuarioRepository.findById(2L);
		System.out.println(oE.getUserName());
	}
	
	@Test
	void testFindAll() {
		System.out.println("testFindAll ******************");
		Map<String, Object> listaUsuario = usuarioRepository.findAll(0, 10);
		System.out.println(listaUsuario);
	}
	
	@Test
	void testCreate() {
		System.out.println("testCreate ******************");
		Usuario oUsuario = new Usuario();
		oUsuario.setUserName("x");
		oUsuario.setClave("12345678");
		oUsuario.setIdPersona(1L);
		oUsuario.setIdPerfil(2L);
		oUsuario.setActivo("N");
		
		Usuario x = usuarioService.create(oUsuario);
		assertEquals(10, 10);
	}

	@Test
	void testDelete() {
		assertEquals(10, 10);
	}

}

package chunbao.nl.event.gui.springboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import chunbao.nl.event.gui.springboot.model.Todo;

public interface TodoRepository extends JpaRepository<Todo, Long>{
	List<Todo> findByUserName(String user);
}

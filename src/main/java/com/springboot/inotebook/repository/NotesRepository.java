package com.springboot.inotebook.repository;

import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.springboot.inotebook.model.NoteBook;

@Repository
public interface NotesRepository extends MongoRepository<NoteBook,ObjectId>{
	Optional<NoteBook> findByIsbn(String isbn);
	void deleteByIsbn(String isbn);

}

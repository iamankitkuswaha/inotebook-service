package com.springboot.inotebook.service;

import java.util.List;
import java.util.Optional;

 
import com.springboot.inotebook.model.NoteBook;

public interface NotesServices {
	NoteBook addNoteBook(NoteBook noteBook);
	List<NoteBook> getAllBooks();
	Optional<NoteBook> findByISBN(String isbn);
	NoteBook updateNoteBook(NoteBook noteBook,String isbn);
	void deleteNoteBook(String isbn);

}

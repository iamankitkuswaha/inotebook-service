package com.springboot.inotebook.service.imp;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.springboot.inotebook.exception.BookNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory; 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.inotebook.model.NoteBook;
import com.springboot.inotebook.repository.NotesRepository;
import com.springboot.inotebook.service.NotesServices;

@Service
@Slf4j
public class NotesServicesImp implements NotesServices{
	@Autowired
	private NotesRepository notesRepo;

	@Override
	public NoteBook addNoteBook(NoteBook noteBook) {
		if (notesRepo.findByIsbn(noteBook.getIsbn())!=null) {
		    log.info("Already present!!");
		    return noteBook;
		}
		return notesRepo.insert(noteBook);
	}

	@Override
	public List<NoteBook> getAllBooks() {
		return notesRepo.findAll();
	}

	@Override
	public NoteBook updateNoteBook(NoteBook noteBook, String isbn) {
		Optional<NoteBook> currBook = findByISBN(isbn);
		if(noteBook.getAuthor()==null) {
			noteBook.setAuthor(currBook.get().getAuthor());
		}
		if(noteBook.getDescription()==null) {
			noteBook.setDescription(currBook.get().getDescription());
		}
		if(noteBook.getName()==null) {
			noteBook.setName(currBook.get().getName());
		}
		if(noteBook.getTag()==null) {
			noteBook.setTag(currBook.get().getTag());
		}
		noteBook.setDate(new Date());
		return notesRepo.save(noteBook);
	}

	@Override
	public void deleteNoteBook(String isbn) {
		Optional<NoteBook> noteBook = findByISBN(isbn);
		notesRepo.deleteByIsbn(isbn);
		log.info("Deleted successfulluy!!");
	}

	@Override
	public Optional<NoteBook> findByISBN(String isbn) {
		Optional<NoteBook> noteBook = Optional.ofNullable(notesRepo.findByIsbn(isbn)
                .orElseThrow(() -> new BookNotFoundException("Book is not present with given isbn:" + isbn)));
		return noteBook;
	}

}

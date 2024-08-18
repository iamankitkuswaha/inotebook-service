package com.springboot.inotebook.controller;

import java.util.List;
import java.util.Optional;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.inotebook.model.NoteBook;
import com.springboot.inotebook.service.NotesServices;


@Slf4j
@RestController
@RequestMapping("/api/v1/inotebooks")
public class NotesController {
	@Autowired
	private NotesServices notesService;
	
	public NotesController(NotesServices notesService) {
		super();
		this.notesService = notesService;
	}
	
	@GetMapping
	@CrossOrigin(origins = "http://allowed-origin.com", maxAge = 3600)
	public ResponseEntity<List<NoteBook>> getAllBooks(){
		return new ResponseEntity<>(notesService.getAllBooks(),HttpStatus.OK);
	}
	
	@GetMapping("isbn/{isbn}")
	@CrossOrigin(origins = "http://allowed-origin.com", maxAge = 3600)
	public ResponseEntity<Optional<NoteBook>> getByISBN(@PathVariable @Valid String isbn){
		return new ResponseEntity<>(notesService.findByISBN(isbn),HttpStatus.OK);
	}
	
	@PostMapping
	@CrossOrigin(origins = "http://allowed-origin.com", maxAge = 3600)
	public ResponseEntity<NoteBook> addNoteBook(@RequestBody NoteBook noteBook){
		return new ResponseEntity<>(notesService.addNoteBook(noteBook),HttpStatus.CREATED);
	}
	
	@PatchMapping("update/{isbn}")
	@CrossOrigin(origins = "http://allowed-origin.com", maxAge = 3600)
	public ResponseEntity<NoteBook> updateNoteBook(@PathVariable("isbn") @Valid String isbn, @RequestBody NoteBook noteBookDetails){
		return new ResponseEntity<>(notesService.updateNoteBook(noteBookDetails, isbn),HttpStatus.OK);
	}
	
	@DeleteMapping("delete/isbn/{isbn}")
	@CrossOrigin(origins = "http://allowed-origin.com", maxAge = 3600)
	public ResponseEntity<String> deleteNoteBook(@PathVariable @Valid String isbn){
		notesService.deleteNoteBook(isbn);
		return new ResponseEntity<>("Book with "+isbn+" ISBN number has deleted",HttpStatus.OK);
	}

}

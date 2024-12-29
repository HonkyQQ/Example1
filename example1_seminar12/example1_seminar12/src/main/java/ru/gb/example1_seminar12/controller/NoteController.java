package ru.gb.example1_seminar12.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.gb.example1_seminar12.model.Note;
import ru.gb.example1_seminar12.services.FileGateWay;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/notes")
public class NoteController {
    private final FileGateWay fileGateWay;

    @PostMapping
    public ResponseEntity <Note> addNote(@RequestBody Note note){
        note.setCreation(LocalDateTime.now());
        fileGateWay.writeToFile(note.getTitle() + ".txt", note.toString());
        return new ResponseEntity<>(HttpStatus.OK);
    }

}

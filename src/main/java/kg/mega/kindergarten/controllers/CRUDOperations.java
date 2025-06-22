package kg.mega.kindergarten.controllers;

import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface CRUDOperations<DTO,CDTO, ID> {
    @PostMapping
     DTO create(@RequestBody CDTO cdto);
    @GetMapping
    DTO read(@PathVariable ID id);
    @GetMapping("/list")
    List<DTO> readAll(@RequestParam int page, @RequestParam int size);
    @PutMapping
    DTO update(@RequestBody DTO dto);
    @DeleteMapping
    boolean delete(@RequestParam ID id);
}

package kg.mega.kindergarten.controllers;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface CRUDOperations<DTO,CDTO, UDTO> {
    @PostMapping("/create")
    DTO create(@Valid @RequestBody CDTO dto);
    @PutMapping("/update")
    DTO update(@PathVariable Long id, @Valid @RequestBody UDTO updatedDto);
    @DeleteMapping("/delete")
    ResponseEntity<?> delete(@RequestParam Long id);
    @GetMapping("/getList")
    List<DTO> allList(@RequestParam int page, @RequestParam int size);
    @GetMapping("/findById")
    DTO findById(@RequestParam Long id);
}

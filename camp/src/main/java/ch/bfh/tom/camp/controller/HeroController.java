package ch.bfh.tom.camp.controller;

import ch.bfh.tom.camp.model.Hero;
import ch.bfh.tom.camp.repository.HeroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.CacheControl;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.Base64;

@RestController
@RequestMapping("/heroes")
public class HeroController {

    @Autowired
    private HeroRepository heroRepository;

    @GetMapping
    public @ResponseBody
    Iterable<Hero> list() {
        return heroRepository.findAll();
    }

    @GetMapping("/{id}")
    public @ResponseBody
    Hero getById(@PathVariable String id) {
        return heroRepository.findById(id).get();
    }


    @GetMapping(value = "/{id}/getImage")
    public ResponseEntity<ByteArrayResource> getImage(@PathVariable String id) {
        Hero hero = heroRepository.findById(id).get();
        HttpHeaders headers = new HttpHeaders();
        byte[] media = hero.getImage();
        media = Base64.getEncoder().encodeToString(media).getBytes();
        headers.setCacheControl(CacheControl.noCache().getHeaderValue());
        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType("application/octet-stream"))
                .header(HttpHeaders.CONTENT_DISPOSITION, "inline; filename=\"" + hero.getImagePath() + "\"")
                .contentLength(media.length)
                .body(new ByteArrayResource(media));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public void create(@RequestBody Hero hero) {
        heroRepository.save(hero);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable String id) {
        heroRepository.deleteById(id);
    }

    @GetMapping(value = "/{id}/changeName")
    public Hero changeName(@RequestParam String name, @PathVariable String id) {
        Hero hero = heroRepository.findById(id).get();
        hero.setName(name);
        hero = heroRepository.save(hero);
        return hero;
    }
}

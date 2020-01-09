package ch.bfh.tom.camp.controller;

import ch.bfh.tom.camp.model.Hero;
import ch.bfh.tom.camp.repository.HeroRepository;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.io.InputStream;

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


    @GetMapping(value = "/{id}/getImage",
            produces = MediaType.IMAGE_JPEG_VALUE)
    public ResponseEntity<byte[]> getImage(@PathVariable String id) {
        Hero hero = heroRepository.findById(id).get();
        HttpHeaders headers = new HttpHeaders();
        InputStream in = getClass().getResourceAsStream(hero.getImagePath());
        byte[] media = new byte[0];
        try {
            media = IOUtils.toByteArray(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
        headers.setCacheControl(CacheControl.noCache().getHeaderValue());

        return new ResponseEntity<>(media, headers, HttpStatus.OK);
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

}

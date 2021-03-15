package de.mvolleys.box.rest

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController


@CrossOrigin(originPatterns = ["http://*:*"])
@RestController
class MainController{

    @GetMapping("/REST")
    fun restInfo(): ResponseEntity<String> {
        return ResponseEntity.ok().body(infoResponse)
    }
}



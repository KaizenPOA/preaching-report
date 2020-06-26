package org.publishers.controllers

import org.publishers.models.Publisher
import org.publishers.repositories.PublishersRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*
import java.util.concurrent.atomic.AtomicLong

@RestController
@RequestMapping("publishers")
class PublishersController {

    @Autowired
    lateinit var publishersRepository: PublishersRepository

    @GetMapping
    fun all() = publishersRepository.findAll()

    @GetMapping("/{id}")
    fun find(@PathVariable id: UUID) = publishersRepository.findById(id)

    @PostMapping
    fun add(@RequestBody publisher: Publisher) = publishersRepository.save(publisher)


}
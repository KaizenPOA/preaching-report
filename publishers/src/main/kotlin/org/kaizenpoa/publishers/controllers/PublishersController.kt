package org.kaizenpoa.publishers.controllers

import org.kaizenpoa.publishers.models.PublisherModel
import org.springframework.web.bind.annotation.*
import java.util.concurrent.atomic.AtomicLong

@RestController
@RequestMapping("publishers")
class PublishersController {
    val counter = AtomicLong()

    @GetMapping("/")
    fun list() = PublisherModel(counter.incrementAndGet(), "Hello", true)

    @GetMapping("")
    fun find(@RequestParam(value = "name", defaultValue = "Douglas") name:String) =
            PublisherModel(counter.incrementAndGet(), "Hello, $name", true)

    @PostMapping
    fun add(@RequestBody publisher: PublisherModel) {

    }



}
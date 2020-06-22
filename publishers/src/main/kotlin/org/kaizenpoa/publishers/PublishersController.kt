package org.kaizenpoa.publishers

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.util.concurrent.atomic.AtomicLong

@RestController
class PublishersController {
    val counter = AtomicLong()

    @GetMapping("/")
    fun home(@RequestParam(value = "name", defaultValue = "Douglas") name:String) =
            Publisher(counter.incrementAndGet(), "Hello, $name", true)

}
package org.publishers.controllers

import org.publishers.models.Group
import org.publishers.repositories.GroupsRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("groups")
class GroupsController {

    @Autowired
    lateinit var groupsRepository: GroupsRepository

    @GetMapping("/")
    fun all() = groupsRepository.findAll()

    @GetMapping("")
    fun find(@RequestParam(value = "name", defaultValue = "") name: String) =
            groupsRepository.findByName(name)

    @PostMapping
    fun add(@RequestBody group: Group) = groupsRepository.save(group)


}
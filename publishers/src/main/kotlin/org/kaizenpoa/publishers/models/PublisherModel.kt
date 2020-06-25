package org.kaizenpoa.publishers.models

data class PublisherModel(val id: Long, val nome: String, val active: Boolean = true, val group: GroupModel? = null)
package kz.sdu.roza.data.api

import java.util.Objects

interface BaseAPI {
    fun fetchResource()

    fun getMessage(): String

    fun getData(): Map<String, Any?>
}

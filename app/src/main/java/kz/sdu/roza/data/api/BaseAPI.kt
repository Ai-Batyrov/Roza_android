package kz.sdu.roza.data.api

interface BaseAPI {
    fun getMessage(): String

    fun getData(): Map<String, Any?>

    fun insertItem(item: Any?)
}

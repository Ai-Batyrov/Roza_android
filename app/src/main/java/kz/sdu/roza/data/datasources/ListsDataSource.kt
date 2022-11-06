package kz.sdu.roza.data.datasources

abstract class ListsDataSource {
    abstract fun setList(data: List<Any>)

    abstract fun getList(): List<Any>
}

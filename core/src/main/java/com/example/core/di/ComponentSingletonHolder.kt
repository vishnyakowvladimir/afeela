package com.example.core.di

abstract class ComponentSingletonHolder<Api : ModuleApi, Component : Api, Dependencies>(
    private var creator: (Dependencies) -> Component
) {
    @Volatile
    private var instance: Component? = null

    private fun initAndGet(dependencies: Dependencies): Api {
        return instance ?: synchronized(this) {
            instance ?: creator.invoke(dependencies).also { newInstance -> instance = newInstance }
        }
    }

    open fun get(): Component =
        instance ?: throw ComponentInitException("You must call 'initAndGet()' method first")

    fun isInitialized() = instance != null

    fun reset() {
        instance = null
    }

    fun builder() = Builder(::initAndGet)

    class Builder<out Api, in Dependencies>(private var creator: (Dependencies) -> Api) {

        private var dependencies: Dependencies? = null

        fun dependencies(value: Dependencies) = apply { dependencies = value }

        fun build(): Api {
            return creator.invoke(dependencies!!)
        }
    }
}
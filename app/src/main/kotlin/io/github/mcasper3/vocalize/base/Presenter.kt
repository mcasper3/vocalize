package io.github.mcasper3.vocalize.base

abstract class Presenter<V : View> {
    protected var view: V? = null

    open fun attach(view: V) {
        this.view = view
    }

    fun detatch() {
        this.view = null
    }

    fun isViewAttached() = null != view

    fun checkViewAttached() { if (!isViewAttached()) throw ViewNotAttachedException() }
}
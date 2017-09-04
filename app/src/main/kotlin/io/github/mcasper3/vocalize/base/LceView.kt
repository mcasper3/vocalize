package io.github.mcasper3.vocalize.base

interface LceView<T> {
    fun showLoading()
    fun hideLoading()
    fun showError()
    fun showEmpty()
    fun showContent(content: T)
}
